const userArray = [
  {
    id: 'user1', name: 'Alan Wake', age: 21, city: 'New York',
  },
  {
    id: 'user2', name: 'Steve Rogers', age: 106, city: 'Chicago',
  },
  {
    id: 'user3', name: 'Tom Hanks', age: 47, city: 'Detroit',
  },
  {
    id: 'user4', name: 'Ryan Burns', age: 16, city: 'New York',
  },
  {
    id: 'user5', name: 'Jack Ryan', age: 31, city: 'New York',
  },
  {
    id: 'user6', name: 'Clark Kent', age: 34, city: 'Metropolis',
  },
  {
    id: 'user7', name: 'Bruce Wayne', age: 21, city: 'Gotham',
  },
  {
    id: 'user8', name: 'Tim Drake', age: 21, city: 'Gotham',
  },
  {
    id: 'user9', name: 'Jimmy Olsen', age: 21, city: 'Metropolis',
  },
  {
    id: 'user10', name: 'Ryan Burns', age: 21, city: 'New York',
  },
];

export function getUsers(req, res) {
  const { sort, ...filters } = req.query;

  // Filtrar usuarios según los criterios
  let filteredUsers = userArray.filter((user) => {
    let isValid = true;
    for (const key in filters) {
      isValid = isValid && user[key] == filters[key];
    }
    return isValid;
  });

  // Ordenar los resultados si se proporciona el parámetro "sort"
  if (sort) {
    const sortOrder = sort.startsWith('-') ? -1 : 1;
    const sortBy = sort.replace(/^-/, ''); // Eliminar el signo "-" si está presente
    filteredUsers = filteredUsers.sort((a, b) => {
      if (a[sortBy] < b[sortBy]) return -1 * sortOrder;
      if (a[sortBy] > b[sortBy]) return 1 * sortOrder;
      return 0;
    });
  }

  const okObject = {
    code: 200,
    userlist: filteredUsers,
  };
  res.status(200).send(okObject);
}

export function getUser(req, res) {
  const { id } = req.params;
  const user = userArray.find((u) => u.id === id);
  const okObject = {
    code: 200,
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
