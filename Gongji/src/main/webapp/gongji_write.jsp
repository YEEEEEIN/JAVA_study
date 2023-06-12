<%@page import="Domain.Gongji"%>
<%@page import="Dao.GongjiDaoImpl"%>
<%@page import="Dao.GongjiDao"%>
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
	try {
		request.setCharacterEncoding("UTF-8"); // 요청의 인코딩을 UTF-8로 설정합니다.
		int id = 0; // ID 변수를 초기화합니다.
		String title = request.getParameter("title"); // 요청에서 제목을 가져옵니다.
		String content = request.getParameter("content"); // 요청에서 내용을 가져옵니다.
		
		GongjiDao gongjiDao = new GongjiDaoImpl(); // GongjiDaoImpl 객체를 생성합니다.
		Gongji gongji = new Gongji(); // Gongji 객체를 생성합니다.
		
		String ckey = request.getParameter("key"); // Allview 페이지에서 전달된 파라미터 key 값을 받아옵니다.
		
		if (ckey.equals("INSERT")){
			gongji.setTitle(title); // 공지사항의 제목을 설정합니다.
			gongji.setContent(content); // 공지사항의 내용을 설정합니다.
			id = gongjiDao.insertGongji(gongji); // 공지사항을 삽입하고 생성된 ID를 가져옵니다.
			
		} else { // UPDATE
			id = Integer.parseInt(request.getParameter("id")); // id값을 받아옵니다.
			gongji.setId(id); // 공지사항의 ID를 설정합니다.
			gongji.setTitle(title); // 공지사항의 제목을 설정합니다.
			gongji.setContent(content); // 공지사항의 내용을 설정합니다.
			
			gongji = gongjiDao.updateGongji(gongji); // 공지사항을 업데이트합니다.
		}

		int c = gongjiDao.getCurrentPage(id, 10); // 현재 페이지를 가져옵니다.
		response.sendRedirect("gongji_list.jsp?page=" + c); // 목록 페이지로 리다이렉트합니다.
	} catch(Exception e){
      	e.printStackTrace(); // 에러 내용을 출력합니다.
      	out.println(e); // 에러 메시지를 출력합니다.
     }%>
</body>
</html>
