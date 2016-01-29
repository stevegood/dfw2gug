layout 'layout.gtpl',

  bodyContents: contents {

    div(class:'container') {
      header {
        div(class: 'page-header') {
          h1 "Hello there, ${name}, you sure look nice!"
        }
      }
    }

    footer {}
  }