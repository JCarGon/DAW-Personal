import path from 'path';
import * as fs from 'fs';

export function getNotes(req, res) {
  const notesPath = path.join(process.cwd(), 'notes');

  let response = '';
  fs.readdir(notesPath, (err, files) => {
    if (err) {
      response = `Error al listar archivos: ${err}`;
    } else {
      response = 'Archivos en el directorio: ';
      files.forEach((file) => {
        response += `${file}, `;
      });
    }

    const okObject = {
      code: 200,
      noteslist: response,
    };
    res.status(200).send(okObject);
  });
}

export function getNote(req, res) {
  const { name } = req.params;
  const filename = `${name}.note`;
  const notesPath = path.join(process.cwd(), 'notes', filename);

  fs.access(notesPath, fs.constants.F_OK, (err) => {
    if (err) {
      const response = {
        code: 404,
        message: 'Note not found',
        noteName: filename,
      };
      res.status(404).send(response);
    } else {
      fs.readFile(notesPath, 'utf8', (readErr, data) => {
        if (readErr) {
          const response = {
            code: 500,
            message: `Error reading note: ${readErr}`,
            noteName: filename,
          };
          res.status(500).send(response);
        } else {
          const response = {
            code: 200,
            message: 'Note found',
            noteName: filename,
            content: data,
          };
          res.status(200).send(response);
        }
      });
    }
  });
}

export function postNote(req, res) {
  if (!req.body.name) {
    const errorObject = {
      code: 400,
      message: 'Bad Request. name property is required',
      body: req.body,
    };
    res.status(400).send(errorObject);
  } else {
    const notesPath = path.join(process.cwd(), 'notes');

    fs.readdir(notesPath, (err, files) => {
      if (err) {
        const errorObject = {
          code: 500,
          message: `Error al listar archivos: ${err}`,
        };
        res.status(500).send(errorObject);
      } else {
        const indexToCreate = files.some((note) => note === `${req.body.name}.note`);

        if (!indexToCreate) {
          const nameNote = `${req.body.name}.note`;
          const fileContent = req.body.content || ''; // Use req.body.content if present, otherwise an empty string

          fs.writeFile(path.join(notesPath, nameNote), fileContent, (writeErr) => {
            if (writeErr) {
              const errorObject = {
                code: 500,
                message: `Error reading note: ${writeErr}`,
              };
              res.status(500).send(errorObject);
            } else {
              const createNote = {
                code: 201,
                message: 'Note created correctly',
                name: nameNote,
                content: fileContent,
              };
              res.status(201).send(createNote);
            }
          });
        } else {
          const errorObject = {
            code: 409,
            message: 'Conflict. name already exists',
            body: req.body,
          };
          res.status(409).send(errorObject);
        }
      }
    });
  }
}

export function patchNote(req, res) {
  const { name } = req.params;
  const filename = `${name}.note`;
  const notesPath = path.join(process.cwd(), 'notes', filename);

  fs.access(notesPath, fs.constants.F_OK, (err) => {
    if (err) {
      const response = {
        code: 404,
        message: 'Note not found',
        noteName: filename,
      };
      res.status(404).send(response);
    } else {
      const content = `\n${req.body.content}`;
      fs.appendFile(notesPath, content, (error) => {
        if (error) {
          const response = {
            code: 500,
            message: `Error editing note: ${error}`,
            noteName: filename,
          };
          res.status(500).send(response);
        } else {
          const okObject = {
            code: 200,
            message: `Note ${filename} edited.`,
            noteName: filename,
            content: req.body.content,
          };
          res.status(200).send(okObject);
        }
      });
    }
  });
}

export function putNote(req, res) {
  const { name } = req.params;
  const filename = `${name}.note`;
  const notesPath = path.join(process.cwd(), 'notes', filename);

  fs.access(notesPath, fs.constants.F_OK, (err) => {
    if (err) {
      const response = {
        code: 404,
        message: 'Note not found',
        noteName: filename,
      };
      res.status(404).send(response);
    } else {
      fs.writeFile(notesPath, req.body.content, { flag: 'w' }, (error) => {
        if (error) {
          const response = {
            code: 500,
            message: `Error editing note: ${error}`,
            noteName: filename,
          };
          res.status(500).send(response);
        } else {
          const okObject = {
            code: 200,
            message: `Note ${filename} edited.`,
            noteName: filename,
            content: req.body.content,
          };
          res.status(200).send(okObject);
        }
      });
    }
  });
}

export function deleteNote(req, res) {
  const { name } = req.params;
  const filename = `${name}.note`;
  const notesPath = path.join(process.cwd(), 'notes', filename);

  fs.access(notesPath, fs.constants.F_OK, (err) => {
    if (err) {
      const response = {
        code: 404,
        message: 'Note not found',
        noteName: filename,
      };
      res.status(404).send(response);
    } else {
      fs.unlink(notesPath, (unlinkErr) => {
        if (unlinkErr) {
          const response = {
            code: 500,
            message: `Error deleting note: ${unlinkErr}`,
            noteName: filename,
          };
          res.status(500).send(response);
        } else {
          const response = {
            code: 200,
            message: `Note ${filename} deleted.`,
            noteName: filename,
          };
          res.status(200).send(response);
        }
      });
    }
  });
}
