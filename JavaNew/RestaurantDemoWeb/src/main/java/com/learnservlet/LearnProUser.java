package com.learnservlet;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LearnProUser")
public class LearnProUser extends HttpServlet {

	private static final long serialVersionUID = -6187165086021437158L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// lay du lieu
		String[] userIds = request.getParameterValues("userIdd");
		String[] usernames = request.getParameterValues("username");
		String[] emails = request.getParameterValues("email");
		
		// in dux lieu ra man hinh
		
		if(userIds != null && usernames != null && emails != null) {
			for(int i = 0; i<userIds.length;i++) {
				System.out.println("UserID: "+userIds[i]);
				System.out.println("User Name: "+usernames[i]);
				System.out.println("Email: "+emails[i]);
			}
		} else  {
			System.out.println("null");
		}
		response.sendRedirect("LearnProMain");
	}
}
