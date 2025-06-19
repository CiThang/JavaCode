package com.learnservlet;

import java.io.*;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ajaxServlet")
public class AJAXServlet extends HttpServlet {

	private static final long serialVersionUID = -7700755874240748101L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/data.jsp");
		rd.forward(req, resp);
	}
	
	   @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Đọc dữ liệu từ request
	        BufferedReader reader = request.getReader();
	        StringBuilder requestData = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            requestData.append(line);
	        }
	        reader.close();

	        // Chuyển đổi chuỗi JSON thành đối tượng JSON
	        String jsonData = requestData.toString();
	        JSONArray jsonArray = new JSONArray(jsonData);

	        // In dữ liệu ra màn hình server
	        System.out.println("Data received from JSP:");
	        for (int i = 0; i < jsonArray.length(); i++) {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            System.out.println("ID: " + jsonObject.getString("id"));
	            System.out.println("Name: " + jsonObject.getString("name"));
	            System.out.println("Age: " + jsonObject.getString("age"));
	            System.out.println("--------------------------");
	        }

	        // Thiết lập các thông số cần thiết cho response
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        // Phản hồi lại client
	        out.println("<html>");
	        out.println("<head><title>Data from JSP</title></head>");
	        out.println("<body>");
	        out.println("<h2>Data received and printed on server console.</h2>");
	        out.println("</body></html>");
	    }
	}