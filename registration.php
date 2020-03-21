<?php

session_start();
$_SESSION['message'] = '';

$mysqli = new mysqli('localhost', 'root', '', 'seng');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    //two passwords are equal to each other
    if ($_POST['psw'] == $_POST['Cpsw']) {

        $username = $mysqli->real_excape_string($_POST['uname']);
        $email = $mysqli->real_excape_string($_POST['email']);
        $password = md5($_POST['psw']);
        
        $_SESSION['uname'] = $username;
        
        $sql = "INSERT INTO users (email, username, password) "
                . "VALUES ('$email', '$username', '$password')";

        if ($mysqli->query($sql) === true) {
            $_SESSION['message'] = 'Registration succesful!';
            header("location: welcome.html");
        }
        else {
            $_SESSION['message'] = "User could not be added to the database.";
        }
    }
    else {
        $_SESSION['message'] = "Two passwords must match.";
    }
}

?>