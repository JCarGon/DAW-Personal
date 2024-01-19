import './App.css';
import ListaDeFrutas from '../ListaFrutas/ListaDeFrutas';

function App() {
  const frutas1 = [
    {nombre: "manzana", emoji: "🍎"},
    {nombre: "plátano", emoji: "🍌"},
    {nombre: "naranja", emoji: "🍊"},
    {nombre: "pera", emoji: "🍐"}
  ];
  const frutas3 = [
    {nombre: "cereza", emoji: "🍒"},
    {nombre: "fresa", emoji: "🍓"},
    {nombre: "sandía", emoji: "🍉"},
    {nombre: "manzana", emoji: "🍎"}
  ];
  const frutas2 = [
    {nombre: "piña", emoji: "🍍"},
    {nombre: "melón", emoji: "🍈"},
    {nombre: "fresa", emoji: "🍓"},
    {nombre: "pera", emoji: "🍐"}
  ];

  return (
    <div className="App">
      <ListaDeFrutas frutas={frutas1}></ListaDeFrutas>
      <ListaDeFrutas frutas={frutas2}></ListaDeFrutas>
      <ListaDeFrutas frutas={frutas3}></ListaDeFrutas>
    </div>
  );
}

export default App;
