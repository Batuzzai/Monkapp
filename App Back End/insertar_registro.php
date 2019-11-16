<?php
    include 'conexion.php';
    
    $nombres = $_POST["nombres"];
    $apellidos = $_POST["apellidos"];
    $correo = $_POST["correo"];
    $contrasena = $_POST["contrasena"];
    $edad = $_POST["edad"];

    $insertar = "INSERT INTO usuarios(nombres, apellidos, correo, contrasena, edad) VALUES ('$nombres','$apellidos','$correo','$contrasena','$edad')";
    
    $resultado = mysqli_query($conexion, $insertar);

    mysqli_close($conexion);

?>
