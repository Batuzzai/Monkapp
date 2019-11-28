<?php
    session_start();
    if(!isset($_SESSION['user'])){              // Si el usuario entra a Pag_principal sin haberse logeado se le redirigirá a la pagina principal
        header('Location:index');
    }
    $int = (int)$_SESSION['user'];
    $identificador = $int - 1;
    $data = json_decode(file_get_contents("http://localhost/Api/usuarios"), true);      
 
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Usuarios</title>
</head>
<body>
    <h1> Esta es la pagina de usuarios generales </h1>
    <h2> Bienvenido <?php echo $data[$identificador]['nombre_apellido']; ?> </h2>
    <h2> ID de usuario <?php echo $_SESSION['user']; ?> </h2>
    <a href="Cerrar_sesion"> Cerrar Sesion </a>
</body>
</html>