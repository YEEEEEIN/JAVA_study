package Java_230404;

public class Java_0404_06 {

	public static void main(String[] args) {
		int k23_iI; // ���� k23_iI int�� ����
		double k23_iD; // ���� k23_iD double �� ����

		k23_iI = 10 / 3; // 10/3�� �� k23_iI�� ����
		k23_iD = 10 / 3.0; // 10 / 3.0�� �� k23_iD�� ����

		// int�� double�� ������ ����� �Ǽ��� �����̴�
		if (k23_iI == k23_iD) { // k23_iI == k23_iD�̶��
			System.out.printf("equal\n"); // ���
		} else { // k23_iI != k23_iD
			System.out.printf("Not equal[%f][%f]\n", (double) k23_iI, k23_iD); // (double) k23_iI , k23_iD ���
		}

		// ���� ��ȿ���ڱ��� ǥ�õ� �� ������ �ٸ���
		if (k23_iD == 3.333333) { // k23_iD == 3.333333�̸�
			System.out.printf("equal\n"); // ���
		} else { // k23_iD != 3.333333
			System.out.printf("Not equal[3.333333][%f]\n", k23_iD); // k23_iD ���
		}

		k23_iD = (int) k23_iD; // ���� k23_iD int������ ����ȯ, k23_iD = 3
		if (k23_iI == k23_iD) { // k23_iI == k23_iD���
			System.out.printf("equal\n"); // ���
		} else { // k23_iI != k23_iD
			System.out.printf("Not equal[%f][%f]\n", (double) k23_iI, k23_iD); // (double) k23_iI, k23_iD ���
		}

		System.out.printf("int�� �μ�[%d][%f]\n", k23_iI, k23_iD); // k23_iI, k23_iD ���
		System.out.printf("double�� �μ�[%f][%f]\n", (double) k23_iI, k23_iD); // (double) k23_iI, k23_iD) ���

		char k23_a = 'c'; // ���� k23_a char�� ����, 'c'�� �ʱ�ȭ

		if (k23_a == 'b') { // k23_a == 'b'���
			System.out.printf("a�� b�̴�\n"); // ���
		}
		if (k23_a == 'c') { // k23_a == 'c'��� // ���
			System.out.printf("a�� c�̴�\n");
		}
		if (k23_a == 'd') { // k23_a == 'd'��� // ���
			System.out.printf("a�� d�̴�\n");
		}

		String k23_aa = "abcd"; // String�� ������ �ƴ� Ŭ����
		if (k23_aa.equals("abcd")) { // String�� Ŭ���� �̱� ������ equals �Լ� ���
			System.out.printf("aa�� abcd�̴�\n"); // ���
		} else { // k23_aa �� "abcd"�� �ƴ϶��
			System.out.printf("aa�� abcd�� �ƴϴ�\n"); // ���
		}

		boolean k23_bb = true; // ���� k23_bb boolean�� ����, true�� �ʱ�ȭ
		if (!!k23_bb) { // k23_bb�� �ƴѰ� �ƴϸ�
			System.out.printf("bb�� �ƴϰ� �ƴϸ� ���̴�\n"); // ���
		} else { // k23_bb�� �ƴѰ� �ƴѰ� �ƴϸ�
			System.out.printf("bb�� �ƴϰ� �ƴϸ� �����̴�\n"); // ���
		}
	}

}
