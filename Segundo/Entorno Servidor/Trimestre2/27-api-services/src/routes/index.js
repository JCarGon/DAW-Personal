import express from 'express';
import userRouter from './users.js';
import pokemonRouter from './pokemons.js';
import login from '../controllers/misc-controller.js';
import { restrictiveZone, validateMiddleware } from '../middlewares/auth-middleware.js';
import postPutReq from '../controllers/postPutReq-controller.js';

const router = express.Router();

router.post('/login', login);
router.use('/pokemons', pokemonRouter);
router.post('/postInfo', postPutReq);
router.use('/users', validateMiddleware, restrictiveZone, userRouter);

export default router;
