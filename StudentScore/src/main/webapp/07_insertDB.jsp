<%@page import="kopo23.domian.StudentScore"%>
<%@page import="kopo23.dao.StudentScoreDaoImpl"%>
<%@page import="kopo23.dao.StudentScoreDao"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<!-- html 한글처리 -->
<%@ page contentType="text/html; charset=utf8"%>
<%-- 페이지의 콘텐츠 타입과 문자 인코딩 설정 --%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.net.*"%>
<%-- jsp파일에 java 클래스, java sql import --%>

<html>
<head></head>
<body>
	<%
           	try{
           	request.setCharacterEncoding("UTF-8"); // UTF-8로 자동 인코딩
           	
            String name = request.getParameter("name"); // 파라미터가 name 값 가져오기
            int kor = Integer.parseInt(request.getParameter("korean")); // 파라미터가 korean 값 가져오기
            int eng = Integer.parseInt(request.getParameter("english")); // 파라미터가 english 값 가져오기
            int mat = Integer.parseInt(request.getParameter("math")); // 파라미터가 math 값 가져오기
            
        	// StudentScore 객체 생성 및 필드 값 설정
            StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
            StudentScore studentScore = new StudentScore();
            studentScore.setName(name);
            studentScore.setKor(kor);
            studentScore.setEng(eng);
            studentScore.setMat(mat);
            
        	 // 학생 성적 데이터를 데이터베이스에 생성
            StudentScore printResult = studentScoreDao.create(studentScore);
            
            // 생성된 학생 성적 데이터의 학번(studentid) 가져오기
            String studentid = printResult.getStudentid();
            
            %>

	<!--추가 버튼을 누른 후 확인할 수 있는 완료 창-->
	<h1>성적입력추가완료</h1>

	<form method='get' action='06_inputForm1.html'> <!--아래 폼을 다 채우고 실행은 06_inputForm1.jsp로 간다-->
		<table cellspacing=1 width=500 border=0> <!-- table 열고 셀크기, 넓이, 테두리 스타일 지정 -->
			<tr>
				<!-- 제출용(<input type="submit">) 버튼을 생성, 버튼의 스타일을 지정하고, 뒤로가기라는 텍스트를 버튼에 표시, 사용자가 이 버튼을 클릭하면 주변 폼(form)을 제출 -->
				<td width=100><input type="submit" style="width: 100px; height: 50px; font-size: 16px;"  value="뒤로가기"></td> 
			</tr>
		</table>
		<br>
		<table cellspacing=5 width=500 height=250 border=1> <!-- table 열고 셀크기, 넓이, 테두리 스타일 지정 -->
			<tr>
				<td width=200>
					<p align=center>이름</p> <!-- 이름 -->
				</td>
				<td width=300>
					<!-- 'name'아리는 이름에 불러온 파라미터 값 저장 -->
					<p align=center><input type='text' name='name' value='<%=name%>' readonly></p> 
				</td>
			</tr>
			<tr>
				<td width=200>
					<p align=center>학번</p> <!-- 학번 -->
				</td>
				<td width=300>
					<!-- 'studentid'아리는 이름에 불러온 파라미터 값 저장 -->
					<p align=center><input type='text' name='studentid' value='<%=studentid%>' readonly></p>
				</td>
			</tr>
			<tr>
				<td width=200>
					<p align=center>국어</p> <!-- 국어 -->
				</td>
				<td width=500>
					<!-- 'korean'아리는 이름에 불러온 파라미터 값 저장 -->
					<p align=center><input type='text' name='korean' value='<%=kor%>' readonly></p>
				</td>
			</tr>
			<tr>
				<td width=200>
					<p align=center>영어</p> <!-- 영어 -->
				</td>
				<td width=500>
					<!-- 'english'아리는 이름에 불러온 파라미터 값 저장 -->
					 <p align=center><input type='text' name='english' value='<%=eng%>' readonly></p>
				</td>
			</tr>
			<tr>
				<td width=200>
					<p align=center>수학</p> <!-- 수학 -->
				</td>
				<td width=500>
					<!-- 'math'아리는 이름에 불러온 파라미터 값 저장 -->
					<p align=center><input type='text' name='math' value='<%=mat%>' readonly></p>
				</td>
			</tr>
		</table>

	</form>
	<% } catch (Exception e) { 
		out.println(e); 
	} %>
</body>
</html>






