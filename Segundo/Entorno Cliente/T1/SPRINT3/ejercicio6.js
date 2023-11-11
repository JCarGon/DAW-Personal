const estudiantes = [
  { nombre: "Juan", ciudad: "Madrid", beca: false, edad: 21, calificaciones: { matematicas: 5, fisica: 7, historia: 6 } },
  { nombre: "Ana", ciudad: "Barcelona", beca: true, edad: 20, calificaciones: { matematicas: 9, fisica: 6, historia: 8 } },
  { nombre: "Pedro", ciudad: "Madrid", beca: false, edad: 23, calificaciones: { matematicas: 4, fisica: 5, historia: 7 } },
  { nombre: "Maria", ciudad: "Sevilla", beca: true, edad: 19, calificaciones: { matematicas: 8, fisica: 7, historia: 9 } },
  { nombre: "Jose", ciudad: "Madrid", beca: false, edad: 22, calificaciones: { matematicas: 6, fisica: 7, historia: 5 } },
  { nombre: "Isabel", ciudad: "Valencia", beca: true, edad: 20, calificaciones: { matematicas: 5, fisica: 8, historia: 7 } },
  { nombre: "David", ciudad: "Bilbao", beca: false, edad: 24, calificaciones: { matematicas: 7, fisica: 6, historia: 8 } },
  { nombre: "Laura", ciudad: "Barcelona", beca: true, edad: 19, calificaciones: { matematicas: 6, fisica: 8, historia: 7 } },
  { nombre: "Miguel", ciudad: "Sevilla", beca: false, edad: 21, calificaciones: { matematicas: 7, fisica: 7, historia: 8 } },
  { nombre: "Sara", ciudad: "Madrid", beca: true, edad: 20, calificaciones: { matematicas: 6, fisica: 5, historia: 9 } },
  { nombre: "Daniela", ciudad: "Valencia", beca: false, edad: 22, calificaciones: { matematicas: 8, fisica: 9, historia: 6 } },
  { nombre: "Alberto", ciudad: "Bilbao", beca: true, edad: 23, calificaciones: { matematicas: 5, fisica: 8, historia: 6 } },
  { nombre: "Gabriel", ciudad: "Sevilla", beca: false, edad: 19, calificaciones: { matematicas: 8, fisica: 5, historia: 7 } },
  { nombre: "Carmen", ciudad: "Barcelona", beca: true, edad: 24, calificaciones: { matematicas: 9, fisica: 9, historia: 9 } },
  { nombre: "Roberto", ciudad: "Madrid", beca: false, edad: 20, calificaciones: { matematicas: 4, fisica: 5, historia: 5 } },
  { nombre: "Carolina", ciudad: "Valencia", beca: true, edad: 22, calificaciones: { matematicas: 5, fisica: 7, historia: 6 } },
  { nombre: "Alejandro", ciudad: "Bilbao", beca: false, edad: 23, calificaciones: { matematicas: 9, fisica: 8, historia: 8 } },
  { nombre: "Lucia", ciudad: "Barcelona", beca: true, edad: 21, calificaciones: { matematicas: 7, fisica: 7, historia: 7 } },
  { nombre: "Ricardo", ciudad: "Sevilla", beca: false, edad: 19, calificaciones: { matematicas: 6, fisica: 5, historia: 6 } },
  { nombre: "Marina", ciudad: "Madrid", beca: true, edad: 20, calificaciones: { matematicas: 5, fisica: 9, historia: 8 } }
];

function mejoresEstudiantesPorAsignatura(asignatura) {
  const estudiantesConAsignatura = estudiantes.filter((estudiante) =>
    asignatura in estudiante.calificaciones
  );

  estudiantesConAsignatura.sort((a, b) =>
    b.calificaciones[asignatura] - a.calificaciones[asignatura]
  );

  const mejoresEstudiantes = estudiantesConAsignatura.slice(0, 3);

  console.log(`La asignatura escogida es: ${asignatura}`);
  console.log(`Los 3 mejores estudiantes en ${asignatura} son:`);
  mejoresEstudiantes.forEach((estudiante, index) => {
    console.log(`${index + 1}. ${estudiante.nombre} - Calificación: ${estudiante.calificaciones[asignatura]}`);
  });
}

document.getElementById("botonAsignaturaDestacada").addEventListener("click", () => {
  mejoresEstudiantesPorAsignatura("matematicas");
});

function asignaturaConMenorRendimiento(estudiantes) {
  const promediosPorAsignatura = {};

  estudiantes.forEach((estudiante) => {
    for (const asignatura in estudiante.calificaciones) {
      if (asignatura in promediosPorAsignatura) {
        promediosPorAsignatura[asignatura] += estudiante.calificaciones[asignatura];
      } else {
        promediosPorAsignatura[asignatura] = estudiante.calificaciones[asignatura];
      }
    }
  });

  for (const asignatura in promediosPorAsignatura) {
    promediosPorAsignatura[asignatura] /= estudiantes.length;
  }

  let asignaturaMenorRendimiento = null;
  let menorPromedio = Infinity;

  for (const asignatura in promediosPorAsignatura) {
    if (promediosPorAsignatura[asignatura] < menorPromedio) {
      menorPromedio = promediosPorAsignatura[asignatura];
      asignaturaMenorRendimiento = asignatura;
    }
  }

  return asignaturaMenorRendimiento;
}

