package com.lipcoder.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Get/Post 로 구분지어 나눠보자.
@WebServlet("/calculator")
public class Calculator extends HttpServlet {
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			
//		// GET은 반드시 대문자로 해줘야함
//		if(req.getMethod().equals("GET")) {	
//			System.out.println("GET 요청이 왔습니다.");
//		} else if (req.getMethod().equals("POST")) {
//			System.out.println("POST 요청이 왔습니다.");
//		}
//		
//		
//		// 부모의 service 함수를 호출한다.
//		super.service(req, resp);
//		
//		// 부모의 service는 doGet, doPost중 알맞은 곳으로
//		// 라우팅 해주는 역할을 한다.
//		// 부모의 service 메서드 실행시,
//		// 두 함수를 오버리이딩하지 않을 경우
//		// 405 에러가 발생한다.
//		// doGet();
//		// doPost();
//	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGET 메소드가 호출 되었습니다.");
		
		Cookie[] cookies = request.getCookies();
		
		String exp = "0";
		if(cookies != null) 
			for(Cookie c : cookies)
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		
		PrintWriter out = response.getWriter();
		
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style type=\"text/css\">");
		out.write("input {");
		out.write("	width: 50px;");
		out.write("	height: 50px;");
		out.write("}");
		out.write(".output {");
		out.write("	height: 50px;");
		out.write("	background: #e9e9e9;");
		out.write("	font-size: 24px;");
		out.write("	font-weight: bold;");
		out.write("	text-align: right;");
		out.write("	padding: 0px 5px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form method=\"post\">");
		out.write("		<table>");
		out.write("			<tr>");
		out.printf("				<td class=\"output\"colspan=\"4\">%s</td>", exp);
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\"name=\"operator\"value=\"CE\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"operator\"value=\"C\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"operator\"value=\"BS\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"operator\"value=\"/\"/></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\"name=\"value\"value=\"7\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"value\"value=\"8\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"value\"value=\"9\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"operator\"value=\"*\"/></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\"name=\"value\"value=\"4\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"value\"value=\"5\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"value\"value=\"6\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"operator\"value=\"-\"/></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td><input type=\"submit\"name=\"value\"value=\"1\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"value\"value=\"2\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"value\"value=\"3\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"operator\"value=\"+\"/></td>");
		out.write("			</tr>");
		out.write("			<tr>");
		out.write("				<td></td>");
		out.write("				<td><input type=\"submit\"name=\"value\"value=\"0\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"dot\"value=\".\"/></td>");
		out.write("				<td><input type=\"submit\"name=\"operator\"value=\"=\"/></td>");
		out.write("			</tr>");
		out.write("		</table>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPOST 메소드가 호출 되었습니다.");
		
		Cookie[] cookies = request.getCookies();
		
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
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
		
		if(exp.equals(""))
			expCookie.setMaxAge(0);		// 쿠키를 삭제하는 방법
		
		// cookie를 특정 URL 로만 전송하겠다.
		// 루트를 명시하면 어떤 페이지에서든 쓰인다
		expCookie.setPath("/calculator");
		response.addCookie(expCookie);
		response.sendRedirect("calculator");
	}
}
