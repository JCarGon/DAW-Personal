export function validateMiddleware(req, res, next) {
  if (!req.headers.password) {
    const errorObject = {
      code: 401,
      error: 'unauthorized',
      message: 'Acceso restringido, por favor, incluya la palabra secreta en el parámetro "password" en la cabera de la petición',
    };
    res.status(401).send(errorObject);
  } else {
    next();
  }
}

// eslint-disable-next-line no-unused-vars
export function restrictiveZone(req, res, next) {
  if (req.headers.password === 'patata') {
    next();
  } else {
    const errorObject = {
      code: 401,
      error: 'unauthorized',
      message: 'Password incorrecta',
    };
    res.status(401).send(errorObject);
  }
}
