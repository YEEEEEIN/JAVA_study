package Java_230404;

public class Java_0404_12 {

	public static void main(String[] args) {
		String[] k23_units = { "��", "��", "��", "��", "��", "��", "��", "ĥ", "��", "��" }; // ���� k23_units String �迭 ����, �ʱⰪ ����
		for (int k23_i = 0; k23_i < 101; k23_i++) { // k23_i�� 0~100���� �ݺ�

			if (k23_i >= 0 && k23_i < 10) { // k23_i 0~9����
				System.out.printf("�����ڸ� : %s\n", k23_units[k23_i]); // k23_units[k23_i] ���
			}

			else if (k23_i >= 10 && k23_i < 100) { // k23_i 10~99����
				int k23_i10, k23_i0; // k23_i10, k23_i0 ���� ����
				k23_i10 = k23_i / 10; // �����ڸ� ���� -> 10���ڸ� ��
				k23_i0 = k23_i % 10; // ������ -> 1���ڸ� ��
				
				if (k23_i0 == 0) { // 1���ڸ��� 0�̸�
					System.out.printf("�����ڸ� : %s��\n", k23_units[k23_i10]); // 10�� �ڸ� ���� ���
				} else { // 1���ڸ��� 0�� �ƴϸ�
					System.out.printf("�����ڸ� : %s��%s\n", k23_units[k23_i10], k23_units[k23_i0]); // 10�� �ڸ� ���� 1�� �ڸ� �� ���
				}
				
			} else { // �� �ܿ���
				System.out.printf("==> %d\n", k23_i); // ���� k23_i ���
			}
		}
	}
}
