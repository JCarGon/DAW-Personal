const logoProductos = document.getElementById("logoProductos");
const categorias = document.querySelector(".categorias");

logoProductos.addEventListener("mouseenter", () => {
  categorias.style.display = "block";
});

logoProductos.addEventListener("mouseleave", () => {
  categorias.style.display = "none";
});