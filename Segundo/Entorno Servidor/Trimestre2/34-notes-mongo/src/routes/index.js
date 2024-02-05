import express from 'express';
import { login } from '../controllers/login-controller.js';
import miscRouter from './misc-router.js';
import userRouter from './user-router.js';
import notesController from './notes-router.js';

const router = express.Router();

router.post('/login', login);
router.use('/users', userRouter);
router.use('/notes', notesController);

router.use(miscRouter);

export default router;
