package Java_0404;

public class Java_0404_08 {

	public static void main(String[] args) {
		// ���α׷����� �� �� �Ƴ��� �� ���� �������ΰ� ����
		// �������� .�� ������ �߰�
		
		for (int k23_i = 1; k23_i < 13; k23_i++) { // k23_i�� 1~12���� �ݺ� => ��
			System.out.printf(" %d�� =>", k23_i); // k23_i ���
			for (int k23_j= 1; k23_j < 32; k23_j++) { // k23_j�� 1~31���� �ݺ� => ��
				System.out.printf("%d,", k23_j - 1); // k23_j - 1������ ,�� ���

				if (k23_i == 1 && k23_j == 31) { // 1�� 31��
					System.out.printf("%d.", k23_j); // k23_j = 31 .�� ���
					break; // for�� Ż��
				}
				
				if (k23_i == 2 && k23_j == 28) { // 2�� 28��
					System.out.printf("%d.", k23_j); // k23_j = 28 .�� ���
					break; // for�� Ż��
				}
				
				if (k23_i == 3 && k23_j == 31) { // 3�� 31��
					System.out.printf("%d.", k23_j); // k23_j = 31 .�� ���
					break; // for�� Ż��
				}
				
				if (k23_i == 4 && k23_j == 30) { // 4�� 30��
					System.out.printf("%d.", k23_j); // j = 30 .�� ���
					break; // for�� Ż��
				}
				
				if (k23_i == 5 && k23_j == 31) { // 5�� 31��
					System.out.printf("%d.", k23_j); // k23_j = 31 .�� ���
					break; // for�� Ż��
				}
				 
				if (k23_i == 6 && k23_j == 30) { // 6�� 30��
					System.out.printf("%d.", k23_j); // k23_j = 30 .�� ���
					break; // for�� Ż��
				}
				 
				if (k23_i == 7 && k23_j == 31) { // 7�� 31��
					System.out.printf("%d.", k23_j); // k23_j = 31 .�� ���
					break; // for�� Ż��
				}
				
				if (k23_i == 8 && k23_j == 31) { // 8�� 31��
					System.out.printf("%d.", k23_j); // k23_j = 31 .�� ���
					break; // for�� Ż��
				}
				
				if (k23_i == 9 && k23_j == 30) { // 9�� 30��
					System.out.printf("%d.", k23_j); // k23_j = 30 .�� ���
					break; // for�� Ż��
				}
				
				if (k23_i == 10 && k23_j == 31) { // 10�� 31��
					System.out.printf("%d.", k23_j); // k23_j = 31 .�� ���
					break; // for�� Ż��
				}
				
				if (k23_i == 11 && k23_j == 30) { // 11�� 30��
					System.out.printf("%d.", k23_j); // k23_j = 30 .�� ���
					break; // for�� Ż��
				}
				
				if (k23_i == 12 && k23_j == 31) { // 12�� 31��
					System.out.printf("%d.", k23_j); // k23_j = 31 .�� ���
					break; // for�� Ż��
				}
			}
			System.out.printf("\n");

		}
	}
}
