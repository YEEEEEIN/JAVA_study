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
<head>
<%
	    	try{
	            String name = ""; // 이름 변수 문자형 선언
	            String studentid = ""; // 학번 변수 문자형 선언
	            String kor = ""; // 국어 변수 문자형 선언
	            String eng = ""; // 영어 변수 문자형 선언
	            String mat = ""; // 수학 변수 문자형 선언
	            
				request.setCharacterEncoding("UTF-8"); // UTF-8로 자동 인코딩
				String ctmp = request.getParameter("searchStudentid"); // searchid라는 이름의 박스 안에 있는 값을 가지고 온다
				if (ctmp.length() == 0) ctmp = "0"; // Ediring 만약 이 문장이 없는데 아무 학번도 없이 조회한다면?
						
				StudentScoreDao studentScoreDao = new StudentScoreDaoImpl(); // StudentScoreDao 인터페이스의 구현 클래스의 인스턴스를 생성합니다.
	            StudentScore studentScore = new StudentScore(); // StudentScore 객체 생성
	            studentScore = studentScoreDao.selectOne(ctmp); // selectOne함수 실행 값을 studentScore에 저장
	            
	            if (studentScore.getStudentid() == null) { // studentScore의 학번이 null이면
	            	studentid = "해당학번없음"; // studentid에 "해당학번없음" 저장
	            } else { // 학번이 null이 아니면
	            	// 객체의 값들을 get을 통해 불러와서 각각의 변수에 저장
	            	name = studentScore.getName();
	            	studentid = studentScore.getStudentid();
	            	kor = Integer.toString(studentScore.getKor());
	            	eng = Integer.toString(studentScore.getEng());
	            	mat = Integer.toString(studentScore.getMat());
	            }
		%>

	<SCRIPT LANGUAGE="JavaScript">
	        function submit1() { // submit1 함수 정의
	        	const form = document.getElementById('showRec'); // HTML 문서에서 id 속성이 "showRec"인 요소를 찾아와 해당 요소를 변수 form에 할당
	    		const searchStudentid = form.elements.searchStudentid.value; // form의 요소인 searchStudentid 값 가져와서 변수에 대입
	    		const pattern1 = /^\d+$/; // 숫자만 허용하는 패턴
	    		const pattern2 = /^.+$/; // 빈 문자열을 허용하지 않는 패턴
	    		const pattern3 = /^[^.]*$/; // 점을 허용하지 않는 패턴
	    		if (!pattern1.test(studentid) || !pattern2.test(studentid) // 만약 학번이 3개 pattern에 해당하지 않는다면
	    				|| !pattern3.test(studentid)) {
	    			alert("유효한 값을 입력하세요"); // 해당 메세지 출력 
	    		} else {
	    			form.action = "09_showREC.jsp"; // 09_showREC.jsp로 제출할 위치 지정
	    			form.submit(); // 제출
	    		}
	        }   

            function submitForm(mode){ // submitForm 함수
            	const form = document.getElementById('updateData'); // HTML 문서에서 id 속성이 "updateData"인 요소를 찾아와 해당 요소를 변수 form에 할당
                if(mode == "update"){ // 매개변수 mode가 update라면
                	const name = form.elements.name.value; // 이름 필드 값 가져오기
        			const kor = form.elements.korean.value; // 국어 점수 필드 값 가져오기
        			const eng = form.elements.english.value; // 영어 점수 필드 값 가져오기
        			const mat = form.elements.math.value; // 수학점수 필드 값 가져오기
        			// const pattern1 = /^([a-zA-Z]|[가-힣])+$/; // 한글 또는 영어만 입력 가능한 패턴1
        			const pattern1 = /^([a-zA-Z가-힣]+|[a-zA-Z0-9가-힣]+)$/; // 한글 또는 영어만 입력 가능한 패턴1, 한글, 영어, 숫자 조합도 입력 가능
        			const pattern2 = /^(?:100|[1-9]?[0-9])$/; // 0부터 100 사이의 정수만 입력 가능한 패턴2

        			if (name.trim() === '' || kor.trim() === '' || eng.trim() === ''
        					|| mat.trim() === '') { // 입력 창이 비어있으면
        				alert("데이터를 모두 입력해주세요."); // 해당 메세지 출력
        				return; // 함수 실행 종료
        			}
        			
        			if (!pattern1.test(name)) { // 이름에 유효한 한글 또는 영어가 입력되지 않으면
        				alert("이름은 정확한 한글 또는 영어만 입력 가능합니다."); // 해당 메세지 출력
        				return; // 함수 실행 종료
        			}
        			
        			if (!pattern2.test(kor) || !pattern2.test(eng) || !pattern2.test(mat)) { // 점수가 0부터 100사이의 값이 아니면
        				alert("국어, 영어, 수학 점수는 0부터 100 사이의 정수만 입력 가능합니다."); // 해당 메세지 출력
        				return; // 함수 실행 종료
        			}
        			
        			if (name.length > 20) { // 이름이 20자 이상이면
        				alert("이름은 20자 이하만 입력 가능합니다."); // 해당 메세지 출력
        				return; // 함수 실행 종료
        			}
        			
        			form.action = "10_updateDB.jsp"; // myform이라는 이름의 HTML 폼의 action 속성을 "10_update.jsp"로 설정 => action 속성은 폼 데이터가 제출될 대상 URL을 지정
        			form.submit(); // myform이라는 이름의 HTML 폼의 action 속성을 "10_update.jsp"로 설정합니다. action 속성은 폼 데이터가 제출될 대상 URL을 지정
                } else if(mode == "delete"){ // 매개변수 mode가 delete라면
                	form.action = "11_deleteDB.jsp"; // 11_deleteDB.jsp로 제출할 위치 지정
                	form.submit(); // 제출
                }
            }
            
	
        </SCRIPT>
</head>

<body>
	<h1>성적 조회 후 정정 / 삭제</h1>
	<form method='get' id="showRec"> <!-- GET 메서드를 사용하는 폼을 생성하고, 해당 폼의 식별자를 "showRec"로 설정 -->
		<table cellspacing=1 width=500 border=0> <!-- 테이블을 생성하며, 셀 간의 간격은 1, 너비는 500, 테두리는 없도록 설정 -->
			<tr>
				<td width=100>
					<!-- 조회할 학번 -->
					<p align=center>조회할 학번</p>
				</td>
				<td width=200>
					<p align=center>
						<!-- 너비가 150, 높이가 50 픽셀, 글꼴 크기가 16인 텍스트 입력 상자를 생성하고, "searchStudentid"라는 이름으로 식별 -->
						<input type='text' style="width: 150px; height: 50px; font-size: 16px;" name='searchStudentid' value=''>
					</p>
				</td>
				<td width=500>
				<!-- 너비가 100, 높이가 50 픽셀, 글꼴 크기가 16인 "조회"라는 값을 가지는 버튼을 생성하고, 클릭 이벤트가 발생하면 "submit1()" 함수를 호출 -->
				<input type="button" style="width: 100px; height: 50px; font-size: 16px;" value="조회" onclick="submit1()"></td>
			</tr>
		</table>
	</form>



	<form method='get' action='myform' id='updateData'>
		<!--이 폼 버튼은 두 개, 즉 action을 위해 자바스크립트 함수로 분기정의함-->
		<table cellspacing=5 width=500 height=250 border=1>
			<tr>
				<td width=200>
					<p align=center>이름</p>
				</td>
				<td width=300>
					<p align=center>
						<!-- 'name'이라는 이름에 불러온 파라미터 값 저장 -->
						<input type='text' name='name' value='<%=name%>'>
					</p>
				</td>
			</tr>
			<tr>
				<td width=200>
					<p align=center>학번</p>
				</td>
				<td width=300>
					<p align=center>
						<!-- 'studentid'이라는 이름에 불러온 파라미터 값 저장 -->
						<input type='text' name='studentid' value='<%=studentid%>' readonly>
					</p>
				</td>
			</tr>
			<tr>
				<td width=200>
					<p align=center>국어</p>
				</td>
				<td width=300>
					<p align=center>
						<!-- 'korean'이라는 이름에 불러온 파라미터 값 저장 -->
						<input type='text' name='korean' value='<%=kor%>'>
					</p>
				</td>
			</tr>
			<tr>
				<td width=200>
					<p align=center>영어</p>
				</td>
				<td width=300>
					<p align=center>
						<!-- 'english'이라는 이름에 불러온 파라미터 값 저장 -->
						<input type='text' name='english' value='<%=eng%>'>
					</p>
				</td>
			</tr>
			<tr>
				<td width=200>
					<p align=center>수학</p>
				</td>
				<td width=300>
					<p align=center>
						<!-- 'math'이라는 이름에 불러온 파라미터 값 저장 -->
						<input type='text' name='math' value='<%=mat%>'>
					</p>
				</td>
			</tr>
		</table>

		<%
			if (!studentid.equals("해당학번없음")) { // 만약 studentid가 "해당학번없음"이 아니라면 다음과 같은 버튼을 출력
				out.println("<tr>");
				out.println("<table cellspacing = 1 width = 400 border = 0>"); // table 열고 셀크기, 넓이, 테두리 스타일 지정
				out.println("<tr>");
				out.println(
				"<td width = 200><p align = center><input type = button value = \"수정\" style=\"width: 150px; height: 50px; font-size: 16px;\" onClick = \"submitForm('update')\"></p></td>");
				out.println(
				"<td width = 200><p align = center><input type = button value = \"삭제\" style=\"width: 150px; height: 50px; font-size: 16px;\" onClick = \"submitForm('delete')\"></p></td>");
				out.println("</tr>");
				out.println("</table>");
			}
		%>
	</form>
	<% } catch (Exception e) { 
                    out.println(e); 
                } %>
</body>
</html>
