package rocks.stevegood.ratpack.chat

/**
 * Created by Steve on 2/3/2016.
 */
interface MessageHandler {
  String getUrl()
  void handle(MessageContext context)
}