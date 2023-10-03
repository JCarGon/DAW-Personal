const person1 = {nombre: 'juan', edad: 15};
const person2 = {nombre: 'juan', edad: 20};
const person3 = {"D": 0, "X": 1, "W": [1, 2, 4],"B": 3, "A": 0};
const person4 = {"D": 0, "X": 1, "W": [1, 2, 4], "B": 3, "A": 0};
let flag = true;

function objetosIguales(obj1, obj2) {
  if (Object.keys(obj1).length !== Object.keys(obj2).length) {
    flag = false;
    return flag;
  }else{
    for (let prop in obj1) {
      if (obj1.hasOwnProperty(prop)) {
        if(Array.isArray(obj1[prop]) && Array.isArray(obj2[prop])){
            let array1 = {};
            Object.assign(array1, obj1[prop]);
            let array2 = {};
            Object.assign(array2, obj2[prop]);
            flag = objetosIguales(array1, array2);
        }else if((Object.prototype.toString.call(obj1[prop]) === '[object Object]') && Object.prototype.toString.call(obj2[prop]) === '[object Object]'){
          objetosIguales(obj1[prop], obj2[prop]);
        }else if (!obj2.hasOwnProperty(prop) || obj1[prop] !== obj2[prop]) {
          flag = false;
          return flag;
        }
      }
    }
    return flag;
  }
}
console.log(objetosIguales(person1, person2));