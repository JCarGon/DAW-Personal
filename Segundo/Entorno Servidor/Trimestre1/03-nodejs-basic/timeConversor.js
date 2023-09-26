const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

let hours = 0;
let minutes = 0;
let seconds = 0;
let timeToConvert = '';
let initialTime = '';

const conversorTiempo = async () => {
    timeToConvert = await new Promise((resolve) => {
        readline.question('Introduce seconds to convert to time: ', (userInput) => {
            resolve(userInput);
            initialTime = userInput;
        });
    });
    readline.close();

    while(timeToConvert-3600 >= 0){ //3600s = 1 hour
        timeToConvert -= 3600;
        hours++;
    }
    while(timeToConvert-60 >= 0){ //60s = 1 minute
        timeToConvert -= 60;
        minutes++;
    }
    seconds = timeToConvert;

    console.log(`${initialTime} second/s is/are: ${hours} hour/s, ${minutes} minute/s and ${seconds} second/s.`);
};
conversorTiempo();