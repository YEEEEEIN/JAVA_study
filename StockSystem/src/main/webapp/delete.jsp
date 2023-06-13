<%@page import="Domain.Stock"%>
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
	try {
		request.setCharacterEncoding("UTF-8"); // 요청의 인코딩을 UTF-8로 설정합니다.
		String ckey = request.getParameter("key"); // Allview 페이지에서 전달된 파라미터 key 값을 받아옵니다.
		String id = ckey; // ID 변수에 ckey 값을 할당합니다.
		
		StockDao stockDao = new StockDaoImpl(); // StockDaoImpl 객체를 생성합니다.
		Stock stock = new Stock(); // Stock 객체를 생성합니다.
	
		int c = stockDao.getCurrentPage(id, 20); // 현재 페이지를 가져옵니다.
		stockDao.deleteStock(id); // 해당 ID에 해당하는 주식 정보를 삭제합니다.
		response.sendRedirect("list.jsp?page=" + c); // 목록 페이지로 리다이렉트합니다.
	} catch (Exception e) {
		e.printStackTrace(); // 에러 내용을 출력합니다.
		out.println(e); // 에러 메시지를 출력합니다.
	}
	%>

</body>
</html>
