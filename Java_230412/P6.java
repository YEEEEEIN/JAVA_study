package Java_230412;

import java.io.BufferedReader; // �ؽ�Ʈ ������ �б� ���� BufferedReader Ŭ���� ����Ʈ
import java.io.BufferedWriter; // �ؽ�Ʈ ������ ���� ���� BufferedReader Ŭ���� ����Ʈ
import java.io.File; // ���� �ٷ�� ���� File Ŭ���� ����Ʈ
import java.io.FileReader; // ���� �б� ���� FileReader Ŭ���� ����Ʈ
import java.io.FileWriter; // ���� ���� ���� FileWriter Ŭ���� ����Ʈ
import java.io.IOException; // ����� ���� �� �߻��ϴ� �Ϲ����� ���ܸ� ó���ϴ� ���� Ŭ���� ����Ʈ

public class P6 {
	// ���� ����
	public static void FileWrite() throws IOException {
		File k23_f = new File("C:\\Users\\����\\Desktop\\������\\Mytest.txt"); // ���� ��� ����
		BufferedWriter k23_bw = new BufferedWriter(new FileWriter(k23_f)); // ���� ���� ���� BufferedWriter ��ü ����

		k23_bw.write("�ȳ� ����"); // �ؽ�Ʈ �Է�
		k23_bw.newLine(); // ����
		k23_bw.write("hello ���"); // �ؽ�Ʈ �Է�
		k23_bw.newLine(); // ����

		k23_bw.close(); // ���� �ݱ�
	}
	// ���� �б�
	public static void FileRead() throws IOException {
		File k23_f = new File("C:\\Users\\����\\Desktop\\������\\Mytest.txt"); // ���� ��� ����
		BufferedReader k23_br = new BufferedReader(new FileReader(k23_f)); // ���� �б� ���� BufferedReader ��ü ����

		String k23_readtxt; // ���Ͽ��� �о�� ���ڿ��� ������ ����

		while ((k23_readtxt = k23_br.readLine()) != null) { // ���Ͽ��� �о�� ���ڿ��� ������ ����
			System.out.printf("%s\n", k23_readtxt);
		}
		k23_br.close(); // ���� �ݱ�

	}

	public static void main(String[] args) throws IOException {
		FileWrite(); // ���� ���� �Լ� ���
		FileRead(); // ���� �б� �Լ� ���
	}

}
