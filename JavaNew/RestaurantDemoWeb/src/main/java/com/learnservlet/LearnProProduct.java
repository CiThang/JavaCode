package com.learnservlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LearnProProduct")
public class LearnProProduct extends HttpServlet {

	private static final long serialVersionUID = 3441248274242713339L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Lay du lieu tu form
		
		String userId = request.getParameter("userId");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		
		System.out.println("User Id: "+userId);
		System.out.println("UserName: "+username);
		System.out.println("Email: "+email);
				
		response.sendRedirect("LearnProMain");
	}
	
	
}
