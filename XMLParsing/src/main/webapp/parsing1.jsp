<%@ page contentType="text/xml; charset=utf-8" %>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*" %>

<%
	// MySQL JDBC 드라이버를 로드합니다. 데이터베이스와의 연결에 필요합니다.
	Class.forName("com.mysql.cj.jdbc.Driver");

	// 데이터베이스에 연결합니다. URL은 "jdbc:mysql://호스트:포트/데이터베이스이름" 형식입니다.
	// "root"는 데이터베이스 사용자 이름, "kopo23"은 비밀번호입니다.
	Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.23:33060/kopo23", "root", "kopo23");

	// SQL 문을 데이터베이스로 보내고 실행하기 위한 Statement 객체를 생성합니다.
	Statement stmt = conn.createStatement();

	// "examtable" 테이블에서 모든 열을 선택하는 쿼리를 실행하고 결과를 ResultSet 객체로 받습니다.
	ResultSet rset = stmt.executeQuery("SELECT * FROM examtable;");

	// XML 출력을 위한 루트 엘리먼트를 생성합니다.
	out.println("<datas>");

	// ResultSet 객체에서 데이터를 읽어와서 XML 형식으로 출력합니다.
	while(rset.next()) {
		out.println("<data>");

		out.println("<name>" + rset.getString(1) + "</name>"); // 첫 번째 열의 데이터를 name 엘리먼트로 출력합니다.
		out.println("<studentid>" + rset.getString(2) + "</studentid>"); // 두 번째 열의 데이터를 studentid 엘리먼트로 출력합니다.
		out.println("<kor>" + Integer.toString(rset.getInt(3)) + "</kor>"); // 세 번째 열의 데이터를 kor 엘리먼트로 출력합니다.
		out.println("<eng>" + Integer.toString(rset.getInt(4)) + "</eng>"); // 네 번째 열의 데이터를 eng 엘리먼트로 출력합니다.
		out.println("<mat>" + Integer.toString(rset.getInt(5)) + "</mat>"); // 다섯 번째 열의 데이터를 mat 엘리먼트로 출력합니다.

		out.println("</data>");
	}

	// XML 출력을 마무리하기 위해 루트 엘리먼트를 닫습니다.
	out.println("</datas>");

	stmt.close(); // Statement 객체를 닫습니다.
	conn.close(); // Connection 객체를 닫습니다.
%>
