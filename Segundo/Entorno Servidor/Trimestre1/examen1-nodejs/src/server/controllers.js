export function notFoundController(req, res) {
  const headers = {
    'Content-Type': 'text/html',
  };
  res.headers(headers);
  return res.status(200).send('<h1>Redirecting</h1>');
}

let playerPlace = 1;
let computerPlace = 1;
export function tirardado(req, res) {
  let msgPlayer = '';
  let msgComputer = '';
  const headers = {
    'Content-Type': 'text/html',
  };
  res.headers = headers;
  const playerNumber = Math.floor(Math.random() * 6) + 1;
  const computerNumber = Math.floor(Math.random() * 6) + 1;
  playerPlace += playerNumber;
  computerPlace += computerNumber;
  if (playerPlace < 63) {
    if (playerPlace === 5) {
      playerPlace = 9;
      msgPlayer = `El jugador ha sacado un ${playerNumber}, ha llegado a la casilla 5 y 
      salta a la casilla ${playerPlace}.`;
    } else if (playerPlace === 6) {
      playerPlace = 12;
      msgPlayer = `El jugador ha sacado un ${playerNumber}, ha llegado a la casilla 6 y 
      salta a la casilla ${playerPlace}.`;
    } else if (playerPlace === 9) {
      playerPlace = 14;
      msgPlayer = `El jugador ha sacado un ${playerNumber}, ha llegado a la casilla 9 y 
      salta a la casilla ${playerPlace}.`;
    } else if (playerPlace === 12) {
      playerPlace = 6;
      msgPlayer = `El jugador ha sacado un ${playerNumber}, ha llegado a la casilla 12 y 
      retrocede a la casilla ${playerPlace}.`;
    } else if (playerPlace === 58) {
      playerPlace = 1;
      msgPlayer = `El jugador ha sacado un ${playerNumber}, ha llegado a la casilla 58 y 
      retrocede a la casilla ${playerPlace}.`;
    } else {
      msgPlayer = `El jugador ha sacado un ${playerNumber} y ha llegado a 
      la casilla ${playerPlace}.`;
    }
  } else if (playerPlace > 63) {
    const restPlayer = playerPlace - 63;
    playerPlace = 63;
    playerPlace -= restPlayer;
    msgPlayer = `El jugador ha sacado un ${computerNumber}, ha pasado la casilla 63 y ha vuelto 
    a la casilla ${playerPlace}.`;
  }
  if (computerPlace < 63) {
    if (computerPlace === 5) {
      computerPlace = 9;
      msgComputer = `La máquina ha sacado un ${computerNumber}, ha llegado a la casilla 5 y 
      salta a la casilla ${computerPlace}.`;
    } else if (computerPlace === 6) {
      computerPlace = 12;
      msgComputer = `La máquina ha sacado un ${computerNumber}, ha llegado a la casilla 6 y 
      salta a la casilla ${computerPlace}.`;
    } else if (computerPlace === 9) {
      computerPlace = 14;
      msgComputer = `La máquina ha sacado un ${computerNumber}, ha llegado a la casilla 9 y 
      salta a la casilla ${computerPlace}.`;
    } else if (computerPlace === 12) {
      computerPlace = 6;
      msgComputer = `La máquina ha sacado un ${computerNumber}, ha llegado a la casilla 12 y 
      retrocede a la casilla ${computerPlace}.`;
    } else if (computerPlace === 58) {
      computerPlace = 1;
      msgComputer = `La máquina ha sacado un ${computerNumber}, ha llegado a la casilla 58 y 
      retrocede a la casilla ${computerPlace}.`;
    } else {
      msgComputer = `La máquina ha sacado un ${computerNumber} y ha llegado a 
      la casilla ${computerPlace}.`;
    }
  } else if (computerPlace > 63) {
    const restComputer = computerPlace - 63;
    computerPlace = 63;
    computerPlace -= restComputer;
    msgPlayer = `La máquina ha sacado un ${computerNumber}, ha pasado la casilla 63 y ha vuelto 
    a la casilla ${computerPlace}.`;
  }
  if ((computerPlace === 63) && (playerPlace !== 63)) {
    msgComputer = `La máquina ha sacado un ${computerNumber} y ha llegado a 
    la casilla 63. Gana la partida!`;
  } else if ((computerPlace !== 63) && (playerPlace === 63)) {
    msgPlayer = `El jugador ha sacado un ${playerNumber} y ha llegado a 
    la casilla 63. Gana la partida!`;
  } else if ((computerPlace === 63) && (playerPlace === 63)) {
    return res.status(200).send('Empate, los dos llegaron a 63 a la vez.');
  }
  return res.status(200).send(`${msgPlayer} || ${msgComputer}`);
}

export function restartGame(req, res) {
  playerPlace = 1;
  computerPlace = 1;
  const headers = {
    'Content-Type': 'text/html',
  };
  res.headers = headers;
  return res.status(200).send(`El juego se reinicia. El usuario se encuentra en la posición: ${playerPlace};
  la máquina se encuentra en la posición: ${computerPlace}`);
}
