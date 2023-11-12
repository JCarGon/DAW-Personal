document.querySelector('.footer-logo').addEventListener('click', function() {
  window.scroll({
      top: 0, // La posición hacia la que deseas desplazarte
      left: 0,
      behavior: 'smooth' // Hace que el scroll sea suave
  });
});

window.addEventListener('scroll', function() {
  const navBg = document.querySelector('.nav-bg');
  if (window.scrollY > 100) {
      navBg.style.position = 'fixed';
      navBg.style.top = '0';
  } else {
      navBg.style.position = 'static';
      navBg.style.top = 'auto';
  }
});

document.getElementById("btn_menu").addEventListener("click", showMenu);
document.getElementById("back_menu").addEventListener("click", hideMenu);
nav = document.querySelector(".nav-responsive");
background_menu = document.getElementById("back_menu");

function showMenu(){
  nav.style.right = "0px";
  background_menu.style.display = "block";
}

function hideMenu(){
  nav.style.right = "-330px";
  background_menu.style.display = "none";
}

document.addEventListener("DOMContentLoaded", function() {
  // Espera a que el DOM esté completamente cargado

  // Selecciona el botón "Cargar más" por su ID
  const loadMoreButton = document.getElementById("loadMoreButton");

  // Agrega un evento de clic al botón
  loadMoreButton.addEventListener("click", function() {
    // Crea un nuevo elemento div con la clase "product-row"
    const newRow = document.createElement("div");
    newRow.className = "product-row";

    // Agrega dos productos a la nueva fila (puedes personalizar esto según tus necesidades)
    newRow.innerHTML = `
      <div class="product-image">
        <img class="product-promo" src="imagenes/Kimetsu/Kimetsu1.png" alt="Nuevo Producto 1" width="500px">
        <p class="product-title">Nuevo Producto 1</p>
        <p class="product-price">PRECIO: 100€ <del><small>(PVP: 120€)</small></del></p>
      </div>
      <div class="product-image">
        <img class="product-promo" src="imagenes/Kimetsu/Kimetsu4.png" alt="Nuevo Producto 2" width="500px">
        <p class="product-title">Nuevo Producto 2</p>
        <p class="product-price">PRECIO: 150€ <del><small>(PVP: 180€)</small></del></p>
      </div>
    `;

    // Selecciona el contenedor de productos existente y agrega la nueva fila al final
    const productContainer = document.querySelector(".product-container");
    productContainer.appendChild(newRow);
  });
});
