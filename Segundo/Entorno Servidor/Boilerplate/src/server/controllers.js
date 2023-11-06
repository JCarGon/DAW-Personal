import url from 'url';
// eslint-disable-next-line import/extensions
import { fizzbuzz } from '../../public/fizzbuzz.js';

export function pingController(req, res) {
  const headers = {
    'Content-Type': 'text/html',
  };
  res.headers = headers;
  return res.send('<h1>Pong</h1>');
}

export function jsonController(req, res) {
  const headers = {
    'Content-Type': 'application/json',
  };
  res.headers = headers;
  const object = {
    message: 'this is a json',
  };
  return res.send(JSON.stringify(object));
}

export function pageController(req, res) {
  const headers = {
    'Content-Type': 'text/html',
  };
  res.headers = headers;
  return res.send('<h2>This is a web page</h2>');
}

export function errorController(req, res) {
  const headers = {
    'Content-Type': 'text/plain',
  };
  res.headers = headers;
  return res.status(404).send('404 ERROR');
}

export function catController(req, res) {
  res.setHeader('Location', '/pageHTML');
  return res.status(302).send();
}

export function helloController(req, res) {
  const parsedUrl = url.parse(req.url, true);
  if (parsedUrl.query && parsedUrl.query.name) {
    const headers = {
      'Content-Type': 'text/plain',
    };
    res.headers = headers;
    return res.status(200).send(`Hello ${parsedUrl.query.name}!`);
  }
  const headers = {
    'Content-Type': 'text/plain',
  };
  res.headers = headers;
  return res.status(400).send('Bad Request: Missing "name" parameter');
}

export function fizzBuzzController(req, res) {
  const urlParts = url.parse(req.url, true);

  if (urlParts.query && urlParts.query.number) {
    const headers = {
      'Content-Type': 'text/plain',
    };
    res.headers(headers);
    return res.status(200).send(`Fizzbuzz result: ${fizzbuzz(urlParts.query.number)}`);
  }
  const headers = {
    'Content-Type': 'text/plain',
  };
  res.headers = headers;
  return res.status(400).send('Bad Request: Missing "number" parameter');
}

export function notFoundController(req, res) {
  const headers = {
    'Content-Type': 'text/html',
  };
  res.headers(headers);
  return res.status(200).send('<h1>Redirecting</h1>');
}
