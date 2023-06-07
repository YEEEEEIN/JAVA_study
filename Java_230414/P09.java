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
		// 1. DocumentBuilder �ν��Ͻ� ������ ���� �غ�
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		// 2. �Ľ��� XML ���� ��� ���� �� Document �ν��Ͻ� ����
		Document doc = docBuilder.parse(new File("C:\\Users\\����\\Desktop\\�ڹٽ�ȭ(v2023)-�ڹٽ�ȭ\\testdata.xml"));

		// 3. Document�� root ���(Element)�� �����´�.
		Element root = doc.getDocumentElement();

		// 4. XML ���Ͽ��� "name" �±׸� ��� ������ NodeList�� ��´�.
		NodeList tag_name = doc.getElementsByTagName("name");

		// 5. �� ���� �±׵鵵 NodeList�� ��´�.
		NodeList tag_studentid = doc.getElementsByTagName("studentid"); // �й��� ��´�
		NodeList tag_kor = doc.getElementsByTagName("kor"); // ���� ������ ��´�
		NodeList tag_eng = doc.getElementsByTagName("eng"); // ���� ������ ��´�
		NodeList tag_mat = doc.getElementsByTagName("mat"); // ���� ������ ��´�

		// 6. ����� ���� for ����
		System.out.println("************************\n");
		for (int i = 0; i < tag_name.getLength(); i++) {
			System.out.printf("�̸� : %s\n", tag_name.item(i).getFirstChild().getNodeValue()); // �̸� ���
			System.out.printf("�й� : %s\n", tag_studentid.item(i).getFirstChild().getNodeValue()); // �й� ���
			System.out.printf("���� : %s\n", tag_kor.item(i).getFirstChild().getNodeValue()); // ���� ���� ���
			System.out.printf("���� : %s\n", tag_eng.item(i).getFirstChild().getNodeValue()); // ���� ���� ���
			System.out.printf("���� : %s\n", tag_mat.item(i).getFirstChild().getNodeValue()); // ���� ���� ���
			;
		}
		
	}

}
