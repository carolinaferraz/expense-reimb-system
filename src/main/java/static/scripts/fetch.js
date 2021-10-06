/* the fetch api provides a simple way of fetching resources async  */

let url = 'http://localhost:7777/r/all';

fetch(url).then(
    response => {
        response.json().then(
            json_body => {
                console.log(json_body);
            }
        ) 
    }
)