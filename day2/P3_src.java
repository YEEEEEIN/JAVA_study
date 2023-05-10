package day2;

import java.util.*;

class P3_src { // 서로 다른 빈도수 만들기
	public int solution(String s) {
		int answer = 0;
		HashMap<Character, Integer> sH = new HashMap<>();
		HashSet<Integer> ch = new HashSet<>();
		
		// x라는 문자가 등장한 빈도수 세기
		for (char x : s.toCharArray()) {
			sH.put(x, sH.getOrDefault(x, 0) + 1);
		}
		
		// 모든 문자의 빈도수가 서로 다르게 하게하기 
		for (char key : sH.keySet()) { // keySet(): sH의 모든 키를 Set형태로 반환(중복x) // a,b,c 차례로 들어간다
			while (ch.contains(sH.get(key))) { // 처음에 ch는 값이 없기 때문에 for문을 안탄다. // ch는 b의 값인 3을 가지고 있기 때문에
				sH.put(key, sH.get(key) - 1); // 중복을 없애기 위해 지우고 그 값 저장
				answer++; // 중복을 없애기 위해 지운 횟수 => 우리가 구하려는 값
			}
			if(sH.get(key) == 0) continue; // 키의 값이 0이면 다음 키로 
			ch.add(sH.get(key)); // sH의 key의 value를 key로 가지는 ch // ch에 a의 값인 3추가
		}
		return answer;
	}

	public static void main(String[] args) {
		P3_src T = new P3_src();
		System.out.println(T.solution("aaabbbcc"));
		System.out.println(T.solution("aaabbc"));
		System.out.println(T.solution("aebbbbc"));
		System.out.println(T.solution("aaabbbcccde"));
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));
	}
}