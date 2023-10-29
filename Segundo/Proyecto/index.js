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

let line1__bars = document.querySelector(".line1__bars-menu");
let line2__bars = document.querySelector(".line2__bars-menu");
let line3__bars = document.querySelector(".line3__bars-menu");

function animateBars() {
  line1__bars.classList.toggle("activeline1__bars-menu");
  line2__bars.classList.toggle("activeline2__bars-menu");
  line3__bars.classList.toggle("activeline3__bars-menu");
}

document.querySelector(".bars__menu").addEventListener("click", animateBars);
