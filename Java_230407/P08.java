package Java_230407;

public class P08 {
	
	private static int inVal;
	
	public static void up() {
		inVal++;
		System.out.printf("�� �׳� �޼ҵ�[%d]\n", inVal);
	}

	public static void main(String[] args) {
		inVal = 0; // �ڱ� ���� ���� ���
		
		Elevater elev; // Ŭ������ �޾� ��ü�� ����
		elev = new Elevater(); // �ν��Ͻ��� �����Ͽ� ��ü�� ����
		
		up(); // �� �׳� ���� �ҽ� �� �޼ҵ�
		
		for(int i = 0; i <10; i++) {
			elev.up(); // �� ���������� Ŭ������ �� elev ��ü(�ν��Ͻ��� ������ ����)�� up()�޼ҵ�
			
			System.out.printf("MSG[%s]\n", elev.help);
		}
		
		for(int i = 0; i <10; i++) {
			elev.down(); // �� ���������� Ŭ������ �� elev ��ü(�ν��Ͻ��� ������ ����)�� down()�޼ҵ�
			
			System.out.printf("MSG[%s]\n", elev.help);
		}
		

	}

}
