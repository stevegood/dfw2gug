package rocks.stevegood.ratpack.chat

import com.sun.xml.internal.ws.handler.HandlerException
import ratpack.registry.Registry

/**
 * Created by Steve on 2/3/2016.
 */
class DefaultMessageContext implements MessageContext {
  private final Registry registry
  private final MessageRequest request
  private final MessageResponse response
  private final MessageHandler[] messageHandlers
  private final MessageHandler exhausted
  private int nextIndex

  DefaultMessageContext(MessageResponse response, Registry registry, MessageRequest request, MessageHandler[] messageHandlers, MessageHandler exhausted, int nextIndex) {
    this.response = response
    this.registry = registry
    this.request = request
    this.messageHandlers = messageHandlers
    this.exhausted = exhausted
    this.nextIndex = nextIndex
  }

  @Override
  MessageContext getContext() {
    this
  }

  @Override
  def <O> O get(Class<O> type) {
    registry.get type
  }

  @Override
  MessageRequest getRequest() {
    request
  }

  @Override
  MessageResponse getResponse() {
    response
  }

  @Override
  void next() {
    if (nextIndex + 1 < messageHandlers.size()) {
      doNext(this, registry, messageHandlers, nextIndex + 1, exhausted)
    }
  }

  @Override
  void insert(MessageHandler... handlers) {
    doNext(this, registry, messageHandlers, 0, exhausted)
  }

  @Override
  void insert(Registry registry, MessageHandler... handlers) {
    Registry joinedRegistry = this.registry.join(registry)
    doNext(this, joinedRegistry, messageHandlers, 0, new RejoinMessageHandler())
  }

  private class RejoinMessageHandler implements MessageHandler {
    String url = exhausted.url

    @Override
    void handle(MessageContext context) {
      doNext(DefaultMessageContext.this, registry, messageHandlers, nextIndex, exhausted)
    }
  }

  protected void doNext(MessageContext parentContext, Registry registry, final MessageHandler[] nextHandlers, int nextIndex, MessageHandler exhausted) {
    MessageContext context
    MessageHandler handler

    if (nextIndex >= nextHandlers.size()) {
      context = parentContext
      handler = exhausted
    } else {
      handler = nextHandlers[nextIndex]
      context = createContext(registry, nextHandlers, nextIndex, exhausted)
    }

    try {
      handler.handle(context)
    } catch (Throwable e) {
      if (e instanceof HandlerException) {
        throw (HandlerException) e
      } else {
        throw new HandlerException(e)
      }
    }
  }

  private MessageContext createContext(Registry registry, MessageHandler[] nextHandlers, int nextIndex, MessageHandler exhausted) {
    new DefaultMessageContext(response, registry, request, nextHandlers, exhausted, nextIndex)
  }

  private static class HandlerException extends Error {
    private static final long serialVersionUID = 0

    private HandlerException(Throwable cause) {
      super(cause)
    }
  }
}
