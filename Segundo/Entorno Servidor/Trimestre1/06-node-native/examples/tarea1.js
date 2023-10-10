import * as readline from 'readline';
import * as fs from 'fs';

if (process.argv.length !== 3) {
  console.error('Uso: node programa.js nombre_del_archivo');
  process.exit(1);
}else{
    const nombreArchivo = process.argv[2];
    
    const rl = readline.createInterface({
      input: fs.createReadStream(nombreArchivo),
      output: process.stdout,
      terminal: false
    });
    
    // Leer el contenido línea por línea
    rl.on('line', (line) => {
      console.log(line);
    });
    
    rl.on('error', (err) => {
      console.error(`Error al leer el archivo: ${err.message}`);
    });
    
    rl.on('close', () => {
      console.log('Lectura del archivo completa.');
    });
}