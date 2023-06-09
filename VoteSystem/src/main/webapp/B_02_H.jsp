<%@page import="Dao.VoteDao"%>
<%@page import="Dao.VoteDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>투표 B_02_H.jsp</title>
</head>

<body>
	<table cellspacing="0" width="600" border="1" height="50">
		<tr>
			<td width=100><a href="A_01_H.jsp">후보등록</a></td>
			<td width=100 bgcolor="orange"><a href="B_01_H.jsp">투표</a></td>
			<td width=100><a href="C_01_H.jsp">개표결과</a></td>
		</tr>
	</table>
	<%
	try {
		request.setCharacterEncoding("UTF-8");
		int kiho = Integer.parseInt(request.getParameter("kiho")); // 투표 대상 기호 가져오기
		int age = Integer.parseInt(request.getParameter("age")); // 투표자 나이 가져오기

		VoteDao voteDao = new VoteDaoImpl(); // VoteDaoImpl 객체 생성
		voteDao.insertIntoTupyo(kiho, age); // 투표 결과 DB에 저장

	} catch (Exception e) {
		out.println(e); // 예외 처리
	}
	%>
	<h1>투표 결과</h1>
	<br>
	<h1>투표를 완료하였습니다.</h1>
</body>
</html>
