package com.lipcoder.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
						   	HttpServletResponse resp) 
		throws ServletException, IOException {
		
		// application 저장소 (서블릿 Context)
		// 서블릿 컨테이너와 통신
		// 이를 통해 서블릿들끼리 정보를 공유할 수 있음
		ServletContext application = req.getServletContext();
		
	
		// Session 객체
		HttpSession session = req.getSession();
		
		
		// Cookie
		// Cookie를 받아온다.
		Cookie[] cookies = req.getCookies();
		
		String Param = req.getParameter("v");
		String op = req.getParameter("operator");
		
		int v = 0;
		
		try {
			v = Integer.parseInt(Param);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// 계산
		if(op.equals("=")) {
			
			// servlet context를 이용해 
			// container에 저장된 값을 가져온다.
			// int x = (Integer)application.getAttribute("value");
			
			// session 객체를 이용하여 값을 가져온다.
			// int x = (Integer)session.getAttribute("value");
			
			int x = 0;
			
			// 올바른 쿠키를 찾는다.
			for(Cookie c : cookies) 
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			
			
			
			int y = v;
			
			// String operator = (String)application.getAttribute("op");
			// String operator = (String)session.getAttribute("op");
			String operator = "";
			for(Cookie c : cookies) 
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			
			
			int result = 0;
			if(operator.equals("+"))
				result = x + y;
			else
				result = x - y;
			
			resp.getWriter().println("계산 결과 : " + result);
		} 
		// 값을 저장
		else {
			// servlet context를 이용해 
			// container에 값을 저장한다.
			// application.setAttribute("value", v);
			// application.setAttribute("op", op);
			
			// session 객체를 이용해 값을 저장
			// session.setAttribute("value", v);
			// session.setAttribute("op", op);
			
			// 쿠키 추가
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			// path 추가
			// "/" 인자 = 모든 페이지에서 쿠키를 가져와라
			// "/calc2" 인자 = calc2 URL 요청에만 쿠키를 전달해라
			valueCookie.setPath("/calc2");  
			// 유효기간 설정 
			// 초 단위로 적용된다.
			valueCookie.setMaxAge(24 * 60 * 60);	// 24시간		
			opCookie.setPath("/calc2");
			resp.addCookie(valueCookie);
			resp.addCookie(opCookie);
		}
	
	}
}
