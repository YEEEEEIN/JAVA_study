<%@page import="Domain.Vote"%>
<%@page import="Dao.VoteDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="Dao.VoteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>후보등록 A_01_H.jsp</title>
</head>
<body>
	<script>
		function confirmDelete() { // confirmDelete 함수 정의
			return confirm("삭제하시겠습니까?"); // 문구 출력
		}
		
		function submit1() { // submit1 함수 정의
			const form = document.getElementById('insert'); // HTML 문서에서 id 속성이 "insert"인 요소를 찾아와 해당 요소를 변수 form에 할당
			const name = form.elements.name.value; // 이름 필드 값 가져오기
			// const pattern1 = /^([a-zA-Z]|[가-힣])+$/; // 한글 또는 영어만 입력 가능한 패턴1
			const pattern1 = /^([a-zA-Z가-힣]+|[a-zA-Z0-9가-힣]+)$/; // 한글 또는 영어만 입력 가능한 패턴1, 한글, 영어, 숫자 조합도 입력 가능
			const pattern2 = /^(?:100|[1-9]?[0-9])$/; // 0부터 100 사이의 정수만 입력 가능한 패턴2

			if (name.trim() === '') { // 입력 창이 비어있으면
				alert("이름을 모두 입력해주세요."); // 해당 메세지 출력
				return; // 함수 실행 종료
			}

			if (!pattern1.test(name)) { // 이름에 유효한 한글 또는 영어가 입력되지 않으면
				alert("이름은 정확한 한글 또는 영어만 입력 가능합니다."); // 해당 메세지 출력
				return; // 함수 실행 종료
			}

			if (name.length > 20) { // 이름이 20자 이상이면
				alert("이름은 20자 이하만 입력 가능합니다."); // 해당 메세지 출력
				return; // 함수 실행 종료
			}

			form.action = "A_03_H.jsp"; // A_03_H.jsp로 제출할 위치 지정
			form.submit(); // 제출

		}
	</script>

	<table cellspacing="0" width="600" border="1" height="50"> <!-- table 열고 셀크기, 넓이, 테두리 스타일 지정 -->
		<tr>
			<td width=100 bgcolor="orange"><a href="A_01_H.jsp">후보등록</a></td> <!-- 후보등록에 스타일 지정, A_01_H.jsp로 가는 링크 생성 -->
			<td width=100><a href="B_01_H.jsp">투표</a></td>  <!-- 투표에 스타일 지정, B_01_H.jsp로 가는 링크 생성 -->
			<td width=100><a href="C_01_H.jsp">개표결과</a></td>  <!-- 개표결과에 스타일 지정, C_01_H.jsp로 가는 링크 생성 -->
		</tr> 
	</table>
	<h1>후보등록</h1>
	<table cellspacing=3 width=600 border=1> <!-- table 열고 셀크기, 넓이, 테두리 스타일 지정 -->
		<tr>
			<td><p align=center>후보명 입력</p></td> 
		</tr>
		<%
		VoteDao voteDao = new VoteDaoImpl(); // VoteDaoImpl 인터페이스의 구현 클래스의 인스턴스를 생성
		Vote vote = new Vote(); // Vote 객체 생성
		List<Vote> votes = voteDao.selectAll(); // voteDao 인스턴스의 selectAll() 메서드를 호출하여 Vote 객체의 리스트를 가져옵니다.
		int newKiho = voteDao.calNumber(); // 자동부여 기호를 계산한 값을 변수에 저장

		for (int i = 0; i < votes.size(); i++) { // votes 리스트의 사이즈 만큼 반복
			Vote vote1 = votes.get(i); // 객체 선언하여 리스트의 값들을 하나씩 가져옴

			out.println("<tr>"); // tr 열기 및 스타일 지정
			out.println("<td>"); // tr 열기 및 스타일 지정
			// 해당 코드는 HTML 폼을 생성하여 기호와 이름을 표시하고, 삭제 버튼을 제공하는 기능을 구현한 것
			// 폼 데이터는 A_02_H.jsp 페이지로 전송되며, 삭제 버튼을 클릭할 때 confirmDelete() 함수가 호출되어 삭제 여부를 확인ㄴ
			out.println(
			"<form method='post' action='A_02_H.jsp' onsubmit='return confirmDelete()'>기호:<input type='text' name='kiho' value="
					+ vote1.getKiho() + "  readonly> 이름 : <input type='text' name='name' value='" + vote1.getName()
					+ "' readonly> <input type='submit' value='삭제'>");
			out.println("</form>"); // tr 닫기
			out.println("</td>"); // tr 닫기
			out.println("</tr>"); // tr 닫기  
		}

		out.println("<tr>"); // tr 열기 및 스타일 지정
		out.println("<td>"); // tr 열기 및 스타일 지정
		// 해당 코드는 HTML 폼을 생성하여 새로운 후보의 기호와 이름을 입력받고, 추가 버튼을 제공하는 기능을 구현한 것
		// 기호는 읽기 전용으로 표시되며, 이름은 사용자가 입력할 수 있습니다. 추가 버튼을 클릭하면 submit1() 함수가 호출되어 폼 데이터를 처리
		out.println("<form method='post' id='insert'>기호:<input type='text' name='kiho' value=" + newKiho
				+ " readonly> 이름 : <input type='text' name='name' value=''> <input type='button' value='추가' onclick='submit1()'>");
		out.println("</form>"); // tr 닫기
		out.println("</td>"); // tr 닫기
		out.println("</tr>"); // tr 닫기
		%>


	</table>
</body>
</html>