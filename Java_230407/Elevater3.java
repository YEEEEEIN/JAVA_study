package Java_230407;

public class Elevater3 extends Elevater2 {
	void Repair() {
		help = String.format("�������Դϴ�");
	}
	
	void up() { // ���������Ͱ� �ö�
		if (floor == limit_up_floor) {
			help = "���������Դϴ�.";
		} else {
			floor = floor + 2; // �ֻ����� �ƴ� �� �� ���� �ö�
			help = String.format("%d���Դϴ�", floor);
		}
		
		this.down(); // ���� �̷��� �ϸ� ��ĭ �ö󰡰� ��ĭ ������
	}

	void down() { // ���������Ͱ� ������
		super.down();
		System.out.printf("Ŭ���� �ȿ��� ����ִ� MSG [%s]\n", this.help);
		// this.down() : ��� ȣ�� �� �R���� ����...
		
	}
}
