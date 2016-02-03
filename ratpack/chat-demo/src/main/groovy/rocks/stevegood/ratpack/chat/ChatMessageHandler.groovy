package rocks.stevegood.ratpack.chat

import com.google.inject.Inject
import groovy.json.JsonSlurper

/**
 * Created by Steve on 2/3/2016.
 */
class ChatMessageHandler implements MessageHandler {
  String url = 'jms:queue:chat.queue'

  private final MessageBroadcaster broadcaster
  private final ChatService chatService
  private final JsonSlurper slurper = new JsonSlurper()

  @Inject
  ChatMessageHandler(MessageBroadcaster broadcaster, ChatService chatService) {
    this.broadcaster = broadcaster
    this.chatService = chatService
  }

  @Override
  void handle(MessageContext context) {
    Map<String, String> message = (Map<String, String>)slurper.parseText(context.request.message)
    String id = chatService.save(message.chatMessage)
    broadcaster.broadcast(message.wsContext, id)
    context.next()
  }
}
