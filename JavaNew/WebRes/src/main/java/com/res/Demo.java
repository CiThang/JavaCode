package com.res;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Demo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5529430175405227220L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.println("Helloooo world");
		
		printWriter.println("<p> bug oiiii bug a` </p>");
		
		printWriter.close();
		
	}
}
