const divs = document.querySelectorAll('.div1');

function mouseOver(event) {
    event.target.style.backgroundColor = 'blue';
    event.target.style.color = 'white';
}

function mouseOut(event) {
    event.target.style.backgroundColor = '';
    event.target.style.color = '';
}

divs.forEach(function (div) {
    div.addEventListener('mouseover', mouseOver);
    div.addEventListener('mouseout', mouseOut);
});