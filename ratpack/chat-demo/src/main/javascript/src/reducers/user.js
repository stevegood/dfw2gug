/**
 * Created by Steve on 2/2/2016.
 */

const user = (state, action) => {
  switch (action.type) {
    case 'LOGIN':
      return action.user;
    default:
      return null;
  }
};

export default user;
