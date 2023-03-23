<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="jsp.css">
<title>Resultados del triángulo equilátero</title>
</head>

<body>

	<h1>Resultados del triángulo equilátero</h1>
	<h3>El área del triángulo es:<%=request.getAttribute("area")%></h3>
	<h3>El perímetro del triángulo es:<%=request.getAttribute("perimetro")%></h3>

	<form action="index.jsp">
		<input type="submit" value="Calcular otro triángulo">
	</form>
</body>
</html>
