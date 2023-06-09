<%@page import="Dao.VoteDaoImpl"%>
<%@page import="Dao.VoteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>후보등록 A_02_H.jsp</title>
</head>
<body>
	<%
	try {
		request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정

		int kiho = Integer.parseInt(request.getParameter("kiho")); // kiho 파라미터 값을 정수로 변환하여 저장

		VoteDao voteDao = new VoteDaoImpl(); // VoteDaoImpl 객체 생성
		voteDao.deleteHubo(kiho); // 특정 기호의 후보를 삭제하는 메소드 호출

	} catch (Exception e) {
		out.println(e); // 예외 발생 시 예외 메시지 출력
	}
	%>

	<table cellspacing="0" width="600" border="1" height="50">
		<tr>
			<td width=100 bgcolor="orange"><a href="A_01_H.jsp">후보등록</a></td>
			<td width=100><a href="B_01_H.jsp">투표</a></td>
			<td width=100><a href="C_01_H.jsp">개표결과</a></td>
		</tr>
	</table>
	<h1>후보등록 삭제</h1>
	<br>
	<h1>후보등록 삭제 완료</h1>
</body>
</html>
