package Java_230412;

import java.io.BufferedReader; // BufferedReader ����Ʈ 
import java.io.File; // File ����Ʈ
import java.io.FileReader; // FileReader ����Ʈ
import java.io.IOException; // IOException ����Ʈ

public class P8_1 {
	
	public static void main(String[] args) throws IOException {
		// ���� ��� ����
		File k23_f = new File("C:\\Users\\����\\Desktop\\������\\���������������.txt");
		// ������ �о���̱� ���� BufferedReader ��ü ����
		BufferedReader k23_br = new BufferedReader(new FileReader(k23_f));

		String k23_readtxt;

		// ������ ����ִ� ��� ����ó��
		if ((k23_readtxt = k23_br.readLine()) == null) {
			System.out.printf("�� �����Դϴ�\n");
			return;
		}

		// ������ ù��° �ٿ��� �ʵ���� �о��
		String[] k23_field_name = k23_readtxt.split("\t"); // tap�� txt����

		// ���� ��ġ(����, �浵) ����
		double k23_lat = 37.3860521;
		double k23_lng = 127.1214038;

		// ������ �����͸� �� �پ� �о�ͼ� ó��
		int k23_LineCnt = 0;
		while ((k23_readtxt = k23_br.readLine()) != null) {
			// ���� �����ڷ� �� �ʵ庰�� ������ �迭�� ����
			String[] k23_field = k23_readtxt.split("\t");

			// ���� ������ ��ȣ ���
			System.out.printf("**[%d]��° �׸�*******************\n", k23_LineCnt);
			// �ʵ��� �� ���
			System.out.printf(" %s : %s\n", k23_field_name[10], k23_field[10]); // 9��: �����ּ�
			System.out.printf(" %s : %s\n", k23_field_name[13], k23_field[13]); // 12��: �����ּ�
			System.out.printf(" %s : %s\n", k23_field_name[14], k23_field[14]); // 13��: �浵�ּ�

			// ���� ��ġ�� �ش� ��ġ�� �Ÿ� ���
			double dist = Math.sqrt(Math.pow(Double.parseDouble(k23_field[13]) - k23_lat, 2)
					+ Math.pow(Double.parseDouble(k23_field[14]) - k23_lng, 2));
			System.out.printf(" ���������� �Ÿ� : %f\n", dist); // 13��: �浵 �ּ�
			System.out.printf("********************************\n");

			k23_LineCnt++;
		}

		// BufferedReader ��ü �ݱ�
		k23_br.close();
	}
}
