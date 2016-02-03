/**
 * Created by Steve on 2/2/2016.
 */

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
