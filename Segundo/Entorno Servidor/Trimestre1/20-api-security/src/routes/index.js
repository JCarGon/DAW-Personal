import express from 'express';
import userRouter from './users.js';
import { pingController, login } from '../controllers/misc-controller.js';
import { restrictiveZone, validateMiddleware } from '../middlewares/logs-middleware.js';

const router = express.Router();

router.get('/ping', pingController);
router.post('/login', login);
router.use('/users', validateMiddleware, restrictiveZone, userRouter);

export default router;
