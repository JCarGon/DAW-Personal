import express from 'express';
import loaders from './loaders/index.js';

const server = express();

loaders(server);

export default server;

// eslint-disable-next-line no-unused-vars
const userRouter = express.Router();

/* /ping + logger
server.get('/ping', (req, res) => { // simulate a status code
  let randomStatusCode;
  if (Math.random() > 0.6) {
    randomStatusCode = 500;
    logger.log({
      level: 'error',
      message: `Server error. Response with status code: ${randomStatusCode}`,
    });
  } else if (Math.random() > 0.3) {
    randomStatusCode = 400;
    logger.log({
      level: 'warn',
      message: `Auth error / permissions error. Response with status code: ${randomStatusCode}`,
    });
  } else {
    randomStatusCode = 200;
    logger.log({
      level: 'info',
      message: `Response with status code: ${randomStatusCode}`,
    });
  }
  res.send('pong');
}, morgan('customFormat')); */
