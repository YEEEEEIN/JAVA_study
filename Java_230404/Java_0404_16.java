package Java_230404;

public class Java_0404_16 {

	public static void main(String[] args) {
		int K23_n, K23_m; // n, m ���� int�� ����

		K23_m = 20; // m�� 20 ����
		K23_n = 1; // n�� 1 ����

		while (true) { // while �ݺ���
			for (int K23_i = 0; K23_i < K23_m; K23_i++) { // i�� 0���� m-1���� �ݺ�
				System.out.printf(" "); // ��ĭ ���
			}
			for (int K23_i = 0; K23_i < K23_n; K23_i++) { // i�� 0���� n-1���� �ݺ�
				System.out.printf("*"); // �� ���
			}
			System.out.printf("\n"); // �� �ٲ�
			K23_m = K23_m - 1; // ������ ��ĭ�� ������ 1���� �پ��� ������
			K23_n = K23_n + 2; // ���� ������ 2���� �þ�� ������

			if (K23_m < 0) { // m < 0 �� ��
				break; // while�� Ż��
			}
		}
	}
}
