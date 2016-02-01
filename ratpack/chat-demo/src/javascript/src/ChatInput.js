import React, {Component} from 'react';
import {
	Button,
	Input
} from 'react-bootstrap';

export default class ChatInput extends Component {
	render(){
		const sendButton = <Button>Send</Button>
		return (
			<form className="chat-input">
				<Input type='text' ref='input' placeholder='Say something...' buttonAfter={sendButton} />
			</form>
		)
	}
}