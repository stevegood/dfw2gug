/**
 * Created by Steve on 2/2/2016.
 */

import { connect } from 'react-redux';
import ChatOutput from '../components/ChatOutput';

const getMessages = (state) => {
  return {
    messages: state.messages
  };
};

const MessageList = connect(getMessages)(ChatOutput);

export default MessageList;
