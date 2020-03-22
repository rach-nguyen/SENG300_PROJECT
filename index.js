var modal = document.getElementById("id01");
var modal2 = document.getElementById("id02");

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal || event.target == modal2) {
    modal.style.display = "none";
    modal2.style.display = "none";
  }
};

var password = document.getElementById("psw");
var confirmPassword = document.getElementById("Cpsw");
var matchpassword = document.getElementById("matchpassword");
var submit = document.getElementById("submit");

password.onfocus = function() {
  document.getElementById("checkpasswordmatch").style.display = "block";
};

password.onblur = function() {
  document.getElementById("checkpasswordmatch").style.display = "none";
};

confirmPassword.onfocus = function() {
  document.getElementById("checkpasswordmatch").style.display = "block";
};

confirmPassword.onblur = function() {
  document.getElementById("checkpasswordmatch").style.display = "none";
};

submit.onfocus = function() {
  document.getElementById("checkpasswordmatch").style.display = "block";
};

var check = function() {
  if (
    document.getElementById("psw").value ==
    document.getElementById("Cpsw").value
  ) {
    document.getElementById("matchpassword").style.color = "green";
    document.getElementById("matchpassword").innerHTML = "matching";
    matchpassword.classList.remove("invalid");
    matchpassword.classList.add("valid");
  } else {
    document.getElementById("matchpassword").style.color = "red";
    document.getElementById("matchpassword").innerHTML = "not matching";
  }
};
