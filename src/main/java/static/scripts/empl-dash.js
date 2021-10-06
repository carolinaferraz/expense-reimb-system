// get all approved requests
function getAllPending() {

    let url = 'http://localhost:7777/r/all/1';
    let xhr = new XMLHttpRequest(); 
    
        // while waiting for response . . . (check readyState then build dom manip based on status code)
        xhr.onreadystatechange = function() {
            if(xhr.readyState === 4 && xhr.status === 200) {
    
        // accessing the data from the req && immediately convert it to a js object (JSON.parse is the opp of JSON.stringify):
    
            let requests = JSON.parse(xhr.response);
    
            // console.log(requests);

             let header = document.createElement('h3');
            header.innerText = "Your Active Requests";
            
    
        
        for(let request of requests) {

            let container = document.getElementById('data-display');
           

            let archived_list = document.createElement('ul');
            archived_list.className = "archived-list";
    
            let link_id = document.createElement('a');
            let req_header = document.createElement('li');
    
            link_id.href = "http://localhost:7777/r/"+ request.request_id,
            link_id.innerText = request.request_id;

            let employee_id = document.createElement('span');
            employee_id.innerText = " eid: " + request.employee_id + " - ";
    
            let archived_description = document.createElement('span');
            archived_description.innerText = " - " + request.request_description + " - ";
    
            let archived_amount = document.createElement('span');
            archived_amount.innerText = " US$ " + request.request_amount;
                
    
    // creating relationships between els:

            
            container.appendChild(header);
            header.appendChild(archived_list);
            archived_list.appendChild(req_header);
            req_header.appendChild(employee_id);
            req_header.appendChild(link_id);
            
            req_header.appendChild(archived_description);
            req_header.appendChild(archived_amount);
            } // end of 'for' loop
    
    
        }
            }
        // }
    
        xhr.open('GET', url);
        xhr.send();
    
    }

    const empl_getAll = document.getElementById("empl_getAll");
    empl_getAll.addEventListener('click', (event) => {
        getAllPending();
    });


