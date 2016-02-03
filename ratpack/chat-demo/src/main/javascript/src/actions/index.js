/**
 * Created by Steve on 2/2/2016.
 */

export const login = (user) => {
  return {
    type: 'LOGIN',
    user
  };
};

export const receiveMessage = (id, user, text) => {
  return {
    type: 'RECEIVE',
    id, user, text
  };
};

export const sendMessage = (user, text) => {
  return {
    type: 'SEND',
    user,
    text
  };
};
