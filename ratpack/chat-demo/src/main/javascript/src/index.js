import React from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';
import {compose, createStore} from 'redux';
import App from './components/App';
import {receiveMessage} from './actions';

import chatApp from './reducers';

let store = compose(
  window.devToolsExtension ? window.devToolsExtension() : f => f
)(createStore)(chatApp);

store.dispatch(receiveMessage(0, 'System', 'Welcome to chat!'));

render(
  <Provider store={store}>
    <App />
  </Provider>
  , document.getElementById('root')
);