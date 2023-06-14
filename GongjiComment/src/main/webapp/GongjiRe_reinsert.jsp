<%@page import="Dao.GongjiReDaoImpl"%>
<%@page import="Dao.GongjiReDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
function submitForm() { // 제출 버튼 눌렀을 때 호출되는 함수
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
	
	fm.action = "GongjiRe_write.jsp?key=INSERT"; // 이동경로 설정, 키값 설정
	fm.submit(); // 제출
}
</script> <!--스크립트 작성 끝-->
</head>
<body>
	<%
	java.sql.Date Todaydate = new java.sql.Date(System.currentTimeMillis());
	
	int rootId = Integer.parseInt(request.getParameter("rootId")); // rootid 받아옴
	int reLevel = Integer.parseInt(request.getParameter("reLevel")); // relevel 받아옴
	
	GongjiReDao gongjiReDao = new GongjiReDaoImpl(); // DAO 객체 생성
	int reCnt = Integer.parseInt(request.getParameter("reCnt")); // recnt 받아옴
	
	reCnt = gongjiReDao.getReCnt(rootId, reLevel, reCnt); // 모체의 레벨과 cnt
	%>
	
	<form method=get name='fm'> <!--폼 생성-->
		<table width=800 border=1 cellspacing=0 cellpadding=5> <!--테이블 생성-->
			<tr> <!--tr 태그 시작-->
				<th><b>번호</b></th> <!--번호-->
				<td>댓글(insert)<input type=hidden name=key value='INSERT'></td> <!--key 전달-->
			</tr> <!--tr 태그 끝-->
			<tr> <!--tr 태그 시작-->
				<th><b>제목</b></th> <!--제목-->
				<!--제목 출력-->
				<td><input type=text name=title size=70 maxlength=70 placeholder="제목을 입력하세요."></td>
			</tr> <!--tr 태그 끝-->
			<tr> <!--tr 태그 시작-->
				<th><b>일자</b></th> <!--오늘 일자-->
				<td><%=Todaydate%></td> <!--오늘 일자-->
			<input type=hidden name=date value='<%=Todaydate%>'> <!--오늘 일자-->
			</tr> <!--tr 태그 끝-->
			<tr> <!--tr 태그 시작-->
				<th><b>내용</b></th> <!--내용-->
				 <!--내용 출력-->
				<td><textarea style='width:500px; height:250px;' name=content cols=70 row=600 placeholder="본문 내용을 입력하세요."></textarea></td>
			</tr> <!--tr 태그 끝-->
			<tr> <!--tr 태그 시작-->
				<th><b>원글</b></th> <!--원글 id-->
				<td><%=rootId%></td> <!--원글 id cnffur-->
			<input type=hidden name=rootId value=<%=rootId%>> <!--원글 id wjsekf-->
			</tr> <!--tr 태그 끝-->
			<tr> <!--tr 태그 시작-->
				<th><b>댓글수준</b></th> <!--댓글수준-->
				<td> <!--td 닫기-->
			  <%=reLevel+1%> <!--댓글수준-->
			  <span style="float: right; margin-right: 50px;"> <!--span 생성-->
			    댓글 내 순서: <%=reCnt%> <!--댓글 내 순서 출력-->
			<input type=hidden name=reLevel value=<%=reLevel+1%>> <!--relevel-->
			<input type=hidden name=reCnt value=<%=reCnt%>> <!--recnt-->
			  </span><!--span 닫기-->
			</td> <!--td 닫기-->
			
			</tr> <!--tr 태그 끝-->
			</table> <!--테이블 작성 끝-->
		
			<table width=600> <!--테이블 생성-->
				<tr> <!--tr 태그 시작-->
					<td width=550></td> <!--td 열고 닫기-->
					<td><input type=button value="취소" onclick="history.back()"></td><!--취소 버튼 생성-->
					<td><input type=button value="쓰기" onclick="submitForm()"></td> <!--쓰기 버튼 생성-->
					
			</table> <!--테이블 작성 끝-->
</form> <!--폼 작성 끝-->
</body>
</html>