<%@page import="Domain.Stock"%>
<%@page import="Dao.StockDaoImpl"%>
<%@page import="Dao.StockDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
	<%
		String ckey = request.getParameter("key"); // Allview 페이지에서 전달된 파라미터 key 값을 받아옵니다.
	
		StockDao stockDao = new StockDaoImpl();
		Stock stock = stockDao.selectOne(ckey);
	
		if (stock.getId() == null) {
			out.println("<script>alert('없는 상품 번호입니다.'); location.href='list.jsp';</script>");
		} else {
			// 상품 정보를 변수에 저장합니다.
			String id = stock.getId(); // 상품 번호
			String name = stock.getName(); // 상품명
			int amount = stock.getAmount(); // 재고현황
			String regDate = stock.getRegDate(); // 상품 등록일
			String checkDate = stock.getCheckDate(); // 재고 파악일
			String content = stock.getContent(); // 상품 설명
			String photo = stock.getPhoto(); // 상품 사진
	%>
	
	<script>
	function submitForm(id) {
	    var confirmDelete = confirm("정말 삭제하시겠습니까?");
	    if (confirmDelete) {
	        location.href = "delete.jsp?key=" + id;
	    }
	}
</script>

</head>
<body>
	
	<form method="post" name="fm">
	<table width="800" border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td width="200"><b>상품 번호</b></td> <!-- 상품 번호 -->
			<td width="600"><%=id.replaceAll("<", "&lt;").replaceAll(">", "&gt;")%></td> <!-- 상품 번호 값 -->
		</tr>
		<tr>
			<td><b>상품명</b></td> <!-- 상품명 -->
			<td><%=name.replaceAll("<", "&lt;").replaceAll(">", "&gt;")%></td> <!-- 상품명 값 -->
		</tr>
		<tr>
			<td><b>재고현황</b></td> <!-- 재고현황 -->
			<td><%=amount%></td> <!-- 재고현황 값 -->
		</tr>
		<tr>
			<td><b>상품등록일</b></td> <!-- 상품등록일 -->
			<td><%=regDate%></td> <!-- 상품등록일 값 -->
		</tr>
		<tr>
			<td><b>재고파악일</b></td> <!-- 재고파악일 -->
			<td><%=checkDate%></td> <!-- 재고파악일 값 -->
		</tr>
		<tr>
			<td><b>상품설명</b></td> <!-- 상품설명 -->
			<td style="max-width: 300px; word-wrap: break-word;">
				<textarea style="resize: none; overflow: auto;" name="content" cols="60" rows="10" readonly><%=content%></textarea> <!-- 상품설명 값 -->
		</tr>
		<tr>
			<td><b>상품사진</b></td> <!-- 상품사진 -->
			<% if (stock.getPhoto() == null || stock.getPhoto().equals("./image/null")) { %>
				<td><img src="image/null.gif"></td> <!-- 상품사진이 없을 경우 기본 이미지 -->
			<% } else { %>
				<td><img src="<%=photo%>"></td> <!-- 상품사진 -->
			<% } %>
		</tr>
	</table>
	<table width="800">
		<tr>
			<td width="500"></td>
			<td><input type="button" value="목록" onClick="location.href='list.jsp'"></td> <!-- 목록 버튼 -->
			<td><input type="button" value="상품삭제" onClick="submitForm('<%=id%>')"></td> <!-- 상품삭제 버튼 -->
			<td><input type="button" value="재고수정" onClick="location.href='update.jsp?key=<%=id%>'"></td> <!-- 재고수정 버튼 -->
		</tr>
	</table>
</form>


	<% } %>
</body>
</html>