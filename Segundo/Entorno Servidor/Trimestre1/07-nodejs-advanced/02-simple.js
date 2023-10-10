const promise = new Promise(function(resolve, reject) {
    resolve('Success');
    //reject('Error')
});

promise
    .then((value) => console.log(value))
    .catch((reason) => console.log(reason));