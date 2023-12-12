import path from 'path';
import * as fs from 'fs';

export function getNotes(req, res) {
  const notesPath = path.join(process.cwd(), 'notes');
  const {
    sort, page, pageSize, noteName,
  } = req.query;

  fs.readdir(notesPath, (err, files) => {
    if (err) {
      const errorObject = {
        code: 500,
        error: `Error al listar archivos: ${err}`,
      };
      res.status(500).send(errorObject);
      return;
    }

    // Aplicar filtrado por nombre de notas
    let filteredFiles = files;

    if (noteName) {
      const searchTerm = noteName.toLowerCase();
      filteredFiles = filteredFiles.filter((file) => {
        const fileName = path.parse(file).name.toLowerCase();
        return fileName.includes(searchTerm);
      });
    }

    // Obtener información adicional sobre cada archivo
    const filesWithInfo = filteredFiles.map((file) => {
      const filePath = path.join(notesPath, file);
      const stats = fs.statSync(filePath);
      return {
        name: path.parse(file).name,
        creationDate: stats.birthtime,
        lastModifiedDate: stats.mtime,
        size: stats.size,
      };
    });

    // Ordenar los resultados si se proporciona el parámetro "sort"
    if (sort) {
      const sortOrder = sort.startsWith('-') ? -1 : 1;
      const sortBy = sort.replace(/^-/, '');

      filesWithInfo.sort((a, b) => {
        let valueA = a[sortBy];
        let valueB = b[sortBy];

        if (sortBy === 'creationDate' || sortBy === 'lastModifiedDate') {
          // Convertir cadenas de fecha en objetos Date para comparar
          valueA = Date.parse(a[sortBy]);
          valueB = Date.parse(b[sortBy]);
        } else if (sortBy !== 'size') {
          // Convertir otros valores a minúsculas para ordenar
          valueA = a[sortBy].toLowerCase();
          valueB = b[sortBy].toLowerCase();
        }

        if (valueA < valueB) return -1 * sortOrder;
        if (valueA > valueB) return 1 * sortOrder;
        return 0;
      });
    }

    // Aplicar paginación
    const currentPage = parseInt(page, 10) || 1;
    const itemsPerPage = parseInt(pageSize, 10) || filesWithInfo.length;
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;

    const paginatedFiles = filesWithInfo.slice(startIndex, endIndex);

    const okObject = {
      code: 200,
      page: currentPage,
      pageSize: itemsPerPage,
      totalItems: filesWithInfo.length,
      notesList: paginatedFiles,
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
          const filePath = path.join(notesPath);
          const stats = fs.statSync(filePath);
          const response = {
            code: 200,
            message: 'Note found',
            noteName: filename,
            creationDate: stats.birthtime,
            lastModifiedDate: stats.mtime,
            size: stats.size,
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
