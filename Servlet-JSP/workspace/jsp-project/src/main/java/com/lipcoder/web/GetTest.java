package com.lipcoder.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get-tag")
public class GetTest extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		// cnt 키의 쿼리스트링 값을 가져와 숫자로 변환한다.
		//int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		// 기본값으로 설정 
		// null ptr exception을 회피하기 위
		/* 
		 * \/hello?cnt=3 	==>		"3"
		 * \/hello?cnt=		==>		"" 	 (X)
		 * \/hello?			==>		null (X)
		 * \/hello			==>		null (X)
		 */
		String temp = req.getParameter("cnt");
		int cnt = 100;
		if(temp != null && !temp.equals("")) 
			cnt = Integer.parseInt(temp);
		
		
		for(int i = 0; i < cnt; i++) {
			out.println("안녕하세요 Servlet!!!<br />");
		}
		
	}

}
