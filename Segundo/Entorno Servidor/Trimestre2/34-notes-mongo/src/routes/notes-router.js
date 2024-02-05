import { Router } from 'express';
import { checkToken } from '../middlewares/auth-middleware.js';
import { getAllNotesController, getNoteController, createNoteController, updateNoteController, deleteNoteController } from '../controllers/notes-controller.js';

const router = Router();

router.get('/', getAllNotesController);
router.get('/:id', getNoteController);
router.post('/', checkToken, createNoteController);
router.patch('/:id', checkToken, updateNoteController);
router.delete('/:id', checkToken, deleteNoteController);

export default router;
