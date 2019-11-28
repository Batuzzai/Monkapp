<?php
    session_start();
    include_once 'conexion_dbs/conexion.php';

    if(!isset($_SESSION['user'])){              // Si el usuario entra a Pag_principal sin haberse logeado se le redirigirá a la pagina principal
        header('Location:index.php');
    }                                                                  
   
    $identificador = $_SESSION['user'] - 1;

    $data = json_decode(file_get_contents("http://13monoscl.000webhostapp.com/api/usuarios"), true);

    $sql = 'SELECT nick FROM usuarios WHERE id = ?';
    $instruccion = $pdo->prepare($sql);
    $instruccion->execute(array($_SESSION['user']));
    $r = $instruccion->fetch();


    if($r['nick'] == 'fromiti' || $r['nick'] == 'batuzzai' ){       
        header('Location:admin.php');   
    }else{       
        echo '<h1> Bienvenido '. $data[$identificador]['nombre_apellido']. '</h1>'; 
        echo '<h2> ID de usuario: '. $_SESSION['user']. '</h2>';

    }
    echo '<br><a href = "Cerrar_sesion.php"> Cerrar sesión </a>';



?>