import ratpack.groovy.template.MarkupTemplateModule
import rocks.stevegood.ratpack.chat.ChatService
import rocks.stevegood.ratpack.chat.InMemoryChatService
import rocks.stevegood.ratpack.chat.MessageBroadcaster
import rocks.stevegood.ratpack.chat.MessagingModule
import rocks.stevegood.ratpack.chat.RatpackMessaging

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
    bindInstance ChatService, new InMemoryChatService()
    bindInstance MessageBroadcaster, new MessageBroadcaster()
    module MessagingModule
    module MarkupTemplateModule

  }

  handlers {

    get {
      render groovyMarkupTemplate("index.gtpl", title: "My Ratpack App")
    }

    post('send-message') { MessageBroadcaster broadcaster ->
      broadcaster.broadcast(context.request.path, 'send-message invoked!')
      render 'success'
    }

    get("ws/:wsContext") { MessageBroadcaster broadcaster ->
      broadcaster.register context
      broadcaster.broadcast(context.request.path, 'Socket connected!')
    }

    files { dir "public" }
  }
}
