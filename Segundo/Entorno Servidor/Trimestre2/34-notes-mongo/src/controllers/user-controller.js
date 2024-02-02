import { getUsers, createUser, deleteUser } from "../services/database/user-db-service.js";
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
