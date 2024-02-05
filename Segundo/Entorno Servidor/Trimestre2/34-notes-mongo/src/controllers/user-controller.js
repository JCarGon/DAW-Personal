import { getUserByName, getUsers, createUser, deleteUser, updateUser} from "../services/database/user-db-service.js";
import { encryptPassword } from "../utils/encrypt.js";

export async function getUsersController(req, res, next) {
  try {
    const users = await getUsers(req.query);
    res.send(users);
  } catch (error){
    next(error);
  }
}

export async function createUserController(req, res, next) {
  try {
    const body = req.body;
    body.password = await encryptPassword(body.password);
    const user = await createUser(req.body);
    res.status(201).send(user);
  } catch (error){
    if(error.code = 11000){
      error.status = 409;
    }
    if(error.message.includes('validation')){
      error.status = 400;
    }
    next(error);
  }
}

export async function deleteUserController(req, res, next) {
  try {
    const deletedUser = await deleteUser(req.params);
    res.status(200).send(deletedUser);
  } catch(error){
    next(error);
  }
}

export async function getUserMe(req, res, next){
  try {
    const user = await getUserByName(req.user.username);
    return res.send(user);
  } catch (error) {
    next(error);
  }
}

export async function updateUserController(req, res, next){
  //TO DO
  try {
    await updateUser(req.params);
  } catch (error) {
    next(error);
  }
}
