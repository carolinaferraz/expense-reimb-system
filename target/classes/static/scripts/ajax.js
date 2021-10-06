/* using readyState of an xhr as guide for this ajax workflow */


function getAllRequests() {

    let url = 'http://localhost:7777/r/all';
    let xhr = new XMLHttpRequest(); 

    // while waiting for response . . . (check readyState then build dom manip based on status code)
    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4 && xhr.status === 200) {

    // accessing the data from the req && immediately convert it to a js object (JSON.parse is the opp of JSON.stringify):

        let requests = JSON.parse(xhr.response);

        // console.log(requests);

    /*iterate over array and manipulate dom accordingly. note that the information is not coming from a form anymore but from the db */

    for(let request of requests) {
        
        let home_container = document.getElementById('home-container');

        let active_list = document.createElement('ul');
        active_list.className = "active-list";

        let link_id = document.createElement('a');
        let req_header = document.createElement('li');

        link_id.href = "http://localhost:7777/r/"+ request.request_id,
        link_id.innerText = request.request_id;

        let new_description = document.createElement('span');
        new_description.innerText = " - " + request.request_description + " - ";

        let new_amount = document.createElement('span');
        new_amount.innerText = " US$ " + request.request_amount;

// creating relationships between els:

        home_container.appendChild(active_list);
        active_list.appendChild(req_header);
        req_header.appendChild(link_id);
        req_header.appendChild(new_description);
        req_header.appendChild(new_amount);
        } // end of 'for' loop


    }
        }
    // }

    xhr.open('GET', url);
    xhr.send();

}

// loading function on console for testing :)
window.onload = function() {
    getAllRequests();
}



