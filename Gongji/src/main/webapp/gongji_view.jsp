<%@page import="Domain.Gongji"%>
<%@page import="Dao.GongjiDaoImpl"%>
<%@page import="Dao.GongjiDao"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
<head>
</head>
<body>
	<%
        int ckey = Integer.parseInt(request.getParameter("key")); // Allview 페이지에서 전달된 파라미터 key 값을 받아옵니다.
        
 	   	GongjiDao gongjiDao = new GongjiDaoImpl();
        
 	   	Gongji gongji = gongjiDao.selectOneGongji(ckey);
 	   	
 	   	int id = gongji.getId(); // 공지사항의 ID를 가져옵니다.
 		String title = gongji.getTitle(); // 공지사항의 제목을 가져옵니다.
 		String date = gongji.getDate(); // 공지사항의 일자를 가져옵니다.
 		String content = gongji.getContent(); // 공지사항의 내용을 가져옵니다.
 		
	%>
        
	<form method="post" name="fm">
		<table width="650" border="1" cellspacing="0" cellpadding="5">
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
				<th>내용</th>
            	<td style="max-width: 300px; word-wrap: break-word;">
            		<textarea name="content" cols="60" rows="20" readonly style="resize: none; overflow: auto;"><%=gongji.getContent()%></textarea> <!-- 내용을 출력하되, 읽기 전용으로 텍스트 영역에 표시합니다. -->
				</td>
			</tr>
		</table>
		<table width="650">
			<tr>
				<td width="600"></td>
				<td><input type="button" value="목록" onclick="location.href='gongji_list.jsp'"></td> <!-- '목록' 버튼, 클릭 시 gongji_list.jsp로 이동합니다. -->
				<td><input type="button" value="수정" onclick="location.href='gongji_update.jsp?key=<%=id%>'"></td> <!-- '수정' 버튼, 클릭 시 gongji_update.jsp로 이동하며 해당 공지사항의 ID를 파라미터로 전달합니다. -->
			</tr>
		</table>
	</form>
</body>

</html>
