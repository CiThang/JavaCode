package com.learnservlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddRow")
public class LearnProAddRow extends HttpServlet {

	private static final long serialVersionUID = -4245368297738930980L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids = request.getParameterValues("ID");
		String[] names = request.getParameterValues("NAME");

		if (ids != null && names != null && ids.length == names.length) {
			for (int i = 0; i < ids.length; i++) {
				  System.out.println("ID: " + ids[i] + ", Name: " + names[i]);
			}		
		} else if(names == null) {
			System.out.println("name nulls");
		}
		response.sendRedirect("LearnProMain");
	}
}
