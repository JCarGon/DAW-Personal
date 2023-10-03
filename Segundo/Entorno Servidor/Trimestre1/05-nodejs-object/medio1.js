obj = {a: 1, b: 2, c: 3};

function invertKeyValue(obj) {
    const newObj = {};
    const k = Object.keys(obj);
    const v = Object.values(obj);
    for (let i = 0; i < k.length; i++) {
      newObj[v[i]] = k[i];
    }
    return newObj;
};

console.log(invertKeyValue(obj));