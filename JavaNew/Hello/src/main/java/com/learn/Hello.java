package com.learn;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Hello extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3189996801679619907L;

	@Override
	public void init() throws ServletException {
		System.out.println("Bat dau voi servlet");
	}
	@Override
	public void destroy() {
		System.out.println("Ket thuc servlet");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
		
		System.out.println("Phuong thuc cua request "+arg0.getMethod());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("/text/html");
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("<h1> xin chao");
		
		writer.close();
	}
}