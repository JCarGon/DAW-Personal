import { Router } from 'express';
import { getUsersController, createUserController, deleteUserController } from '../controllers/user-controller.js';

const router = Router();

router.get('/', getUsersController);
router.post('/', createUserController);
router.delete('/:id', deleteUserController);

export default router;
