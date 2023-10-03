const student1 = { nombre: "Juan", notas: [3, 5, 4] };
const student2 = { nombre: "Carlitos", notas: [5, 9, 7] };
const student3 = { nombre: "Maria", notas: [2, 3, 10] };
const student4 = { nombre: "Laura", notas: [8, 9, 8] };
const students = [student1, student2, student3, student4];

function topMark(students) {
  let topMark = 0;
  let studentTopMark = {};

  for (let i = 0; i < students.length; i++) {
    for (let j = 0; j < students[i].notas.length; j++) {
      if (students[i].notas[j] > topMark) {
        topMark = students[i].notas[j];
        studentTopMark = { name: students[i].nombre, topNote: topMark };
      }
    }
  }
  return studentTopMark;
}

console.log(topMark(students));