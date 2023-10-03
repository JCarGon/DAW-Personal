function OvsE(number){
    const stringNumber = number.toString();
    let arrayNumber = [];
    let acc = 0;
    for(let i=0; i<stringNumber.length; i++){
        arrayNumber.push(Number(stringNumber[i]));
    }
    for(let i=0; i<arrayNumber.length; i++){
        acc += arrayNumber[i];
    }
    if(acc%2 != 0){
        console.log('Oddish');
    }else{
        console.log('Evenish');
    }
};

const OvsE2 = (number) => {
    const stringNumber = number.toString();
    let arrayNumber = [];
    let acc = 0;
    for(let i=0; i<stringNumber.length; i++){
        arrayNumber.push(Number(stringNumber[i]));
    }
    for(let i=0; i<arrayNumber.length; i++){
        acc += arrayNumber[i];
    }
    if(acc%2 != 0){
        console.log('Oddish');
    }else{
        console.log('Evenish');
    }
};

OvsE(123445); //impar - oddish
OvsE2(12368); //par - evenish