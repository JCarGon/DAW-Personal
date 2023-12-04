// eslint-disable-next-line no-unused-vars
export default function errorMiddleware(err, req, res, next) {
  const { status = 500, message } = err;
  res.status(status).send(status === 500 ? 'Server Error' : message);
}
