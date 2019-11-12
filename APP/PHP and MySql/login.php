<?php

	$hostname='localhost';
    $database='id11498467_registro_de_usuarios';
    $username='id11498467_root';
    $password='nokia303..';
	
	$json=array();
		if(isset($_POST["correo"]) && isset($_POST["contrasena"])){
			
			$user=$_POST['correo'];
			$pwd=$_POST['contrasena'];
			
			//$user = "lucas.ivergara18@gmail.com";
			//$pwd = "nokia303..";
			
			$conexion=mysqli_connect($hostname,$username,$password,$database);
		
			$consulta="SELECT correo, contrasena, nombres, edad, apellidos FROM usuarios WHERE correo = '{$user}' AND contrasena = '{$pwd}'";
			
			$resultado=mysqli_query($conexion,$consulta);

			if($consulta){
				if($reg=mysqli_fetch_array($resultado)){
					$json['datos'][]=$reg;
				}
				mysqli_close($conexion);
				echo json_encode($json);
			
			}else{	
				$results["correo"]='';
				$results["contrasena"]='';
				$results["nombres"]='';
				$results["apellidos"]='';
				$results["edad"]='';
				$json['datos'][]=$results;
			echo json_encode($json);
			}
		
		}else{
			$results["correo"]='';
			$results["contrasena"]='';
			$results["nombres"]='';
			$results["apellidos"]='';
			$results["edad"]='';
			$json['datos'][]=$results;
			echo json_encode($json);
		}
?>