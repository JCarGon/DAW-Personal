import express from 'express';

const server = express();
const animalsRouter = express.Router();

server.use('/animals', animalsRouter);
const objectError = {
  code: 404,
  error: 'Not Found',
  message: 'Error: Path not found',
};

animalsRouter.get('/dog', (req, res) => res.send({ grow: 'guau guau' }));
animalsRouter.get('/cat', (req, res) => res.send({ grow: 'miau' }));
animalsRouter.get('/bird', (req, res) => res.send({ grow: 'pio pio' }));
server.get('*', (req, res) => res.status(404).send(objectError));

server.listen(3000, () => {
  // eslint-disable-next-line no-console
  console.log('Server running');
});
