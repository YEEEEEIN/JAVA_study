package Java_230403;

public class Java_0403_02 {

	public static int k23_taxcal(int k23_val, int k23_rate) { // ���ڸ� int�� k23_val(���� ���� ��), int�� k23_rate(���� % ��)�� �޴´�
		int k23_ret; // int�� ����

		if (((double) k23_val * (double) k23_rate / 100.0) == k23_val * k23_rate / 100) { // double������ ���� ����� ���� �Ҽ��� ���� ������ ��������
			k23_ret = k23_val * k23_rate / 100; // int�� �� �״�� ���
		} else { // int���� �ٸ���
			k23_ret = k23_val * k23_rate / 100 + 1; // int�� ��+ 1�� ���
		}
		return k23_ret; // k23_ret ���� ��ȯ
	}

	public static void main(String[] args) {

		int k23_val = 271; // ���� ���� ��
		int k23_rate = 3; // ���� 3�ۼ�Ʈ

		int k23_tax = k23_taxcal(k23_val, k23_rate); // ���� k23_val, k23_rate�� �޾Ƽ� k23_taxcal �Լ� ���

		System.out.printf("*******************************************\n");
		System.out.printf("*             �ܼ� ���� ���             *\n");
		System.out.printf("*���� ���� ��� : %f\n", k23_val * k23_rate / 100.0); // double�� ���� ���� �ݾ� ���
		System.out.printf("*�������� : %d, ���� : %d, �����԰��� : %d\n", k23_val, k23_tax, k23_val + k23_tax); // ��������, ���ݰ���, ��������+���ݰ��� ���																					
		System.out.printf("*******************************************\n");

	}

}
