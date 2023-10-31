/* eslint-disable no-console */
import http from 'http';

const server = http.createServer(() => {
  console.log('Server created');
});

// Configure server
server.listen(3000, () => {
  console.log('Server is ready to take request');
});
