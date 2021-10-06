// manager special views 

    // get all requests
    function getAllRequests() {

        let url = 'http://localhost:7777/r/all/';
        let xhr = new XMLHttpRequest(); 
    
        // while waiting for response . . . (check readyState then build dom manip based on status code)
        xhr.onreadystatechange = function() {
            if(xhr.readyState === 4 && xhr.status === 200) {
    
        // accessing the data from the req && immediately convert it to a js object (JSON.parse is the opp of JSON.stringify):
    
            let requests = JSON.parse(xhr.response);
    
            // console.log(requests);
    
        /*iterate over array and manipulate dom accordingly. note that the information is not coming from a form anymore but from the db */
    
        for(let request of requests) {
            
            let container = document.getElementById('data-display');
    
            let header = document.createElement('h3');
            header.innerText = "Currently Active";

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

            
            let btn = document.createElement("button");
            btn.className="approve_btn"; btn.id="appbtn"
            btn.value="true";
            let t = document.createTextNode("approve");


            btn.appendChild(t);
            
    
    // creating relationships between els:
    
            container.appendChild(active_list);
            active_list.appendChild(req_header);
            req_header.appendChild(link_id);
            req_header.appendChild(new_description);
            req_header.appendChild(new_amount);
            req_header.appendChild(btn);
            } // end of 'for' loop
    
    
        }
            }
        // }
    
        xhr.open('GET', url);
        xhr.send();
    
    }
    
    // loading function on load for testing :)
    // window.onload = function() {
    //     getAllRequests();
    // }

    const get_all_link = document.getElementById("get_all");
    get_all_link.addEventListener('click', (event) => {
        getAllRequests();
    });




 

    ////////////////////////////////////// 
    // not working 
    function approveRequest() {

        let url = 'http://localhost:7777/r/'+request.request_id+'up';
        let xhr = new XMLHttpRequest(); 
    

        xhr.onreadystatechange = function() {
            if(xhr.readyState === 4 && xhr.status === 200) {

            let click_btn = document.getElementById("appbtn");
    
            let request = JSON.parse(xhr.response);


            request.request_id 
              
            
            }
        }
        xhr.open('post', url);
        xhr.send();
 }

    function removeRow() {

    let req_header = document.getElementsByTagName('li'); 
    let active_list = document.getElementsByClassName('active-list');
    active_list.removeChild(req_header); 
    }

    // let click_btn = document.getElementById("appbtn");
 
    // click_btn.addEventListener("click", approveRequest)
    // click_btn.addEventListener("click", removeRow)