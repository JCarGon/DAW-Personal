import { encryptPassword } from "../utils/encrypt.js";
import { createNote, getNotes, getNote, updateNote, deleteNote } from "../services/notes/notes-service.js";

export async function getAllNotesController(req, res, next) {
  try {
    const users = await getNotes(req.query);
    res.status(200).send(users);
  } catch (error){
    next(error);
  }
}

export async function getNoteController(req, res, next) {
  try {
    const note = await getNote(req.params);
    res.status(200).send(note);
  } catch (error) {
    next(error);
  }
}

export async function createNoteController(req, res, next) {
  try {
    const noteBody = {...req.body, author: req.user.id}
    const note = await createNote(noteBody);
    res.status(201).send(note);
  } catch (error){
    if(error.code = 11000){
      error.status = 409;
    }
    if(error.message.includes('validation')){
      error.status = 400;
    }
    next(error);
  }
}

export async function updateNoteController(req, res, next) {
  try {
    const { id } = req.params;
    const body = req.body;
    const patchNote = await updateNote(id, body);
    res.status(200).send(patchNote);
  } catch (error) {
    next(error);
  }
}

export async function deleteNoteController(req, res, next) {
  try {
    const deletedNote = await deleteNote(req.params);
    res.status(200).send(deletedNote);
  } catch(error){
    next(error);
  }
}
