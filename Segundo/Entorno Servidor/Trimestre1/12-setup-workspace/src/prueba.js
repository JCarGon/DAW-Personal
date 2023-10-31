const youShouldNeverUseVar = 'This is my very long line that eslint should check as an error ............................................';

function myFunction(used, nonUsed) {
  if (used) {
    // eslint-disable-next-line no-console
    console.log(nonUsed);
  }
}

myFunction(true, youShouldNeverUseVar);
