/* eslint-disable import/extensions */
// eslint-disable-next-line import/no-extraneous-dependencies
import express from 'express';
import * as controller from './server/controllers.js';

const port = 3000;

const server = express();

// para tener body
server.use(express.json());
server.use(express.urlencoded({ extended: true }));

server.get('/ping', (req, res) => res.send('pong'));
server.get('/headers', controller.headerController);
server.get('/params/:name', controller.paramsController);
server.get('/query', controller.queryController);
server.post('/body', controller.bodyController);

server.listen(port, () => {
  // eslint-disable-next-line no-console
  console.log(`Server ready at port: ${port}`);
});
