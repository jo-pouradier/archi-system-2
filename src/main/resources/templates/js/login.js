

function setCookie(cname, cvalue, exdays) {
    const d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    let expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

async function sendForm(){
    const form = document.getElementById("addCardForm");
    const formData = new FormData(form);
    const card = Object.fromEntries(formData.entries());
    const cardSet = await getCards();

    for (let cardS of cardSet){
        if (cardS === card) {
            alert('La carte existe déjà');
            return;
        }
    }
    sendCard(card);
    cancelForm();
}

function cancelForm(){
    const form = document.getElementById("addCardForm");
    form.reset();
}

async function sendCard(card){
    const url = 'http://vps.cpe-sn.fr:8083/card';
    const context = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'accept': '*/*',
            'Access-Control-Allow-Origin': '*'
        },
        body: JSON.stringify(card)
    };
    let response = await fetch(url, context);
    if(response.ok){
        alert("La carte a bien été ajoutée");
        cancelForm();
    } else{
        console.log(response.status);
    }
}