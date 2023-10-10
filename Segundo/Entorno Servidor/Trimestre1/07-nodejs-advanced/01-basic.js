const promise = new Promise(function(resolve, reject) {
    resolve('Success');
    //reject('Error')
});

promise.then(
    function(value) {
        console.log(`OK: ${value}`);
    },
    function(reason) {
      console.log(`Error: ${reason}`);
    }
)