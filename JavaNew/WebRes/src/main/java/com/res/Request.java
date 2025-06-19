package com.res;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/request_test")
public class Request extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1738073579643397810L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("request "+ req.getMethod());	
		
		req.getContentType();
		System.out.println(req.getServerName());
		System.out.println(req.getServletPath());
		
		Enumeration<String> keys = req.getHeaderNames();
		while(keys.hasMoreElements()) {
			String key  = keys.nextElement();
			
			System.out.println(key + " : "+req.getHeader(key));
		}
	}
}
