
function addNewRequest(request) {

    let url = 'http://localhost:7777/r/new';
    let xhr = new XMLHttpRequest();
 

    // fill el with input from form values: 
    let input_boxes = document.getElementsByTagName('input');
    
    let new_id = document.createElement('p');
    new_id.innerText = input_boxes[0].value;
    
    let new_description = document.createElement('p');
    new_description.innerText = input_boxes[1].value;
    
    let new_amount = document.createElement('p');
    new_amount.innerText = input_boxes[2].valueAsNumber;
    
    
    // creating relationships between els:
    // new_request_box.appendChild(new_title);
    // new_request_box.appendChild(new_id);
    // new_request_box.appendChild(new_description);
    // new_request_box.appendChild(new_amount);
    // container.appendChild(new_request_box);

    xhr.open("post", url);
    xhr.send(request);
    
    }
    const submit_button = document.querySelector('[type=submit]');
    submit_button.addEventListener('click', (event) => {
           
        addNewRequest();

    });