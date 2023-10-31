// eslint-disable-next-line import/prefer-default-export
export function fizzbuzz(n) {
  let result = '';
  // eslint-disable-next-line no-plusplus
  for (let i = 0; i < n; i++) {
    if (n % 3 === 0 && n % 5 === 0) {
      result += 'FizzBuzz, ';
    } else if (n % 5 === 0) {
      result += 'buzz, ';
    } else if (n % 3 === 0) {
      result += 'fizz, ';
    } else {
      result += 'i, ';
    }
  }
  return result;
}
