import './App.css';
import HolaMundo from '../holaMundo/HolaMundo';
import Saludo from '../Saludo/Saludo';

function App() {
  return (
    <div className="App">
      <HolaMundo/>
      <Saludo nombre="Ana"/>
      <Saludo nombre="Carlitos"/>
      <Saludo nombre="Jesus"/>
    </div>
  );
}

export default App;
