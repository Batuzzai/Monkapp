<?php
    
	$hostname='localhost';
    $database='id11498467_registro_de_usuarios';
    $username='id11498467_root';
    $password='nokia303..';
    $conexion = new mysqli($hostname, $username, $password, $database);
    if($conexion->connect_errno){
        echo "lo sentimos, el sitio web esta experimentando errores";
    }  
?>