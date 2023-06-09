<%@page import="Domain.Vote"%>
<%@page import="Dao.VoteDaoImpl"%>
<%@page import="Dao.VoteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>후보등록 A_03_H.jsp</title>
</head>
<body>
	<%
		try {
			request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정

			String name = request.getParameter("name"); // name 파라미터 값을 가져와서 저장
			
			VoteDao voteDao = new VoteDaoImpl(); // VoteDaoImpl 객체 생성

			int a = voteDao.insertIntoHubo(name); // 후보를 추가하는 메소드 호출하여 결과를 저장


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
	<h1>후보등록 추가</h1>
	<br>
	<h1>후보등록 추가 완료</h1>
</body>
</html>
