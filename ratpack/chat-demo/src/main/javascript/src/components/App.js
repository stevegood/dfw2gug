import React from 'react';
import {
	Col,
	Grid,
	PageHeader,
	Row
} from 'react-bootstrap';
import MessageList from '../containers/MessageList';
import UserInput from '../containers/UserInput';

const App = () => (
  <Grid>
    <Row>
      <Col sm={12}>
        <PageHeader>Chat!</PageHeader>
      </Col>
    </Row>
    <Row>
      <Col sm={12}>
        <MessageList />
        <UserInput />
      </Col>
    </Row>
  </Grid>
);

export default App;
