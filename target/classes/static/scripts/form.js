function loginForm() {
    let url = 'http://localhost:7777/login';
    let xhr = new XMLHttpRequest();

    let employee = JSON.parse(xhr.response);

    console.log(employee);

    xhr.open("post", url);

    let formRes = JSON.stringify({"username": document.getElementById("username").value, "password":document.getElementById("password").value});
    
    xhr.send(formRes);

    }

    const login_btn = document.querySelector('[type=submit]');
    login_btn.addEventListener('click', (event) => {
          
        loginForm({logged:'in!'});

    });

    // manager login

    function loginForm() {
        let url = 'http://localhost:7777/locked';
        let xhr = new XMLHttpRequest();
    
        let employee = JSON.parse(xhr.response);
    
        xhr.open("post", url);
    
        let formRes = JSON.stringify({"username": document.getElementById("username").value, "password":document.getElementById("password").value});
        
        xhr.send(formRes);
    
        }
    
        const login_btn = document.querySelector('[type=submit]');
        login_btn.addEventListener('click', (event) => {
              
            loginForm({logged:'in!'});
    
        });