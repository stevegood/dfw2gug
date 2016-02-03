import React, {Component} from 'react';

const Message = ({user, text}) => (
  <div>
    <strong>{user}:</strong> {text}
  </div>
);

export default Message;
