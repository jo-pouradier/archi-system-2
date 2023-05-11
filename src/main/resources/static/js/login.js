// import * as moduleForm from './moduleForm.js'

function login(){
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const data = {username: username, password: password};
    console.log(username, password);
    fetch('/login-form', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(function(response) {
        if(response.ok) {
            console.log(response.body);
            try{
                if(data !== "-1"){
                    document.cookie = "userId=" + response.body.userId + ";path=/";
                    window.location.href = "/";
                }
            } catch (e) {
                console.log(e);
                alert("Error: " + e + "\nReconnectez vous");
            }
        } else {
            console.log(response.status);
            alert(response.message);
            return null;
        }
    })
}
function  register() {
    window.location.href = "/register";
}