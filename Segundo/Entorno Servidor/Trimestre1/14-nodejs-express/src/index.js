/* eslint-disable import/extensions */
// eslint-disable-next-line import/no-extraneous-dependencies
import express from 'express';
import { routes, defaultRoute } from './server/routes.js';

const port = 3000;

const server = express();

server.get('/ping', routes.ping);
server.get('/json', routes.json);
server.get('/page', routes.page);
server.get('/error', routes.error);
server.get('/cat', routes.cat);
server.get('/hello', routes.hello);
server.get('/pageHTML', server.use('/pageHTML', express.static('./public/page.html')));
server.get('/fizzBuzz', routes.fizzbuzz);
server.get('*', defaultRoute);

server.listen(port, () => {
  // eslint-disable-next-line no-console
  console.log(`Server ready at port: ${port}`);
});
