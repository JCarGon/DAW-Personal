const obj = { a: 1, b: 2, c: 3 };

const newObj = Object.entries(obj);
for (let index = 0; index < newObj.length; index++) {
    console.log(newObj[index]);
}