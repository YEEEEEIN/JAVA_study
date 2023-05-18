package Java_0405;

public class Java_0405_06 {

	public static void main(String[] args) {
		int iWeekday = 5; // 1�� 1���� �ݿ��Ϻ��� ���� ����
		// iWeekday = 0(��), 1(��), 2(ȭ), 3(��), 4(��), 5(��), 6(��) => �ϼ��� ��ġ
		int[] iEnd = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 1~12�� �� �� �迭 ����

		for (int iMon = 0; iMon < 12; iMon++) { // �ſ� 0~11������
			System.out.printf("\n\n\t\t\t%d��\n", iMon + 1); // ���� 0���� �������� ��� ������ +1�� ���ش�
			System.out.printf("==================================================\n"); // ���
			System.out.printf(" ��\t��\tȭ\t��\t��\t��\t��\n"); // ���� ���

			int dayOfWeek = iWeekday; // iWeekday�� dayOfWeek�� ����
			for (int day = 1; day <= iEnd[iMon]; day++) { // 1�Ϻ��� �ش� �� �迭�� ����ִ� �ϼ� ��ŭ 1�� �����ϸ鼭 ���

				// ���� ù��° day���� ���� ���
				if (day == 1) { // day�� �� ���� ù ���̸�
					for (int i = 0; i < dayOfWeek; i++) { // �ϼ��� ��ġ ������
						System.out.print("\t"); // ���� ���
					}
				}
				
				System.out.printf("%2d\t", day); // day ���

				if (dayOfWeek == 6) { // dayOfWeek�� 6�̸� = �����
					System.out.print("\n"); // ���� -> �������� �ٲ�� ������
				}

				// �Ͽ��Ϸ� �ٲ��ֱ�
				dayOfWeek = (dayOfWeek + 1) % 7; // ���� �ַ� �ٲ��ֱ� dayOfWeek�� 0���� ����
			}

			if (dayOfWeek != 0) { // ������ ���� ��ġ�� 0�� �ƴϸ� => ������� �ƴϸ�
				System.out.print("\n"); // ���� -> ������ ���� ����
			}

			iWeekday = (iWeekday + iEnd[iMon]) % 7; // ���� �� ���� �� ����
		}

	}

}
