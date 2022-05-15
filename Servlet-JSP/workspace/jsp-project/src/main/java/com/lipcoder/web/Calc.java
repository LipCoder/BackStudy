package com.lipcoder.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// Service
		int x = 0;
		int y = 0;
		int result = 0;
		
		
		String ParamX = req.getParameter("x");
		String ParamY = req.getParameter("y");
		String op = req.getParameter("operator");
		
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
		
		if(op.equals("덧셈"))
			result = x + y;
		else
			result = x - y;
		
		
		resp.getWriter().println("계산 결과 : " + result);
	}
}
