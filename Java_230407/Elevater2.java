package Java_230407;

public class Elevater2 {
	public int limit_up_floor; // 최상위 층
	public int limit_down_floor; // 최하위 층
	public int floor; // 현재 층
	public String help;
	
	// 엘리베이터 기본 준공
	Elevater2() {
		limit_up_floor = 10; // 최상위 층
		limit_down_floor = 0; // 최하위 층
		floor = 1; // 현재 층
		help = "엘리베이터 기본 준공완료";

	}

	// 최대층 ,최소층, 현재층을 주어서 클래스를 생성할 수 있도록 해봤다
	Elevater2(int up_floor, int d_floor, int in_floor) {
		limit_up_floor = up_floor;
		limit_down_floor = d_floor;
		floor = in_floor;
		help = "엘리베이터 맞춤 준공완료";
	}

	void up() { // 엘리베이터가 올라감
		if (floor == limit_up_floor) {
			help = "마지막층입니다.";
		} else {
			floor++; // 최상층이 아닐 때 한 층씩 올라감
			help = String.format("%d층입니다", floor);
		}
	}

	void down() { // 엘리베이터가 내려감
		if (floor == limit_down_floor) {
			help = "처음층입니다.";
		} else {
			floor--; // 최하층이 아닐 때 한 층씩 올라감
			help = String.format("%d층입니다", floor);
		}
	}

	// 처음 몇층인지 지정한다면 그만큼 올라가도록 해봤다
	void up(int u) {
		for (int i = 0; i < u; i++) {
			this.up(); // this를 쓰면 명확해짐
		}
	}

	// 처음 몇층인지 지정한다면 그만큼 내려가도록 해봤다
	void down(int u) {
		for (int i = 0; i < u; i++) {
			down(); // this를 쓰면 명확해짐
		}
	}
	
	void msg(String id) {
		System.out.printf("%s => [%s], 최대층[%d] 최소층[%d] 현재층[%d]\n",
				id, help, limit_up_floor, limit_down_floor, floor);
	}

}
