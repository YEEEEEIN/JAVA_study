package Java_230404;

public class Java_0404_03 {

	public static void main(String[] args) {
		int k23_sum = 0; // ���� k23_sum int�� �����ϰ� 0���� �ʱ�ȭ
		for (int k23_i = 0; k23_i < 10; k23_i++) { // k23_i�� 0���� 10 ������ i�� 1�� ����
			k23_sum = k23_sum + k23_i; // k23_sum + k23_i�� k23_sum�� ���� (����)
		}
		System.out.printf("k23_sum %d\n", k23_sum); // k23_sum ���
		
		// for�� ������
		for (int k23_i = 1; k23_i < 10; k23_i++) { // k23_i�� 1���� 10 ������ k23_i�� 1�� ����
			System.out.printf("******************\n"); // ���
			System.out.printf("������ %d ��\n", k23_i); // k23_i ���
			System.out.printf("******************\n"); // ���
			for (int k23_j = 1; k23_j < 10; k23_j++) { // k23_j�� 1���� 10 ������ k23_i�� 1�� ����
				System.out.printf(" %d x %d = %d \n", k23_i, k23_j, k23_i * k23_j); // k23_i, k23_j, k23_i * k23_j ���
			}
		}
	}
}
