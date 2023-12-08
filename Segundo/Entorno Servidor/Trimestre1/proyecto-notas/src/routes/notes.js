import express from 'express';
import {
  getNotes, getNote, postNote, deleteNote, patchNote, putNote,
} from '../controllers/note-controller.js';
import { authenticateJWT } from '../middlewares/auth-middleware.js';

const router = express.Router();

router.get('/', getNotes);
router.get('/:name', getNote);
router.post('/', authenticateJWT, postNote);
router.patch('/:name', authenticateJWT, patchNote);
router.put('/:name', authenticateJWT, putNote);
router.delete('/:name', authenticateJWT, deleteNote);

export default router;
