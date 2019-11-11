<?php
    include 'conexion.php';
    $nombres = $_POST['Nombres'];
    $apellidos = $_POST['Apellidos'];
    $correo = $_POST['Correo electronico'];
    $contrasena = $_POST['Contrasena'];
    $fecha = $_POST['Fecha de nacimiento'];

    $consulta = "insert into usuarios values('".$nombres."','".$apellidos."','".$correo."','".$constrasena."','".$fecha."')";
    mysqli_query($conexion, $consulta) or die (mysqli_error());
    mysqli_close($conexion);

?>