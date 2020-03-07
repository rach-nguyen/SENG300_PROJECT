function getLoginInfo(){
    let user = document.getElementById("uname").value;
    console.log(user);
    let pass = document.getElementById("passw").value;
    console.log(pass);
}

function openSign() {
    document.getElementById("signup").style.display = "block";
}
function closeSign() {
    document.getElementById("signup").style.display = "none";
}