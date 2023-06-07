package Java_230412;

import java.io.File; // ���� �ٷ�� ���� File Ŭ���� ����Ʈ
import java.io.FileReader; // ���� �б� ���� FileReader Ŭ���� ����Ʈ
import java.io.FileWriter; // ���� ���� ���� FileWriter Ŭ���� ����Ʈ

public class P5 {

	public static void main(String[] args) {
		try { // ���� ó�� ����
			File k23_f = new File("C:\\Users\\����\\Desktop\\������\\text.txt"); // �Է��� ������ġ�� ������ �����ϴ� File Ŭ������ �ν��Ͻ��� f ����
			FileWriter k23_fw = new FileWriter(k23_f); // ������ ���� ���� FileWriter Ŭ������ �ν��Ͻ��� fw ����

			k23_fw.write("�ȳ� ����\n"); // ���Ͽ� "�ȳ� ����" ���ڿ� ����
			k23_fw.write("hello ���\n"); // ���Ͽ� "�ȳ� ����" ���ڿ� ����

			k23_fw.close(); // ���� ���� ����

			FileReader k23_fr = new FileReader(k23_f); // ������ �б� ���� FileReader Ŭ������ �ν��Ͻ��� fr ����

			int k23_n = -1; // ���ڸ� �о���� �� ����� ���� n�� -1�� �ʱ�ȭ
			char[] k23_ch; // ���ڿ��� ������ char�� �迭 ch ����

			while (true) {
				k23_ch = new char[100]; // ���� �ְ� ���� 100���� �Ҵ�
				k23_n = k23_fr.read(k23_ch); // ���Ͽ��� �ִ� ch.length��ŭ�� ���ڿ��� �о���̰�, ������ �о���� ������ ������ n�� ����

				if (k23_n == -1)
					break; // �о���� ������ ������ -1�̸� ���� �б� ����

				for (int k23_i = 0; k23_i < k23_n; k23_i++) { // �о���� ������ ������ŭ �ݺ��� ����
					// for(char c : ch){
					System.out.printf("%c", k23_ch[k23_i]); // �о���� ���ڿ��� ���
				}
			}
			k23_fr.close();// �о���� ���ڿ��� ���
			System.out.printf("\n FILE READ END ");// �о���� ���ڿ��� ���
		} catch (Exception k23_e) {// �о���� ���ڿ��� ���
			System.out.printf("�� ����[%s]\n", k23_e); // ���� �޽��� ���
		}
	}
}
