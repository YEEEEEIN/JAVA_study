<%@page import="Domain.Gongji"%>
<%@page import="Dao.GongjiDaoImpl"%>
<%@page import="Dao.GongjiDao"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>

<head>
	<%
   		int ckey = Integer.parseInt(request.getParameter("key")); // Allview 페이지에서 전달된 파라미터 key 값을 받아옵니다.
    
	   	GongjiDao gongjiDao = new GongjiDaoImpl(); // GongjiDaoImpl 객체를 생성합니다.
    
	   	Gongji gongji = gongjiDao.selectOneGongji(ckey); // ckey 값을 사용하여 GongjiDao에서 공지 정보를 가져옵니다.
		
		String title = gongji.getTitle(); // 공지 제목을 가져옵니다.
		String date = gongji.getDate(); // 공지 등록일을 가져옵니다.
		String content = gongji.getContent(); // 공지 내용을 가져옵니다.
		// out.println(ckey);

	%>
	
	<script language="JavaScript">
	function submitForm(mode) {
		if (mode == "write") { // 쓰기 모드인 경우
			const title = fm.elements.title.value; // 이름 필드 값 가져오기
			const content = fm.elements.content.value; // 국어 점수 필드 값 가져오기
			
			if (title.trim() === '') { // 입력 창이 비어있으면
				alert("제목을 입력해주세요."); // 해당 메세지 출력
				return; // 함수 실행 종료
			}


			if (title.length > 70) { // 제목이 70자 이상이면
				alert("제목은 70자 이하만 입력 가능합니다."); // 해당 메세지 출력
				return; // 함수 실행 종료
			}

			fm.action = "gongji_write.jsp?key=UPDATE"; // 업데이트 액션으로 폼을 전송합니다.
			fm.submit();

		} else if (mode == "delete") { // 삭제 모드인 경우
			var confirmDelete = confirm("정말 삭제하시겠습니까?"); // 해당 메세지 출력
			if (confirmDelete) { // '예'를 선택한 경우의 동작
				fm.action = "gongji_delete.jsp?key=<%=ckey%>"; // 삭제 액션으로 폼을 전송합니다.
			} else { // '아니오'를 선택한 경우의 동작
				retrun; // 함수 실행 종료
			}
		}
		
		fm.submit();
	}
	</script>
</head>


<body>
	
	<form method="post" name="fm">
		<table width="650" border="1" cellspacing="0" cellpadding="5">
			<tr>
				<td><b>번호</b></td>
				<td><input type="text" name="id" size="70" value="<%=ckey%>" readonly></td> <!-- 번호 필드, ckey 값을 출력하고 읽기 전용으로 설정합니다. -->
			</tr>
			<tr>
				<td><b>제목</b></td>
				<td><input type="text" name="title" size="70" maxlength="70" value="<%=title%>"></td> <!-- 제목 필드, title 값을 출력합니다. -->
			</tr>
			<tr>
				<td><b>일자</b></td>
				<td><%=date%></td> <!-- 일자 정보를 출력합니다. -->
			</tr>
			<tr>
				<td><b>내용</b></td>
				<td><textarea style="width: 500px; height: 250px; resize: none; overflow: auto;" name="content" cols="70" row="600"><%=content%></textarea></td> <!-- 내용 필드, content 값을 출력합니다. -->
			</tr>
		</table>
		<table width="650">
			<tr>
				<td width="600"></td>
				<td><input type="button" value="목록" onclick="location.href='gongji_list.jsp'"></td> <!-- '목록' 버튼, 클릭 시 gongji_list.jsp로 이동합니다. -->
				<td><input type="button" value="쓰기" onclick="submitForm('write')"></td> <!-- '쓰기' 버튼, 클릭 시 submitForm 함수를 호출하여 쓰기 모드로 폼을 전송합니다. -->
				<td><input type="button" value="삭제" onclick="submitForm('delete')"></td> <!-- '삭제' 버튼, 클릭 시 submitForm 함수를 호출하여 삭제 모드로 폼을 전송합니다. -->
			</tr>
		</table>
	</form>
</body>


</html>