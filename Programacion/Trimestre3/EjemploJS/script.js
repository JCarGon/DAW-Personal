function addDataToDatabase(data) {
    // Open a connection to the database
    const request = window.indexedDB.open('myDatabase', 4);
  
    // Add data
    request.onsuccess = function (event) {
      const db = event.target.result;
      const transaction = db.transaction(['myObjectStore'], 'readwrite');
      const objectStore = transaction.objectStore('myObjectStore');
      const createdEntry = objectStore.put(data);
  
      createdEntry.onsuccess = function () {
        console.log(`${data.title} added to the database`);
      };
  
      transaction.oncomplete = function () {
        console.log('???');
        db.close();
      };
    };
  }
  
  function load() {
    console.log('Hello!');
    // Open a connection to the database
    const request = window.indexedDB.open('myDatabase', 4);
    // Retrieve data
    request.onsuccess = function (event) {
      const db = event.target.result;
  
      if (!db.objectStoreNames.contains('myObjectStore')) {
        console.log('Object store not found');
        return;
      }
  
      const transaction = db.transaction(['myObjectStore'], 'readonly');
      const objectStore = transaction.objectStore('myObjectStore');
      const request = objectStore.getAll();
  
      request.onsuccess = function () {
        console.log(request.result);
        const div = document.getElementById('list');
        div.innerHTML = '';
        request.result.forEach((item) => {
          const elem1 = document.createElement('h3');
          const content1 = document.createTextNode(item.name);
          const elem2 = document.createElement('p');
          const content2 = document.createTextNode(item.area);
          elem1.onclick = function () {
            remove(item.id);
            load();
          };
          elem1.append(content1);
          div.append(elem1);
          elem2.append(content2);
          div.append(elem2);
        });
      };
  
      transaction.oncomplete = function () {
        db.close();
      };
    };
  }
  
  function remove(id) {
    // Open a connection to the database
    const request = window.indexedDB.open('myDatabase', 4);
    // Delete data
    request.onsuccess = function (event) {
      const db = event.target.result;
      const transaction = db.transaction(['myObjectStore'], 'readwrite');
      const objectStore = transaction.objectStore('myObjectStore');
      const request = objectStore.delete(id);
  
      request.onsuccess = function () {
        console.log('Data deleted from the database');
      };
  
      transaction.oncomplete = function () {
        db.close();
      };
    };
  }
  
  function add() {
    const name = document.getElementById('name').value;
    const area = document.getElementById('area').value;
    const data = { id: Math.random() * 1000, name, area };
    addDataToDatabase(data);
    load();
  }
  
  function init() {
    // Open a connection to the database
    const request = window.indexedDB.open('myDatabase', 4);
    console.log('Init');
  
    request.onerror = function (event) {
      console.log('Database error:', event);
    };
    // Create object stores
    request.onupgradeneeded = function (event) {
      console.log('Configuring IndexedDB...');
      const db = event.target.result;
      db.createObjectStore('myObjectStore', {
        keyPath: 'id',
        autoIncrement: true,
      });
      //objectStore.createIndex('title', 'title', { unique: false });
      load();
    };
  }