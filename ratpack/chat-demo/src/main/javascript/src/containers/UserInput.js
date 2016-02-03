/**
 * Created by Steve on 2/2/2016.
 */

import React from 'react';
import {
  Button,
  Input
} from 'react-bootstrap';
import { connect } from 'react-redux';
import { login, sendMessage } from '../actions';

const getUser = (state) => {
  return {
    user: state.user
  };
};

let UserInput = ({user, dispatch}) => {
  let val = '';

  if (!user) {
    return (
      <form className="chat-input">
        <Input
          type='text'
          onKeyUp={e => {
          val = e.target.value;
        }}
          placeholder="What's your name?"
          buttonAfter={
          <Button onClick={() => {
            dispatch(login(val));
            val = '';
          }}>Login</Button>
        }
        />
      </form>
    )
  }

  return (
    <form className="chat-input">
      <Input
        type='text'
        onKeyUp={e => {
          val = e.target.value;
        }}
        placeholder='Say something...'
        buttonAfter={
          <Button onClick={() => {
            dispatch(sendMessage(user, val));
            val = '';
          }}>Send</Button>
        }
      />
    </form>
  );
};

UserInput = connect(getUser)(UserInput);

export default UserInput;
