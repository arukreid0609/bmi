package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;

@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/healthCheck.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double weight = Double.parseDouble(request.getParameter("weight"));
		Double height = Double.parseDouble(request.getParameter("height"));
		
		Health health = new Health();
		health.setWeight(weight);
		health.setHeight(height);
		
		HealthCheckLogic logic = new HealthCheckLogic();
		logic.execute(health);
		
		request.setAttribute("health", health);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/healthCheckResult.jsp");
		rd.forward(request, response);
	}

}
