import express from 'express';
import loaders from './loaders/index.js';

const server = express();

loaders(server);

export default server;

// eslint-disable-next-line no-unused-vars
const userRouter = express.Router();
