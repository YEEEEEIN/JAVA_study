package day1;

import java.util.ArrayList;

class P5 {
	public int solution(int[] nums) {
		int answer = 0;
		int n = nums.length;
		ArrayList<Integer> peak = new ArrayList<>(); // peak가 몇개인지 모르기 때문에
		// System.out.println(nums);
		for (int i = 1; i < n - 1; i++) {
			if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
				peak.add(i);
				// System.out.println(nums[i] +","+ nums[i-1]+"," + nums[i+1]);
			}
		}
		//System.out.println(peak.size());

		for (int x : peak) { // peak = {1, 4, 7}일 때
			int left = x;
			int right = x;
			int cnt = 1; // 본인 스스로 피크값
			while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
				left--; // 0
				cnt++;
			}
			while (right + 1 < n && nums[right] > nums[right + 1]) {
				right++;
				cnt++;
			}
			answer = Math.max(answer, cnt);
		}

		return answer;
	}

	public static void main(String[] args) {
		P5 T = new P5();
		System.out.println(T.solution(new int[] { 1, 2, 1, 2, 3, 2, 1 }));
		System.out.println(T.solution(new int[] { 1, 1, 2, 3, 5, 7, 4, 3, 1, 2 }));
		System.out.println(T.solution(new int[] { 3, 2, 1, 3, 2, 4, 6, 7, 3, 1 }));
		System.out.println(T.solution(new int[] { 1, 3, 1, 2, 1, 5, 3, 2, 1, 1 }));
	}
}
