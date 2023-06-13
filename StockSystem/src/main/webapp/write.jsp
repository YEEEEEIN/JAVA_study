<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="Domain.Stock"%>
<%@page import="Dao.StockDaoImpl"%>
<%@page import="Dao.StockDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	try {

		request.setCharacterEncoding("UTF-8"); // 요청 파라미터의 인코딩을 UTF-8로 설정

		String ckey = request.getParameter("key"); // Allview 페이지에서 전달된 파라미터 key 값을 받아옵니다.

		StockDao stockDao = new StockDaoImpl();
		Stock stock = new Stock();

		if (ckey.equals("INSERT")) { // 새 상품 등록
			String path = "./image/"; // 상대경로
			String realPath = request.getServletContext().getRealPath(path); // 절대경로
			System.out.println("write.jsp - realPath : " + realPath); // 절대경로 확인
			int size = 10 * 1024 * 1024; // 파일 크기 지정 10M

			MultipartRequest multi = new MultipartRequest(request, realPath, size, "utf-8", new DefaultFileRenamePolicy()); // 파일 업로드 처리

			String id = multi.getParameter("id"); // 상품 번호
			String name = multi.getParameter("name"); // 상품명
			int amount = Integer.parseInt(multi.getParameter("amount")); // 재고현황
			String content = multi.getParameter("content"); // 상품설명
			String photo = multi.getFilesystemName("photo"); // 상품사진 파일명
			
			// 각각의 값들 객체에 세팅
			stock.setId(id);
			stock.setName(name);
			stock.setAmount(amount);
			stock.setContent(content);
			stock.setPhoto(path + photo); // ./image/photo

			stockDao.insertStock(stock); // 상품 등록

			int c = stockDao.getCurrentPage(id, 20);
			response.sendRedirect("list.jsp?page=" + c); // 목록 페이지로 이동
		} else { // ckey = UPDATE, 재고 수정
			String id = request.getParameter("id"); // 상품 번호

			int amount = Integer.parseInt(request.getParameter("amount")); // 재고현황

			stock.setId(id);
			stock.setAmount(amount);

			stockDao.updateStock(stock); // 상품 재고 수정

			int c = stockDao.getCurrentPage(id, 20);
			response.sendRedirect("list.jsp?page=" + c); // 목록 페이지로 이동
		}

	} catch (Exception e) {
		e.printStackTrace(); // 에러 내용 출력
		out.println(e); // 에러 메시지 출력
	}
	%>

</body>
</html>
