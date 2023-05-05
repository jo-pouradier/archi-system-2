// import * as moduleForm from './moduleForm.js'

function login(){
    const data = document.getElementById("loginForm");

    console.log(data);
    fetch('/login-form', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(function(response) {
        if(response.ok) {
            try{
                document.cookie = "userId=" + response.body.userId + ";path=/";
                window.location.href = "/login";
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