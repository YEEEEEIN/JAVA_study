package Java_0404;

public class Java_0404_11 {

	public static void main(String[] args) {
		// ������ ��(���� �ָ���)�� �迭�� �̿��ϴ� �͵� �� ����̴�.
		
		int [] k23_iLMD = {31,28,31,30,31,30,31,31,30,31,30,31}; // ���� k23_iLMD int�� �迭 ����, �ʱ�ȭ
		// �� �迭�� 0���� �����Ѵٴ� �Ϳ� ����
		// iLMD[0] ~iLMD[11]
		
		for (int k23_i = 1; k23_i < 13; k23_i++) { // k23_i(��)�� 1~12���� �ݺ�
			System.out.printf(" %d�� =>", k23_i); // k23_i ���
			for (int k23_j = 1; k23_j < 32; k23_j++) { // k23_j(��)�� 1~31���� �ݺ�
				System.out.printf("%d", k23_j); // k23_j ���
				if(k23_iLMD[k23_i - 1] == k23_j) { // �迭�� ���� k23_j�� ������
					break; // ���� for�� Ż��
				}
				System.out.printf(","); // �������Ͽ� �޸� �����
			}
			System.out.printf("."); // �������Ͽ� �� ���
			System.out.printf("\n"); // ����
		}
	}
}
