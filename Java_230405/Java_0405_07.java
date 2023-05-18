package Java_230405;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Java_0405_07 {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("###,###,###,###"); // DecimalFormat ��ü �����Ͽ� �� ���� ���� ����
		LocalDateTime now = LocalDateTime.now(); // LocalDateTime ��ü �����Ͽ� ����ð� �ҷ�����
		String NowTime = now.format(DateTimeFormatter.ofPattern(("yyyy/MM/dd HH:mm:ss"))); // ���Ŀ� �ô� �ð� ����

		int price = 67200; // �Һ��ڰ� ����
		double vatRate = 0.1; // �ΰ����� 0.1 ����

		// �����հ�
		double calTax = price / (vatRate + 1.0); // �Һ��ڰ� / 1.1�� double�� �����հ迡 ����
		// ����� �� double������ ���� ����ؼ� �Ҽ����� �ս��� �����ش�
		// ��������ȯ �� ��� �Ҽ����� �սǵǾ� ������� ������ ��Ÿ�� ���� ����

		// �ΰ���
		double vatprice = calTax * vatRate; // double�� �����հ� * double�� �ΰ������� double�� �ΰ����� ����
		int ivatprice = (int) Math.ceil(vatprice); // �ΰ����� �׻� ���� �޾ƾ��ϱ� ������ �ø�ó�� �� ������ ��ȯ�Ͽ� ����

		// ������հ�
		int realCalTax = price - ivatprice; // �� �����հ� = �Һ��ڰ� - �ΰ���

		System.out.printf("�ſ����\n"); // ���� ���
		System.out.printf("%s%18s\n", "�ܸ��� : 2N68665898", "��ǥ��ȣ : 041218"); // ���� ���
		System.out.printf("������ : �Ѿ��ġ�\n"); // ���� ���
		System.out.printf("��  �� : ��� ������ �д籸 Ȳ�����351���� 10 , 1��\n"); // ���� ���
		System.out.printf("��ǥ�� : ��â��\n"); // ���� ���
		System.out.printf("%s%20s\n", "����� : 752-53-00558", "TEL : 7055695"); // ���� ���
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n"); // ���
		System.out.printf("%s%33s��\n", "��  ��", df.format(realCalTax)); // �ݾ� ���Ŀ� �°� ���
		System.out.printf("%s%33s��\n", "�ΰ���", df.format(ivatprice)); // �ΰ��� ���Ŀ� �°� ���
		System.out.printf("%s%33s��\n", "��  ��", df.format(price)); // �հ� ���Ŀ� �°� ���
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n"); // ���

		System.out.printf("�츮ī��\n"); // ���� ���
		System.out.printf("ī���ȣ : 5387-20**-****-4613(S)  �Ͻú�\n"); // ���� ���
		System.out.printf("�ŷ��Ͻ� : %s\n", NowTime); // ����ð� ���Ŀ� �°� ���
		System.out.printf("���ι�ȣ : 70404427\n"); // ���� ���
		System.out.printf("�ŷ���ȣ : 357734873739\n"); // ���� ���
		System.out.printf("���� : ��ī���    ���� : 720068568\n"); // ���� ���
		System.out.printf("�˸� : EDC����ǥ\n"); // ���� ���
		System.out.printf("���� : TEL)1544-4700\n"); // ���� ���
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n"); // ���
		System.out.printf("%22s\n", "*�����մϴ�*"); // ���� ���
		System.out.printf("%39s\n", "ǥ��v2.08_20200212"); // ���� ���

	}

}
