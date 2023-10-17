import * as readline from "readline";
import * as fs from "fs";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function createFile() {
  rl.question("Introduce un nombre para el archivo que quieres crear: ",(fileName) => {
      const filePath = `notes/${fileName}.note`;
      const fileContent = "";
      fs.writeFile(filePath, fileContent, (err) => {
        if (err) {
          console.error("Error al crear el archivo:", err + "\n");
          rl.close();
        } else {
          console.log(`Se ha creado el archivo "${fileName}" con éxito en la ruta: `,filePath + "\n");
          rl.close();
        }
      });
    }
  );
}

function editFile() {
  fs.readdir("notes", (err, files) => {
    if (err) {
      console.error("Error al listar archivos:", err);
      rl.close();
    } else {
      console.log("Archivos en el directorio:");
      files.forEach((file) => {
        console.log(file);
      });
      rl.question("Introduce el nombre del archivo que quieres modificar sin la extensión: ",(name) => {
          const filePath = `notes/${name}.note`;
          if (fs.existsSync(filePath)) {
            const inputLines = [];
            const readLines = () => {
              rl.question("Introduce el texto para agregar al archivo (presiona Enter para finalizar): ",(text) => {
                  if (text === "") {
                    const fileContent = inputLines.join("\n") + "\n";
                    fs.appendFile(filePath, fileContent, (err) => {
                      if (err) {
                        console.error("Error al escribir en el archivo:",err + "\n");
                        rl.close();
                      } else {
                        console.log(`Se ha agregado el texto al archivo "${name}.note" con éxito en la ruta: `,filePath + "\n");
                        rl.close();
                      }
                    });
                  } else {
                    inputLines.push(text);
                    readLines();
                  }
              });
            };
            readLines();
          } else {
            console.log(`El archivo "${filePath}" no existe.\n`);
            rl.close();
          }
        });
    }
  });
}

function deleteFile() {
  fs.readdir("notes", (err, files) => {
    if (err) {
      console.error("Error al listar archivos:", err);
      rl.close();
    } else {
      console.log("Archivos en el directorio:");
      files.forEach((file) => {
        console.log(file);
      });
      rl.question("Introduce el nombre del archivo que quieres eliminar sin la extensión: ",(name) => {
          const filePath = `notes/${name}.note`;
          if (fs.existsSync(filePath)) {
            fs.unlink(filePath, (err) => {
              if (err) {
                console.error("Error al eliminar el archivo:", err);
                rl.close();
              } else {
                console.log(`Se ha eliminado el archivo "${name}.note" con éxito.\n`);
                rl.close();
              }
            });
          } else {
            console.log(`El archivo "${filePath}" no existe.\n`);
            rl.close();
          }
        });
    }
  });
}

function run() {
  const choice = process.argv[2];
  if (choice) {
    if (choice === "1") {
      createFile();
    } else if (choice === "2") {
      editFile();
    } else if (choice === "3") {
      deleteFile();
    }
  } else {
    const menu = `Menú del editor de notas:
  1. Crear una nota.
  2. Editar una nota existente.
  3. Eliminar una nota.
  4. Salir.
  Seleccione una opción: `;

    rl.question(menu, (answer) => {
      const option = parseInt(answer);
      if (option === 1) {
        createFile();
      } else if (option === 2) {
        editFile();
      } else if (option === 3) {
        deleteFile();
      } else if (option === 4) {
        console.log("Saliendo del programa.\n");
        rl.close();
      } else {
        console.log("Opción no válida. Por favor, selecciona una opción del menú.\n");
      }
    });
  }
}

run();