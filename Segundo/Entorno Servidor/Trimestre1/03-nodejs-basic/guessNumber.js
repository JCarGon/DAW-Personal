const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

const randomNumber = Math.floor(Math.random() * 100) + 1;
let lifes = 7;
let userOption = '';
let accert = false;
console.log('Machine has choosed a random number between 1 and 100. You have to guess before your lifes become 0.');

const juego = async () => {
    do{
        userOption = await new Promise((resolve) => {
            readline.question('Introduce a number: ', (userInput) => {
                resolve(userInput);
            });
        });
        if(userOption > randomNumber){
            lifes--;
            console.log(`This number is bigger than the random number. You lost one life. You have ${lifes} life/s.`);
        }else if(userOption < randomNumber){
            lifes--;
            console.log(`This number is smaller than random number. You lost one life. You have ${lifes} life/s.`);
        }else{
            accert = true;
            console.log(`Congrats! You have ${lifes} life/s more! You rock!`);
        }
    }while((lifes != 0) && !accert);
    
    if(!accert){
        console.log(`Unlucky :(. Try next. The random number was: ${randomNumber}.`);
    }
    readline.close();
};
juego();