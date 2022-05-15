package com.lipcoder.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post-tag-with-filter")
public class ServletFilterTest extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		// 한글 요청이 많으므로 직접 설정하지 말고,
		// 필터로 하자..
		// web.xml에서 동작하도록!
		//req.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		out.println(title);
		out.println(content);
	}

}