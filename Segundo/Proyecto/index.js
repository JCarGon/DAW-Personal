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