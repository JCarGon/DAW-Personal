// eslint-disable-next-line import/prefer-default-export
export function fizzbuzz(n) {
  let result = '';
  // eslint-disable-next-line no-plusplus
  for (let i = 1; i <= n; i++) {
    if (i % 3 === 0 && i % 5 === 0) {
      result += 'FizzBuzz ';
    } else if (i % 5 === 0) {
      result += 'buzz ';
    } else if (i % 3 === 0) {
      result += 'fizz ';
    } else {
      result += `${i} `;
    }
  }
  return result;
}
