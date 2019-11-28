<?php
    session_start();
    include_once 'conexion_dbs/conexion.php';

    if(!isset($_SESSION['id'])){              // Si el usuario entra a Pag_principal sin haberse logeado se le redirigirá a la pagina principal
        header('Location:index');
    }                                                                  
    $sql = 'SELECT nick FROM usuarios WHERE id = ?';
    $instruccion = $pdo->prepare($sql);
    $instruccion->execute(array($_SESSION['user']));
    $r = $instruccion->fetch();

    if($r['nick'] == 'fromiti' || $r['nick'] == 'batuzzai' ){       
        header('Location:admin');   
    }else{ 
        header('Location:principal');
    }
 
?>