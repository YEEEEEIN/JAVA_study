package Java_0403;

public class Java_0403_03 {
	public static int k23_netprice(int k23_price, double k23_rate) { // ��������(��ǰ����, ����)
		return (int) (k23_price / (1 + k23_rate)); // ���������� ������ ��ȯ(����)
	}

	public static void main(String[] args) {
		int k23_price = 1234; // ��ǰ ����
		double k23_tax_rate = 0.1; // ����

		int k23_netprice = k23_netprice(k23_price, k23_tax_rate); // �º� netprice�� ����, �캯 netprice�� �Լ�
		int k23_tax = k23_price - k23_netprice; // ���� = ��ǰ ���� - ���� ����
		
		//���
		System.out.printf("***********************************************\n");
		System.out.printf("*        �Һ��ڰ�, ��������, ���� ���        *\n");
		System.out.printf("�Һ��� ���� : %d, �������� : %d, ���� : %d\n", k23_price, k23_netprice, k23_tax);
		System.out.printf("***********************************************\n");
	}
}
