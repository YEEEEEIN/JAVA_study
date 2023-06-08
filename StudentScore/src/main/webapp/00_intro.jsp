<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<!-- html 한글처리 -->
<%@ page contentType="text/html; charset=utf8"%>
<%-- 페이지의 콘텐츠 타입과 문자 인코딩 설정 --%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*"%>
<%-- jsp파일에 java 클래스, java sql import --%>

<html>
<head></head>

<body>
	<h1>
		<center>JSP 실습 1</center>
	</h1>

	<%
	// 변수 초기화
	String data;
	int cnt = 0;

	// 파일 읽기
	FileReader f1 = new FileReader("C:/Users/예인/eclipse-jsp_workspace/StudentScore/src/main/webapp/00_cnt.txt"); // 경로 설정
	StringBuffer sb = new StringBuffer();
	int ch = 0;
	while ((ch = f1.read()) != -1) {
		sb.append((char) ch);
	}
	data = sb.toString().trim().replace("\n", "");
	f1.close();

	// 데이터 처리
	cnt = Integer.parseInt(data); // 문자열을 정수로 변환
	cnt++; // 카운트 증가
	data = Integer.toString(cnt); // 정수를 문자열로 변환
	out.println("<br><br>현재 홈페이지 방문자조회수는 [" + data + "] 입니다</br>"); // 결과 출력

	// 파일 쓰기
	FileWriter f12 = new FileWriter("C:/Users/예인/eclipse-jsp_workspace/StudentScore/src/main/webapp/00_cnt.txt", false); // 경로 설졍
	f12.write(data);
	f12.close();
	%>
</body>
</html>