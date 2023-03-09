package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculoTrianguloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalculoTrianguloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double base = Double.parseDouble(request.getParameter("base"));
		double altura = Double.parseDouble(request.getParameter("altura"));
		calculo.Triangulo triangulo = new calculo.Triangulo(base, altura);
		double area = triangulo.calcularArea();
		double perimetro = triangulo.calcularPerimetro();
		request.setAttribute("area", area);
		request.setAttribute("perimetro", perimetro);
		request.getRequestDispatcher("resultados.jsp").forward(request, response);
	}
}
