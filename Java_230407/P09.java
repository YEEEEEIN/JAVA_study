package Java_230407;

public class P09 {

	public static void main(String[] args) {
		TvRemocon k23_tvre = new TvRemocon();
		// ä�� 10�ø���, 10������
		System.out.printf("ä�� 10�ø���, 10������\n"); // ���

		for (int k23_i = 0; k23_i < 10; k23_i++) { // ä�� 10 �ø��� ���� 10�� �ݺ�
			k23_tvre.k23_ChannelUp(); // �� TvRemocon Ŭ������ �� tvre ��ü(�ν��Ͻ��� ������ ����)�� ChannelUp()�޼ҵ�

			System.out.printf("MSG[%s]\n", k23_tvre.k23_help);
		}

		for (int k23_i = 0; k23_i < 10; k23_i++) { // ä�� 10 ������ ���� 10�� �ݺ�
			k23_tvre.k23_ChannelDown(); // �� TvRemocon Ŭ������ �� tvre ��ü(�ν��Ͻ��� ������ ����)�� ChannelDown()�޼ҵ�

			System.out.printf("MSG[%s]\n", k23_tvre.k23_help); // tvre ��ü�� help�� ��� �޼��� ���
		}

		// ���� 5�ø���, 5������
		System.out.printf("\n���� 5�ø���, 5������\n"); // ���
		for (int k23_i = 0; k23_i < 5; k23_i++) { // ���� 5 �ø��� ���� 5�� �ݺ�
			k23_tvre.k23_VolUp(); // �� TvRemocon Ŭ������ �� tvre ��ü(�ν��Ͻ��� ������ ����)�� VolUp()�޼ҵ�

			System.out.printf("MSG[%s]\n", k23_tvre.k23_help); // tvre ��ü�� help�� ��� �޼��� ���
		}

		for (int k23_i = 0; k23_i < 5; k23_i++) { // ���� 5 ������ ���� 5�� �ݺ�
			k23_tvre.k23_VolDown(); // �� TvRemocon Ŭ������ �� tvre ��ü(�ν��Ͻ��� ������ ����)�� VolDown()�޼ҵ�

			System.out.printf("MSG[%s]\n", k23_tvre.k23_help); // tvre ��ü�� help�� ��� �޼��� ���
		}

	}

}
