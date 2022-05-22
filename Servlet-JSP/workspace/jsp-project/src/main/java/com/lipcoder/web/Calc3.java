package com.lipcoder.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
						   	HttpServletResponse resp) 
		throws ServletException, IOException {
		

		Cookie[] cookies = req.getCookies();
		
		String value = req.getParameter("value");
		String operator = req.getParameter("operator");
		String dot = req.getParameter("dot");
		
		String exp = "";
		if(cookies != null) 
			for(Cookie c : cookies)
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		
		if(operator != null && operator.equals("=")) {
			// 계산
			// JavaScript Engine
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("graal.js");
			
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else if (operator != null && operator.equals("C")) {
			// 쿠키 삭제
			exp = "";
		}
		
		else {
			// 누적
			exp += (value == null) ? "" : value;
			exp += (operator == null) ? "" : operator;
			exp += (dot == null) ? "" : dot;
		}
		
		
		Cookie expCookie = new Cookie("exp", exp);
		
		if(exp.isEmpty())
			expCookie.setMaxAge(0);		// 쿠키를 삭제하는 방법
		
		// cookie를 특정 URL 로만 전송하겠다.
		// 루트를 명시하면 어떤 페이지에서든 쓰인다
		expCookie.setPath("/");
		resp.addCookie(expCookie);
		
		resp.sendRedirect("calcpage");
	}
}
