var tabla = [
  {
    Nombre: "Ana",
    Edad: 25,
    DNI: "45678912B",
    "Tiene/No tiene hijos": "Tiene",
    "Fecha de nacimiento": "12/05/1998",
  },
  {
    Nombre: "Carlos",
    Edad: 30,
    DNI: "12345678A",
    "Tiene/No tiene hijos": "No tiene",
    "Fecha de nacimiento": "05/02/1993",
  },
  {
    Nombre: "Berta",
    Edad: 28,
    DNI: "98765432C",
    "Tiene/No tiene hijos": "Tiene",
    "Fecha de nacimiento": "20/03/1995",
  },
  {
    Nombre: "David",
    Edad: 31,
    DNI: "11223344D",
    "Tiene/No tiene hijos": "Tiene",
    "Fecha de nacimiento": "18/08/1992",
  },
  {
    Nombre: "Elena",
    Edad: 27,
    DNI: "23456789E",
    "Tiene/No tiene hijos": "No tiene",
    "Fecha de nacimiento": "03/11/1995",
  },
  {
    Nombre: "Fernando",
    Edad: 33,
    DNI: "34567890F",
    "Tiene/No tiene hijos": "Tiene",
    "Fecha de nacimiento": "15/09/1989",
  },
  {
    Nombre: "Gabriela",
    Edad: 22,
    DNI: "45678901G",
    "Tiene/No tiene hijos": "No tiene",
    "Fecha de nacimiento": "27/07/2001",
  },
  {
    Nombre: "Hector",
    Edad: 29,
    DNI: "56789012H",
    "Tiene/No tiene hijos": "Tiene",
    "Fecha de nacimiento": "02/04/1994",
  },
  {
    Nombre: "Isabel",
    Edad: 26,
    DNI: "67890123I",
    "Tiene/No tiene hijos": "No tiene",
    "Fecha de nacimiento": "08/12/1996",
  },
  {
    Nombre: "Juan",
    Edad: 35,
    DNI: "78901234J",
    "Tiene/No tiene hijos": "Tiene",
    "Fecha de nacimiento": "19/01/1987",
  },
  {
    Nombre: "Laura",
    Edad: 24,
    DNI: "89012345K",
    "Tiene/No tiene hijos": "Tiene",
    "Fecha de nacimiento": "13/06/1999",
  },
  {
    Nombre: "Manuel",
    Edad: 32,
    DNI: "90123456L",
    "Tiene/No tiene hijos": "No tiene",
    "Fecha de nacimiento": "10/10/1990",
  },
  {
    Nombre: "Natalia",
    Edad: 23,
    DNI: "01234567M",
    "Tiene/No tiene hijos": "No tiene",
    "Fecha de nacimiento": "29/04/2000",
  },
  {
    Nombre: "Olga",
    Edad: 29,
    DNI: "12345678N",
    "Tiene/No tiene hijos": "Tiene",
    "Fecha de nacimiento": "21/07/1993",
  },
  {
    Nombre: "Pedro",
    Edad: 36,
    DNI: "23456789O",
    "Tiene/No tiene hijos": "Tiene",
    "Fecha de nacimiento": "07/03/1986",
  },
  {
    Nombre: "Quim",
    Edad: 28,
    DNI: "34567890P",
    "Tiene/No tiene hijos": "Tiene",
    "Fecha de nacimiento": "14/09/1995",
  },
  {
    Nombre: "Rosa",
    Edad: 30,
    DNI: "45678901Q",
    "Tiene/No tiene hijos": "No tiene",
    "Fecha de nacimiento": "04/02/1992",
  },
  {
    Nombre: "Sergio",
    Edad: 27,
    DNI: "56789012R",
    "Tiene/No tiene hijos": "No tiene",
    "Fecha de nacimiento": "16/10/1995",
  },
  {
    Nombre: "Teresa",
    Edad: 31,
    DNI: "67890123S",
    "Tiene/No tiene hijos": "Tiene",
    "Fecha de nacimiento": "09/12/1991",
  },
  {
    Nombre: "Ursula",
    Edad: 29,
    DNI: "78901234T",
    "Tiene/No tiene hijos": "No tiene",
    "Fecha de nacimiento": "26/05/1993",
  },
];

