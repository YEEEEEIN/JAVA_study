package Java_230407;

public class P17 {

	public static void main(String[] args) {

		TvRemoconX tvre;
		tvre = new TvRemoconX(); // tvre ��ü ����

		// ä�� 10 �ø���
		System.out.printf("ä�� 10 �ø���\n"); // ���
		for (int i = 0; i < 10; i++) { // ä�� 10 �ø��� ���� 10�� �ݺ�
			tvre.channelUp();
			tvre.chMsg("ä�� 1 �ø���");
		}

		// ä�� 10 ������
		System.out.printf("\nä�� 10 ������\n"); // ���
		for (int i = 0; i < 10; i++) { // ä�� 10 ������ ���� 10�� �ݺ�
			tvre.channelDown();
			tvre.chMsg("ä�� 1 ������");
		}

		// ���� 5 �ø���
		System.out.printf("\n���� 5 �ø���\n"); // ���
		for (int i = 0; i < 5; i++) { // ���� 5 �ø��� ���� 5�� �ݺ�
			tvre.volUp();
			tvre.volMsg("���� 1 �ø���");
		}

		// ���� 5 ������
		System.out.printf("\n���� 5 ������\n"); // ���
		for (int i = 0; i < 5; i++) { // ���� 5 ������ ���� 5�� �ݺ�
			tvre.volDown();
			tvre.volMsg("���� 1 ������");
		}
		
		tvre.batteryCheck(); // ���͸� üũ
		System.out.printf("MSG TvRemocon[%s]\n", tvre.help); 

	}

}
