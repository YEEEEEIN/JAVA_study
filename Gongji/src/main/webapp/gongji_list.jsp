<%@page import="Service.GongjiServiceImpl"%>
<%@page import="Service.GongjiService"%>
<%@page import="Dto.Pagination"%>
<%@page import="Domain.Gongji"%>
<%@page import="java.util.List"%>
<%@page import="Dao.GongjiDaoImpl"%>
<%@page import="Dao.GongjiDao"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%@ page import="java.sql.*,javax.sql.*,java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
<head>
<style>
.bottom_paging_box { /*페이지 박스 스타일 지정*/
	width: 600;
	margin-top: 18px;
	text-align: center;
	line-height: 20px;
	color: black;
	font-size: 25px;
}

a:link { /*a 링크 스타일 지정*/
	color: blue;
	text-decoration: none;
}

.current_page { /*현재 페이지 스타일 지정*/
	font-weight: bold;
}
</style>
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
	int countPerPage = 10; // 변수 countPerPage int형 선언, 값 10
	if (countPerPageValue != null) { // 만약 countPerPageValue null이 아니라면
		countPerPage = Integer.parseInt(countPerPageValue); // countPerPage countPerPageValue 정수형으로 변환하여 저장
		if (countPerPage < 1) { // countPerPage 1보다 작으면 
	countPerPage = 10; // countPerPage 10 저장
		}
	}

	// StudentScoreDao 인터페이스의 구현 클래스의 인스턴스를 생성합니다.
	GongjiDao gongjiDao = new GongjiDaoImpl();

	// studentScoreDao 인스턴스의 selectAll() 메서드를 호출하여 StudentScore 객체의 리스트를 가져옵니다.
	// pageNum과 countPerPage 매개변수는 데이터를 페이징하기 위해 사용됩니다.
	List<Gongji> gongjies = gongjiDao.selectAll(pageNum, countPerPage);

	// StudentScoreService 인터페이스의 구현 클래스의 인스턴스를 생성합니다.
	GongjiService gongjiService = new GongjiServiceImpl();

	// studentScoreService 인스턴스의 getPagination() 메서드를 호출하여 Pagination 객체를 가져옵니다.
	// pageNum과 countPerPage 매개변수는 페이징 정보를 계산하는 데 사용됩니다.
	Pagination pagination = gongjiService.getPagination(pageNum, countPerPage);

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

	<table cellspacing=1 width=600 border=0>
		<!-- 테이블을 생성하고 간격, 너비, 테두리 속성을 설정합니다. -->
		<td><p
				style="font-size: 30px; font-weight: bold; text-align: center;">분당
				융기원 공지사항</p></td>
		<!-- 테이블 셀 안에 제목을 출력합니다. -->
		<hr>
		<!-- 수평선을 추가합니다. -->
	</table>
	<br>

	<table cellspacing=1 width=600 border=1>
		<!-- 테이블을 생성하고 간격, 너비, 테두리 속성을 설정합니다. -->
		<tr>
			<!-- 테이블 행을 시작합니다. -->
			<td width=50><p align=center>번호</p></td>
			<!-- 테이블 셀에 번호를 출력합니다. -->
			<td width=500><p align=center>제목</p></td>
			<!-- 테이블 셀에 제목을 출력합니다. -->
			<td width=100><p align=center>등록일</p></td>
			<!-- 테이블 셀에 등록일을 출력합니다. -->
		</tr>
		<%
		for (int i = 0; i < gongjies.size(); i++) {
			// 공지사항 목록의 크기만큼 반복합니다.
			Gongji gongji = gongjies.get(i);
			out.println("<tr>");
			// 테이블 행을 시작합니다.
			out.println("<td width=50><p align=center>" + gongji.getId() + "</p></td>");
			// 번호를 출력합니다.
			out.println("<td width=500><p align=left>");
			// 제목을 출력합니다.
			out.println("<a href='gongji_view.jsp?key=" + gongji.getId() + "'>"
			+ gongji.getTitle().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "</a>");
			// 제목에 링크를 추가하고, HTML 특수 문자를 치환하여 출력합니다.
			out.println("</p></td>");
			// 테이블 셀을 닫습니다.
			out.println("<td width=100><p align=center>" + gongji.getDate() + "</p></td>");
			// 등록일을 출력합니다.
			out.println("</tr>");
			// 테이블 행을 닫습니다.
		}
		%>
	</table>
	<table width=650>
		<!-- 너비가 650인 테이블을 생성합니다. -->
		<tr>
			<!-- 테이블 행을 시작합니다. -->
			<td width=550></td>
			<!-- 너비가 550인 빈 셀을 생성합니다. -->
			<td><input type=button value="신규"
				OnClick="window.location='gongji_insert.jsp'"></td>
			<!-- "신규" 버튼을 생성하고 클릭 시 페이지를 이동합니다. -->
		</tr>
	</table>


	<div class="bottom_paging_box" style="width: 600px;">
		<% if (10 < c) { %>
		<!-- 현재 페이지가 10보다 큰 경우에만 실행 -->
		<!-- 이전 페이지로 이동하는 링크를 생성합니다. -->
		<a href="gongji_list.jsp?page=<%=pp%>"><<</a> <a href="gongji_list.jsp?page=<%=p%>"><</a>
		<% } %>

		<% for (int i = s; i <= e; i++) { %>
		<!-- 페이지 번호의 범위에 해당하는 반복문 -->
		<% if (i == c) { %>
		<!-- 현재 페이지인 경우에는 스타일을 변경하여 표시 -->
		<!-- 현재 페이지를 강조하여 표시하는 링크를 생성합니다. -->
		<a style="color: red;" href="list.jsp?page=<%=i%>"><%=i%></a>
		<% } else { %>
		<!-- 다른 페이지를 표시하는 링크를 생성합니다. -->
		<a href="gongji_list.jsp?page=<%=i%>"><%=i%></a>
		<% } %>
		<% } %>

		<% if (nn != -1) { %>
		<!-- 다음 페이지가 존재하는 경우에만 실행 -->
		<!-- 다음 페이지로 이동하는 링크를 생성합니다. -->
		<a href="gongji_list.jsp?page=<%=n%>">></a> <a href="gongji_list.jsp?page=<%=nn%>">>></a>
		<% } %>
	</div>

	<%
	} catch (Exception e) {
	e.printStackTrace(); // 에러 내용 찾기
	out.println(e); // 에러 내용 출력
	}
	%>
</body>
</html>