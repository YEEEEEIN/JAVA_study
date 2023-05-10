package day2;

import java.util.*;

class P2_src { // 같은 빈도수 만들기
	public int[] solution(String s) {
		int[] answer = new int[5]; // abcde
		HashMap<Character, Integer> sH = new HashMap<>();
		
		// 각 문자가 등장한 빈도수 세기
		for (char x : s.toCharArray()) { // a,b,c 만 저장
			sH.put(x, sH.getOrDefault(x, 0) + 1); // 문자x를 sH 해쉬맵에 빈도수 값으로 1 추가 => put을 해야 값이 저장된다
		}

		int max = Integer.MIN_VALUE; // 정수 중 가장 작은 값
		String tmp = "abcde"; // 주어진 문자 abcde
		// 빈도수의 최댓값 구하기
		for (char key : tmp.toCharArray()) {
			sH.put(key, sH.getOrDefault(key, 0)); // => 모든 문자를 넣기 위해 다시 한번 저장 => 없었던 문자인 e,d 추가로 저장
			if (sH.get(key) > max) {
				max = sH.get(key);
			}
		}
		
		for (int i = 0; i < tmp.length(); i++) {
			answer[i] = max - sH.get(tmp.charAt(i));
		}
//		for(char key : tmp.toCharArray()){
//			if(sH.getOrDefault(key, 0) > max){
//				max = sH.getOrDefault(key, 0);
//			}
//		}
//		for(int i = 0; i < tmp.length(); i++){
//			answer[i] = max - sH.getOrDefault(tmp.charAt(i), 0);
//		}
		return answer;

	}

	public static void main(String[] args) {
		P2_src T = new P2_src();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
