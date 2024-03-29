// eslint-disable-next-line import/extensions
import * as controllers from './controllers.js';

export const defaultRoute = (req, res) => {
  res.statusCode = 302;
  res.setHeader('Location', '/notFound');
  return res.end('<h1>Redirect</h1>');
};

export const routes = {
  ping: controllers.pingController,
  json: controllers.jsonController,
  page: controllers.pageController,
  error: controllers.errorController,
  cat: controllers.catController,
  hello: controllers.helloController,
  pageHTML: controllers.pageHTMLController,
  fizzbuzz: controllers.fizzBuzzController,
  notFound: controllers.notFoundController,
};
