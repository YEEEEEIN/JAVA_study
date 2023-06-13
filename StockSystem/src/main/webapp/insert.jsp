<%@page import="Domain.Stock"%>
<%@page import="Dao.StockDaoImpl"%>
<%@page import="Dao.StockDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>

	
	
	<script language="JavaScript">
	
	   function showPreview(event) { // event를 매개변수로 받는 함수 선언
		   var file = event.target.files[0];
		   var fileName = file.name;
		   var fileExtension = fileName.split('.').pop().toLowerCase();
		   
		   // 허용할 이미지 파일 확장자 목록
		   var allowedExtensions = ['jpg', 'jpeg', 'png', 'gif'];
		   
		   // 허용된 확장자인지 확인
		   if (!allowedExtensions.includes(fileExtension)) {
		       alert('이미지 파일만 업로드할 수 있습니다.');
		       event.target.value = ''; // 파일 선택 창 초기화
		       return;
		   }
		    
	        var reader = new FileReader(); // FileReader 객체 생성 (파일 내용 읽음)
	        reader.onload = function() { // 이벤트 핸들러 정의 (파일 읽기 완료시 실행)
	        var imgElement = document.getElementById('preview'); // preview id를 가진 이미지 엘리먼트 가져옴
	        imgElement.src = reader.result; // 파일 내용 읽어온 후 이미지엘리먼트 src에 설정
	        };
	        reader.readAsDataURL(event.target.files[0]); // 선택한 파일을 data url 형식으로 읽어옴
		}
	   
		function submitForm() {
 			const id = fm.elements.id.value; // 상품번호 필드 값 가져오기
			const name = fm.elements.name.value; // 제목 필드 값 가져오기
			const amount = fm.elements.amount.value; // 재고현황 필드 값 가져오기
			const content = fm.elements.content.value; // 상품설명 필드 값 가져오기
			const photo = fm.elements.photo.value; // 상품사잔 필드 값 가져오기 => 없어도 될듯 
	
			if (id.trim() === '' || name.trim() === '' || amount.trim() === '' || content.trim() === '') { // 입력 창이 비어있으면
				alert("데이터를 모두 입력해주세요. (상품사진은 선택)"); // 해당 메세지 출력
				return; // 함수 실행 종료
			}
			
			if (id.length > 15) { // 이름이 20자 이상이면
				alert("상품번호은 15자 이하만 입력 가능합니다."); // 해당 메세지 출력
				return; // 함수 실행 종료
			}
			
			if (name.length > 20) { // 이름이 20자 이상이면
				alert("상품명은 20자 이하만 입력 가능합니다."); // 해당 메세지 출력
				return; // 함수 실행 종료
			}
			
			// 정규식을 사용하여 한글 자음 또는 모음이 단독으로 입력되었는지 확인합니다.
		    const koreanPattern = /^[ㄱ-ㅎㅏ-ㅣ]+$/;
		    if (koreanPattern.test(name)) {
		        alert("한글 자음 또는 모음은 단독으로 입력할 수 없습니다."); // 해당 메세지 출력
		        return; // 함수 실행 종료
		    }
		    
		 	// 정규식을 사용하여 0부터 10,000 이하의 정수인지 확인합니다.
		    const numberPattern2 = /^[0-9]{1,5}$/;
		    if (!numberPattern2.test(amount) || amount < 0 || amount > 10000) {
		        alert("재고현황은 0부터 10,000 이하의 정수만 입력 가능합니다."); // 해당 메세지 출력
		        return; // 함수 실행 종료
		    }

			
			fm.action = "write.jsp?key=INSERT";
			fm.submit();
		}
	</script>
</head>
<body>
	<%
	java.sql.Date date = new java.sql.Date(System.currentTimeMillis()); // 현재 시간을 가져와서 변수 date에 저장합니다.
	
	%>
	<!-- enctype="multipart/form-data": 폼 데이터에 파일 업로드가 포함되어 있을 경우, 데이터 전송 방식을 설정 -->
	<form method="post" name='fm' enctype="multipart/form-data">
		<table width=800 border=1 cellspacing=0 cellpadding=5>
			<tr>
				<td><b>상품 번호</b></td> <!-- 상품 번호 입력란 -->
				<td><input type=text name=id size=66 maxlength=20></td>
			</tr>
			<tr>
				<td><b>상품명</b></td> <!-- 상품명 입력란 -->
				<td><input type=text name=name size=66 maxlength=50></td>
			</tr>
			<tr>
				<td><b>재고현황</b></td> <!-- 재고현황 입력란 -->
				<td><input type=text name=amount size=66 maxlength=10></td>
			</tr>
			<tr>
				<td><b>상품등록일</b></td> <!-- 상품 등록일 -->
				<td><%=date%></td>
			</tr>
			<tr>
				<td><b>재고등록일</b></td> <!-- 재고 등록일 -->
				<td><%=date%></td>
			</tr>
			<tr>
				<td><b>상품설명</b></td> <!-- 상품 설명 입력란 -->
				 <td><textarea style='width: 500px; height: 250px; resize: none; overflow: auto;' name="content" rows="10" cols="50" style="resize: none; overflow: auto"></textarea></td>
			</tr>
			<tr>
				<td><b>상품사진</b></td> <!-- 상품 사진 업로드 -->
				<td><input type="file" name="photo" onchange="showPreview(event)"> <img id="preview" src="#" alt="" style="max-width: 300px;"></td>
			</tr>
		</table>
		
		<table width=800>
			<tr>
				<td width=500></td>
				<td><input type=button value="상품등록 취소"
					OnClick="location.href='list.jsp'"></td>
				<td><input type=button value="상품등록 완료"
					OnClick="submitForm()"></td>
			</tr>
		</table>
	</form>
</body>

</html>