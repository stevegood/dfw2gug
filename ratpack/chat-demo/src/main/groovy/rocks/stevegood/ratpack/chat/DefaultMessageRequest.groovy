package rocks.stevegood.ratpack.chat

import jdk.nashorn.internal.ir.annotations.Immutable

/**
 * Created by Steve on 2/3/2016.
 */
@Immutable
class DefaultMessageRequest implements MessageRequest {
  final Map<String, String> headers
  final String message
}
