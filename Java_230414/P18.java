package Java_230414;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class P18 {
	// �޼ҵ� oneRec ����
	public static JSONObject oneRec(String name, int studentid, int kor, int eng, int mat) {
		JSONObject dataObject = new JSONObject(); // JSON ��ü ����
		dataObject.put("name", name); // ������ �߰�
		dataObject.put("studentid", studentid); // ������ �߰�
		
		JSONArray score = new JSONArray(); // JSON �迭 ����
		score.add(kor); // ������ �߰�
		score.add(eng); // ������ �߰�
		score.add(mat); // ������ �߰�
		dataObject.put("score", score); // ������ �߰� 
		
		return dataObject; // JSON ��ü ��ȯ
	}

	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject(); // JSON ��ü ����

		JSONArray dataArray = new JSONArray(); // JSON �迭 ����

		JSONObject dataObject = new JSONObject(); // JSON ��ü ����

		dataObject.put("name", "����"); // ������ �߰�
		dataObject.put("studentid", "209901"); // ������ �߰�
		JSONArray score = new JSONArray();

		score.add(90); // ������ �߰�
		score.add(100); // ������ �߰�
		score.add(95); // ������ �߰�
		dataObject.put("score", score); // ������ �߰�
		dataArray.add(dataObject); // JSON �迭�� JSON ��ü �߰�
		
		// ����ϰ� �Լ� ó��
		dataArray.add(oneRec("����", 209902, 100, 85, 75)); // ������ �߰�
		dataArray.add(oneRec("���", 209903, 90, 75, 85)); // ������ �߰�
		dataArray.add(oneRec("�糪", 209904, 90, 85, 75)); // ������ �߰�
		dataArray.add(oneRec("��ȿ", 209905, 80, 75, 85)); // ������ �߰�
		dataArray.add(oneRec("�̳�", 209906, 90, 85, 55)); // ������ �߰�
		dataArray.add(oneRec("����", 209907, 70, 75, 65)); // ������ �߰�
		dataArray.add(oneRec("ä��", 209908, 100, 75, 95)); // ������ �߰�
		dataArray.add(oneRec("����", 209909, 80, 85, 95)); // ������ �߰�
		
		// ���� ���� �� ������ ����
		try {
			// ���Ͽ� ���� ���� FileWriter ��ü ���� �� ���� ��� ����
			FileWriter file = new FileWriter("C:\\Users\\����\\Desktop\\�ڹٽ�ȭ(v2023)-�ڹٽ�ȭ\\testdata2.json");
			file.write(dataArray.toJSONString()); // JSONArray ��ü�� JSON ���ڿ��� ��ȯ�Ͽ� ���Ͽ� ����
			file.flush(); // ���۸��� ���� ������ ���Ͽ� ����
			file.close(); // ���� ���� ����
		} catch (IOException e) { // ���� ó���� ���� try-catch ���
			e.printStackTrace(); // ���� �߻� �� ���� ���� ���
		}
		
		System.out.println("JSON ����� : " + dataArray); // JSON �迭 ���

	}


}