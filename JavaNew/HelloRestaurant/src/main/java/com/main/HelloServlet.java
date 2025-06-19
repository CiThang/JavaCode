package com.main;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 843928242155303658L;

	@Override
	public void init() throws ServletException {
		System.out.println("Bat dau servlet");
	}
	
	@Override
	public void destroy() {
		System.out.println("Delete servlet");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
		
		System.out.println("Phuong thuc requests "+arg0.getMethod());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<h3> Xin chao servletttttt");
		writer.println("<p> bug bug");
		
		writer.close();
	}
}
