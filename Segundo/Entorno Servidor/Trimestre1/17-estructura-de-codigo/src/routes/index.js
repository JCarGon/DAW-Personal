import express from 'express';
import userRouter from './users.js';
import pingController from '../controllers/misc-controller.js';
import { restrictiveZone, validateMiddleware } from '../middlewares/logs-middleware.js';

const router = express.Router();

router.get('/ping', pingController);
router.use('/users', validateMiddleware, restrictiveZone, userRouter);

export default router;
