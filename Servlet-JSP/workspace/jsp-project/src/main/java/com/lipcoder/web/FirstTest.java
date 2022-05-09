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
@WebServlet("/hi")
public class FirstTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		//out.println("Hello World!");
		
		for(int i = 0; i < 100; i++)
			out.println((i+1) + " : Hello World!!<br >");
		
		// println이여도 html 형식의 파일이 아니기 때문에
		// 개행되어 출력되지 않는다. 
	}
}
