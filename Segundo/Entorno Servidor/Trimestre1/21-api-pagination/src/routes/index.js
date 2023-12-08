import express from 'express';
import userRouter from './users.js';
import login from '../controllers/misc-controller.js';
import { restrictiveZone, validateMiddleware } from '../middlewares/auth-middleware.js';

const router = express.Router();

router.post('/login', login);
router.use('/users', validateMiddleware, restrictiveZone, userRouter);

export default router;
