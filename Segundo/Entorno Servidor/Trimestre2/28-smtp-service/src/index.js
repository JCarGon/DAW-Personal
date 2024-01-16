import app from './app.js';
import logger from './utils/logger.js';
import config from './config.js';

const port = config.port || 3000;

app.listen(port, () => {
  logger.info(`Server ready at port: ${port}`);
});
