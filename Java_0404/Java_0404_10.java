package Java_0404;

public class Java_0404_10 {

	public static void main(String[] args) {
		// ����
		// ���� �̷� ǥ���� ����
		for (int k23_i = 1; k23_i < 13; k23_i++) { // k23_i�� 1~12���� �ݺ�
			System.out.printf(" %d�� =>", k23_i); // k23_i ���
			LOOP: for (int k23_j = 1; k23_j < 32; k23_j++) { // k23_j�� 1~31���� �ݺ�
				System.out.printf("%d,", k23_j); // k23_j ���
				switch (k23_i) { // k23_i��
				case 4: // 4�� ��
				case 6: // 6�� ��
				case 9: // 9�� ��
				case 11: // 11�� ��
					if (k23_j == 30) { // k23_j�� 30�̸�
						break LOOP; // LOOP Ż��
					}
					break; // switch case Ż�� -> ������ 28�� ���� ���
				case 2: // 2�� ��
					if (k23_j == 28) { // k23_j�� 28�̸�
						break LOOP; // LOOP Ż��
					}
					break; // switch case Ż��
				}
			}
			System.out.printf("\n"); // ����
		}
	}
}