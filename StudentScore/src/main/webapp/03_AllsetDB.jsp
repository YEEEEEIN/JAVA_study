<!--AllsetDB.jsp : examtable에 데이터를 insert하는 jsp파일-->
<%@page import="kopo23.dao.StudentScoreDaoImpl"%>
<%@page import="kopo23.dao.StudentScoreDao"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf8"/> <!-- html 한글처리 -->
<%@ page contentType="text/html; charset=utf8" %> <%-- 페이지의 콘텐츠 타입과 문자 인코딩 설정 --%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*" %> <%-- jsp파일에 java 클래스, java sql import --%>

<html>
<head></head>
    <body>
        <%
     	// StudentScoreDao 인터페이스를 구현한 StudentScoreDaoImpl 클래스의 객체를 생성하여 studentScoreDao 변수에 할당합니다.
        StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
     	// studentScoreDao의 allsetTable(500) 메서드를 호출하여 테이블 생성 쿼리를 실행하고 그 결과를 insert 변수에 할당합니다.
		String insert = studentScoreDao.allsetTable(500);
		// insert 변수의 내용을 출력합니다.
		out.println(insert);
        %>
    </body>
</html>