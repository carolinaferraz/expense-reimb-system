/* a promise is basically a 'stand-in' for a value. */

let my_promise = new Promise((resolve, reject) => {
    resolve('successfully obtained requests');
});
my_promise.then(
    (data) => {
        console.log(data);
    }
);


// creation flow much like ajax, but now wrapped in a Promise. this is more verbose 
let xhr_promise = new Promise((resolve, reject) => {

let url = 'http://localhost:7777/request/all';
let xhr = new XMLHttpRequest();

xhr.onreadystatechange = function() {
    if(xhr.readyState === 4 && xhr.status === 200) {
        let requests = resolve(JSON.parse(xhr.response));

        console.log(requests);
    } else if(xhr.readyState === 4 && xhr.status !== 200) {
        reject('something went wrong');
    }
}
xhr.open('GET', url);
xhr.send();
});

xhr_promise.then(
    (requests) => {
        console.log(requests);
    }
)