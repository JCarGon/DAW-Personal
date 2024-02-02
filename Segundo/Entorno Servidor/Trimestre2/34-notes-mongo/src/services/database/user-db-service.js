import { User } from '../../models/index.js'
import { checkHash } from '../../utils/encrypt.js';

export async function getUserByName(username) {
  const user = await User.findOne({ username });
  return user;
};

export async function getUsers(filters){
  const { name } = filters;
  const query = {
    username: name ? new RegExp(name, 'i'): undefined,
    //expresión regular para buscar si algún nombre de usuario contiene el introducido en el filters
  };

  const cleanedQuery = Object.fromEntries(
    Object.entries(query).filter(([_, a]) => a !== undefined)
  );
  const users = await User.find(cleanedQuery);

  return users;
}

export async function createUser(user) {
  const userDoc = new User(user);
  const createUser = await userDoc.save();
  return createUser;
}


export async function deleteUser(params){
  const deleteUser = await User.findByIdAndDelete(params.id);
  if(!deleteUser) throw HttpStatusError(404, `User not found`);
  return deleteUser;
}

export async function updateAnimal(req, res, next) {
  try {
    const { id } = req.params;
    const animal = await Animal.findById(id);
    if(!animal) throw HttpStatusError(404, `Animal not found`);
    Object.assign(animal, req.body);
    const updateAnimal = await animal.save();
    return res.status(200).send(updateAnimal);
  } catch(err) {
    next(err);
  }
}
