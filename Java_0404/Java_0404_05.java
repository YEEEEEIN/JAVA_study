package Java_0404;

public class Java_0404_05 {

	public static void main(String[] args) {
		// �����
		int k23_iA, k23_iB; // ���� k23_iA, k23_iB int�� ����

		k23_iA = 0; // k23_iA�� 0 ����
		while (true) {
			k23_iB = 0; // k23_iB�� 0 ����
			while (true) {
				System.out.print("*"); // k23_iA == k23_iB�� ���� ������ �����
				if (k23_iA == k23_iB) // k23_iA == k23_iB�̸�
					break; // �� �� while�� Ż��
				k23_iB++; // k23_iB + 1
			}
			System.out.print("\n"); // �ٹٲ�
			k23_iA++; // k23_iA + 1
			if (k23_iA == 30) // k23_iA == 30�̸�
				break; // �ٱ� �� while�� Ż�� => ����� ����
		}
	}
}
