<%@page import="Domain.Stock"%>
<%@page import="Dao.StockDaoImpl"%>
<%@page import="Dao.StockDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
	<%	
	// Allview 페이지에서 전달된 파라미터 key 값을 받아옵니다.
	String ckey = request.getParameter("key");

	// StockDaoImpl 객체와 StockDao 인터페이스를 import합니다.
	StockDao stockDao = new StockDaoImpl();
	// stockDao.selectOne(ckey) 메서드를 호출하여 해당 키에 해당하는 Stock 객체를 조회합니다.
	Stock stock = stockDao.selectOne(ckey);

	// Stock 객체에서 필요한 데이터를 변수에 저장합니다.
	String name = stock.getName();
	int amount = stock.getAmount();
	String regDate = stock.getRegDate();
	String checkDate = stock.getCheckDate();
	String content = stock.getContent();
	String photo = stock.getPhoto();
	%>

	<script language="JavaScript">
	function submitForm(mode) {
		if (mode == "update") {
			const amount = fm.elements.amount.value; // 이름 필드 값 가져오기
			
			if (amount.trim() === '') { // 입력 창이 비어있으면
				alert("수량을 입력해주세요."); // 해당 메세지 출력
				return; // 함수 실행 종료
			}
			
			// 정규식을 사용하여 0부터 10000 이하의 정수인지 확인합니다.
		    const numberPattern = /^[0-9]{1,5}$/;
		    if (!numberPattern.test(amount) || amount < 0 || amount > 10000) {
		        alert("재고현황은 0부터 10000 이하의 정수만 입력 가능합니다."); // 해당 메세지 출력
		        return; // 함수 실행 종료
		    }

			fm.action = "write.jsp?key=UPDATE";
			fm.submit();

		} else if (mode == "delete") {
			var confirmDelete = confirm("정말 삭제하시겠습니까?"); // 해당 메세지 출력
			if (confirmDelete) {
				fm.action = "delete.jsp?key=<%=ckey%>"; // '예'를 선택한 경우의 동작
			} else {
				retrun; // '아니오'를 선택한 경우의 동작
			}
		}
		
		fm.submit();
	}
	</script>
	
</head>
<body>
	<%
	java.sql.Date date = new java.sql.Date(System.currentTimeMillis()); // 현재 시간 출력
	
	%>
	
	<form method="post" name="fm">
	<!-- 상품 정보를 표시하는 테이블 -->
	<table width="800" border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td width="200"><b>상품 번호</b></td>
			<td width="600"><input type="text" name="id" size="66" value="<%=ckey%>" readonly></td>
		</tr>
		
		<tr>
			<td><b>상품명</b></td>
			<td><%=name.replaceAll("<", "&lt;").replaceAll(">", "&gt;")%></td>
		</tr>
		<tr>
			<td><b>재고현황</b></td>
			<td><input type="text" name="amount" size="66" maxlength="70" value="<%=amount%>"></td>
		</tr>
		<tr>
			<td><b>상품등록일</b></td>
			<td><%=regDate%></td>
		</tr>
		<tr>
			<td><b>재고파악일</b></td>
			<td><%=date%></td>
		</tr>
		<tr>
			<td><b>상품설명</b></td>
			<td><textarea style="width: 500px; resize: none; overflow: auto;" name="content" cols="60" rows="10" readonly><%=content%></textarea>
		</tr>
		<tr>
			<td><b>상품사진</b></td>
			<td><%=photo%></td>
		</tr>
	</table>

	<!-- 버튼을 포함한 하단 테이블 -->
	<table width="800">
		<tr>
			<td width="500"></td>
			<td><input type="button" value="목록" onClick="location.href='list.jsp'"></td>
			<td><input type="button" value="상품삭제" onClick="submitForm('delete')"></td>		
			<td><input type="button" value="재고수정" onClick="submitForm('update')"></td>
		</tr>
	</table>
</form>

</body>
</html>