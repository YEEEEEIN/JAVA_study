<%@page import="Domain.Stock"%>
<%@page import="Dto.Pagination"%>
<%@page import="Service.StockServiceImpl"%>
<%@page import="Service.StockService"%>
<%@page import="java.util.List"%>
<%@page import="Dao.StockDaoImpl"%>
<%@page import="Dao.StockDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	width: 800px;
	margin: 0 auto;
	padding: 20px;
}

h1 {
	font-size: 30px;
	font-weight: bold;
	text-align: center;
	margin: 0;
	padding: 0;
}

table {
	width: 800px;
	border-collapse: collapse;
}

table th {
	background-color: #f2f2f2;
	padding: 1px;
	text-align: center;
}

table td {
	text-align: center;
}

.bottom_paging_box {
	width: 600px;
	margin-top: 18px;
	text-align: center;
	line-height: 20px;
	color: black;
	font-size: 25px;
}

.search_box {
	margin-top: 20px;
	text-align: right;
}

.search_box input[type="text"] {
	width: 200px;
	padding: 5px;
}

.search_box input[type="button"] {
	padding: 5px 10px;
	background-color: #f2f2f2;
	border: none;
	cursor: pointer;
}
</style>


<script language="JavaScript">
function submitForm() {
    const id = document.getElementById('searchid').elements.key.value;

    if (id.trim() === '') { // 입력 창이 비어있으면
       alert("데이터를 입력해주세요."); // 해당 메세지 출력
       return; // 함수 실행 종료
    }
   	document.getElementById('searchid').action = "view.jsp";
	document.getElementById('searchid').submit();
}
</script>


<%
try {
	String pageValue = request.getParameter("page"); // 파라미터 page 값을 가져와서 String pageValue에 저장
	int pageNum = 1; // 변수 pageNum int형 선언, 값 1 
	if (pageValue != null) { // 만약 pageValue null이 아니라면
		pageNum = Integer.parseInt(pageValue); // pageNum pageValue을 정수형으로 변환하여 저장
		if (pageNum < 1) { // pageNum이 1보다 작으면 
	pageNum = 1; // pageNum에 1 저장
		}
	}

	String countPerPageValue = request.getParameter("countPerPage"); // 파라미터 countPerPage 값을 가져와서 String countPerPageValue 저장
	int countPerPage = 20; // 변수 countPerPage int형 선언, 값 10
	if (countPerPageValue != null) { // 만약 countPerPageValue null이 아니라면
		countPerPage = Integer.parseInt(countPerPageValue); // countPerPage countPerPageValue 정수형으로 변환하여 저장
		if (countPerPage < 1) { // countPerPage 1보다 작으면 
	countPerPage = 20; // countPerPage 10 저장
		}
	}

	// StockDao 인터페이스의 구현 클래스의 인스턴스를 생성합니다.
	StockDao stockDao = new StockDaoImpl();

	// studentScoreDao 인스턴스의 selectAll() 메서드를 호출하여 StudentScore 객체의 리스트를 가져옵니다.
	// pageNum과 countPerPage 매개변수는 데이터를 페이징하기 위해 사용됩니다.
	List<Stock> stockes = stockDao.selectAll(pageNum, countPerPage);

	// StudentScoreService 인터페이스의 구현 클래스의 인스턴스를 생성합니다.
	StockService stockService = new StockServiceImpl();

	// studentScoreService 인스턴스의 getPagination() 메서드를 호출하여 Pagination 객체를 가져옵니다.
	// pageNum과 countPerPage 매개변수는 페이징 정보를 계산하는 데 사용됩니다.
	Pagination pagination = stockService.getPagination(pageNum, countPerPage);

	int c = pagination.getC(); // pagination의 현재 페이지 값 가져오기
	int s = pagination.getS(); // pagination의 페이지박스 시작 값 가져오기
	int e = pagination.getE(); // pagination의 페이지박스 끝 값 가져오기
	int p = pagination.getP(); // pagination의 10페이지 이전 값 가져오기
	int pp = pagination.getPp(); // pagination의 처음 페이지 값 가져오기
	int n = pagination.getN(); // pagination의 10페이지 이후 값 가져오기 
	int nn = pagination.getNn(); // pagination의 마지막 페이지 값 가져오기
%>
</head>
<body>
	<table width=800 border=0>
	<!-- 테이블 제목 -->
	<td><p style="font-size: 30px; font-weight: bold; text-align: center;">㈜트와이스 재고 현황-전체현황</p></td>
	</table>
<br>
<div>
	<!-- 검색 폼 -->
	<form method="get" id="searchid">
		<input type="text" name="key" placeholder="검색어를 입력하세요"> 
		<input type=button value="검색" OnClick="submitForm()">
	</form>
</div>
<br>

<table cellspacing=1 width=800 border=1>
	<!-- 재고 목록 테이블 -->
	<tr>
		<!-- 열 제목 -->
		<td width=100>상품번호</td>
		<td width=250>상품명</td>
		<td width=150>현재 재고수</td>
		<td width=150>상품등록일</td>
		<td width=150>재고파악일</td>
	</tr>

	<%
	for(int i = 0; i < stockes.size(); i++) {
		Stock stock = stockes.get(i);
		out.println("<tr>");
		out.println("<td width=150>");
		// 상품번호 링크
		out.println("<a href='view.jsp?key=" + stock.getId().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "'>" + stock.getId().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "</td>");
		out.println("<td width=350>");
		// 상품명 링크
		out.println("<a href='view.jsp?key=" + stock.getId().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "'>" + stock.getName().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "</a></td>");
		out.println("<td width=100>" + stock.getAmount() + "</td>");
		out.println("<td width=100>" + stock.getCheckDate() + "</td>");
		out.println("<td width=100>" + stock.getRegDate() + "</td>");
		out.println("</tr>");
	}
	%>
	</table>
	<br>
	<table width=800>
		<tr>
			<td width=700></td>
			<!-- 신규 등록 버튼 -->
			<td><input type=button value="신규등록"
				OnClick="window.location='insert.jsp'"></td>
		</tr>
	</table>


	<div class="bottom_paging_box" style="width: 800px;">
		<% if (10 < c) { %>
		<!-- 현재 페이지가 10보다 큰 경우에만 실행 -->
		<!-- 이전 페이지로 이동하는 링크를 생성합니다. -->
		<a href="list.jsp?page=<%=pp%>"><<</a> <a href="list.jsp?page=<%=p%>"><</a>
		<% } %>

		<% for (int i = s; i <= e; i++) { %>
		<!-- 페이지 번호의 범위에 해당하는 반복문 -->
		<% if (i == c) { %>
		<!-- 현재 페이지인 경우에는 스타일을 변경하여 표시 -->
		<!-- 현재 페이지를 강조하여 표시하는 링크를 생성합니다. -->
		<a style="color: red;" href="list.jsp?page=<%=i%>"><%=i%></a>
		<% } else { %>
		<!-- 다른 페이지를 표시하는 링크를 생성합니다. -->
		<a href="list.jsp?page=<%=i%>"><%=i%></a>
		<% } %>
		<% } %>

		<% if (nn != -1) { %>
		<!-- 다음 페이지가 존재하는 경우에만 실행 -->
		<!-- 다음 페이지로 이동하는 링크를 생성합니다. -->
		<a href="list.jsp?page=<%=n%>">></a> <a href="list.jsp?page=<%=nn%>">>></a>
		<% } %>
	</div>

	<% } catch(Exception e){
	      	e.printStackTrace(); // 에러 내용 찾기
	      	out.println(e); // 에러 내용 출력
	      } %>

</body>
</html>