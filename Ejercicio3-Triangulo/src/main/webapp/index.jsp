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

	<%
	String nombre = (String) session.getAttribute("nombre");
	if (nombre == null) {
	%>
	
	<form method="post" action="index.jsp">
		<label for="nombre">Ingresa tu nombre:</label> <input type="text"
			id="nombre" name="nombre" required><br> <br> <input
			type="submit" value="Guardar">
	</form>
	
	<%
	} else {
	out.println("<h1>Bienvenido, " + nombre + "!</h1>");
	}
	
	Cookie[] cookies = request.getCookies();
	
	double baseAnterior = 0;
	double alturaAnterior = 0;
	double areaAnterior = 0;
	double perimetroAnterior = 0;
	
	if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("base")) {
			baseAnterior = Double.parseDouble(cookie.getValue());
		} else if (cookie.getName().equals("altura")) {
			alturaAnterior = Double.parseDouble(cookie.getValue());
		} else if (cookie.getName().equals("area")) {
			areaAnterior = Double.parseDouble(cookie.getValue());
		} else if (cookie.getName().equals("perimetro")) {
			perimetroAnterior = Double.parseDouble(cookie.getValue());
		}
	}
	}
	%>

	<form method="post" action="CalculoTrianguloServlet">
		<label for="base">Base:</label> 
		<input type="number" id="base" name="base" required>
		<br> 
		<br> 
		<label for="altura">Altura:</label>
		<input type="number" id="altura" name="altura" required>
		<br>
		<br> 
		<input type="submit" value="Calcular">
	</form>

	<%if (areaAnterior != 0 && perimetroAnterior != 0) {%>
	
	<h2>Último triángulo calculado:</h2>
	<h3>Base:<%=baseAnterior%></h3>
	<h3>Altura:<%=alturaAnterior%></h3>
	<h3>Área:<%=areaAnterior%></h3>
	<h3>Perímetro:<%=perimetroAnterior%></h3>
	<%
	}
	%>

	<%
	String name = request.getParameter("nombre");
	if (name != null && !name.isEmpty()) {
		session.setAttribute("nombre", name);
	}
	%>

</body>

</html>