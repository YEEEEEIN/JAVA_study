package Java_230407;

public class Elevater3 extends Elevater2 {
	void Repair() {
		help = String.format("수리중입니다");
	}
	
	void up() { // 엘리베이터가 올라감
		if (floor == limit_up_floor) {
			help = "마지막층입니다.";
		} else {
			floor = floor + 2; // 최상층이 아닐 때 한 층씩 올라감
			help = String.format("%d층입니다", floor);
		}
		
		this.down(); // 만일 이렇게 하면 두칸 올라가고 한칸 내려감
	}

	void down() { // 엘리베이터가 내려감
		super.down();
		System.out.printf("클래스 안에서 찍고있는 MSG [%s]\n", this.help);
		// this.down() : 재귀 호출 시 뻉뺑이 돈다...
		
	}
}
