package Java_230414;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class P09 {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// 1. DocumentBuilder 인스턴스 생성을 위한 준비
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		// 2. 파싱할 XML 파일 경로 설정 및 Document 인스턴스 생성
		Document doc = docBuilder.parse(new File("C:\\Users\\예인\\Desktop\\자바심화(v2023)-자바심화\\testdata.xml"));

		// 3. Document의 root 요소(Element)를 가져온다.
		Element root = doc.getDocumentElement();

		// 4. XML 파일에서 "name" 태그를 모두 가져와 NodeList에 담는다.
		NodeList tag_name = doc.getElementsByTagName("name");

		// 5. 각 과목 태그들도 NodeList에 담는다.
		NodeList tag_studentid = doc.getElementsByTagName("studentid"); // 학번을 담는다
		NodeList tag_kor = doc.getElementsByTagName("kor"); // 국어 점수를 담는다
		NodeList tag_eng = doc.getElementsByTagName("eng"); // 영어 점수를 담는다
		NodeList tag_mat = doc.getElementsByTagName("mat"); // 수학 점수를 담는다

		// 6. 출력을 위한 for 루프
		System.out.println("************************\n");
		for (int i = 0; i < tag_name.getLength(); i++) {
			System.out.printf("이름 : %s\n", tag_name.item(i).getFirstChild().getNodeValue()); // 이름 출력
			System.out.printf("학번 : %s\n", tag_studentid.item(i).getFirstChild().getNodeValue()); // 학번 출력
			System.out.printf("국어 : %s\n", tag_kor.item(i).getFirstChild().getNodeValue()); // 국어 점수 출력
			System.out.printf("영어 : %s\n", tag_eng.item(i).getFirstChild().getNodeValue()); // 영어 점수 출력
			System.out.printf("수학 : %s\n", tag_mat.item(i).getFirstChild().getNodeValue()); // 수학 점수 출력
			;
		}
		
	}

}
