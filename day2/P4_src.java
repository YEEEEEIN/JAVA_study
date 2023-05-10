package day2;

import java.util.*;

class P4_src { // ������ �ִ� �κм���
	public int solution(int[] nums, int m) {
		int answer = 0;
		HashMap<Integer, Integer> nH = new HashMap<>();
		int sum = 0;
		nH.put(0, 1); // �ʱⰪ ���� => sum = m �� �� ��
		for (int x : nums) { // 2, 2, 3, -1, -1/ -1, 3, 1, 1
			sum += x; // 2 4 7 6 5/ 4 7 8 9
			if (nH.containsKey(sum - m)) { // -3 -1 2 1 0/ -1 2 3 4
				answer += nH.get(sum - m); // 0 0 1 0 1/ 1 0 1 0 2 ��, �� ���� = ������ ������� ��
			}
			nH.put(sum, nH.getOrDefault(sum, 0) + 1); // (2,1) (4,1+1) (7,1+1) (6,1) (5,1)/ () () (8,1)
		}
		return answer;
	}

	public static void main(String[] args) {
		P4_src T = new P4_src();
		System.out.println(T.solution(new int[] { 2, 2, 3, -1, -1, -1, 3, 1, 1 }, 5));
		System.out.println(T.solution(new int[] { 1, 2, 3, -3, 1, 2, 2, -3 }, 5));
		System.out.println(T.solution(new int[] { 1, 2, 3, -3, 1, 2 }, 3));
		System.out.println(T.solution(new int[] { -1, 0, 1 }, 0));
		System.out.println(T.solution(new int[] { -1, -1, -1, 1 }, 0));
	}
}