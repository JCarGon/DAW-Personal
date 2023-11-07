/* eslint-disable import/extensions */
// eslint-disable-next-line import/no-extraneous-dependencies
import express from 'express';
import { routes, defaultRoute } from './server/routes.js';

const port = 3000;

const server = express();

server.get('/tirardado', routes.tirardado);
server.get('/restartgame', routes.restartgame);
server.get('*', defaultRoute);

server.listen(port, () => {
  // eslint-disable-next-line no-console
  console.log(`Server ready at port: ${port}`);
});
