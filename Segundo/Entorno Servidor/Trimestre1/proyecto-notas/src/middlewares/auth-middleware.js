// eslint-disable-next-line no-unused-vars
import dotenv from 'dotenv';
// eslint-disable-next-line import/no-extraneous-dependencies
import jwt from 'jsonwebtoken';

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

export function authenticateJWT(req, res, next) {
  const authHeader = req.headers.authorization;
  if (authHeader) {
    const token = authHeader.split(' ')[1];
    // eslint-disable-next-line consistent-return
    jwt.verify(token, process.env.accessTokenSecret, (err, user) => {
      if (err) {
        if (err.name === 'TokenExpiredError') {
          const errorObject = {
            code: 403,
            error: 'Forbidden',
            message: 'Expired token',
          };
          return res.status(403).send(errorObject);
        }
        const errorObject = {
          code: 403,
          error: 'Forbidden',
          message: 'Invalid token',
        };
        return res.status(403).send(errorObject);
      }

      req.user = user;
      next();
    });
  } else {
    const errorObject = {
      code: 401,
      messsage: 'Unauthorized',
    };
    res.status(401).send(errorObject);
  }
}
