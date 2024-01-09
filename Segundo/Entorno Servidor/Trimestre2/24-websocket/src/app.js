import express from 'express';

const server = express();

server.use('/123', express.static('public'));

export default server;