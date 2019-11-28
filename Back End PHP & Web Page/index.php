<?php 
	session_start(); 
	if(isset($_SESSION['user'])){
		header('Location:Pag_principal');
	}
?>	
<!DOCTYPE html>
<html lang = "es">
<head>
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Monkapp Login</title>
</head>
<body>
	<div class="align">
		<img class="logo" src="img/logo.svg">
		<div class="card">
			<div class="head">
				<div></div>
				<a id="login" class="selected" href="#login">Login</a>
				<a id="register" href="#register">Registro</a>
				<div></div>
			</div>
			<div class="tabs">
				<form action = "Login" method = "POST">
					<div class="inputs">
						<div class="input">
							<input placeholder="Nombre de usuario" type="text" name = "nombre_usuario">
							<img src="img/user.svg">
						</div>
						<div class="input">
							<input placeholder="Contraseña" type="password" name = "contrasena">
							<img src="img/pass.svg">
						</div>
					</div>
					<button>Acceder</button>
				</form>           
                
                <form action="Registrar_usuario" method = "POST">
					<div class="inputs">
                        <div class="input">
							<input placeholder="Nombre y apellido" type="text" name = "nombre_apellido">
							<img src="img/user.svg">
						</div>
                        <div class="input">
							<input placeholder="Correo electronico" type="text" name = "correo">
							<img src="img/mail.svg">
						</div>
						<div class="input">
							<input placeholder="Nombre de usuario" type="text" name = "nombre_usuario">
							<img src="img/user.svg">
						</div>
						<div class="input">
							<input placeholder="Contraseña" type="password" name = "contrasena">
							<img src="img/pass.svg">
						</div>
						<div class="input">
							<input placeholder="Confirmar contraseña" type="password" name = "contrasena2">
							<img src="img/pass.svg">
						</div>
					</div>
					<button>Registrarse</button>
				</form>
			</div>
		</div>
	</div>
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/index.js"></script>
</body>
</html>