import React from 'react';
import Message from './Message';

const ChatOutput = ({messages}) => (
  <div className="chat-output">
    {messages.map((message) =>
      <Message key={message.id} {...message} />
    )}
  </div>
);

export default ChatOutput;