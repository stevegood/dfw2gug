package rocks.stevegood.ratpack.chat

import ratpack.registry.Registry

/**
 * Created by Steve on 2/3/2016.
 */
interface MessageContext {
  MessageContext getContext()
  abstract <O> O get(Class<O> type)
  MessageRequest getRequest()
  MessageResponse getResponse()
  void next()
  void insert(MessageHandler... handlers)
  void insert(Registry registry, MessageHandler... handlers)
}