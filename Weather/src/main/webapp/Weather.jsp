<%@ page import="org.w3c.dom.Document" %> 
<%@ page import="org.w3c.dom.Element" %>
<%@ page import="org.w3c.dom.NodeList" %>
<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="javax.xml.parsers.DocumentBuilder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Weather Forecast</title>
<style>
body {
  font-family: Arial, sans-serif; /* Arial 또는 sans-serif 글꼴을 사용합니다. */
  font-size: 12px; /* 글꼴 크기는 12px로 설정합니다. */
}

table {
  border-collapse: collapse; /* 테이블 경계를 합칩니다. */
  width: 100%; /* 테이블의 너비는 100%입니다. */
  font-size: 14px; /* 글꼴 크기는 14px로 설정합니다. */
}

th, td {
  padding: 8px; /* 셀 안의 여백(padding)을 8px로 설정합니다. */
  text-align: left; /* 셀 내용을 왼쪽에 정렬합니다. */
  border-bottom: 1px solid #ddd; /* 아래쪽 테두리를 1px 두께의 회색(#ddd)으로 설정합니다. */
}

th {
  background-color: #f2f2f2; /* th 요소의 배경색을 연한 회색(#f2f2f2)으로 설정합니다. */
}

tr {
  text-align: center; /* 행 내용을 가운데로 정렬합니다. */
}

