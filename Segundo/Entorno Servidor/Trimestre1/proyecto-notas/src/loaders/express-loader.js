/* eslint-disable import/no-extraneous-dependencies */
import { fileURLToPath } from 'url';
import path from 'path';
import express from 'express';
import cors from 'cors';
import swaggerUi from 'swagger-ui-express';
import YAML from 'yamljs';

import router from '../routes/index.js';
import errorMiddleware from '../middlewares/error-middleware.js';
import printDateMiddleware from '../middlewares/misc-middleware.js';

const filename = fileURLToPath(import.meta.url);
const dirname = path.dirname(filename);

const swaggerDocument = YAML.load(path.join(dirname, '../openapi/openapi.yml'));

export default function expressLoader(server) {
  server.use(cors());
  server.use(express.json());
  server.use(express.urlencoded());
  /* Swagger */
  server.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));

  server.use(printDateMiddleware);

  server.use(router);

  server.use(errorMiddleware);
}
