// get all approved requests
function getAllApprovedbyEmployeeID() {

    let url = 'http://localhost:7777/r/all/ok/6';
    let xhr = new XMLHttpRequest(); 
    
        // while waiting for response . . . (check readyState then build dom manip based on status code)
        xhr.onreadystatechange = function() {
            if(xhr.readyState === 4 && xhr.status === 200) {
    
        // accessing the data from the req && immediately convert it to a js object (JSON.parse is the opp of JSON.stringify):
    
            let requests = JSON.parse(xhr.response);
    
            // console.log(requests);
    

            let header = document.createElement('h3');
            header.innerText = "Past Requests";

            
    
        
        for(let request of requests) {

            let container = document.getElementById('data-display');
            // let active_list = document.getElementsByClassName('active-list');
            // container.removeChild(active_list);


            let archived_list = document.createElement('ul');
            archived_list.className = "archived-list";
    
            let link_id = document.createElement('a');
            let req_header = document.createElement('li');
    
            link_id.href = "http://localhost:7777/r/"+ request.request_id,
            link_id.innerText = request.request_id;
    
            let archived_description = document.createElement('span');
            archived_description.innerText = " - " + request.request_description + " - ";
    
            let archived_amount = document.createElement('span');
            archived_amount.innerText = " US$ " + request.request_amount;
                
    
    // creating relationships between els:

            
            container.appendChild(header);
            header.appendChild(archived_list);
            archived_list.appendChild(req_header);
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

    const mngr_archived = document.getElementById("mngr_archived");
    mngr_archived.addEventListener('click', (event) => {
        getAllApprovedbyEmployeeID();
    });

    // archive_link.onclick = getAllApproved();


