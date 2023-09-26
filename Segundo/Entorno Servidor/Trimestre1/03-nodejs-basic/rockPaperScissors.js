const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  const juego = async () => {
    const textoIntro = 'Rock, paper o scissors. You have these options: \n1: Rock, \n2: Paper, \n3: scissors.\nChoose one: ';
    let userLifes = 3;
    let machineLifes = 3;
    let userOption = '';
  
    do{
      let machineOption = Math.floor(Math.random() * 3) + 1;
      userOption = await new Promise((resolve) => {
        readline.question(textoIntro, (userInput) => {
          resolve(userInput);
        });
      });
      if((userOption === '1') && (machineOption === 1)){ //rock-rock
        console.log(`Draw. Both options are rock. No one loses any life.\nUser life/s: ${userLifes} || Machine life/s: ${machineLifes}`);
      }else if((userOption === '1') && (machineOption === 2)){ //rock-paper
        userLifes--;
        console.log(`User option was rock, machine option was paper. Machine wins. User loses one life.\nVidas usuario: ${userLifes} || vidas máquina: ${machineLifes}`);
      }else if((userOption === '1') && (machineOption === 3)){ //rock-scissors
        machineLifes--;
        console.log(`User option was rock, machine option was scissors. User wins. Machine loses one life.\nUser life/s: ${userLifes} || Machine life/s: ${machineLifes}`);
      }else if((userOption === '2') && (machineOption === 2)){ //paper-paper
        console.log(`Draw. Both options are paper. No one loses any life.\nUser life/s: ${userLifes} || Machine life/s: ${machineLifes}`);
      }else if((userOption === '2') && (machineOption === 1)){ //paper-rock
        machineLifes--;
        console.log(`User option was paper, machine option was rock. User wins. Machine loses one life.\nUser life/s: ${userLifes} || Machine life/s: ${machineLifes}`);
      }else if((userOption === '2') && (machineOption === 3)){ //paper-scissors
        userLifes--;
        console.log(`User option was paper, machine option was scissors. Machine wins. User loses one life.\nUser life/s: ${userLifes} || Machine life/s: ${machineLifes}`);
      }else if((userOption === '3') && (machineOption === 3)){ //scissors-scissors
        console.log(`Draw. Both options are scissors. No one loses any life.\nUser life/s: ${userLifes} || Machine life/s: ${machineLifes}`);
      }else if((userOption === '3') && (machineOption === 1)){ //scissors-rock
        userLifes--;
        console.log(`User option was scissors, machine option was rock. Machine wins. User loses one life.\nUser life/s: ${userLifes} || Machine life/s: ${machineLifes}`);
      }else if((userOption === '3') && (machineOption === 2)){ //scissors-paper
        machineLifes--;
        console.log(`User option was scissors, machine option was paper. User wins. Machine loses one life.\nUser life/s: ${userLifes} || Machine life/s: ${machineLifes}`);
      }
    }while((userLifes !=0) && (machineLifes != 0));
  
    if(userLifes == 0){
      console.log('You havent got any lifes. Machine wins.');
    }else{
      console.log('MAchine havent got any lifes. You win.');
    }
    readline.close();
  };
  juego();