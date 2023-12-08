import express from 'express';
import notesRouter from './notes.js';
import { restrictiveZone, validateMiddleware } from '../middlewares/auth-middleware.js';
import login from '../controllers/misc-controller.js';

const router = express.Router();

router.post('/login', login);
router.use('/notes', validateMiddleware, restrictiveZone, notesRouter);

export default router;
