package Java_0404;

public class Java_0404_09 {

	public static void main(String[] args) {
		for (int k23_i = 1; k23_i <13; k23_i++) { // k23_i�� 1~12���� �ݺ�
			System.out.printf(" %d�� =>", k23_i); // k23_i ���
			for (int k23_j= 1; k23_j < 32; k23_j++) { // k23_j�� 1~31���� �ݺ�
				System.out.printf("%d,", k23_j); // k23_j ���
				
				if(k23_i == 4 || k23_i == 6 || k23_i == 9 || k23_i == 7 || k23_i == 11) { // k23_i == 4, 6, 9, 7, 11 �� �ϳ� �̸鼭
					if (k23_j == 30) { // k23_j�� 30�� ��
						break; // for�� Ż��
					}
				}
				
				if(k23_i == 2) { // k23_i == 2 �� �ϳ� �̸鼭
					if (k23_j == 28) { // k23_j�� 28�� ��
						break; // for�� Ż��
					}
				}
			}
			System.out.printf("\n"); // ����
		}
	}
}
