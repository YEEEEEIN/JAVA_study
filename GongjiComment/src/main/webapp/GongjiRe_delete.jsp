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
	<%
	int c = 0;
    try {
        request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정합니다.

        int id = Integer.parseInt(request.getParameter("id")); // Allview 페이지에서 전달된 파라미터 key 값을 받아옵니다.
        
        GongjiReDao gongjiReDao = new GongjiReDaoImpl(); // GongjiDaoImpl 클래스의 객체를 생성합니다.
        gongjiReDao.deleteOneGongji(id);
    %>
    
    <script> // 스크립트 작성 시작
	alert('삭제되었습니다.'); // 삭제되었다는 안내문 출력
	window.location='GongjiRe_list.jsp?key=<%=id%>'; // 리스트에서 해당 id가 존재하는 페이지로 이동
	</script> <!--스크립트 작성 끝-->

    <%    
    } catch (Exception e) {
        e.printStackTrace(); // 에러 내용을 출력합니다.
        out.println(e); // 에러 내용을 출력합니다.
    }
    %>
</head>
<body>
</body>
</html>
