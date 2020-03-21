<?php
session_start();

$con = mysqli_connect('localhost'

$conn = new mysqli ($host, $dbusername, $dbpassword, $dbname);

if (mysqli_connect_error()){
    die('Connect Error ('. mysqli_connect_errno() .') '
        .mysqli_connect_error());
}
else{
    $sql = "INSERT INTO account (username, password)
    values ('$username', '$password')";
    if ($conn->query($sql)){
        echo "New record is inserted sucessfully;"
    }
    else {
        echo "Error: ". $sql ."<br>". $conn->error;
    }
    $conn->close();
}
$username = filter_input(INPUT_POST, 'username');
$password = filter_input(INPUT_POST, 'password');

$host = "localhost";
$dbusername = "root";
$dbpassword = "";
$dbname = "SENG"




$conn = new mysqli ($host, $dbemail, $dbusername, $dbpassword, $dbname);

if (mysqli_connect_error()){
    die('Connect Error ('. mysqli_connect_errno() .') '
        .mysqli_connect_error());
}
else{
    $sql = "INSERT INTO account (email, username, password)
    values ('$email', '$username', '$password')";
    if ($conn->query($sql)){
        echo "New record is inserted sucessfully;"
    }
    else {
        echo "Error: ". $sql ."<br>". $conn->error;
    }
    $conn->close();
}


mysql_connect($host, $username, $password);
mysql_select_db($dbname);

if(isset(['email'])) {
    $email=$_POST['email'];
    $password=$_POST['psw'];

    $sql="select * from loginform where user='".$username."'AND Pass='".$password."'
    limit 1";

    $result=mysql_query($sql);

    if(mysql_num_rows($result)==1) {
        echo " You have Successfully Logged in";
        exit();
    }
}

?>