package day2;

import java.util.*;

class P2_src { // ���� �󵵼� �����
	public int[] solution(String s) {
		int[] answer = new int[5]; // abcde
		HashMap<Character, Integer> sH = new HashMap<>();
		
		// �� ���ڰ� ������ �󵵼� ����
		for (char x : s.toCharArray()) { // a,b,c �� ����
			sH.put(x, sH.getOrDefault(x, 0) + 1); // ����x�� sH �ؽ��ʿ� �󵵼� ������ 1 �߰� => put�� �ؾ� ���� ����ȴ�
		}

		int max = Integer.MIN_VALUE; // ���� �� ���� ���� ��
		String tmp = "abcde"; // �־��� ���� abcde
		// �󵵼��� �ִ� ���ϱ�
		for (char key : tmp.toCharArray()) {
			sH.put(key, sH.getOrDefault(key, 0)); // => ��� ���ڸ� �ֱ� ���� �ٽ� �ѹ� ���� => ������ ������ e,d �߰��� ����
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
