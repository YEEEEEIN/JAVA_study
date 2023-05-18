package Java_230405;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Java_0405_08_01 {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("###,###,###,###"); // ���� ����
		LocalDateTime now = LocalDateTime.now(); //  ���� �ð� ���ϱ�
		LocalDate currentDate = LocalDate.now(); // ���� ��¥ ���ϱ�
		// 14���� ���� ��¥ ���ϱ�
        LocalDate futureDate = currentDate.plusDays(14);
        // ���ϴ� �������� ��¥ ����ϱ�
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM��dd��");
        String result = futureDate.format(formatter);
		
	    String NowTime = now.format(DateTimeFormatter.ofPattern(("yyyy/MM/dd HH:mm:ss")));
	    // ǰ��
	    String itemname1 = "ǻ��� �����ܿ븶��ũ(�ְ����)";
	    byte [] aa = itemname1.getBytes();
	    String aa_itemname1 = new String(aa, 0, 26);
	    String itemcode1 = "1031615";
	    int price1= 3000;
	    int amount1 = 1;
	    int total1 = price1 * amount1;
	    
	    String itemname2 = "�����̵�ĸ���(������)(100ȣ)";
	    byte [] bb = itemname2.getBytes();
	    String bb_itemname2 = new String(bb, 0, 26);
	    String itemcode2 = "11008152";
	    int price2= 1000;
	    int amount2 = 1;
	    int total2 = price2 * amount2;
	    
	    String itemname3 = "�������� ���׸�����ũ(�˷�̴�Ÿ��)";
	    byte [] cc = itemname3.getBytes();
	    String cc_itemname3 = new String(cc, 0, 26);
	    String itemcode3 = "1020800";
	    int price3= 1000;
	    int amount3 = 1;
	    int total3 = price3 * amount3;
	    
	    // ����
	    int totalAll =  total1 +  total2 +  total3; // �Ǹ��հ�
	    double rateVat = 0.1; // �ΰ�����
	    double price_not_vat = totalAll / (1 + rateVat); // �����հ�
	    double priceVat = totalAll - price_not_vat; // �ΰ���
	   
		// ��º�
		System.out.printf("%23s\n", "\"���ΰ���, ���̼�\"");
	
		System.out.printf("(��)�Ƽ����̼�_�д缭����\n");
		System.out.printf("��ȭ:031-702-6016\n");
		System.out.printf("����:���� ������ ���μ�ȯ�� 2748 (���)\n");
		System.out.printf("��ǥ:������,��ȣ�� 213-81-52063\n");
		System.out.printf("����:��⵵ ������ �д籸 �д��53���� 11 (������)\n");
		
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		System.out.printf("%24s\n", "�Һ����߽ɰ濵(CCM) �������");
		System.out.printf("%26s\n", "ISIO 9001 ǰ���濵�ý��� �������");
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		System.out.printf("%6s��ȯ/ȯ�� 14��(%s)�̳�,\n", "", result); // ��¥ �ٲٱ�
		
		System.out.printf("(����)������. ����ī�� ���� �� ���Ը��忡�� ����\n");
		System.out.printf("%23s\n", "����/���� �� �Ѽս� ��ȯ/ȯ�� �Ұ�");
		System.out.printf("%23s\n", "üũī�� ��� �� �ִ� 7�� �ҿ�");
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		System.out.printf("[PDS 1058231] %27s\n", NowTime );
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		
		System.out.printf("%s %2s %2s %2s\n", aa_itemname1, df.format(price1), df.format(amount1), df.format(total1));
		System.out.printf("[%s]\n", itemcode1);
		System.out.printf("%s %2s %2s %2s\n", bb_itemname2, df.format(price2), df.format(amount2), df.format(total2));
		System.out.printf("[%s]\n", itemcode2);
		System.out.printf("%s %2s %2s %2s\n", cc_itemname3, df.format(price3), df.format(amount3), df.format(total3));
		System.out.printf("[%s]\n", itemcode3);
		
		
		System.out.printf("%19s%18s\n","�����հ�", df.format(price_not_vat));
		System.out.printf("%20s%18s\n","�ΰ���", df.format(priceVat));
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");
		System.out.printf("%s%33s\n","�Ǹ��հ�", df.format(totalAll));
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		System.out.printf("%s%33s\n","�ſ�ī��", df.format(totalAll));
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");
		System.out.printf("%s%33s\n","�츮ī��", "538720**********");
		System.out.printf("%s%11s %s\n","���ι�ȣ 77982843(0)", "���αݾ�", df.format(totalAll));
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		System.out.printf("%25s �д缭����\n", NowTime );
		System.out.printf("��ǰ �� ��Ÿ ���� : 1522-4400\n");
		System.out.printf("����� �� �����̼� ���� ���� : 1599-2211\n");
		System.out.printf("%28s\n", "2112820610158231");
		
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");
		System.out.printf("�´��̼� ����� �� �Ǵ� Ȩ�������� �����ϼż� ȸ������ �� �پ��� ������ ����������! ��\n");
		
		
		
//		// ���� 10 �ۼ�Ʈ
//				double vatRate = 0.1;
//				int calrate = 10;
//
//				// �����հ�
//				double calTax = sum / (vatRate + 1.0);
//
//				// �ΰ���
//				double netprice = calTax * calrate / 100;
//				int inetprice = (int) Math.ceil(netprice);
//
//				// ������հ�
//				int kk = sum - inetprice;
		
		
	
	
		

	}
	

	
	

}
