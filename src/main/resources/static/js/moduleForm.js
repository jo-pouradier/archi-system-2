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

function setCookie(cname, cvalue, exdays) {
    const d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    let expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}