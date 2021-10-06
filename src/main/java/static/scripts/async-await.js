
async function getRequests() {
let url = 'http://localhost:7777/request/all';
let response_body = await fetch(url);
let requests = await response_body.json();

console.log(requests);

}

window.onload = function() {
    this.getRequests();
}