<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% 
	// page 객체
	pageContext.setAttribute("a", "AAA");
	pageContext.setAttribute("result", "hello");
%>
<body>
	<%=request.getAttribute("result") %>입니다.
	${requestScope.result} <!-- to EL --><br>
	${names[0]}, ${names[1]}<br>
	${notice.title }		<br>
	
	${a}	<br>
	
	${result}			<br>
	${param.n}			<br>
	
	${header.accept}	<br>
	<br>
	<br>
	${param.n > 3}, ${param.n ge 3}						<br>
	${param == null || param == ''} 					<br>
	${empty param.n}, ${not empty param.n}				<br>	
	${empty param.n?'값이 비어 있습니다.':param.n}			<br>
	${param.n/2}
</body>
</html>