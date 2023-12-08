import express from 'express';
import {
  getUsers, getUser, postUser, deleteUser, putUser, patchUser,
} from '../controllers/user-controller.js';
import { authenticateJWT } from '../middlewares/auth-middleware.js';

const router = express.Router();

router.get('/', getUsers);
router.get('/:id', getUser);
router.post('/', authenticateJWT, postUser);
router.put('/:id', authenticateJWT, putUser);
router.patch('/:id', authenticateJWT, patchUser);
router.delete('/:id', authenticateJWT, deleteUser);

export default router;
