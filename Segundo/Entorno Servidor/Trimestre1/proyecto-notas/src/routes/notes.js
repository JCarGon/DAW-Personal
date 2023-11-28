import express from 'express';
import {
  getNotes, getNote, postNote, deleteNote, patchNote, putNote,
} from '../controllers/note-controller.js';

const router = express.Router();

router.get('/', getNotes);
router.get('/:name', getNote);
router.post('/', postNote);
router.delete('/:name', deleteNote);
router.patch('/:name', patchNote);
router.put('/:name', putNote);

export default router;
