import express from 'express';
// eslint-disable-next-line import/no-extraneous-dependencies
import cors from 'cors';

import router from '../routes/index.js';
import errorMiddleware from '../middlewares/error-middleware.js';
import printDateMiddleware from '../middlewares/misc-middleware.js';

export default function expressLoader(server) {
  server.use(cors());
  server.use(express.json());
  server.use(express.urlencoded());

  server.use(printDateMiddleware);

  server.use(router);

  server.use(errorMiddleware);
}
