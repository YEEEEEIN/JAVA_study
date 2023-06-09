<%@page import="java.util.List"%>
<%@page import="Domain.Vote"%>
<%@page import="Dao.VoteDao"%>
<%@page import="Dao.VoteDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>개표결과 C_01_H.jsp</title>
</head>

<table cellspacing="0" width="700" border="1" height="50">
	<tr>
		<td width=100><a href="A_01_H.jsp">후보등록</a></td>
		<td width=100><a href="B_01_H.jsp">투표</a></td>
		<td width=100 bgcolor="orange"><a href="C_01_H.jsp">개표결과</a></td>
	<tr>
</table>

<%
VoteDao voteDao = new VoteDaoImpl(); // VoteDaoImpl 객체 생성
List<Vote> votes = voteDao.selectAll(); // 모든 투표 정보 가져오기

if (votes.size() == 0) {
	out.println("<h1>개표 결과가 없습니다.<h1>"); // 개표 결과가 없을 경우 메시지 출력
} else {
%>
<h1>후보별 득표 결과</h1>
<table cellspacing=3 width=700 border=1>
	<tr>
		<td width=100><p align=center>이름</p></td>
		<td width=600><p align=center>인기도</p></td>
	</tr>
	<%
	int totalCount = voteDao.countAll(); // 전체 투표 수 가져오기

	for (int i = 0; i < votes.size(); i++) {
		Vote vote1 = votes.get(i);

		int kihoCount = voteDao.countVotes(vote1.getKiho()); // 해당 기호의 투표 수 가져오기
		int voteRate = (int) ((double) kihoCount / totalCount * 100); // 인기도 계산 (투표율)

		int barLength = (int) (voteRate * 4); // 인기도를 기준으로 막대 길이 계산

		out.println("<tr>");
		out.println("<td width=100><a href='C_02_H.jsp?key=" + vote1.getKiho() + "&name=" + vote1.getName()
		+ "'><p align=center>" + "기호" + vote1.getKiho() + "번 " + vote1.getName() + "</p></a></td>"); // 후보 이름과 기호 출력 및 링크 추가
		out.print("</td>");
		out.println("<td width=600>");
		out.println("<div>");
		out.println("<span><img src='bar.jpg' style='width: " + barLength
		+ "px; height: 20px; display: inline-block;'></span>"); // 막대 그래프 출력
		out.println("<span>" + kihoCount + "명 " + " (" + voteRate + "%)</span>"); // 득표 수와 인기도 출력
		out.println("</div>");
		out.println("</td>");
		out.println("</tr>");
	}
	%>
</table>
<%
}
%>
</body>
</html>
