<%@page import="Domain.Gongji"%>
<%@page import="Dao.GongjiDaoImpl"%>
<%@page import="Dao.GongjiDao"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>

<head>
<script language="JavaScript">
	function submitForm() { // submitForm 함수 선언
		const title = fm.elements.title.value; // 이름 필드 값 가져오기
		const content = fm.elements.content.value; // 국어 점수 필드 값 가져오기

		if (title.trim() === '') { // 입력 창이 비어있으면
			alert("제목을 입력해주세요."); // 해당 메세지 출력
			return; // 함수 실행 종료
		}
		
		if (content.trim() === '') { // 입력 창이 비어있으면
			alert("내용을 입력해주세요."); // 해당 메세지 출력
			return; // 함수 실행 종료
		}
		
		if (title.length > 70) { // 이름이 20자 이상이면
			alert("제목은 70자 이하만 입력 가능합니다."); // 해당 메세지 출력
			return; // 함수 실행 종료
		}
		
		fm.action = "gongji_write.jsp?key=INSERT"; // 이동경로 설정, 키값 설정
		fm.submit(); // 제출
	}
</script>
</head>

<body>
	<%
	java.sql.Date date = new java.sql.Date(System.currentTimeMillis()); // 현재 날짜를 가져옵니다.
	
	%>
	<form method=post name='fm'>
		<table width=650 border=1 cellspacing=0 cellpadding=5>
			<tr>
				<td><b>번호</b></td> <!-- 번호 열 -->
				<td>신규(insert)<input type=hidden name=id></td> <!-- 번호 입력란 -->
			</tr>
			<tr>
				<td><b>제목</b></td> <!-- 제목 열 -->
				<td><input type=text name=title size=70 maxlength=70></td> <!-- 제목 입력 필드 -->
			</tr>
			<tr>
				<td><b>일자</b></td> <!-- 일자 열 -->
				<td><%=date%></td> <!-- 현재 날짜 출력 -->
			</tr>
			<tr>
				<td><b>내용</b></td> <!-- 내용 열 -->
				<td><textarea style='width: 500px; height: 250px; resize: none; overflow: auto;' name=content cols=70 row=600></textarea></td> <!-- 내용 입력 필드 -->
			</tr>
		</table>
		
		<table width=650>
			<tr>
				<td width=600></td>
				<td><input type=button value="취소" OnClick="location.href='gongji_list.jsp'"></td> <!-- 취소 버튼 -->
				<td><input type=button value="쓰기" OnClick="submitForm()"></td> <!-- 쓰기 버튼 -->
			</tr>
		</table>
	</form>
</body>


</html> 