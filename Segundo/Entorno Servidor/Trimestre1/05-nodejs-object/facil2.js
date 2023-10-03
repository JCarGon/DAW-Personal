const obj = { a: 1, b: 2, c: 3 };

const keys = Object.keys(obj);
const values = Object.values(obj);
const array = [keys,values] //[['a', 'b', 'c'], [1, 2, 3]]
for (let index = 0; index < array.length; index++) {
    console.log(array[index]);
}