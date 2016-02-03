package rocks.stevegood.ratpack.chat

/**
 * Created by Steve on 2/3/2016.
 */
interface ChatService {

  String save(Map message)
  Map get(String id)
  void delete(String id)

}
