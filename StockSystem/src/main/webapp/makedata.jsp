<%@page import="Dao.StockDaoImpl"%>
<%@page import="Dao.StockDao"%>
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
	// StockDaoImpl 객체와 StockDao 인터페이스를 import합니다.
	StockDao stockDao = new StockDaoImpl();
	// stockDao.makedata() 메서드를 호출하여 데이터를 생성합니다.
	String makedata = stockDao.makedata();
	// 생성된 데이터를 출력합니다.
	out.println(makedata);
	%>

</body>
</html>
