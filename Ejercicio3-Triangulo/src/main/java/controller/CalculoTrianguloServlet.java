package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalculoTrianguloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalculoTrianguloServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double base = Double.parseDouble(request.getParameter("base"));
		double altura = Double.parseDouble(request.getParameter("altura"));
		
		calculo.Triangulo triangulo = new calculo.Triangulo(base, altura);
		
		double area = triangulo.calcularArea();
		double perimetro = triangulo.calcularPerimetro();

		Cookie baseCookie = new Cookie("base", String.valueOf(base));
		Cookie alturaCookie = new Cookie("altura", String.valueOf(altura));
		Cookie areaCookie = new Cookie("area", String.valueOf(area));
		Cookie perimetroCookie = new Cookie("perimetro", String.valueOf(perimetro));
		
		response.addCookie(baseCookie);
		response.addCookie(alturaCookie);
		response.addCookie(areaCookie);
		response.addCookie(perimetroCookie);

		request.setAttribute("area", area);
		request.setAttribute("perimetro", perimetro);
		request.getRequestDispatcher("resultados.jsp").forward(request, response);
	}
}