function agregarFilasATabla() {
    var tablaPersonas = document.getElementById("tablaPersonas");
    var tbody = tablaPersonas.getElementsByTagName("tbody")[0];

    for (var i = 0; i < tabla.length; i++) {
        var fila = tbody.insertRow(i);
        var persona = tabla[i];
        
        var nombreCell = fila.insertCell(0);
        var edadCell = fila.insertCell(1);
        var dniCell = fila.insertCell(2);
        var hijosCell = fila.insertCell(3);
        var fechaNacimientoCell = fila.insertCell(4);

        nombreCell.innerHTML = persona.Nombre;
        edadCell.innerHTML = persona.Edad;
        dniCell.innerHTML = persona.DNI;
        hijosCell.innerHTML = persona["Tiene/No tiene hijos"];
        fechaNacimientoCell.innerHTML = persona["Fecha de nacimiento"];
    }
}

agregarFilasATabla();

var ordenAscendente = true;

function ordenarTablaPorNombre() {
    var tbody = document.querySelector("#tablaPersonas tbody");
    var filas = Array.from(tbody.rows);

    filas.sort(function(a, b) {
        var nombreA = a.cells[0].textContent;
        var nombreB = b.cells[0].textContent;

        if (ordenAscendente) {
            return nombreA.localeCompare(nombreB);
        } else {
            return nombreB.localeCompare(nombreA);
        }
    });

    while (tbody.firstChild) {
        tbody.removeChild(tbody.firstChild);
    }

    filas.forEach(function(fila) {
        tbody.appendChild(fila);
    });

    ordenAscendente = !ordenAscendente;
}

function ordenarTablaPorEdad() {
  var tbody = document.querySelector("#tablaPersonas tbody");
  var filas = Array.from(tbody.rows);

  filas.sort(function(a, b) {
      var edadA = parseInt(a.cells[1].textContent, 10);
      var edadB = parseInt(b.cells[1].textContent, 10);

      if (ordenAscendente) {
          return edadA - edadB;
      } else {
          return edadB - edadA;
      }
  });

  reordenarFilas(tbody, filas);
}

function ordenarTablaPorDNI() {
  var tbody = document.querySelector("#tablaPersonas tbody");
  var filas = Array.from(tbody.rows);

  filas.sort(function(a, b) {
      var dniA = a.cells[2].textContent;
      var dniB = b.cells[2].textContent;

      if (ordenAscendente) {
          return dniA.localeCompare(dniB);
      } else {
          return dniB.localeCompare(dniA);
      }
  });

  reordenarFilas(tbody, filas);
}

function ordenarTablaPorHijos() {
  var tbody = document.querySelector("#tablaPersonas tbody");
  var filas = Array.from(tbody.rows);

  filas.sort(function(a, b) {
      var hijosA = a.cells[3].textContent;
      var hijosB = b.cells[3].textContent;

      if (ordenAscendente) {
          return hijosA.localeCompare(hijosB);
      } else {
          return hijosB.localeCompare(hijosA);
      }
  });

  reordenarFilas(tbody, filas);
}

function ordenarTablaPorFechaNacimiento() {
  var tbody = document.querySelector("#tablaPersonas tbody");
  var filas = Array.from(tbody.rows);

  filas.sort(function(a, b) {
      var fechaA = a.cells[4].textContent;
      var fechaB = b.cells[4].textContent;

      var dateA = new Date(
          fechaA.split("/")[2], fechaA.split("/")[1] - 1, fechaA.split("/")[0]
      );
      var dateB = new Date(
          fechaB.split("/")[2], fechaB.split("/")[1] - 1, fechaB.split("/")[0]
      );

      if (ordenAscendente) {
          return dateA - dateB;
      } else {
          return dateB - dateA;
      }
  });

  reordenarFilas(tbody, filas);
}

function reordenarFilas(tbody, filas) {
  while (tbody.firstChild) {
      tbody.removeChild(tbody.firstChild);
  }

  filas.forEach(function(fila) {
      tbody.appendChild(fila);
  });

  ordenAscendente = !ordenAscendente;
}

var thNombre = document.querySelector("#tablaPersonas th:first-child");
thNombre.addEventListener("click", ordenarTablaPorNombre);

var thEdad = document.querySelector("#tablaPersonas th:nth-child(2)");
thEdad.addEventListener("click", ordenarTablaPorEdad);

var thDNI = document.querySelector("#tablaPersonas th:nth-child(3)");
thDNI.addEventListener("click", ordenarTablaPorDNI);

var thHijos = document.querySelector("#tablaPersonas th:nth-child(4)");
thHijos.addEventListener("click", ordenarTablaPorHijos);

var thFechaNacimiento = document.querySelector("#tablaPersonas th:nth-child(5)");
thFechaNacimiento.addEventListener("click", ordenarTablaPorFechaNacimiento);