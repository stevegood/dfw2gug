package rocks.stevegood.ratpack.chat

import org.apache.camel.Exchange

/**
 * Created by Steve on 2/3/2016.
 */
class DefaultMessageResponse implements MessageResponse {
  private final Exchange exchange

  DefaultMessageResponse(Exchange exchange) {
    this.exchange = exchange
  }

  @Override
  void send(String message) {
    exchange.out.body = message
  }

  @Override
  void send(Map<String, String> headers, String message) {
    exchange.out.body = message
    exchange.out.headers = headers
  }
}
