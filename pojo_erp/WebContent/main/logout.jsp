<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("emp_no")!= null){
	    session.invalidate(); // 모든세션정보 삭제
	   /* response.sendRedirect("./login.jsp"); // 로그인 화면으로 다시 돌아간다. */		
%>
	<script type="text/javascript">
		location.href="http://localhost:5000/main/login.jsp";
	</script>
<%
	}
%>

<html>
<head>
    <title>로그아웃 처리</title>
</head>
<body>
</body>
</html>