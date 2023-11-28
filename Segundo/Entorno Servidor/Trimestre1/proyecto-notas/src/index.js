// eslint-disable-next-line import/no-extraneous-dependencies
import dotenv from 'dotenv';
import app from './app.js';
import logger from './utils/logger.js';

dotenv.config();
const port = process.env.PORT || 3000;

app.listen(port, () => {
  // eslint-disable-next-line no-console
  logger.info(`Server ready at port: ${port}`);
});
