function addNewRequest() {


let container = document.getElementById('main-container');

// creating elements
let new_request_box = document.createElement('div');
new_request_box.className = "request-box";
let new_title = document.createElement('h3');
new_title.innerText = "Success!";

// fill el with input from form values: 
let input_boxes = document.getElementsByTagName('input');

let new_id = document.createElement('p');
new_id.innerText = input_boxes[0].value;

let new_description = document.createElement('p');
new_description.innerText = input_boxes[1].value;;

let new_amount = document.createElement('p');
new_amount.innerText = input_boxes[2].value;


// creating relationships between els:
new_request_box.appendChild(new_title);
new_request_box.appendChild(new_id);
new_request_box.appendChild(new_description);
new_request_box.appendChild(new_amount);
container.appendChild(new_request_box);

}

// targeting button (input element here) and disabling its default behavior (refreshing the page)

// let submit_button = document.querySelector('[type=submit]')
// submit_button.addEventListener('click', (event) => {
//     if(event.cancelable) {
//         event.preventDefault();
//     }

// // impl custom behaviour by calling function
// addNewRequest();

// })