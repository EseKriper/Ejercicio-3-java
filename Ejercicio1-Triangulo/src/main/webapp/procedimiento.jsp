<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="calculo.Triangulo" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="jsp.css">
<meta charset="UTF-8">
<title>Resultado del cálculo</title>
</head>
<body>
	<%
		double base = Double.parseDouble(request.getParameter("base"));
		double altura = Double.parseDouble(request.getParameter("altura"));
		//------------------------------------------------------------------
		Triangulo triangulo = new Triangulo(base, altura);
		double area = triangulo.calcularArea();
		double perimetro = triangulo.calcularPerimetro();
	%>
	<h1>Resultado del cálculo</h1>
	<p>El área del triángulo es: <%= area %></p>
	<p>El perímetro del triángulo es: <%= perimetro %></p>
</body>
</html>