export function getUser(req, res) {
  const okObject = {
    code: 200,
    message: 'Bienvenid@, disfrute del contenido',
    name: 'Jesus',
  };
  res.status(200).send(okObject);
}

export function postUser(req, res) {
  res.status(200).send(req.body);
}
