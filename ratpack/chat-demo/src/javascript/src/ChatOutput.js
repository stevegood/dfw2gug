import React, {Component} from 'react';
import Message from './Message';

export default class ChatOutput extends Component {
	render() {
		const messages = this.props.messages.map((message) => {
			return (<Message message={message} />)
		})
		return (
			<div className="chat-output">
				{messages}
			</div>
		);
	}
}