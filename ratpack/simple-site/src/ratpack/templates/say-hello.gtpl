layout 'layout.gtpl',

  bodyContents: contents {

    div(class:'container') {
      header {
        div(class: 'page-header') {
          h1 'Say Hello!'
        }
      }

      div(class: 'row') {
        div(class: 'col-sm-6 col-sm-offset-3') {

          form(action: '/hello-there', method: 'POST') {
            div(class: 'form-group') {
              label(for: 'nameField', 'Your name')
              input(
                type: 'text',
                class: 'form-control',
                id: 'nameField',
                name: 'nameField',
                placeholder: 'John Doe'
              )
            }

            button(type: 'submit', class: 'btn btn-primary btn-block', 'Say Hello')
          }

        }
      }
    }
  }