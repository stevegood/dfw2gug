package rocks.stevegood.ratpack.chat

import com.google.inject.AbstractModule
import com.google.inject.Scopes
import org.apache.activemq.broker.BrokerService
import org.apache.camel.CamelContext
import org.apache.camel.impl.DefaultCamelContext

/**
 * Created by Steve on 2/3/2016.
 */
class MessagingModule extends AbstractModule {
  @Override
  protected void configure() {
    BrokerService broker = new BrokerService()
    broker.addConnector('tcp://localhost:61616')
    broker.start()

    bind(CamelContext).toInstance(new DefaultCamelContext())
    bind(ChatMessageHandler).in(Scopes.SINGLETON)
    bind(RatpackMessaging).in(Scopes.SINGLETON)
    bind(MessagingService).in(Scopes.SINGLETON)
  }
}
