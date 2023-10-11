function agregarElemento() {
    const textoInput = document.getElementById('textoInput');
    const lista = document.getElementById('lista');

    const texto = textoInput.value;

    if (texto.trim() !== '') {
        const elementoLista = document.createElement('li');
        elementoLista.textContent = texto;

        lista.appendChild(elementoLista);

        textoInput.value = '';
    }else {
        alert('Tienes que introducir algún texto para agregarlo a la lista!')
    }
}