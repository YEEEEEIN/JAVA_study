<%@page import="java.util.ArrayList"%>
<%@page import="Domain.Vote"%>
<%@page import="java.util.List"%>
<%@page import="Dao.VoteDao"%>
<%@page import="Dao.VoteDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>개표결과 C_02_H.jsp</title>
</head>

<table cellspacing="0" width="600" border="1" height="50">
	<tr>
		<td width=100><a href="A_01_H.jsp">후보등록</a></td>
		<td width=100><a href="B_01_H.jsp">투표</a></td>
		<td width=100 bgcolor="orange"><a href="C_01_H.jsp">개표결과</a></td>
	<tr>
</table>

<%
String ckey = request.getParameter("key");
String name = request.getParameter("name");
%>
<h1>
	[<%=ckey%>번 <%=name%>] 후보 득표 성향
</h1>
<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=75><p align=center>연령대</p></td>
		<td width=500><p align=center>인기도</p></td>
	</tr>
	<%
	int kiho = Integer.parseInt(ckey); // 선택된 후보의 기호 가져오기

	VoteDao voteDao = new VoteDaoImpl(); // VoteDaoImpl 객체 생성

	List<Vote> votes = voteDao.selectOne(kiho); // 해당 기호의 투표 정보 가져오기

	int kihoCount = voteDao.countVotes(kiho); // 해당 기호의 총 투표 수 가져오기

	for (int age = 1; age <= 9; age++) {
		int ageCount = 0;
		for (int i = 0; i < votes.size(); i++) {
			Vote vote1 = votes.get(i);
			if (vote1.getAge() == age) {
				ageCount = vote1.getCount();
				break;
			}
		}

		int voteRate = kihoCount > 0 ? (int) ((double) ageCount / kihoCount * 100) : 0; // 인기도 계산 (투표율)

		int barLength = (int) (voteRate * 4); // 인기도를 기준으로 막대 길이 계산

		out.println("<tr>");
		out.println("<td width=75><p align=center>" + (age * 10) + "대" + "</p></td>"); // 연령대 출력
		out.println("<td width=500><p align=center>");
		out.println("<div>");
		out.println("<span><img src='bar.jpg' style='width: " + barLength
		+ "px; height: 20px; display: inline-block;'></span>"); // 막대 그래프 출력
		out.println("<span>" + ageCount + "명 " + "(" + voteRate + "%)</span>"); // 득표 수와 인기도 출력
		out.println("</div>");
		out.println("</td>");
		out.println("</tr>");
	}
	%>

</table>
</body>
