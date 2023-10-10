import * as readline from 'readline';
import * as fs from 'fs';

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function run(){
    const menu = `Menú del editor de notas:
1. Crear una nota.
2. Editar una nota existente.
3. Eliminar una nota.
4. Salir.
Seleccione una opción: `;

    rl.question(menu, (answer) => {
        const option = parseInt(answer);
        if (option === 1) { //create
            rl.question('Introduce un nombre para el archivo que quieres crear: ', (fileName) => {
                const filePath = `C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Segundo\\Entorno Servidor\\Trimestre1\\06-node-native\\${fileName}.note`;
                const fileContent = '';
                fs.writeFile(filePath, fileContent, (err) => {
                    if (err) {
                        console.error('Error al crear el archivo:', err + '\n');
                        run();
                    } else {
                        console.log(`Se ha creado el archivo "${fileName}" con éxito en la ruta: `, filePath + '\n');
                        run();
                    }
            });
        });
    } else if (option === 2) { //write
        fs.readdir('C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Segundo\\Entorno Servidor\\Trimestre1\\06-node-native', (err, files) => {
            if (err) {
                console.error('Error al listar archivos:', err);
            } else {
                console.log('Archivos en el directorio:');
                files.forEach((file) => {
                    console.log(file);
                });
                rl.question('Introduce el nombre del archivo que quieres modificar sin la extensión: ', (name) => {
                    const filePath = `C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Segundo\\Entorno Servidor\\Trimestre1\\06-node-native\\${name}.note`;
                    if (fs.existsSync(filePath)) {
                        const inputLines = [];
                        const readLines = () => {
                            rl.question('Introduce el texto para agregar al archivo (presiona Enter para finalizar): ', (text) => {
                                if (text === '') {
                                    const fileContent = inputLines.join('\n') + '\n';
                                    fs.appendFile(filePath, fileContent, (err) => {
                                        if (err) {
                                            console.error('Error al escribir en el archivo:', err + '\n');
                                            run();
                                        } else {
                                            console.log(`Se ha agregado el texto al archivo "${name}.note" con éxito en la ruta: `, filePath + '\n');
                                            run();
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
    } else if (option === 3) { //delete
        fs.readdir('C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Segundo\\Entorno Servidor\\Trimestre1\\06-node-native', (err, files) => {
            if (err) {
                console.error('Error al listar archivos:', err);
            } else {
                console.log('Archivos en el directorio:');
                files.forEach((file) => {
                    console.log(file);
                });
                rl.question('Introduce el nombre del archivo que quieres eliminar sin la extensión: ', (name) => {
                    const filePath = `C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Segundo\\Entorno Servidor\\Trimestre1\\06-node-native\\${name}.note`;
                    if (fs.existsSync(filePath)) {
                        fs.unlink(filePath, (err) => {
                            if (err) {
                                console.error('Error al eliminar el archivo:', err);
                                run();
                            } else {
                                console.log(`Se ha eliminado el archivo "${name}.note" con éxito.\n`);
                                run();
                            }
                        });
                    } else {
                        console.log(`El archivo "${filePath}" no existe.\n`);
                        run();
                    }
                });
            }
        });
    } else if(option === 4){
        console.log('Saliendo del programa.\n');
        rl.close();
    }else{
        console.log('Opción no válida. Por favor, selecciona una opción del menú.\n');
        run();
    }
});
}

run();