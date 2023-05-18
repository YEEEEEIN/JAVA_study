package Java_0404;

public class Java_0404_15 {
	public static void main(String[] args) {
		// sin �׷����� �׷�����
		// 360�� : 2pi = 1�� : x
		// x = pi / 180 => 1 / 1����

		double k23_fSin; // ���� k23_fSin double�� ����

		for (int k23_i = 0; k23_i < 360; k23_i++) { // sin�� 0~360�ݺ��̱� ������
			k23_fSin = Math.sin(k23_i * 3.141592 / 180); // Math.sin �Լ��� ���� ���̿��Ͽ� sin �� ����
			System.out.printf("sin %d ==> %f\n", k23_i, k23_fSin); // ����, sin �� ���
		}

		// 360�� ���� �׸���
		for (int k23_i = 0; k23_i < 360; k23_i++) { // sin�� 0~360�ݺ��̱� ������
			k23_fSin = Math.sin(k23_i * 3.141592 / 180); // Math.sin �Լ��� ���� ���̿��Ͽ� sin �� ����

			// -k23_fSin���� -1 ~ 1 �̱� ������ ������ ����� ����� ���ؼ�
			// +1���� �Ͽ� 0 ~ 2 ������ �����
			int k23_iSpace = (int) ((1.0 - k23_fSin) * 50); // ������ ����� ���� �˳��ϰ� 50�� ������
			for (int k23_j = 0; k23_j < k23_iSpace; k23_j++) { // k23_j���� k23_j�� k23_iSpace(����) ��ŭ
				System.out.printf(" "); // ���� ���
			}
			System.out.printf("*[%f][%d]\n", k23_fSin, k23_iSpace); // ���� ��, ���� �� ���
		}

	}

}
