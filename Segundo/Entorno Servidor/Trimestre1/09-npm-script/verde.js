import chalk from 'chalk';

function printGreen(word) {
  const greenWord = chalk.green(word);
  console.log(greenWord);
}

const argument = process.argv[2];

printGreen(argument);