<!--AllviewDB.jsp : examtable에 데이터를 모두 보여주는 jsp파일-->
<%@page import="java.util.ArrayList"%>
<%@page import="kopo23.domian.StudentScore"%>
<%@page import="java.util.List"%>
<%@page import="kopo23.dao.StudentScoreDaoImpl"%>
<%@page import="kopo23.dao.StudentScoreDao"%>
<%@page import="kopo23.dto.Pagination"%>
<%@page import="kopo23.service.StudentScoreService"%>
<%@page import="kopo23.service.StudentScoreServiceImpl"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<!-- html 한글처리 -->
<%@ page contentType="text/html; charset=utf8"%>
<%-- 페이지의 콘텐츠 타입과 문자 인코딩 설정 --%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
<%-- jsp파일에 java 클래스, java sql import --%>

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
</head>

<body>
	<%	
	   	try{
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
		   	StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();

		  	// studentScoreDao 인스턴스의 selectAll() 메서드를 호출하여 StudentScore 객체의 리스트를 가져옵니다.
		  	// pageNum과 countPerPage 매개변수는 데이터를 페이징하기 위해 사용됩니다.
		   	List<StudentScore> studentScores = studentScoreDao.selectAll(pageNum, countPerPage);

		  	// StudentScoreService 인터페이스의 구현 클래스의 인스턴스를 생성합니다.
		  	StudentScoreService studentScoreService = new StudentScoreServiceImpl();

		  	// studentScoreService 인스턴스의 getPagination() 메서드를 호출하여 Pagination 객체를 가져옵니다.
		   	// pageNum과 countPerPage 매개변수는 페이징 정보를 계산하는 데 사용됩니다.
		   	Pagination pagination = studentScoreService.getPagination(pageNum, countPerPage);

		
		   int count = studentScoreDao.count(); // 데이터 총 개수 
		
		   int c = pagination.getC(); // pagination의 현재 페이지 값 가져오기
		   int s = pagination.getS(); // pagination의 페이지박스 시작 값 가져오기
		   int e = pagination.getE(); // pagination의 페이지박스 끝 값 가져오기
		   int p = pagination.getP(); // pagination의 10페이지 이전 값 가져오기
		   int pp = pagination.getPp(); // pagination의 처음 페이지 값 가져오기
		   int n = pagination.getN(); // pagination의 10페이지 이후 값 가져오기 
		   int nn = pagination.getNn(); // pagination의 마지막 페이지 값 가져오기
	   %>

	<% if (studentScores != null && !studentScores.isEmpty()) { %>
	<!-- 예외 처리 변수 -->
	<h1>조회</h1>
	<table cellspacing=3 width=600 border=1> <!-- table 열고 셀크기, 넓이, 테두리 스타일 지정 -->
		<tr>
			<!-- tr 열기 -->
			<td width=50><p align=center>이름</p></td>
			<!--  td 열고 이름 스타일 지정 -->
			<td width=50><p align=center>학번</p></td>
			<!--  td 열고 학번 스타일 지정 -->
			<td width=50><p align=center>국어</p></td>
			<!--  td 열고 국어 스타일 지정 -->
			<td width=50><p align=center>영어</p></td>
			<!--  td 열고 영어 스타일 지정 -->
			<td width=50><p align=center>수학</p></td>
			<!--  td 열고 수학 스타일 지정 -->
			<td width=50><p align=center>합계</p></td>
			<!--  td 열고 합계 스타일 지정 -->
			<td width=50><p align=center>평균</p></td>
			<!--  td 열고 평균 스타일 지정 -->
			<td width=50><p align=center>순위</p></td>
			<!--  td 열고 순위 스타일 지정 -->
		</tr>
		<!-- tr 닫기 -->

		<%
	      }%>

		<%
	      for (int i = 0; i < studentScores.size(); i++) { // 리스트 studentScores의 크기 만큼 반복
	         StudentScore studentScore = studentScores.get(i); // 객체 선언하여 리스트의 값들을 하나씩 가져옴
	         out.println("<tr>"); // 행 열기
	         // 이름 데이터를 링크로 표시하고 클릭 시 04_oneview.jsp 페이지로 이동
	         out.println("<td width=50><p align=center>" + studentScore.getName() + "</p></td>"); // 이름 데이터 가져와서 출력
	         // 학번 데이터 가져와서 출력, 학번 값을 key값으로 설정하여 클릭시 05_oneview.jsp로 이동하게 설정
	         out.println("<td width=50><p align=center><a href='05_oneview.jsp?key=" 
	 	         	+ studentScore.getStudentid() + "'> " + studentScore.getStudentid() + "</a></p></td>");	         
	         out.println("<td width=50><p align=center>" + studentScore.getKor() + "</p></td>"); // 국어 점수 데이터 표시
	         out.println("<td width=50><p align=center>" + studentScore.getEng() + "</p></td>"); // 영어 점수 데이터 표시
	         out.println("<td width=50><p align=center>" + studentScore.getMat() + "</p></td>"); // 수학 점수 데이터 표시
	         out.println("<td width=50><p align=center>" + studentScore.getSum() + "</p></td>"); // 합계 점수 데이터 표시
	         out.println("<td width=50><p align=center>" + studentScore.getAvg() + "</p></td>"); // 평균 점수 데이터 표시
	         out.println("<td width=50><p align=center>" + studentScore.getRank() + "</p></td>"); // 순위 데이터 표시
	         out.println("</tr>"); // 행 닫기
	      }
	      %>

	</table>

		<div class="bottom_paging_box">
			<% 
	   // 현재 페이지가 10보다 큰 경우에만 실행합니다.
	   if (10 < c) {
	   %>
			<!-- 이전 페이지로 이동하는 링크를 생성합니다. -->
			<a href="04_AllviewDB.jsp?page=<%=pp%>"><<</a> <a
				href="04_AllviewDB.jsp?page=<%=p%>"><</a>
			<%
	   }
	   %>
	
			<%
	   // 페이지 번호의 범위에 해당하는 반복문입니다.
	   for (int i = s; i <= e; i++) {
	   %>
	
			<%
	   // 현재 페이지인 경우에는 스타일을 변경하여 표시합니다.
	   if (i == c) {
	   %>
			<!-- 현재 페이지를 강조하여 표시하는 링크를 생성합니다. -->
			<a style="color: red;" href="04_AllviewDB.jsp?page=<%=i%>"><%=i%></a>
			<%
	   } else {
	   %>
			<!-- 다른 페이지를 표시하는 링크를 생성합니다. -->
			<a href="04_AllviewDB.jsp?page=<%=i%>"><%=i%></a>
			<%
	   }
	   %>
			<%
	   }
	   %>
	
			<%
	   // 다음 페이지가 존재하는 경우에만 실행합니다.
	   if (nn != -1) {
	   %>
			<!-- 다음 페이지로 이동하는 링크를 생성합니다. -->
			<a href="04_AllviewDB.jsp?page=<%=n%>">></a> <a
				href="04_AllviewDB.jsp?page=<%=nn%>">>></a>
			<%
	   }
	   %>
		</div>


	<%
	   		} catch(Exception e){
	      	e.printStackTrace(); // 에러 내용 찾기
	      	out.println(e); // 에러 내용 출력
	      }%>

</body>
<!-- body 닫기 -->

</html>
<!-- html 닫기 -->