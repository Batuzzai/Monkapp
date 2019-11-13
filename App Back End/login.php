<?php
    
    $hostname='localhost';
    $database='id11498467_registro_de_usuarios';
    $username='id11498467_root';
    $password='nokia303..';

if($_SERVER['REQUEST_METHOD']=='POST'){

    $con = mysqli_connect($hostname, $username, $password, $database);

    $email = $_POST['correo'];
    $password = $_POST['contrasena'];

    $Sql_Query = "select * from usuarios where correo = '$email' and contrasena = '$password' ";

    $check = mysqli_fetch_array(mysqli_query($con,$Sql_Query));

        if(isset($check)){
            echo "True";
        }else{
            echo "False";
        }
}else{
    echo "Check Again";
    }
    mysqli_close($con);

?>
