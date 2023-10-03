function pinToDance(number) {
  let danceMoves = [];
  let failPIN = false;
  const moves = [
    "Shimmy",
    "Shake",
    "Pirouette",
    "Slide",
    "Box Step",
    "Headspin",
    "Dosado",
    "Pop",
    "Lock",
    "Arabesque",
  ];
  const numberString = number.toString();
  if((numberString.length !== 4) || (/[a-zA-Z]/.test(number))) {
    failPIN = true;
  }
  if (failPIN) {
    console.log('Incorrect PIN.');
  } else {
    console.log('Correct PIN. Ready to dance.');
    for (let i = 0; i < number.length; i++) {
      let count = Number(number[i]) + i;
      if (count > 9) {
        count -= 10;
      }
      danceMoves.push(moves[count]);
    }
  }
  if (!failPIN) {
    console.log(danceMoves);
  }
}

pinToDance("9999");