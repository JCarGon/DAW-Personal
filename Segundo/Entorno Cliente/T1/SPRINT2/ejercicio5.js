function getXPath(element) {
  if (element.id !== '') {
    return `id("${element.id}")`;
  }

  if (element === document.body) {
    return element.tagName.toLowerCase();
  }

  const index = [...element.parentNode.children].indexOf(element) + 1;
  return `${getXPath(element.parentNode)}/${element.tagName.toLowerCase()}[${index}]`;
}

function handleClick(event) {
  const target = event.target;

  if (target.tagName === 'HTML') {
    alert('Se ha hecho clic en el elemento con XPATH: HTML');
  } else {
    const xpath = getXPath(target);
    alert(`Se ha hecho clic en el elemento con XPATH: ${xpath}`);
  }
}

document.addEventListener('click', function(event) {
  const target = event.target;

  if (target.tagName === 'IFRAME') {
    const iframeDocument = target.contentDocument;

    iframeDocument.addEventListener('click', function(iframeEvent) {
      const iframeTarget = iframeEvent.target;

      if (iframeTarget.tagName === 'BUTTON' && iframeTarget.id === 'iframeButton') {
        const xpath = getXPath(iframeTarget);
        alert(`Se ha hecho clic en el botón con id "myIframe" con XPATH: ${xpath}`);
      } else {
        const xpath = getXPath(iframeTarget);
        alert(`Se ha hecho clic en el elemento dentro del iframe con XPATH: ${xpath}`);
      }
    });
  } else {
    handleClick(event);
  }
});