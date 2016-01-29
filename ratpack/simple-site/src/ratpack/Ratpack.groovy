import ratpack.form.Form
import ratpack.groovy.template.MarkupTemplateModule

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
  bindings {
    module MarkupTemplateModule
  }

  handlers {
    get {
      render groovyMarkupTemplate("index.gtpl")
    }

    get('say-hello') {
      render groovyMarkupTemplate("say-hello.gtpl")
    }

    post('hello-there') {
      parse(Form).then { Form form ->
        String name = form.nameField
        render groovyMarkupTemplate("hello-there.gtpl", name: name)
      }
    }

    files { dir "public" }
  }
}
