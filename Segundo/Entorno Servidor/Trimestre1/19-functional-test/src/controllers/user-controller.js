const userArray = [
  {
    id: 'user1',
    name: 'Jesus',
    age: 29,
  },
  {
    id: 'user2',
    name: 'Manolo',
    age: 44,
  },
  {
    id: 'user3',
    name: 'Paquito',
    age: 18,
  },
];

export function getUsers(req, res) {
  const okObject = {
    code: 200,
    message: 'Bienvenid@, disfrute del contenido',
    userlist: userArray,
  };
  res.status(200).send(okObject);
}

export function getUser(req, res) {
  const { id } = req.params;
  const user = userArray.find((u) => u.id === id);
  const okObject = {
    code: 200,
    message: 'Bienvenid@, disfrute del contenido',
    user,
  };
  res.status(200).send(okObject);
}

export function postUser(req, res) {
  if (!req.body.id) {
    const errorObject = {
      code: 400,
      message: 'Bad Request. id property is required',
      body: req.body,
    };
    res.status(400).send(errorObject);
  } else {
    const indexToCreate = userArray.some((user) => user.id === req.body.id);
    if (!indexToCreate) {
      userArray.push(req.body);
      const createObject = {
        code: 200,
        message: 'User created correctly',
        body: req.body,
      };
      res.status(201).send(createObject);
    } else {
      const errorObject = {
        code: 409,
        message: 'Conflict. id property already exists',
        body: req.body,
      };
      res.status(409).send(errorObject);
    }
  }
}

export function deleteUser(req, res) {
  const indexToDelete = userArray.findIndex((user) => user.id === req.params.id);

  if (indexToDelete !== -1) {
    const [userDeleted] = userArray.splice(indexToDelete, 1);
    const deleteObject = {
      code: 200,
      message: 'User deleted correctly',
      body: userDeleted,
    };
    res.status(200).send(deleteObject);
  } else {
    const errorObject = {
      code: 404,
      messsage: 'User not found',
    };
    res.status(404).send(errorObject);
  }
}

export function putUser(req, res) {
  const indexToPUT = userArray.findIndex((user) => user.id === req.params.id);
  if (!req.body.id) {
    const errorObject = {
      code: 400,
      message: 'Bad request. "id" property required',
      body: req.body.id,
    };
    res.status(400).send(errorObject);
  } else if (indexToPUT !== -1) {
    const userPUT = req.body;
    userArray[indexToPUT] = userPUT;
    const putObject = {
      code: 200,
      message: 'User modified correctly',
      body: userPUT,
    };
    res.status(200).send(putObject);
  } else {
    const errorObject = {
      code: 404,
      messsage: 'User not found',
    };
    res.status(404).send(errorObject);
  }
}

export function patchUser(req, res) {
  const indexToPATCH = userArray.findIndex((user) => user.id === req.params.id);
  if (!req.body.id) {
    const errorObject = {
      code: 400,
      message: 'Bad request. "id" property required',
      body: req.body.id,
    };
    res.status(400).send(errorObject);
  } else if (indexToPATCH !== -1) {
    const userPATCH = req.body;
    const userToModified = userArray[indexToPATCH];
    Object.keys(userPATCH).forEach((clave) => {
      userToModified[clave] = userPATCH[clave];
    });
    const patchObject = {
      code: 200,
      message: 'User modified correctly',
      body: userArray[indexToPATCH],
    };
    res.status(200).send(patchObject);
  } else {
    const errorObject = {
      code: 404,
      messsage: 'User not found',
    };
    res.status(404).send(errorObject);
  }
}
