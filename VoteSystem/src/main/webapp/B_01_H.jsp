<%@page import="java.util.List"%>
<%@page import="Domain.Vote"%>
<%@page import="Dao.VoteDaoImpl"%>
<%@page import="Dao.VoteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>투표 B_01_H.jsp</title>
</head>
<body>
	<table cellspacing="0" width="600" border="1" height="50">
		<tr>
			<td width=100><a href="A_01_H.jsp">후보등록</a></td>
			<td width=100 bgcolor="orange"><a href="B_01_H.jsp">투표</a></td>
			<td width=100><a href="C_01_H.jsp">후보등록</a></td>
		</tr>
	</table>


	<%
	VoteDao voteDao = new VoteDaoImpl(); // VoteDaoImpl 객체 생성
	Vote vote = new Vote(); // Vote 객체 생성
	List<Vote> votes = voteDao.selectAll(); // 모든 투표 정보 가져오기
	if (votes.size() == 0) {
		out.println("<h1>투표할 대상이 없습니다.<h1>"); // 투표할 대상이 없을 경우 메시지 출력
	} else {
	%>
	<h1>투표하기</h1>
	<table cellspacing=3 width=600 border=1>
		<tr>
			<form method="post" action="B_02_H.jsp">
				<td width=200><p align=center>
						<select name="kiho" style="height: 50px; width: 180px;">
							<%
							for (int i = 0; i < votes.size(); i++) {
								Vote vote1 = votes.get(i); // 리스트에서 각 투표 정보 가져오기
								out.println("<option value=" + vote1.getKiho() + ">" + "기호"  + vote1.getKiho() + "번 " + vote1.getName() + "</option>"); // 선택 옵션 생성 및 투표 정보 표시
							}
							%>
						</select>
					</p></td>

				<td width=200><p align=center>
						<select name="age" style="height: 50px; width: 100px;">
							<option value="1">10대</option> <!-- 값 1에 10대 할당 -->
							<option value="2">20대</option> <!-- 값 2에 20대 할당 -->
							<option value="3">30대</option> <!-- 값 3에 30대 할당 -->
							<option value="4">40대</option> <!-- 값 4에 40대 할당 -->
							<option value="5">50대</option> <!-- 값 5에 50대 할당 -->
							<option value="6">60대</option> <!-- 값 6에 60대 할당 -->
							<option value="7">70대</option> <!-- 값 7에 70대 할당 -->
							<option value="8">80대</option> <!-- 값 8에 80대 할당 -->
							<option value="9">90대</option> <!-- 값 9에 90대 할당 -->
						</select>
					</p></td>

				<td><p align=center>
						<input type=submit style="height: 50px; width: 100px;" value="투표하기"></td>

			</form>
		</tr>
	</table>
	<%
	}
	%>

</body>
</html>