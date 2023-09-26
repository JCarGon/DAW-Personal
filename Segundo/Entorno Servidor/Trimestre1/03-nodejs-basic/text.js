const text = 'text to introduce';
const letter1 = 'x';
let countX = 0;
const letter2 = 'o';
let countO = 0;
let finalResult = false;

for(let i=0; i<text.length; i++){
    let actuaLetter = text[i];
    if(actuaLetter === letter1){
        countX++;
    }else if(actuaLetter === letter2){
        countO++;
    }
}

console.log(`Text: ${text}`);
console.log(`In this text there is/are ${countX} letter/s "${letter1}" and ${countO} letter/s "${letter2}"`);
if(countX == countO){
    finalResult = true;
    console.log(finalResult);
}else{
    console.log(finalResult);
}