package com.learnservlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/learn")
public class LearnServlet extends HttpServlet {

	private static final long serialVersionUID = 6421136261960165746L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/Learn.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//
		response.setContentType("text.html");
		response.getWriter().println("<h1>Received POST Data </h1>");
		response.getWriter().println("<p>Username: "+username+"</p>");
		response.getWriter().println("<p>Password: "+password+"</p>");
		
		
		
	}
	
}
