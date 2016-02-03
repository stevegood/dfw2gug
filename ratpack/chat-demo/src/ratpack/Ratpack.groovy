import ratpack.groovy.template.MarkupTemplateModule
import rocks.stevegood.ratpack.chat.MessageBroadcaster

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
    bind MessageBroadcaster, new MessageBroadcaster()
    module MarkupTemplateModule
  }

  handlers {

    get {
      render groovyMarkupTemplate("index.gtpl", title: "My Ratpack App")
    }

    post('send-message') {
      render 'success'
    }

    get("ws/:wsContext") { MessageBroadcaster broadcaster ->
      broadcaster.register context
    }

    files { dir "public" }
  }
}
