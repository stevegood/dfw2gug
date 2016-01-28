layout 'layout.gtpl',

bodyContents: contents {

  div(class:'container') {
    header {
      div(class: 'page-header') {
        h1 'Ratpack'
        p 'Simple, lean &amp; powerful HTTP apps'
      }
    }

    div(class: 'row') {
      div(class: 'col-md-12') {
        div(class: 'jumbotron') {
          h2 title
          p 'This is the main page for your Ratpack app.'
        }
      }
    }
  }

  footer {}
}