// eslint-disable-next-line no-unused-vars
import dotenv from 'dotenv';
// eslint-disable-next-line import/no-extraneous-dependencies
import jwt from 'jsonwebtoken';

const users = [
  {
    username: 'admin@admin.com',
    password: 'patatadeadmin',
  }, {
    username: 'jesus',
    password: '1234login',
  },
];

export function pingController(req, res) {
  // eslint-disable-next-line no-console
  console.log('pong');
  res.send('pong');
}

export function login(req, res) {
  const { username, password } = req.body;

  const user = users.find((u) => u.username === username && u.password === password);

  if (user) {
    const expiresIn = 5 * 60;
    const accessToken = jwt.sign(
      { username: user.username },
      process.env.accessTokenSecret,
      { expiresIn },
    );
    res.json({
      accessToken,
      expiresIn,
    });
  } else {
    const errorObject = {
      code: 401,
      messsage: 'Unauthorized',
    };
    res.status(401).send(errorObject);
  }
}
