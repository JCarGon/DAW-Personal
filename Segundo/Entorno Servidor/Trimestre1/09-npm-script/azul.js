import chalk from 'chalk';

function printBlue(word) {
  const blueWord = chalk.blue(word);
  console.log(blueWord);
}

const argument = process.argv[2];

printBlue(argument);