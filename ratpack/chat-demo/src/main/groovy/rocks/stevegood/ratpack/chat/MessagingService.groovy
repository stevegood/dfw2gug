package rocks.stevegood.ratpack.chat

import com.google.inject.Inject
import ratpack.server.Service
import ratpack.server.StartEvent

/**
 * Created by Steve on 2/3/2016.
 */
class MessagingService implements Service {

  @Override
  void onStart(StartEvent event) throws Exception {
    event.registry.get(RatpackMessaging).init()
  }
}
