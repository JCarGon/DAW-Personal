import url from 'url';
import fs from 'fs';
// eslint-disable-next-line import/extensions
import { fizzbuzz } from '../../publish/fizzbuzz.js';

export function pingController(req, res) {
  const headers = {
    'Content-Type': 'text/html',
  };
  res.writeHead(200, headers);
  return res.end('<h1>Hello World</h1>');
}

export function jsonController(req, res) {
  const headers = {
    'Content-Type': 'application/json',
  };
  res.writeHead(200, headers);
  const object = {
    message: 'this is a json',
  };
  return res.end(JSON.stringify(object));
}

export function pageController(req, res) {
  const headers = {
    'Content-Type': 'text/html',
  };
  res.writeHead(200, headers);
  return res.end('<h2>This is a web page</h2>');
}

export function errorController(req, res) {
  const headers = {
    'Content-Type': 'text/plain',
  };
  res.writeHead(404, headers);
  return res.end('404 ERROR');
}

export function catController(req, res) {
  res.statusCode = 302;
  res.setHeader('Location', '/pageHTML');
  return res.end();
}

export function helloController(req, res) {
  const parsedUrl = url.parse(req.url, true);
  if (parsedUrl.query && parsedUrl.query.name) {
    const headers = {
      'Content-Type': 'text/plain',
    };
    res.writeHead(200, headers);
    return res.end(`Hello ${parsedUrl.query.name}!`);
  }
  const headers = {
    'Content-Type': 'text/plain',
  };
  res.writeHead(400, headers);
  return res.end('Bad Request: Missing "name" parameter');
}

export function pageHTMLController(req, res) {
  try {
    const content = fs.readFileSync('./publish/page.html', 'utf8');
    const headers = {
      'Content-Type': 'text/html',
    };
    res.writeHead(200, headers);
    return res.end(content);
  } catch (error) {
    res.statusCode = 500;
    res.setHeader('Content-Type', 'text/plain');
    return res.end('Internal Server Error');
  }
}

export function fizzBuzzController(req, res) {
  const urlParts = url.parse(req.url, true);

  if (urlParts.query && urlParts.query.number) {
    const headers = {
      'Content-Type': 'text/plain',
    };
    res.writeHead(200, headers);
    return res.end(`Fizzbuzz result: ${fizzbuzz(urlParts.query.number)}`);
  }
  const headers = {
    'Content-Type': 'text/plain',
  };
  res.writeHead(400, headers);
  return res.end('Bad Request: Missing "number" parameter');
}

export function notFoundController(req, res) {
  const headers = {
    'Content-Type': 'text/html',
  };
  res.writeHead(200, headers);
  return res.end('<h1>Redirecting</h1>');
}
