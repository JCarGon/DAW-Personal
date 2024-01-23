import { HttpStatusError } from 'common-errors';
import Animal from '../models/Animal.js';

export async function getAnimals(req, res, next) {
  try {
    const results = await Animal.find();
    return res.send(results);
  } catch(err) {
    next(err);
  }
}

export async function getAnimal(req, res, next) {
  try {
    const { id } = req.params;
    if(!await Animal.findById(id)) throw HttpStatusError(404, `Animal not found`);
    return res.send(await Animal.findById(id));
  } catch(err) {
    next(err);
  }
}

export async function createAnimal(req, res, next) {
  try {
    const animal = new Animal(req.body);
    const createAnimal = await animal.save();
    return res.status(201).send(createAnimal);
  } catch(err){
    next(err);
  }
}

export async function updateAnimal(req, res, next) {
  try {
    const { id } = req.params;
    /*Otras formas de hacerlo: (importar mongoose arriba)
    const animal = Animal.find({_id: moongose.Types.ObjectId(id)}).limit(1);
    const animal = Animal.findOne({_id: moongose.Types.ObjectId(id)});*/
    const animal = await Animal.findById(id);
    if(!animal) throw HttpStatusError(404, `Animal not found`);
    Object.assign(animal, req.body);
    const updateAnimal = await animal.save();
    return res.status(200).send(updateAnimal);
  } catch(err) {
    next(err);
  }
}

export async function deleteAnimal(req, res, next) {
  try {
    const { id } = req.params;
    const deleteAnimal = await Animal.findByIdAndDelete(id);
    if(!deleteAnimal) throw HttpStatusError(404, `Animal not found`);
    return res.status(200).send(deleteAnimal);
  } catch(err) {
    next(err);
  }
}
