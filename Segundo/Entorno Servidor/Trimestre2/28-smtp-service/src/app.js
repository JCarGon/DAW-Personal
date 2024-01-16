import express from 'express';
import loaders from './loaders/index.js';
import config from './config.js';

const server = express();

loaders(server, config);

export default server;

// eslint-disable-next-line no-unused-vars
const userRouter = express.Router();
