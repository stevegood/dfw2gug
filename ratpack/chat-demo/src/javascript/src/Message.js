import React, {Component} from 'react';

export default class Message extends Component {
	render(){
		const message = this.props.message;
		
		return (
			<div>
				<strong>{message.user}: </strong> {message.text}
			</div>
		);
	}
}