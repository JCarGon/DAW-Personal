import express from 'express';
import { getPokemon, getListaPokemones } from '../controllers/pokemon-controller.js';

const router = express.Router();

router.get('/', getListaPokemones);
router.get('/:id', getPokemon);

export default router;
