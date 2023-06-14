<%@page import="Domain.GongjiRe"%>
<%@page import="Dao.GongjiReDaoImpl"%>
<%@page import="Dao.GongjiReDao"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
<head>
	<%
		int id = Integer.parseInt(request.getParameter("key")); // Allview 페이지에서 전달된 파라미터 key 값을 받아옵니다.
		
		GongjiReDao gongjiReDao = new GongjiReDaoImpl();
		gongjiReDao.addViewCnt(id); // 조회수 1 추가
		GongjiRe gongjiRe = gongjiReDao.selectOneGongji(id);

		String title = gongjiRe.getTitle(); // 공지사항의 제목을 가져옵니다.
		String date = gongjiRe.getDate(); // 공지사항의 일자를 가져옵니다.
		String content = gongjiRe.getContent(); // 공지사항의 내용을 가져옵니다.
		int rootId = gongjiRe.getRootId();
		int reLevel = gongjiRe.getReLevel();
		int reCnt = gongjiRe.getReCnt();
		int viewCnt = gongjiRe.getViewCnt();
	%>

	<script language="JavaScript">
		function submitForm(mode) {
			if(mode == "delete"){
				var confirmDelete = confirm("정말 삭제하시겠습니까?"); // 해당 메세지 출력
				if (confirmDelete) { // '예'를 선택한 경우의 동작
					location.href = 'GongjiRe_delete.jsp?id=<%=id%>' // 삭제 액션으로 폼을 전송합니다.
				} else { // '아니오'를 선택한 경우의 동작
					retrun; // 함수 실행 종료
				}
			}
			if (mode == "reinsert") {
				location.href = 'GongjiRe_reinsert.jsp?rootId=<%=rootId%>&reLevel=<%=reLevel%>&reCnt=<%=reCnt%>'
			}
			
		}
	</script>
</head>
<body>
	<form method="post" name="fm">
		<table width=800 border="1" cellspacing="0" cellpadding="5">
			<tr>
				<td><b>번호</b></td>
				<td><%=id%></td> <!-- 공지사항의 ID를 출력합니다. -->
			</tr>
			<tr>
				<td><b>제목</b></td>
				<td><%=title.replaceAll("<", "&lt;").replaceAll(">", "&gt;")%></td> <!-- 제목을 출력하되, HTML 태그를 이스케이프하여 출력합니다. -->
			</tr>
			<tr>
				<td><b>일자</b></td>
				<td><%=date%></td> <!-- 일자를 출력합니다. -->
			</tr>
			<tr>
				<td><b>조회수</b></td>
				<td><%=viewCnt%></td> <!-- 조회수 출력합니다. -->
			</tr>
			<tr>
				<th>내용</th>
            	<td><textarea name="content" cols="70" rows="20" readonly style="width: 500px; height: 250px; resize: none; overflow: auto;"><%=gongjiRe.getContent()%></textarea> <!-- 내용을 출력하되, 읽기 전용으로 텍스트 영역에 표시합니다. -->
				</td>
			</tr>
			<tr>
				<td><b>원글</b></td>
				<td><%=rootId%></td> <!-- 원글 출력합니다. -->
			</tr>
			<tr>
				<td><b>댓글수준</b></td>
				<td><%=reLevel%></td> <!-- 댓글수준 출력합니다. -->
			</tr>
			<tr>
				<td><b>댓글내 순서</b></td>
				<td><%=reCnt%></td> <!-- 댓글내 순서 출력합니다. -->
			</tr>
			
		</table>
		<table width=600>
			<tr>
				<td width=500></td>
				<td><input type="button" value="목록" onclick="location.href='GongjiRe_list.jsp'"></td> <!-- '목록' 버튼, 클릭 시 gongji_list.jsp로 이동합니다. -->
				<td><input type="button" value="수정" onclick="location.href='GongjiRe_update.jsp?key=<%=id%>'"></td> <!-- '수정' 버튼, 클릭 시 gongji_update.jsp로 이동하며 해당 공지사항의 ID를 파라미터로 전달합니다. -->
				<td><input type="button" value="삭제" onclick="submitForm('delete')"></td> 
				<td><input type="button" value="댓글" onclick="submitForm('reinsert')"></td> 
			</tr>
		</table>
	</form>
</body>

</html>