.topbar {
  background-color: #007bff; /* 배경색을 파란색(#007bff)으로 설정합니다. */
  color: white; /* 글자색을 흰색으로 설정합니다. */
  background-image: linear-gradient(to bottom, #007bff, #b5d9f8); /* 그라디언트 배경 이미지를 적용합니다. */
}

tr:hover {
  background-color: #b5d9f8; /* 마우스를 올렸을 때 행의 배경색을 연한 파란색(#b5d9f8)으로 변경합니다. */
}

img.weather-icon {
  height: 25px; /* 날씨 아이콘 이미지의 높이를 25px로 설정합니다. */
  vertical-align: middle; /* 수직 정렬을 가운데로 설정합니다. */
}

img.wind-icon {
  height: 25px; /* 바람 아이콘 이미지의 높이를 25px로 설정합니다. */
  transform: rotateZ(90deg); /* 아이콘을 90도 회전시킵니다. */
  vertical-align: middle; /* 수직 정렬을 가운데로 설정합니다. */
}

.wind-direction {
  font-size: 18px; /* 바람 방향 텍스트의 글꼴 크기를 18px로 설정합니다. */
}

tr.today {
  background-color: lightblue; /* 오늘 행의 배경색을 연한 파란색(lightblue)으로 설정합니다. */
}

tr.tomorrow {
  background-color: lightgreen; /* 내일 행의 배경색을 연한 녹색(lightgreen)으로 설정합니다. */
}

tr.dayafter {
  background-color: lightyellow; /* 모레 행의 배경색을 연한 노란색(lightyellow)으로 설정합니다. */
}

</style>
</head>
	<body>
	<%
	  String seq = ""; // 48시간 중 순서
	  String hour = ""; // 시간_03시간
	  String day = ""; // 날짜
	  String temp = ""; // 온도
	  String tmx = ""; // 최고온도
	  String tmn = ""; // 최저온도
	  String sky = ""; // 하늘상태
	  String pty = ""; // 강수상태
	  String wfKor = ""; // 날씨_한국어
	  String wfEn = ""; // 날씨_영어
	  String pop = ""; // 강수확률
	  String r12 = ""; // 강수량_12시간
	  String s12 = ""; // 적설령_12시간
	  String ws = ""; // 풍속
	  String wd = ""; // 풍향
	  String wdKor = ""; // 풍향_한국어
	  String wdEn = ""; // 풍향_영어
	  String reh = ""; // 습도
	  String r06 = ""; // 강수량_06시간
	  String s06 = ""; // 적설량_06시간
	  
	  // DocumentBuilder를 사용하여 DocumentBuilderFactory를 생성합니다. 이 객체는 XML 문서를 파싱하는 데 사용됩니다.
	  DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	  // DocumentBuilder를 사용하여 지정된 URL(http://www.kma.go.kr/wid/queryDFS.jsp?gridx=61&gridy=123)에서 XML 문서를 가져와 Document 객체로 파싱합니다.
	  Document doc = docBuilder.parse("http://www.kma.go.kr/wid/queryDFS.jsp?gridx=61&gridy=123");
	  
	  //Document 객체에서 루트 엘리먼트를 가져옵니다.
	  Element root = doc.getDocumentElement();
	  // getElementsByTagName 메서드를 사용하여 "data" 태그를 가진 엘리먼트들을 가져와 NodeList에 저장합니다
	  NodeList tag_001 = doc.getElementsByTagName("data");
	  
	  out.println("<table cellspacing=1 width=100% border=1>");
	  out.println("<tr class=\"topbar\" style=\"font-weight: bold; color: #000000;\">");
	  out.println("<td width=100>순서_48시 기준</td>"); // 48시간 기준 순서
	  out.println("<td width=100>시간_03시간</td>"); // 3시간 단위 시간
	  out.println("<td width=100>날짜</td>"); // 날짜
	  out.println("<td width=100>온도</td>"); // 기온
	  out.println("<td width=100>최고온도</td>"); // 최고 기온
	  out.println("<td width=100>최저온도</td>"); // 최저 기온
	  out.println("<td width=100>하늘상태</td>"); // 하늘 상태
	  out.println("<td width=100>강수형태</td>"); // 강수 형태
	  out.println("<td width=100>날씨_한국어</td>"); // 날씨 (한국어)
	  out.println("<td width=100>날씨_영어</td>"); // 날씨 (영어)
	  out.println("<td width=100>강수확률</td>"); // 강수 확률
	  out.println("<td width=100>강수량_12시간</td>"); // 12시간 강수량
	  out.println("<td width=100>적설량_12시간</td>"); // 12시간 적설량
	  out.println("<td width=100>풍속</td>"); // 풍속
	  out.println("<td width=100>풍향</td>"); // 풍향
	  out.println("<td width=100>풍향_한국어</td>"); // 풍향 (한국어)
	  out.println("<td width=100>풍향_영어</td>"); // 풍향 (영어)
	  out.println("<td width=100>습도</td>"); // 습도
	  out.println("<td width=100>강수량_06시간</td>"); // 06시간 강수량
	  out.println("<td width=100>적설량_06시간</td>"); // 06시간 적설량
	  out.println("</tr>");
	  
	  for (int i = 0; i < tag_001.getLength(); i++) { // tag_001의 길이만큼 반복
		    Element elmt = (Element) tag_001.item(i);
		    seq = tag_001.item(i).getAttributes().getNamedItem("seq").getNodeValue(); // 순서
		    hour = elmt.getElementsByTagName("hour").item(0).getFirstChild().getNodeValue(); // 시간
		    day = elmt.getElementsByTagName("day").item(0).getFirstChild().getNodeValue(); // 날짜
		    if (day.equals("0")) {
		        day = "오늘";
		    } else if (day.equals("1")) {
		        day = "내일";
		    } else if (day.equals("2")) {
		        day = "모레";
		    }
		    temp = elmt.getElementsByTagName("temp").item(0).getFirstChild().getNodeValue(); // 온도
		    tmx = elmt.getElementsByTagName("tmx").item(0).getFirstChild().getNodeValue(); // 최고 기온
		    tmn = elmt.getElementsByTagName("tmn").item(0).getFirstChild().getNodeValue(); // 최저 기온
		    sky = elmt.getElementsByTagName("sky").item(0).getFirstChild().getNodeValue(); // 하늘 상태
		    pty = elmt.getElementsByTagName("pty").item(0).getFirstChild().getNodeValue(); // 강수 형태
		    wfKor = elmt.getElementsByTagName("wfKor").item(0).getFirstChild().getNodeValue(); // 날씨 (한국어)
		    wfEn = elmt.getElementsByTagName("wfEn").item(0).getFirstChild().getNodeValue(); // 날씨 (영어)
		    pop = elmt.getElementsByTagName("pop").item(0).getFirstChild().getNodeValue(); // 강수 확률
		    r12 = elmt.getElementsByTagName("r12").item(0).getFirstChild().getNodeValue(); // 12시간 강수량
		    s12 = elmt.getElementsByTagName("s12").item(0).getFirstChild().getNodeValue(); // 12시간 적설량
		    ws = elmt.getElementsByTagName("ws").item(0).getFirstChild().getNodeValue(); // 풍속
		    wd = elmt.getElementsByTagName("wd").item(0).getFirstChild().getNodeValue(); // 풍향
		    if (wd.equals("0")) { // 북
		        wd = "↑";
		    } else if (wd.equals("1")) { // 북동
		        wd = "↗️";
		    } else if (wd.equals("2")) { // 동
		        wd = "→";
		    } else if (wd.equals("3")) { // 남동
		        wd = "↘️";
		    } else if (wd.equals("4")) { // 남
		        wd = "↓";
		    } else if (wd.equals("5")) { // 남서
		        wd = " ↙️";
		    } else if (wd.equals("6")) { // 서
		        wd = "←";
		    } else if (wd.equals("7")) { // 북서
		        wd = "↖️";
		    }
		    wdKor = elmt.getElementsByTagName("wdKor").item(0).getFirstChild().getNodeValue(); // 풍향 (한국어)
		    wdEn = elmt.getElementsByTagName("wdEn").item(0).getFirstChild().getNodeValue(); // 풍향 (영어)
		    reh = elmt.getElementsByTagName("reh").item(0).getFirstChild().getNodeValue(); // 습도
		    r06 = elmt.getElementsByTagName("r06").item(0).getFirstChild().getNodeValue(); // 06시간 강수량
		    s06 = elmt.getElementsByTagName("s06").item(0).getFirstChild().getNodeValue(); // 06시간 적설량
		    
		    // 오늘/내일/모레 별로 구분하기 위해 trClass에 다음 대입
		    String trClass = "";
		    if(day.equals("오늘")) {
		      trClass = "today";
		    } else if(day.equals("내일")) {
		      trClass = "tomorrow";
		    } else if(day.equals("모레")) {
		      trClass = "dayafter";
		    }
		    
		    // 각 행의 자료 출력
		    out.println("<tr class=\"" + trClass + "\">"); // 클래스별 css 
		    out.println("<td>" + seq + "</td>");
		    out.println("<td>"+ hour + "시" + "</td>");
		    out.println("<td>"+ day +"</td>");
		    out.println("<td>"+ temp + "℃" + "</td>");
		    out.println("<td>"+ tmx + "℃" + "</td>");
		    out.println("<td>"+ tmn + "℃" + "</td>");
		    
		    // 하늘 날씨 정보에 때라 다음 이미지 ㅊㄹ력
		    if (sky.equals("1")) {
		      out.println("<td><img src='sky1.png' alt='Sky1' class='weather-icon'></td>");
		    } else if (sky.equals("2")) {
		      out.println("<td><img src='sky2.png' alt='Sky2' class='weather-icon'></td>");
		    } else if (sky.equals("3")) {
		      out.println("<td><img src='sky3.png' alt='Sky3' class='weather-icon'></td>");
		    } else if (sky.equals("4")) {
		      out.println("<td><img src='sky4.png' alt='Sky4' class='weather-icon'></td>");
		    }
		    
		    // 바람 방향에 따라 다음 이미지 파일 출력
		    if (pty.equals("0")) {
		      out.println("<td><img src='w0.png' alt='W0' class='weather-icon'></td>");
		    } else if (pty.equals("1")) {
		      out.println("<td><img src='w1.png' alt='W1' class='weather-icon'></td>");
		    } else if (pty.equals("2")) {
		      out.println("<td><img src='w2.png' alt='W2' class='weather-icon'></td>");
		    } else if (pty.equals("3")) {
		      out.println("<td><img src='w3.png' alt='W3' class='weather-icon'></td>");
		    } else if (pty.equals("4")) {
		      out.println("<td><img src='w4.png' alt='W4' class='weather-icon'></td>");
		    }
		    
		    // 출력
		    out.println("<td>"+ wfKor +"</td>");
		    out.println("<td>"+ wfEn +"</td>");
		    out.println("<td>"+ pop + "</td>");
		    out.println("<td>"+ r12 + "</td>");
		    out.println("<td>"+ s12 + "</td>");
		    out.println("<td>"+ ws + "</td>");
		    out.println("<td>"+ wd +"</span></td>");
		    out.println("<td>"+ wdKor +"</td>");
		    out.println("<td>"+ wdEn +"</td>");
		    out.println("<td>"+ reh + "</td>");
		    out.println("<td>"+ r06 + "</td>");
		    out.println("<td>"+ s06 + "</td>");
		    out.println("</tr>");
		 	}
		  
		 out.println("</table>"); // 테이블 닫기
	%>
	</body>
</html>
