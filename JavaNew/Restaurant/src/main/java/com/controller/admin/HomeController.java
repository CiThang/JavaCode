package com.controller.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns  = {"/admin-home"})
public class HomeController extends HttpServlet   {

	private static final long serialVersionUID = -6664342169462446853L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
	}
	
}