document.getElementById("botonAsignaturaMenorRendimiento").addEventListener("click", () => {
  const asignaturaMenorRendimiento = asignaturaConMenorRendimiento(estudiantes);
  console.log(`La asignatura con menor rendimiento es: ${asignaturaMenorRendimiento}`);
});

function mejoraNotasEstudiantesConBeca(estudiantes) {
  const porcentajeMejora = 1.10;

  estudiantes.forEach((estudiante) => {
    if (estudiante.beca === true) {
      for (const asignatura in estudiante.calificaciones) {
    
        const nuevaCalificacion = Math.min(
          estudiante.calificaciones[asignatura] * porcentajeMejora,
          10
        );
        estudiante.calificaciones[asignatura] = parseFloat(nuevaCalificacion.toFixed(1));
      }
  
      console.log(`Notas mejoradas para ${estudiante.nombre}:`);
      console.log(estudiante.calificaciones);
    }
  });
}

document.getElementById("botonMejoraNotasBeca").addEventListener("click", () => {
  mejoraNotasEstudiantesConBeca(estudiantes);
});

function filtradoPorCiudadYAsignatura(estudiantes, ciudad, asignatura) {
  const estudiantesEnCiudad = estudiantes.filter((estudiante) => estudiante.ciudad === ciudad);

  estudiantesEnCiudad.sort((a, b) =>
    b.calificaciones[asignatura] - a.calificaciones[asignatura]
  );

  console.log(`Estudiantes de ${ciudad} en ${asignatura} (ordenados por calificación descendente):`);
  estudiantesEnCiudad.forEach((estudiante) => {
    console.log(`${estudiante.nombre} - Calificación: ${estudiante.calificaciones[asignatura]}`);
  });
}

document.getElementById("botonFiltradoCiudadAsignatura").addEventListener("click", () => {
  const ciudad = "Sevilla";
  const asignatura = "historia";
  filtradoPorCiudadYAsignatura(estudiantes, ciudad, asignatura);
});

function estudiantesSinBecaPorCiudad(estudiantes, ciudad) {
  const estudiantesSinBeca = estudiantes.filter((estudiante) =>
    estudiante.ciudad === ciudad && !estudiante.beca
  );

  console.log(`Estudiantes sin beca en ${ciudad}:`);
  estudiantesSinBeca.forEach((estudiante) => {
    console.log(estudiante.nombre);
  });
}

document.getElementById("botonEstudiantesSinBeca").addEventListener("click", () => {
  const ciudad = "Madrid";
  estudiantesSinBecaPorCiudad(estudiantes, ciudad);
});

function promedioEdadEstudiantesConBeca(estudiantes) {
  const estudiantesConBeca = estudiantes.filter((estudiante) => estudiante.beca);

  if (estudiantesConBeca.length === 0) {
    console.log("No hay estudiantes con beca en la lista.");
    return;
  }

  const sumaEdades = estudiantesConBeca.reduce((total, estudiante) => total + estudiante.edad, 0);
  const promedio = sumaEdades / estudiantesConBeca.length;

  console.log(`Promedio de edad de estudiantes con beca: ${promedio.toFixed(1)}`);
}

document.getElementById("botonPromedioEdadBeca").addEventListener("click", () => {
  promedioEdadEstudiantesConBeca(estudiantes);
});

function mejoresEstudiantesEnTotal(estudiantes) {
  estudiantes.forEach((estudiante) => {
    const calificaciones = Object.values(estudiante.calificaciones);
    const promedioGlobal = calificaciones.reduce((total, calificacion) => total + calificacion, 0) / calificaciones.length;
    estudiante.promedioGlobal = promedioGlobal;
  });

  estudiantes.sort((a, b) => b.promedioGlobal - a.promedioGlobal);

  const mejoresEstudiantes = estudiantes.slice(0, 2);

  return mejoresEstudiantes;
}

document.getElementById("botonMejoresEstudiantes").addEventListener("click", () => {
  const mejores = mejoresEstudiantesEnTotal(estudiantes);
  console.log("Los mejores estudiantes en total son:");
  mejores.forEach((estudiante, index) => {
    console.log(`${index + 1}. ${estudiante.nombre} - Promedio Global: ${estudiante.promedioGlobal.toFixed(1)}`);
  });
});

function estudiantesAprobados(estudiantes) {
  const estudiantesAprobados = estudiantes.filter((estudiante) => {
    const calificaciones = Object.values(estudiante.calificaciones);
    return calificaciones.every((calificacion) => calificacion >= 5);
  });

  const nombresAprobados = estudiantesAprobados.map((estudiante) => estudiante.nombre);

  return nombresAprobados;
}

document.getElementById("botonEstudiantesAprobados").addEventListener("click", () => {
  const nombresAprobados = estudiantesAprobados(estudiantes);

  if (nombresAprobados.length === 0) {
    console.log("No hay estudiantes que hayan aprobado todas las asignaturas.");
  } else {
    console.log("Estudiantes que han aprobado todas las asignaturas:");
    nombresAprobados.forEach((nombre, index) => {
      console.log(`${index + 1}. ${nombre}`);
    });
  }
});