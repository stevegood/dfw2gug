package rocks.stevegood.ratpack.chat

import com.google.inject.Inject
import org.apache.activemq.ActiveMQConnectionFactory
import org.apache.camel.CamelContext
import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.component.jms.JmsComponent
import ratpack.registry.Registry

import javax.jms.ConnectionFactory
import java.util.concurrent.CopyOnWriteArraySet

/**
 * Created by Steve on 2/3/2016.
 */
class RatpackMessaging {
  private final Registry registry
  private final CamelContext context

  @Inject
  RatpackMessaging(Registry registry, CamelContext context) {
    this.registry = registry
    this.context = context
  }

  void init() {
    Map<String, List<MessageHandler>> map = [:]

    registry.getAll(MessageHandler).each { MessageHandler handler ->
      if (!map.containsKey(handler.url)) {
        map[handler.url] = new CopyOnWriteArraySet()
      }

      map[handler.url] << handler
    }

    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory('vm://localhost?broker.persistent=false')
    context.addComponent('jms', JmsComponent.jmsComponent(connectionFactory))
    context.start()
    context.addRoutes new RouteBuilder() {
      @Override
      void configure() throws Exception {
        map.each { k, v ->
          def url = k
          def handlers = v
          from(url).process(new MessageHandlerAdapter(registry, handlers as MessageHandler[]))
        }
      }
    }
  }

  static class MessageHandlerAdapter implements Processor {
    final Registry registry
    final MessageHandler[] messageHandlers

    MessageHandlerAdapter(Registry registry, MessageHandler[] messageHandlers) {
      this.registry = registry
      this.messageHandlers = messageHandlers
    }

    @Override
    void process(Exchange exchange) throws Exception {
      Map<String, String> headers = (Map<String, String>) exchange.in.headers.collectEntries {
        [(it.key): it.value.toString()]
      }

      def request = new DefaultMessageRequest(headers, exchange.in.getBody(String))
      def response = new DefaultMessageResponse(exchange)
      def handler = messageHandlers[0]
      def context = new DefaultMessageContext(response, registry, request, messageHandlers, handler, 1)

      handler.handle(context)
    }
  }
}
