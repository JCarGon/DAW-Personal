function confirmarDatos(): void {
  const nombreInput = document.getElementById('nombreInput') as HTMLInputElement;
  const edadInput = document.getElementById('edadInput') as HTMLInputElement;

  if (nombreInput.value && edadInput.value) {
    const mensaje = `¡Hola! Mi nombre es ${nombreInput.value} y tengo ${edadInput.value} años.`;
    alert(mensaje);
  } else {
    alert('Por favor, completa todos los campos.');
  }
}
