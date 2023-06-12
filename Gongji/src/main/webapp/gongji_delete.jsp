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
        request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정합니다.

        String ckey = request.getParameter("key"); // Allview 페이지에서 전달된 파라미터 key 값을 받아옵니다.
        int id = Integer.parseInt(ckey); // 문자열을 정수로 변환하여 id 변수에 저장합니다.
        
        GongjiDao gongjiDao = new GongjiDaoImpl(); // GongjiDaoImpl 클래스의 객체를 생성합니다.
        Gongji gongji = new Gongji(); // Gongji 클래스의 객체를 생성합니다.

        int c = gongjiDao.getCurrentPage(id, 10); // 현재 페이지 번호를 가져와 c 변수에 저장합니다.
        gongjiDao.deleteOneGongji(id); // id에 해당하는 공지를 삭제합니다.
        response.sendRedirect("gongji_list.jsp?page=" + c); // gongji_list.jsp 페이지로 리다이렉트하고, c 값을 전달합니다.
    } catch (Exception e) {
        e.printStackTrace(); // 에러 내용을 출력합니다.
        out.println(e); // 에러 내용을 출력합니다.
    }
    %>
</body>
</html>
