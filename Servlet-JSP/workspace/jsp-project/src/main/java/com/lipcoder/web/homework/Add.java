package com.lipcoder.web.homework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// Service
		int x = 0;
		int y = 0;
		String ParamX = req.getParameter("x");
		String ParamY = req.getParameter("y");
		
		try {
			x = Integer.parseInt(ParamX);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			y = Integer.parseInt(ParamY);
		} catch (Exception e) {
			// TODO: handle exception
		}

		resp.getWriter().println("덧셈 결과 : " + (x + y));
	}
}
