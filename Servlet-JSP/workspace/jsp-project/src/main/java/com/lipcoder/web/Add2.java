package com.lipcoder.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// Service
		int result = 0;
		
		// 배열 형태로 같은 이름의 파라미터를 여러 개 받을 수 있다.
		String[] params = req.getParameterValues("num");
		
		for(int i = 0; i < params.length; i++) {
			// 주의 : for문 안에서는 선언이 한번만 만들어짐
			// 지역변수를 이용하면 좀 더 바람직한 코딩이다.
			int num = Integer.parseInt(params[i]);	
			result += num;
		}

		resp.getWriter().println("덧셈 결과 : " + result);
	}
}
