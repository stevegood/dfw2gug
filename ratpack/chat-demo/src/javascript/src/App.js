import React, {Component} from 'react';
import {
	Col,
	Grid,
	PageHeader,
	Row
} from 'react-bootstrap';
import ChatOutput from './ChatOutput';
import ChatInput from './ChatInput';

export default class App extends Component {
	constructor(props){
		super(props);
		this.state = {
			user: 'Steve',
			messages: [
				{user: 'Steve', text: 'This is the best message of all time!'},
				{user: 'George', text: 'No, this one is better...'},
				{user: 'Dave', text: 'You\'re both wrong, mine rules them all!'}
			]
		};
	}
	
	render() {
		return (
			<Grid>
				<Row>
					<Col sm='12'>
						<PageHeader>Chat!</PageHeader>
					</Col>
				</Row>
				<Row>
					<Col sm='12'>
						<ChatOutput messages={this.state.messages} />
						<ChatInput user={this.state.user} />
					</Col>
				</Row>
			</Grid>
		);
	}
}