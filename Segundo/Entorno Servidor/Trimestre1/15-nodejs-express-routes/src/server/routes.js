// eslint-disable-next-line import/extensions
import * as controllers from './controllers.js';

export const defaultRoute = (req, res) => {
  res.headers = { Location: '/notFound' };
  return res.status(302).send('<h1>Redirect</h1>');
};

export const routes = {
  ping: controllers.pingController,
  notFound: controllers.notFoundController,
};
