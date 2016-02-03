package rocks.stevegood.ratpack.chat

/**
 * Created by Steve on 2/3/2016.
 */
interface MessageResponse {
  void send(String message)
  void send(Map<String, String> headers, String message)
}