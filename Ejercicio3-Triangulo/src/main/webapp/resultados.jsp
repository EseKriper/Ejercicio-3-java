<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="jsp.css">
<title>Resultados del tri�ngulo equil�tero</title>
</head>

<body>

	<h1>Resultados del tri�ngulo equil�tero</h1>
	<h3>El �rea del tri�ngulo es:<%=request.getAttribute("area")%></h3>
	<h3>El per�metro del tri�ngulo es:<%=request.getAttribute("perimetro")%></h3>

	<form action="index.jsp">
		<input type="submit" value="Calcular otro tri�ngulo">
	</form>
</body>
</html>
