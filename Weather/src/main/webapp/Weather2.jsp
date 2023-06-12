<%@ page import="org.w3c.dom.Document"%>
<%@ page import="org.w3c.dom.Element"%>
<%@ page import="org.w3c.dom.NodeList"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="javax.xml.parsers.DocumentBuilder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Weather Forecast</title>
<style> /* 스타일 시트 정의 */
body {
	font-family: Arial, sans-serif;
	font-size: 10px;
	font-width: bold;
}

table {
	border-collapse: collapse;
	width: 100%;
	font-size: 12px; /* 변경: 테이블 폰트 사이즈를 16px로 설정 */
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

tr {
	/*background-color: #f0f8ff;*/
	text-align: center; /* 변경: 가운데 정렬 스타일 적용 */
}

table {
	background-image: url('cat.jpg');
	opacity: 0.95; /* 투명도 조절 (0.0 ~ 1.0 사이 값) */
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	background-color: rgba(0, 0, 0, 0.000001);
}

.topbar {
	background-color: #007bff;
	color: white;
	background-image: linear-gradient(to bottom, #007bff, #b5d9f8);
}

tr:hover {
	background-color: #b5d9f8;
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
		
		// XML 파싱을 위한 DocumentBuilder 생성
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		// URL에서 XML 문서 가져오기
		Document doc = docBuilder.parse("http://www.kma.go.kr/wid/queryDFS.jsp?gridx=61&gridy=123");
		
		Element root = doc.getDocumentElement();
		NodeList tag_001 = doc.getElementsByTagName("data");
		
		out.println("<table cellspacing=1 width=100% border=1>");
		out.println("<tr class=\"topbar\" style=\"font-weight: bold; color: #000000;\">");
		out.println("<td width=100>순서_48시 기준</td>");
		out.println("<td width=100>시간_03시간</td>");
		out.println("<td width=100>날짜</td>");
		out.println("<td width=100>온도</td>");
		out.println("<td width=100>최고온도</td>");
		out.println("<td width=100>최저온도</td>");
		out.println("<td width=100>하늘상태</td>");
		out.println("<td width=100>강수형태</td>");
		out.println("<td width=100>날씨_한국어</td>");
		out.println("<td width=100>날씨_영어</td>");
		out.println("<td width=100>강수확률</td>");
		out.println("<td width=100>강수량_12시간</td>");
		out.println("<td width=100>적설령_12시간</td>");
		out.println("<td width=100>풍속</td>");
		out.println("<td width=100>풍향</td>");
		out.println("<td width=100>풍향_한국어</td>");
		out.println("<td width=100>풍향_영어</td>");
		out.println("<td width=100>습도</td>");
		out.println("<td width=100>강수량_06시간</td>");
		out.println("<td width=100>적설량_06시간</td>");
		out.println("</tr>");
		
		
		
		for(int i=0; i<tag_001.getLength(); i++){
			Element elmt = (Element)tag_001.item(i);
			seq = tag_001.item(i).getAttributes().getNamedItem("seq").getNodeValue();
			hour = elmt.getElementsByTagName("hour").item(0).getFirstChild().getNodeValue();
			day = elmt.getElementsByTagName("day").item(0).getFirstChild().getNodeValue();
			if(day.equals("0")){
				day = "오늘";
			} else if(day.equals("1")){
				day = "내일";
			} else if(day.equals("2")){
				day = "모레";
			}
			temp = elmt.getElementsByTagName("temp").item(0).getFirstChild().getNodeValue();
			tmx = elmt.getElementsByTagName("tmx").item(0).getFirstChild().getNodeValue();
			tmn = elmt.getElementsByTagName("tmn").item(0).getFirstChild().getNodeValue();
			sky = elmt.getElementsByTagName("sky").item(0).getFirstChild().getNodeValue();
			pty = elmt.getElementsByTagName("pty").item(0).getFirstChild().getNodeValue();
			wfKor = elmt.getElementsByTagName("wfKor").item(0).getFirstChild().getNodeValue();
			wfEn = elmt.getElementsByTagName("wfEn").item(0).getFirstChild().getNodeValue();
			pop = elmt.getElementsByTagName("pop").item(0).getFirstChild().getNodeValue();
			r12 = elmt.getElementsByTagName("r12").item(0).getFirstChild().getNodeValue();
			s12 = elmt.getElementsByTagName("s12").item(0).getFirstChild().getNodeValue();
			ws = elmt.getElementsByTagName("ws").item(0).getFirstChild().getNodeValue();
			wd = elmt.getElementsByTagName("wd").item(0).getFirstChild().getNodeValue();
			if(wd.equals("0")){ // 북
				wd = "↑";
			} else if(wd.equals("1")){ // 북동
				wd = "↗️";
			} else if(wd.equals("2")){ // 동
				wd = "→";
			} else if(wd.equals("3")){ // 남동
				wd = "↘️";
			} else if(wd.equals("4")){ // 남
				wd = "↓";
			} else if(wd.equals("5")){ // 남서
				wd = " ↙️";
			} else if(wd.equals("6")){ // 서
				wd = "←";
			} else if(wd.equals("7")){ // 북서
				wd = "↖️";
			} 
			wdKor = elmt.getElementsByTagName("wdKor").item(0).getFirstChild().getNodeValue();
			wdEn = elmt.getElementsByTagName("wdEn").item(0).getFirstChild().getNodeValue();
			reh = elmt.getElementsByTagName("reh").item(0).getFirstChild().getNodeValue();
			r06 = elmt.getElementsByTagName("r06").item(0).getFirstChild().getNodeValue();
			s06 = elmt.getElementsByTagName("s06").item(0).getFirstChild().getNodeValue();
			
			out.println("<tr>");
			out.println("<td>" + seq + "</td>");
			out.println("<td>"+ hour + "시" + "</td>");
			out.println("<td>"+ day +"</td>");
			out.println("<td>"+ temp + "℃" + "</td>");
			out.println("<td>"+ tmx + "℃" + "</td>");
			out.println("<td>"+ tmn + "℃" + "</td>");
			 if (sky.equals("1")) {
		         out.println("<td><img src='sky1.png'></td>");
		      } else if (sky.equals("2")) {
		         out.println("<td><img src='sky2.png'></td>");
		      } else if (sky.equals("3")) {
		         out.println("<td><img src='sky3.png'></td>");
		      } else if (sky.equals("4")) {
		         out.println("<td><img src='sky4.png'></td>");
		      }
		
			 if (pty.equals("0")) {
		         out.println("<td><img src='w0.png'></td>");
		      } else if (pty.equals("1")) {
		         out.println("<td><img src='w1.png'></td>");
		      } else if (pty.equals("2")) {
		         out.println("<td><img src='w2.png'></td>");
		      } else if (pty.equals("3")) {
		         out.println("<td><img src='w3.png'></td>");
		      } else if (pty.equals("4")) {
			         out.println("<td><img src='w5.png'></td>");
			    }
			out.println("<td>"+ wfKor +"</td>");
			out.println("<td>"+ wfEn +"</td>");
			out.println("<td>"+ pop + "%" + "</td>");
			out.println("<td>"+ r12 + "mm" + "</td>");
			out.println("<td>"+ s12 + "cm" + "</td>");
			out.println("<td>"+ ws + "m/s" + "</td>");
			out.println("<td style=\"font-size: 25px;\">"+ wd + "</td>");
			out.println("<td>"+ wdKor + "풍" +"</td>");
			out.println("<td>"+ wdEn +"</td>");
			out.println("<td>"+ reh + "%" + "</td>");
			out.println("<td>"+ r06 + "mm" + "</td>");
			out.println("<td>"+ s06 + "cm" + "</td>");
			out.println("</tr>");
			
			
		}

	
	
	%>

</body>
</html>