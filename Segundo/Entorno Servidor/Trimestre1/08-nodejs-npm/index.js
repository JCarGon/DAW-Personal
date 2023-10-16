import chalk from 'chalk';
import { faker } from '@faker-js/faker';
import { DateTime } from 'luxon';

function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

console.log(chalk.bgGreenBright('Hello') + chalk.bgBlackBright(' World') + chalk.red('!'));

const name = faker.internet.userName();
const r = Math.floor(Math.random() * 256);
const g = Math.floor(Math.random() * 256);
const b = Math.floor(Math.random() * 256); 
console.log(chalk.rgb(r,g,b).bold(name));

async function countDate(){
  const date = DateTime.now().toFormat('HH:mm:ss dd/MM/yyyy');
  const seconds = DateTime.now().toFormat('ss');
  if(seconds%10 === 0){
    console.log(chalk.green(date.toString()));
  }else{
    console.log(date.toString());
  }
  await sleep(1000);
  countDate();
}

countDate();