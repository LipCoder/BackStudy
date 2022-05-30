<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 스파게티 코드 : 실타래 처럼 코드가 꼬여 문제가 생기면 대책이 없음 -->
<%
	int num = 0;
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 문제점 3. 코드 블럭에 대한 기준이 없어서, 특정 코드를 찾기가 힘들다. -->
<%
	String num_ = request.getParameter("n");
	if(num_ != null && !num_.equals(""))
		num = Integer.parseInt(num_);
%>
<body>
	<!-- 문제점 1. 코드가 복잡해보인다. -->
	<!-- 문제점 2. 코드에서 오류 부분을 잡지 못한다. -->
	<%if(num % 2 != 0){ %>
	홀수입니다.
	<%} 
	else {%>
	짝수입니다.
	<%} %>
</body>
</html>