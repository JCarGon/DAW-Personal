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
