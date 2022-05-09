package com.lipcoder.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Annotaion을 이용한 매핑 
// 코딩량이 적고, 독립적인 개발이 가능하게 한다.
@WebServlet("/korean")
public class KoreanTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 응답할 내용의 문자 인코딩 형식을 설정한다.
		resp.setCharacterEncoding("UTF-8");
		// 수신받을 브라우저에게 문자 인코딩 형식을 알려준다.
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();

		for(int i = 0; i < 100; i++)
			out.println((i+1) + " : 안녕 Servlet!!<br />");
		
		
	}
}
