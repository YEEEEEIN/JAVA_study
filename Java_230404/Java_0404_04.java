package Java_230404;

public class Java_0404_04 {

	public static void main(String[] args) {
		// while�� ������
		int k23_i = 2; // ���� k23_i int�� �����ϰ� 2 �ʱ�ȭ
		while (k23_i <= 9) { // k23_i<=9 while�� �ݺ�
			int k23_j = 1; // ���� k23_j int�� �����ϰ� 1 �ʱ�ȭ
			while (k23_j <= 9) { // k23_j<=9 while�� �ݺ�
				System.out.println(k23_i + " x " + k23_j + " = " + k23_i * k23_j); // ���
				k23_j++; // k23_j + 1
			}
			System.out.println(""); // �ٹٲ�
			k23_i++; // k23_i + 1
		}
	}
}
