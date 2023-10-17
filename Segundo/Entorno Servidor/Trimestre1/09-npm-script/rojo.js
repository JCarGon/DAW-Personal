import chalk from 'chalk';

function printRed(word) {
  const redWord = chalk.red(word);
  console.log(redWord);
}

const argument = process.argv[2];

printRed(argument);