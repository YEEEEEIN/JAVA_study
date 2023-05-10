package day2;

import java.util.*;

class P3_src { // ���� �ٸ� �󵵼� �����
	public int solution(String s) {
		int answer = 0;
		HashMap<Character, Integer> sH = new HashMap<>();
		HashSet<Integer> ch = new HashSet<>();
		
		// x��� ���ڰ� ������ �󵵼� ����
		for (char x : s.toCharArray()) {
			sH.put(x, sH.getOrDefault(x, 0) + 1);
		}
		
		// ��� ������ �󵵼��� ���� �ٸ��� �ϰ��ϱ� 
		for (char key : sH.keySet()) { // keySet(): sH�� ��� Ű�� Set���·� ��ȯ(�ߺ�x) // a,b,c ���ʷ� ����
			while (ch.contains(sH.get(key))) { // ó���� ch�� ���� ���� ������ for���� ��ź��. // ch�� b�� ���� 3�� ������ �ֱ� ������
				sH.put(key, sH.get(key) - 1); // �ߺ��� ���ֱ� ���� ����� �� �� ����
				answer++; // �ߺ��� ���ֱ� ���� ���� Ƚ�� => �츮�� ���Ϸ��� ��
			}
			if(sH.get(key) == 0) continue; // Ű�� ���� 0�̸� ���� Ű�� 
			ch.add(sH.get(key)); // sH�� key�� value�� key�� ������ ch // ch�� a�� ���� 3�߰�
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