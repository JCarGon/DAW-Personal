export default function printDateMiddleware(req, res, next) {
  // eslint-disable-next-line no-console
  console.log(`[${new Date().toISOString()}]${req.method}: ${req.path}`);
  next();
}
