package rocks.stevegood.ratpack.chat

import java.util.concurrent.ConcurrentHashMap

/**
 * Created by Steve on 2/3/2016.
 */
class InMemoryChatService implements ChatService {

  private final Map<String, Map> storage = new ConcurrentHashMap<>()

  @Override
  String save(Map message) {
    String id = UUID.randomUUID().toString()
    message.id = id
    storage[i] = message
    id
  }

  @Override
  Map get(String id) {
    storage.containsKey(id) ? storage[id] : null
  }

  @Override
  void delete(String id) {
    if (storage.containsKey(id)) {
      storage.remove(id)
    }
  }
}
