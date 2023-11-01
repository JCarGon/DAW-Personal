/* eslint-disable import/extensions */
/* eslint-disable no-console */
import http from 'http';
import url from 'url';
import { routes, defaultRoute } from './server/routes.js';

const port = 3000;

const server = http.createServer((req, res) => {
  // Utiliza el módulo 'url' para analizar la URL y obtener la ruta y la cadena de consulta
  const parsedUrl = url.parse(req.url, true);
  const route = routes[parsedUrl.pathname.slice(1)] || defaultRoute;

  route(req, res);
});

server.listen(port, () => {
  console.log(`Server is ready in port ${port}`);
});
