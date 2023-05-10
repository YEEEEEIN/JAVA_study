package day2;

import java.util.HashMap;

class P1_src { // �� �� ����� ���ʹ���
	public int solution(String s) {
		HashMap<Character, Integer> sH = new HashMap<>(); // HashMap => Ű-����
		 // x��� ���ڰ� ������ �󵵼� ����
		for (char x : s.toCharArray()) { // �ε��� ��ȣ�� �ʿ� ���� �� -> �ѹ��� �� �����ֱ� -> for-each �� ���
			sH.put(x, sH.getOrDefault(x, 0) + 1); // x�� sH �ؽ��ʿ� �󵵼��� ��(Ű)���� 1 �߰�
		}
		
		for (int i = 0; i < s.length(); i++) { // �ε����� ��ġ�� �ʿ��ϱ� ������ for-each�� ��� x
			if (sH.get(s.charAt(i)) == 1) // �ε��� i�� ���� �󵵼��� 1�̸�
				return i + 1; // �ε����� 1���� �����ϱ� ������
		}

		return -1; // �� ���� ��� �� ���ڰ� ���� ��� ex)aabb
	}

	public static void main(String[] args) {
		P1_src T = new P1_src();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}
