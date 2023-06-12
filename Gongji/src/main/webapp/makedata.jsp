<%@page import="Dao.GongjiDaoImpl"%>
<%@page import="Dao.GongjiDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// StudentScoreDao 인터페이스를 구현한 StudentScoreDaoImpl 클래스의 객체를 생성하여 studentScoreDao 변수에 할당합니다.
	GongjiDao gongjiDao = new GongjiDaoImpl();
	// studentScoreDao의 createTable() 메서드를 호출하여 테이블 생성 쿼리를 실행하고 그 결과를 create 변수에 할당합니다.
	String makedata = gongjiDao.makeData();
	// create 변수의 내용을 출력합니다.
	out.println(makedata);
	%>
</body>
</html>