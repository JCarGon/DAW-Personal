import express from 'express';
import {
  getUsers, getUser, postUser, deleteUser, putUser, patchUser,
} from '../controllers/user-controller.js';

const router = express.Router();

router.get('/', getUsers);
router.get('/:id', getUser);
router.post('/', postUser);
router.delete('/:id', deleteUser);
router.put('/:id', putUser);
router.patch('/:id', patchUser);

export default router;
