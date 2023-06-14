<%@page import="Domain.GongjiRe"%>
<%@page import="Dao.GongjiReDaoImpl"%>
<%@page import="Dao.GongjiReDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int id = 0;
	try {
		request.setCharacterEncoding("UTF-8"); // 요청의 인코딩을 UTF-8로 설정합니다.
		
		String ckey = request.getParameter("key"); // Allview 페이지에서 전달된 파라미터 key 값을 받아옵니다.

		GongjiReDao gongjiReDao = new GongjiReDaoImpl(); // GongjiDaoImpl 객체를 생성합니다.
		
		GongjiRe gongjiRe = new GongjiRe(); // Gongji 객체를 생성합니다.
		
		
		if(ckey.equals("INSERT")) {
			String title = request.getParameter("title"); // 요청에서 제목을 가져옵니다.
			String content = request.getParameter("content"); // 요청에서 내용을 가져옵니다.
			int rootId = Integer.parseInt(request.getParameter("rootId")); // rootid 값 받아오기
			int reLevel = Integer.parseInt(request.getParameter("reLevel")); // relevel 값 받아오기
			int reCnt = Integer.parseInt(request.getParameter("reCnt")); // recnt 값 받아오기
			
			gongjiRe.setTitle(title); // 공지사항의 제목을 설정합니다.
			gongjiRe.setContent(content); // 공지사항의 내용을 설정합니다.
			gongjiRe.setRootId(rootId); // 공지사항의 내용을 설정합니다.
			gongjiRe.setReLevel(reLevel); // 공지사항의 내용을 설정합니다.
			gongjiRe.setReCnt(reCnt); // 공지사항의 내용을 설정합니다.
			
			id = gongjiReDao.insertGongji(gongjiRe); // 공지사항을 삽입하고 생성된 ID를 가져옵니다.
			
		} 
		
		if(ckey.equals("UPDATE")) {
			id = Integer.parseInt(request.getParameter("id")); // id값을 받아옵니다.
			
			String title = request.getParameter("title"); // title 받아옴
			String content = request.getParameter("content"); // content 받아옴
			
			gongjiRe.setId(id); // id값 세팅
			gongjiRe.setTitle(title); // 공지사항 제목 세팅
			gongjiRe.setContent(content); // 본문 내용 세팅
			
			int update = gongjiReDao.updateGongji(gongjiRe); // 공지사항을 업데이트합니다.
		}

		int c = gongjiReDao.getCurrentPage(id, 10); // 현재 페이지를 가져옵니다.
		response.sendRedirect("GongjiRe_list.jsp?page=" + c); // 목록 페이지로 리다이렉트합니다.
	} catch(Exception e){
      	e.printStackTrace(); // 에러 내용을 출력합니다.
      	out.println(e); // 에러 메시지를 출력합니다.
     }%>
</body>
</html>
