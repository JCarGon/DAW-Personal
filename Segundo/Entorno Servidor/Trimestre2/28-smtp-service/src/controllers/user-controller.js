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
  {
    id: 'user11', name: 'Diana Prince', age: 28, city: 'Themyscira',
  },
  {
    id: 'user12', name: 'Natasha Romanoff', age: 35, city: 'Moscow',
  },
  {
    id: 'user13', name: 'Tony Stark', age: 40, city: 'Los Angeles',
  },
  {
    id: 'user14', name: 'Peter Parker', age: 23, city: 'New York',
  },
  {
    id: 'user15', name: 'Wade Wilson', age: 32, city: 'New York',
  },
  {
    id: 'user16', name: 'Selina Kyle', age: 29, city: 'Gotham',
  },
  {
    id: 'user17', name: 'Barry Allen', age: 26, city: 'Central City',
  },
  {
    id: 'user18', name: 'Hal Jordan', age: 30, city: 'Coast City',
  },
  {
    id: 'user19', name: 'Arthur Curry', age: 35, city: 'Atlantis',
  },
  {
    id: 'user20', name: 'Kara Zor-El', age: 24, city: 'National City',
  },
  {
    id: 'user21', name: 'Elena Rodriguez', age: 27, city: 'Barcelona',
  },
  {
    id: 'user22', name: 'Victor Chen', age: 29, city: 'Shanghai',
  },
  {
    id: 'user23', name: 'Aisha Patel', age: 25, city: 'Mumbai',
  },
  {
    id: 'user24', name: 'Mikhail Ivanov', age: 33, city: 'Moscow',
  },
  {
    id: 'user25', name: 'Lila Garcia', age: 22, city: 'Mexico City',
  },
  {
    id: 'user26', name: 'Isaac Kim', age: 31, city: 'Seoul',
  },
  {
    id: 'user27', name: 'Amelia Santos', age: 28, city: 'Rio de Janeiro',
  },
  {
    id: 'user28', name: 'Rahul Kapoor', age: 26, city: 'Delhi',
  },
  {
    id: 'user29', name: 'Freya Andersson', age: 30, city: 'Stockholm',
  },
  {
    id: 'user30', name: 'Diego Fernandez', age: 29, city: 'Buenos Aires',
  },
  {
    id: 'user31', name: 'Ananya Sharma', age: 24, city: 'New Delhi',
  },
  {
    id: 'user32', name: 'Matteo Bianchi', age: 32, city: 'Rome',
  },
  {
    id: 'user33', name: 'Mia Thompson', age: 28, city: 'Sydney',
  },
  {
    id: 'user34', name: 'Nikhil Patel', age: 27, city: 'Ahmedabad',
  },
  {
    id: 'user35', name: 'Emilia Rodriguez', age: 26, city: 'Bogotá',
  },
  {
    id: 'user36', name: 'Hiroshi Tanaka', age: 30, city: 'Tokyo',
  },
  {
    id: 'user37', name: 'Aria Johnson', age: 23, city: 'Los Angeles',
  },
  {
    id: 'user38', name: 'Eduardo Silva', age: 31, city: 'São Paulo',
  },
  {
    id: 'user39', name: 'Isabella Rossi', age: 29, city: 'Milan',
  },
  {
    id: 'user40', name: 'Oscar Ramirez', age: 28, city: 'Mexico City',
  },
  {
    id: 'user41', name: 'Gabriela Costa', age: 27, city: 'Rio de Janeiro',
  },
  {
    id: 'user42', name: 'Kazuki Yamamoto', age: 33, city: 'Osaka',
  },
  {
    id: 'user43', name: 'Sofia Fernandez', age: 25, city: 'Buenos Aires',
  },
  {
    id: 'user44', name: 'Arjun Kapoor', age: 28, city: 'Mumbai',
  },
  {
    id: 'user45', name: 'Catalina Gomez', age: 26, city: 'Medellín',
  },
  {
    id: 'user46', name: 'Sebastian Morales', age: 30, city: 'Bogotá',
  },
  {
    id: 'user47', name: 'Yuki Nakamura', age: 29, city: 'Tokyo',
  },
  {
    id: 'user48', name: 'Olivia Lewis', age: 23, city: 'New York',
  },
  {
    id: 'user49', name: 'Ricardo Santos', age: 31, city: 'São Paulo',
  },
  {
    id: 'user50', name: 'Aaliyah Khan', age: 28, city: 'Karachi',
  },
  {
    id: 'user51', name: 'Elena Petrov', age: 29, city: 'Moscow',
  },
  {
    id: 'user52', name: 'Aditya Singh', age: 32, city: 'Mumbai',
  },
  {
    id: 'user53', name: 'Luna Park', age: 25, city: 'Sydney',
  },
  {
    id: 'user54', name: 'Leonardo da Silva', age: 28, city: 'Rio de Janeiro',
  },
  {
    id: 'user55', name: 'Zara Ahmed', age: 27, city: 'Lahore',
  },
  {
    id: 'user56', name: 'Gabriel Almeida', age: 30, city: 'São Paulo',
  },
  {
    id: 'user57', name: 'Sophie Dubois', age: 23, city: 'Paris',
  },
  {
    id: 'user58', name: 'Aarav Kapoor', age: 31, city: 'Delhi',
  },
  {
    id: 'user59', name: 'Emma Taylor', age: 29, city: 'New York',
  },
  {
    id: 'user60', name: 'Carlos Rodriguez', age: 28, city: 'Mexico City',
  },
];

export function getUsers(req, res) {
  const {
    sort, page, pageSize, ...filters
  } = req.query;

  // Aplicar paginación
  const currentPage = parseInt(page, 10) || 1;
  const itemsPerPage = parseInt(pageSize, 10) || 10;
  const startIndex = (currentPage - 1) * itemsPerPage;
  const endIndex = startIndex + itemsPerPage;

  // Filtrar usuarios según los criterios
  let filteredUsers = userArray.filter((user) => {
    let isValid = true;
    Object.keys(filters).forEach((key) => {
      // eslint-disable-next-line eqeqeq
      isValid = isValid && user[key] == filters[key];
    });
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

  // Aplicar paginación a los resultados
  const paginatedUsers = filteredUsers.slice(startIndex, endIndex);

  const okObject = {
    code: 200,
    page: currentPage,
    pageSize: itemsPerPage,
    totalItems: filteredUsers.length,
    userList: paginatedUsers,
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
