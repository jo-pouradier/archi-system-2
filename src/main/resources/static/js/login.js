// import * as moduleForm from './moduleForm.js'

async function login(){
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const data = {email: email, password: password};
    console.log(email, password);
    await fetch('/login-form', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(async function(response) {
        let res = response.body.getReader();
        console.log("coucoucopucou");
        let resp = (await res.read()).value;
        console.log("response1232315312" + resp);
        if(response.ok) {
            console.log("response" + (await res.read()));
            try{
                if(data !== "-1"){
                    document.cookie = "userId=" + await response.body + ";path=/";
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