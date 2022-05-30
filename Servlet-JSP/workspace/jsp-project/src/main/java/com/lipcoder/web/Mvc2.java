package com.lipcoder.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc2")
public class Mvc2 extends HttpServlet { 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
		
		String result;
		
		if(num % 2 != 0)
			result = "홀수";
		else 
			result = "짝수";
		
		System.out.println(request.hashCode());
		
		// 저장 객체를 사용
		request.setAttribute("result", result);
		
		String[] names = {"nuwlec", "dragon"};
		request.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL은 좋아요~!");
		request.setAttribute("notice", notice);
		
		// redirect
		// req, resp를 이어가지 않고, 새로운 페이지를 요청한다.
		
		// forward
		RequestDispatcher dispatcher 
			= request.getRequestDispatcher("mvc2.jsp");
		// req, resp의 내용이 jsp로 이어질 것이다.
		dispatcher.forward(request, response);
		
		
	}
}
