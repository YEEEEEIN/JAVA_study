package Java_230412;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class P7 {

	public static void main(String[] args) throws IOException {
		// \�� Ư�������̹Ƿ� \\ �ΰ��� ����Ѵ�
		File k23_f = new File("C:\\Users\\����\\Desktop\\������\\���������������.csv"); // ���� ��� ����
		BufferedReader k23_br = new BufferedReader(new FileReader(k23_f));  // ���� �б� ���� BufferedWriter ��ü ����

		String k23_readtxt; // ���Ͽ��� �о�� ���ڿ��� ������ ����

		// �� ���� ���� �о�� �ʵ���� �� �� �ִ�
		if ((k23_readtxt = k23_br.readLine()) == null) { // ������ ����ִ� ��� => ���⼭ ó�� br.readLine()�� ����ȴ�
			System.out.printf("�� �����Դϴ�\n");
			return;
		}
		// �ʵ���� ��ǥ(,)�� �������� �и��Ͽ� �迭�� ����
		String[] k23_field_name = k23_readtxt.split(","); // csv������ ,�� �� ����
		
		int k23_LineCnt = 1; // ���� �� ���� ����
		while ((k23_readtxt = k23_br.readLine()) != null) { // ���� ������ �� �پ� ���� => �ι�° br.readLine()�� ����ȴ�
			String[] field = k23_readtxt.split(","); // ���� ������ �ʵ尪�� ��ǥ(,)�� �������� �и��Ͽ� �迭�� ����
			System.out.printf("**[%d��° �׸�]******************************\n", k23_LineCnt);
			for (int k23_j = 0; k23_j < k23_field_name.length; k23_j++) { // �ʵ��� �ʵ尪�� ���
				System.out.printf(" %s : %s\n", k23_field_name[k23_j], field[k23_j]); // 
			}
			System.out.println("*******************************************\n");
			if (k23_LineCnt == 100) // 100�� ������ ���
				break;
			k23_LineCnt++; // ���� �� ����
		}
		k23_br.close(); // ���� �ݱ�
	}

}
