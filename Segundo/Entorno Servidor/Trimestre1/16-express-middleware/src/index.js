/* eslint-disable no-console */
import express from 'express';
import winston from 'winston';
import morgan from 'morgan';

const server = express();

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

server.use(morgan('combined', {
  stream: {
    write(message) {
      logger.info(message);
    },
  },
}));

/* Route + Controller */
server.get('/ping', (req, res) => {
  logger.info('pong');
  res.send('pong');
});

server.listen(3000, () => {
  // eslint-disable-next-line no-console
  logger.info('Server ready at port: 3000');
});
