package Java_230407;

public class P14 {

	static TvRemocon2 tvre; // TvRemocon2 Ŭ������ tvre

	public static void main(String[] args) {

		tvre = new TvRemocon2(); // tvre ��ü ����

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

		/*
		 * tvre.channelUp(10); tvre.chMsg("ä�� 10 �ø���");
		 * 
		 * tvre.channelDown(10); tvre.chMsg("ä�� 10 ������");
		 * 
		 * tvre.volUp(5); tvre.volMsg("���� 5 �ø���");
		 */

	}

}
