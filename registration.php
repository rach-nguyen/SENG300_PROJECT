<?php

session_start();
$_SESSION['message'] = '';

$mysqli = new mysqli('localhost', 'root', '', 'seng');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $username = $mysqli->real_escape_string($_POST['uname']);
    $email = $mysqli->real_escape_string($_POST['email']);
    $password = md5($_POST['psw']);
    
    $_SESSION['uname'] = $username;
    
    $sql = "INSERT INTO users (email, username, password) "
            . "VALUES ('$email', '$username', '$password')";

    // if the query is successful redirect to page.
    if ($mysqli->query($sql) === true) {
        echo $_SESSION['message'] = "Registration succesful! Redirecting...";
        header("refresh:2;url= welcome.html");
    }
    else {
        echo $_SESSION['message'] = "User could not be added to the database. Redirecting...";
        header("refresh:2;url= index.html");
    }
}

?>

