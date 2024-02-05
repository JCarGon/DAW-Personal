import { Note } from '../../models/index.js'

export async function getNotes(filters){
  const { title } = filters;
  const query = {
    title: title ? new RegExp(title, 'i'): undefined,
    //expresión regular para buscar si algún nombre de usuario contiene el introducido en el filters
  };

  const cleanedQuery = Object.fromEntries(
    Object.entries(query).filter(([_, a]) => a !== undefined)
  );
  const notes = await Note.find(cleanedQuery);

  return notes;
}

export async function getNote(params) {
  const { id } = params.id;
  const note = await Note.findOne({id});
  return note;
}

export async function createNote(note) {
  const noteDoc = new Note(note);
  const createdNote = await noteDoc.save();
  return createdNote;
}

export async function updateNote(params){
  //TO DO
  Note.findByIdAndUpdate(params.id);
}

export async function deleteNote(params){
  const deleteNote = await Note.findByIdAndDelete(params.id);
  if(!deleteNote) throw HttpStatusError(404, `Note not found`);
  return deleteNote;
}
