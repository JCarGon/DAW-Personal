const array1 = [1, 2, 3, 4, 86, 6, 5, 875];
const array2 = [1, 2, 3, 4, 86, 6, 5, 85];

function sevenBoom(array){
    let boom = false;
    for (let i = 0; i < array.length; i++) {
        let element = array[i].toString();
        if(element.includes('7')){
            boom = true;
            console.log('Boom!!');
            break;
        }
    }
    if(!boom){
        console.log('You stay alive');
    }
};

const sevenBoom2 = (array) => {
    let boom = false;
    for (let i = 0; i < array.length; i++) {
        let element = array[i].toString();
        if(element.includes('7')){
            boom = true;
            console.log('Boom!!');
            break;
        }
    }
    if(!boom){
        console.log('You stay alive');
    }
};

sevenBoom(array1);
sevenBoom2(array2);