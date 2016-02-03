package rocks.stevegood.ratpack.chat

import ratpack.func.Action
import ratpack.handling.Context

import java.util.concurrent.CopyOnWriteArrayList

import static ratpack.websocket.WebSockets.websocket

/**
 * Created by Steve on 2/3/2016.
 */
class MessageBroadcaster {

  private final Map<String, List<Action<String>>> listenerRegistry = new HashMap<>()

  void register(Context context) {
    websocket(context) { ws ->
      register(context.request.path) {
        ws.send(it)
      }
    } connect {
      it.onClose {
        it.openResult.close()
      }
    }
  }

  AutoCloseable register(String wsContext, Action<String> subscriber) {
    if (!listenerRegistry.containsKey(wsContext)) {
      listenerRegistry[wsContext] = new CopyOnWriteArrayList<>()
    }

    listenerRegistry[wsContext] << subscriber

    new AutoCloseable() {
      final String ctx = wsContext

      void close() throws Exception {
        listenerRegistry[ctx].remove subscriber
      }
    }
  }

  void broadcast(String wsContext, String msg) {
    listenerRegistry[wsContext]*.execute(msg)
  }

}
