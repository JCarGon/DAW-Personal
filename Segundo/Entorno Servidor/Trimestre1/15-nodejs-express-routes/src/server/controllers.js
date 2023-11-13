/* eslint-disable no-console */
/* eslint-disable no-plusplus */
export function pingController(req, res) {
  const headers = {
    'Content-Type': 'text/html',
  };
  res.headers = headers;
  return res.send('pong');
}

export function headerController(req, res) {
  if (req.headers.token) {
    res.send(req.headers.token);
  } else {
    const errorObject = {
      code: 404,
      error: 'Not Found',
      message: 'Error: Token not found',
    };
    res.status(404).send(errorObject);
  }
}

export function paramsController(req, res) {
  res.send(`Hola holita vecinito ${req.params.name}`);
}

export function queryController(req, res) {
  if (req.query.number) {
    const { number } = req.query;
    let newNumber = 0;
    for (let i = 1; i <= number; i++) {
      newNumber += i;
    }
    res.send(`El resultado de sumar los ${number} primeros números es: ${newNumber}`);
  } else {
    let newNumber = 0;
    for (let i = 1; i <= 100; i++) {
      newNumber += i;
    }
    res.send(`El resultado de sumar los 100 primeros números es: ${newNumber}`);
  }
}

export function bodyController(req, res) {
  let body = '<ul>\n';
  Object.entries(req.body).forEach(([key, value]) => {
    body += `  <li>${key}: ${value}</li>\n`;
  });
  body += '</ul>';
  res.send(body);
}
