<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>	Admin Clientes AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
//al terminar de cargar se ejecuta la funcion anonima
	$(document).ready(function(){
		$.ajax({
			url : "http://localhost:8080/3-jee/clientes",
			success : function(cliente){
				var clientes = JSON.parse(cliente);
				$.each(clientes, function(index){
					$('#comboClientes').append('<option value="'+clientes[index].idCliente+'">'+clientes[index].nombre+'</option>');
					//console.log(clientes[index].nombre);
				});
			}
		});
		$("#subir").click(function(){
			var cliente = {
					idCliente : $("#txtid").val(),
					nombre : $("#txtnombre").val(),
					apaterno: $("#txtapaterno").val(),
					amaterno: $("#txtamaterno").val(),
					rfc: $("#txtrfc").val()
					}
			var json = JSON.stringify(cliente);
			$.ajax({
				url : "http://localhost:8080/3-jee/clientes",
				method : "POST",
				dataType : "json",
				contentType : "application/json",
				data : json,
				/*data : {
					nombre : $("#txtnombre").val(),
					apaterno: $("#txtapaterno").val(),
					amaterno: $("#txtamaterno").val(),
					rfc: $("#txtrfc").val()
				},*/
				success: function(resultado){
					if(resultado){
						alert("cliente registrado");
					}else{
						alert("Fallo el registro");
					}
				}
			})
		});
		$("#borrar").click(function(){
			var cliente = { idborrar : $("#comboClientes").val() }
			$.ajax({
				url : "http://localhost:8080/3-jee/clientes",
				method : "POST",
				data : cliente,
				success: function(resultado){
					if(resultado){
						alert("Operacion realizada");
					}else{
						alert("Operacion fallida");
					}
				}
			})
		});
	});
</script>
</head>
<body>
	<select id="comboClientes">
		<option value = "0">Selecciona un cliente</option>
	</select><br/>
	<input type="number" id ="txtid" value=0 placeholder="Id del cliente..." required/>
	<br/>
	<input type="text" id ="txtnombre" placeholder="Nombre del cliente..." required/>
	<br/>
	<input type="text" id ="txtapaterno" placeholder="Apellido Paterno..." required/>
	<br/>
	<input type="text" id ="txtamaterno" placeholder="Apellido Materno..." required/>
	<br/>
	<input type="text" id ="txtrfc" placeholder="RFC..."/>
	<br/>
	<input type="button" id="subir" value="Guardar/Actualizar"/>
	<input type="button" id="borrar" value="Eliminar"/>
	<input type="reset" value="Limpiar"/>
</body>
</html>