// GET pending request details
    
    function loadDetails() {
        let single = 'http://localhost:7777/r/34';
        let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4 && xhr.status === 200) {

        let request = JSON.parse(xhr.response);

        // console.log(request);

        let container = document.getElementById('request-wrapper');  

        if(request) {
            
            let req_details = document.createElement('div');
            req_details.className = "single-request";
            
            let req_id = document.createElement('p');
            req_id.innerText = "request id: " + request.request_id;

            let emp_id = document.createElement('p');
            emp_id.innerText = "employee id: " + request.employee_id;

            let req_description = document.createElement('p');
            req_description.innerText = "description: " + request.request_description;

            let req_amount = document.createElement('p');
            req_amount.innerText = "amount: US$ " + request.request_amount;

            container.appendChild(req_details);
            req_details.appendChild(req_id);
            req_details.appendChild(emp_id);
            req_details.appendChild(req_description);
            req_details.appendChild(req_amount);
        } 
    } 
}


    xhr.open('GET', single);
    xhr.send();    
    } // end of loadDetails(); 


    // loading function on console for testing :)
window.onload = function() {
    loadDetails();
}

/////////////////////////////////////////////////////////////////////

    // POST request status update 

    function changeRequestStatus() {


    let url = 'http://localhost:7777/r/:request_id/up';
    let xhr = new XMLHttpRequest();


    let request = JSON.parse(xhr.response);

    console.log(request);

    const btn = document.querySelector('#btn');

    // handle button click
    // btn.onclick = function () {

        // grouping radio buttons 
        const rbs = document.querySelectorAll('input[type="radio"]');
        let selectedValue;

        for (const rb of rbs) {
            if (rb.checked) {
                selectedValue = rb.value;
                break;
            }
        }

        if (rb.value == "true") {
            return xhr.re;

        }
        // alert(selectedValue);
    // };


    xhr.open("post", url);
    xhr.send(request);
    
    }      
 
    submit_button.addEventListener('click', (event) => {
        if(event.cancelable) {
            event.preventDefault();
        }            
        changeRequestStatus({test:'ok'});

    });