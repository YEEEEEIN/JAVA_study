package Java_0404;

public class Java_0404_07 {

	public static void main(String[] args) {
		// ���� �־ ã��
		int k23_iVal; // ���� int ����
		for (int i = 0; i < 300; i++) { // i�� 0~299����
			k23_iVal = 5 * i; // 5 * i���� k23_iVal�� ����
			if (k23_iVal >= 0 && k23_iVal < 10) { // 0 <= k23_iVal <10 �̸�
				System.out.printf("�� %d\n", k23_iVal); // ���� ���
			} else if (k23_iVal >= 10 && k23_iVal < 100) { // 10 <= k23_iVal <100 �̸�
				System.out.printf("�� %d\n", k23_iVal); // ���� ���
			} else if (k23_iVal >= 100 && k23_iVal < 1000) { // 100 <= k23_iVal <1000 �̸�
				System.out.printf("�� %d\n", k23_iVal); // ���� ���
			} else { // k23_iVal >= 1000 �̸�
				System.out.printf("õ %d\n", k23_iVal); // ���� ���
			}
		}
	}
}
