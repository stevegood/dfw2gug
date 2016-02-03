/**
 * Created by Steve on 2/2/2016.
 */

const initWebSockets = () => {
  if (!window.ws || window.ws.readyState !== WebSocket.OPEN) {
    window.ws = new WebSocket('ws://' + location.hostname + ':5050/ws/chat');

    window.ws.onopen = (event) => {
      console.log('WebSocket opened!');
    };

    window.ws.onmessage = (event) => {
      console.log(event);
    };

    window.ws.onclose = (event) => {
      //let timer = setTimeout(() => {
      //  console.log('Retrying connection...');
      //  initWebSockets();
      //  if (window.ws.readyState === WebSocket.OPEN) {
      //    clearTimeout(timer);
      //  }
      //}, 1000);
    }
  }
};
initWebSockets();

const messages = (state = [], action) => {
  switch (action.type) {
    case 'RECEIVE':
      return [
        ...state,
        {id: action.id, user: action.user, text: action.text}
      ];
    case 'SEND':
      // this is just for testing...
      // in the real application we would send the
      // message to the server and then append it via the
      // RECEIVE action.
      return [
        ...state,
        {id: state.length, user: action.user, text: action.text}
      ];
    default:
      return state;
  }
};

export default messages;
