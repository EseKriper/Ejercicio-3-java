<%@page import="controller.CalculoTrianguloServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="html.css">
<title>Área y perimetro</title>
</head>
<body>
	<h1>Calcular el Área y el perímetro de un triángulo equilátero</h1>
	<form method="post" action="CalculoTrianguloServlet">
		<label for="base">Base:</label>
		<input type="number" id="base" name="base" required><br><br>
		<label for="altura">Altura:</label>
		<input type="number" id="altura" name="altura" required><br><br>
		<input type="submit" value="Calcular">
	</form>
</body>
</html>