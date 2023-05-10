package day2;

import java.util.HashMap;

class P1_src { // 한 번 사용한 최초문자
	public int solution(String s) {
		HashMap<Character, Integer> sH = new HashMap<>(); // HashMap => 키-벨류
		 // x라는 문자가 등장한 빈도수 세기
		for (char x : s.toCharArray()) { // 인덱스 번호가 필요 없을 때 -> 한번에 다 때려넣기 -> for-each 문 사용
			sH.put(x, sH.getOrDefault(x, 0) + 1); // x를 sH 해쉬맵에 빈도수의 값(키)으로 1 추가
		}
		
		for (int i = 0; i < s.length(); i++) { // 인덱스의 위치가 필요하기 때문에 for-each문 사용 x
			if (sH.get(s.charAt(i)) == 1) // 인덱스 i의 문자 빈도수가 1이면
				return i + 1; // 인덱스는 1부터 시작하기 때문에
		}

		return -1; // 한 번만 사용 한 문자가 없는 경우 ex)aabb
	}

	public static void main(String[] args) {
		P1_src T = new P1_src();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}
