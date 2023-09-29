function comprobarNumero(){
    const numero = prompt();
    if(numero>10){
        alert('El número es mayor que 10');
    }else if(numero<10){
        alert('El número es menor que 10');
    }else{
        alert('El número introducido es 10');
    }
};

comprobarNumero();