// eslint-disable-next-line import/no-extraneous-dependencies
import app from './app.js';
import config from './config.js';
import { Server } from 'socket.io';

const { port } = config;

const server = app.listen(port, () => {
  // eslint-disable-next-line no-console
  console.log(`Server ready at port: ${port}`);
});

const io = new Server(server);

io.on('connection', (socket) => {
  socket.emit('single', 'para uno');
  io.emit('all', 'Conectado');
  socket.on('echo', (data) => {
    console.log((`echo: ${data}`));
    io.emit('all', data);
  });

  console.log('A user has connected');
  socket.on('disconnect', () => {
    console.log('A user has disconnected');
  });
});

setInterval(() => {
  io.emit('date', new Date());
}, 1000);