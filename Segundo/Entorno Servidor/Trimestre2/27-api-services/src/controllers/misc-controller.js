/* eslint-disable no-unused-vars */
import dotenv from 'dotenv';
import jwt from 'jsonwebtoken';
import bcrypt from 'bcrypt';

const users = [
  {
    username: 'admin@admin.com',
    password: '$2b$07$Eu7P7u/qy8BlOSjryBZnnuRhim7NUQmfZR0IC/.LMubS00Hv/Nm4e',
  }, {
    username: 'jesus',
    password: '$2b$07$pl85H/2l0enO17bg6wfikuK4Lj1FZ.WOQgs1iv2LxL3ONhi9CTFm6',
  },
];

export default function login(req, res) {
  const { username, password } = req.body;

  const user = users.find((u) => (u.username === username)
  && (bcrypt.compareSync(password, u.password)));

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
