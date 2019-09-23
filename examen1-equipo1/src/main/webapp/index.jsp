<%@page import="java.util.List"%>
<%@page import="com.everis.examen1.equipo1.model.Compra" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./ComprasController" method="POST">
		<input type="text" name ="total" placeholder="Total de la compra" required/>
		<br/>
		<input type="date" name ="fecha" placeholder="Fecha de la compra" required/>
		<br/>
		<input type="submit" value="Guardar"/>
	</form>
	<%
		List<Compra> compras = (List<Compra>) request.getAttribute("listaCompras");
	%>
	<% if(compras != null && compras.size() > 0){ %>
	<table>
		<thead>
			<tr>
				<td>Id Compra</td>
				<td>Fecha</td>
				<td>Total</td>
				<td>Id cliente</td>
			</tr>
		</thead>
		<tbody>
			<% for (Compra compra : compras){ %>
			<tr>
				<td><%= compra.getIdcompra() %></td>
				<td><%= compra.getFechaCompra() %></td>
				<td><%= compra.getTotal() %></td>
				<td><%= compra.getIdCliente() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	<% }%>
</body>
</html>
