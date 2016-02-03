package rocks.stevegood.ratpack.chat

/**
 * Created by Steve on 2/3/2016.
 */
interface MessageRequest {
  Map<String, String> getHeaders()
  String getMessage()
}