<!--oneviewDB.jsp : Allview화면에서 하나를 선택하면 해당 사람만 데이터를 보여주는 jsp파일-->
<%@page import="kopo23.domian.StudentScore"%>
<%@page import="kopo23.dao.StudentScoreDaoImpl"%>
<%@page import="kopo23.dao.StudentScoreDao"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf8"/> <!-- html 한글처리 -->
<%@ page contentType="text/html; charset=utf8" %> <%-- 페이지의 콘텐츠 타입과 문자 인코딩 설정 --%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*" %> <%-- jsp파일에 java 클래스, java sql import --%>

<html>
<head></head>
    <body>
        <%
        String ckey = request.getParameter("key"); // Allview 페이지에서 전달된 파라미터 key 값을 받아옵니다.
        
     	// StudentScoreDao 인터페이스의 구현 클래스의 인스턴스를 생성합니다.
 	   	StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
        
 		// studentScoreDao 인스턴스의 selectOne(ckey) 메서드를 호출하여 StudentScore 객체의 리스트를 가져옵니다.
 	    StudentScore studentScore = studentScoreDao.selectOne(ckey);
 	
        %>
		<h1>[<%=ckey%>]조회</h1>
		
		<form method='get' action='04_AllviewDB.jsp'>
		<!--아래 폼을 다 채우고 실행은 06_inputForm1.jsp로 간다-->
		<table cellspacing=3 width=400 border=0>  <!-- table 열고 셀크기, 넓이, 테두리 스타일 지정 -->
			<tr>
				<td width=100><input type="submit" style="width: 100px; height: 50px; font-size: 16px;"  value="뒤로가기"></td> <!-- 뒤로가기 버튼 생성 -->
			</tr>
		</table>
		</form>
        
        <table cellspacing=1 width=600  height=30 border=1> <!-- table 열고 셀크기, 넓이, 테두리 스타일 지정 -->
            <tr> <!-- tr 열기 -->
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
			</tr> <!-- tr 닫기 -->
        <%
            try { // try문 시작 => ResultSet 객체의 생성과 관련된 작업들은 예외를 발생시킬 수 있는 작업이기 때문에

               out.println("<tr>");
               out.println("<td width=50><p align=center>" + studentScore.getName() + "</p></td>"); // 학번 데이터 표시
               out.println("<td width=50><p align=center>" + studentScore.getStudentid() + "</p></td>"); // 국어 점수 데이터 표시
               out.println("<td width=50><p align=center>" + studentScore.getKor() + "</p></td>"); // 영어 점수 데이터 표시
               out.println("<td width=50><p align=center>" + studentScore.getEng() + "</p></td>"); // 수학 점수 데이터 표시
               out.println("<td width=50><p align=center>" + studentScore.getMat() + "</p></td>"); // 합계 점수 데이터 표시
               out.println("<td width=50><p align=center>" + studentScore.getSum() + "</p></td>"); // 합계 점수 데이터 표시
               out.println("<td width=50><p align=center>" + studentScore.getAvg() + "</p></td>"); // 합계 점수 데이터 표시
               out.println("<td width=50><p align=center>" + studentScore.getRank() + "</p></td>"); // 합계 점수 데이터 표시
               out.println("</tr>");
            
            } catch (Exception e) { // Exception 에러 잡기
			    out.println(e); // 에러 내용 출력
		    } 
        %>
    </body>
</html>