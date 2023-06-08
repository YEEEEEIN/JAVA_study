<%@page import="kopo23.dao.StudentScoreDaoImpl"%>
<%@page import="kopo23.dao.StudentScoreDao"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf8"/> <!-- html 한글처리 -->
<%@ page contentType="text/html; charset=utf8" %> <%-- 페이지의 콘텐츠 타입과 문자 인코딩 설정 --%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*" %> <%-- jsp파일에 java 클래스, java sql import --%>

<html><!-- html 열기 -->

<head> <!-- head 열기 -->
</head> <!-- head 닫기 -->

<body> <!-- body 열기 -->
	<%	
	// StudentScoreDao 인터페이스를 구현한 StudentScoreDaoImpl 클래스의 객체를 생성하여 studentScoreDao 변수에 할당합니다.
	StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
	// studentScoreDao의 createTable() 메서드를 호출하여 테이블 생성 쿼리를 실행하고 그 결과를 create 변수에 할당합니다.
	String create = studentScoreDao.createTable();
	// create 변수의 내용을 출력합니다.
	out.println(create);

	%>
</body> <!-- body 닫기 -->

</html> <!-- html 닫기 -->