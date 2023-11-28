import express from 'express';
import notesRouter from './notes.js';
import { restrictiveZone, validateMiddleware } from '../middlewares/logs-middleware.js';

const router = express.Router();

router.use('/notes', validateMiddleware, restrictiveZone, notesRouter);

export default router;
