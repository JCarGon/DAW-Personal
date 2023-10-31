/* eslint-disable no-console */
import http from 'http';
import url from 'url';
import fs from 'fs';
// eslint-disable-next-line import/extensions
import { fizzbuzz } from './fizzbuzz.js';

const port = 3000;

const server = http.createServer((request, response) => {
  const defaultRoute = () => {
    response.statusCode = 302;
    response.setHeader('Location', '/notFound');
    return response.end('<h1>Redirect>/h1>');
  };

  const route = {
    '/ping': () => {
      const headers = {
        'Content-Type': 'text/html',
      };
      response.writeHead(200, headers);
      return response.end('<h1>Hello World</h1>');
    },
    '/json': () => {
      const headers = {
        'Content-Type': 'application/json',
      };
      response.writeHead(200, headers);
      const object = {
        message: 'this is a json',
      };
      return response.end(JSON.stringify(object));
    },
    '/page': () => {
      const headers = {
        'Content-Type': 'text/html',
      };
      response.writeHead(200, headers);
      return response.end('<h2>This is a web page</h2>');
    },
    '/error': () => {
      const headers = {
        'Content-Type': 'text/plain',
      };
      response.writeHead(404, headers);
      return response.end('404 ERROR');
    },
    '/cat': () => {
      response.statusCode = 302;
      response.setHeader('Location', '/page.html');
      return response.end();
    },
    '/hello': () => {
      const urlParts = url.parse(request.url, true);

      if (urlParts.query && urlParts.query.name) {
        const headers = {
          'Content-Type': 'text/plain',
        };
        response.writeHead(200, headers);
        return response.end(`Hello ${urlParts.query.name}!`);
      }
      const headers = {
        'Content-Type': 'text/plain',
      };
      response.writeHead(400, headers);
      return response.end('Bad Request: Missing "name" parameter');
    },
    '/page.html': () => {
      try {
        const content = fs.readFileSync('./src/page.html', 'utf8');
        const headers = {
          'Content-Type': 'text/html',
        };
        response.writeHead(200, headers);
        return response.end(content);
      } catch (error) {
        response.statusCode = 500;
        response.setHeader('Content-Type', 'text/plain');
        return response.end('Internal Server Error');
      }
    },
    '/fizzbuzz': () => {
      const urlParts = url.parse(request.url, true);

      if (urlParts.query && urlParts.query.number) {
        const headers = {
          'Content-Type': 'text/plain',
        };
        response.writeHead(200, headers);
        return response.end(`Fizzbuzz result: ${fizzbuzz(urlParts.query.number)}`);
      }
      const headers = {
        'Content-Type': 'text/plain',
      };
      response.writeHead(400, headers);
      return response.end('Bad Request: Missing "number" parameter');
    },
  }[url.parse(request.url).pathname] || defaultRoute;

  route();
});

server.listen(port, () => {
  console.log(`Server is ready in port ${port}`);
});
