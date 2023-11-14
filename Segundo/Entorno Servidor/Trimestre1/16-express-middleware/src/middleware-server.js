/* eslint-disable no-console */
/* eslint-disable import/extensions */
import express from 'express';

const server = express();
const userRouter = express.Router();

/* Middleware */
function printDateMiddleware(req, res, next) {
  console.log(`[${new Date().toISOString()}]${req.method}: ${req.path}`);
  next();
}

// eslint-disable-next-line no-unused-vars
function errorMiddleware(err, req, res, next) { // next para que lo reconozca como middleware
  const { status = 500, message } = err;
  res.status(status).send(status === 500 ? 'Server Error' : message);
}

/* Controller */
function pingController(req, res) {
  console.log('pong');
  res.send('pong');
}

function getUser(req, res) {
  res.send({ name: 'Jesus' });
}

function postUser(req, res, next) {
  try {
    throw new Error('falla');
    // res.send({ name: 'Jesus' });
  } catch (err) {
    next(err);
  }
}

/* Route + Controller */
userRouter.get('/ping', pingController);
userRouter.get('/user', getUser);
userRouter.post('/user', postUser);

/* Orden de ejecución: middleware de fecha, ruta, middleware de error */
server.use(printDateMiddleware, userRouter, errorMiddleware); // server.use afecta a todo el server

server.listen(3000, () => {
  // eslint-disable-next-line no-console
  console.log('Server ready at port: 3000}');
});
