package Java_230407;

public class P10 {

	public static void main(String[] args) {
		Calc1 cc = new Calc1();

		System.out.printf("2�� ������ ȣ��� [%d]\n", cc.sum(1, 2));
		System.out.printf("3�� ������ ȣ��� [%d]\n", cc.sum(1, 2, 3));
		System.out.printf("4�� ������ ȣ��� [%d]\n", cc.sum(1, 2, 3, 4));
		System.out.printf("������ ������ ȣ��� [%f]\n", cc.sum(1.3, 2.4));

	}

}
