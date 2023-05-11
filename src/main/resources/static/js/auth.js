function isUserLoggedIn() {
    // use cookie to check if user is logged in
    // if not, redirect to login page
    const user = document.cookie.indexOf('userId=');
    console.log(user);
    if (user !== -1) {
        console.log(document.cookie)
        return true;
    } else {
        window.location.href = "/login";
        return false;
    }
}