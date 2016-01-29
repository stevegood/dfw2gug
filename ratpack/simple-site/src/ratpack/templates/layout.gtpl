yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
  head {
    title 'My Marketing Site'
    meta(charset:'utf-8')
    meta(name: 'apple-mobile-web-app-title', content: 'Ratpack')
    meta(name: 'description', content: '')
    meta(name: 'viewport', content: 'width=device-width, initial-scale=1')

    link(href: '/images/favicon.ico', rel: 'shortcut icon')

    link(
      rel:"stylesheet",
      href:"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css",
      integrity:"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7",
      crossorigin:"anonymous"
    )

    script(
      src: '//code.jquery.com/jquery-1.12.0.min.js', ''
    )
    script(
      src:"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js",
      integrity:"sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS",
      crossorigin:"anonymous",
      ''
    )

  }

  body {

    nav(class: 'navbar navbar-default') {
      div(class: 'container-fluid') {
        div(class: 'navbar-header') {
          button(
            type: 'button',
            class: 'navbar-toggle collapsed',
            'data-toggle': 'collapse',
            'data-target': '#bs-example-navbar-collapse-1',
            'aria-expanded': 'false'
          ) {
            span(class: 'sr-only', 'Toggle navigation')
            span(class: 'icon-bar', '')
            span(class: 'icon-bar', '')
            span(class: 'icon-bar', '')
          }

          a(class: 'navbar-brand', href: '/', 'Brand')
        }

        div(class: 'collapse navbar-collapse', id: 'bs-example-navbar-collapse-1') {
          ul(class: 'nav navbar-nav') {
            li {
              a(href: '/say-hello', 'Say Hello')
            }
          }
        }
      }
    }

    bodyContents()
  }
}