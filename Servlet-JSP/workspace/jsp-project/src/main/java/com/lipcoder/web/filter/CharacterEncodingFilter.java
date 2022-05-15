package com.lipcoder.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;



//web.xml에 설정하지 않을때는 어노테이션으로도 가능하다.
@WebFilter("/*")	
public class CharacterEncodingFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 필터로 부터 수행될 명령어 블럭입니다.
		
		// 인코딩이 적용된 환경으로 만든다.
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//System.out.println("before filter");
		
		// FilterChain 
		// --> 다음 녀석으로 넘겨줄것인가? 말것인가? 를 결정한다. (중요)
		chain.doFilter(request, response);
		
		
		//System.out.println("after filter");
	}
}
