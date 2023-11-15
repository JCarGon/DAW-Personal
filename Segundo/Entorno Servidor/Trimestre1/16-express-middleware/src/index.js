/* eslint-disable no-console */
import express from 'express';
import winston from 'winston';
import morgan from 'morgan';

const server = express();
const userRouter = express.Router();

const logger = winston.createLogger({
  transports: [
    new winston.transports.Console({
      format: winston.format.combine(
        winston.format.timestamp({
          format: 'DD/MM/YYYY HH:mm:ss',
        }),
        winston.format.colorize(),
        winston.format.printf((info) => `[${[info.timestamp]}] (${info.level}) ${info.message}`),
      ),
    }),
  ],
});

morgan.format('customFormat', ':method :url :status :res[content-length] - :response-time ms');

/* /ping + logger */
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
}, morgan('customFormat'));

/* Validate middleware */
function validateMiddleware(req, res, next) {
  if (!req.headers.password) {
    const errorObject = {
      code: 401,
      error: 'unauthorized',
      message: 'Acceso restringido, por favor, incluya la palabra secreta en el parámetro "password" en la cabera de la petición',
    };
    res.status(401).send(errorObject);
  } else {
    next();
  }
}

/* Validate Password */
function restrictiveZone(req, res) {
  if (req.headers.password === 'patata') {
    const okObject = {
      code: 200,
      message: 'Bienvenid@, disfrute del contenido',
    };
    res.status(200).send(okObject);
  } else {
    const errorObject = {
      code: 401,
      error: 'unauthorized',
      message: 'Password incorrecta',
    };
    res.status(401).send(errorObject);
  }
}

userRouter.get('/admin', restrictiveZone);

server.use(validateMiddleware, userRouter);

server.listen(3000, () => {
  // eslint-disable-next-line no-console
  logger.info('Server ready at port: 3000');
});
