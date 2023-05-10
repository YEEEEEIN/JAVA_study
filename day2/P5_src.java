package day2;

//day2 ��Ű���� ���ϴ� P5_src Ŭ���� ����
import java.util.*; // Java Util ��Ű�� import

class P5_src {
	// solution �޼��� ����
	public String solution(String[] votes, int k){
		String answer = " "; // �ʱ�ȭ
		HashMap<String, HashSet<String>> voteHash = new HashMap<>(); // key�� String, value�� HashSet<String> Ÿ���� �ؽø� ����
		HashMap<String, Integer> candidate = new HashMap<>(); // key�� String, value�� Integer Ÿ���� �ؽø� ����
		HashMap<String, Integer> present = new HashMap<>(); // key�� String, value�� Integer Ÿ���� �ؽø� ����

		// votes �迭�� ��� ���ҿ� ���� �ݺ��� ����
		for(String x : votes){
			String a = x.split(" ")[0]; // x�� ������ �������� �ڸ� �� ù ��° ���ڿ��� a�� ����
			String b = x.split(" ")[1]; // x�� ������ �������� �ڸ� �� �� ��° ���ڿ��� b�� ����
			voteHash.putIfAbsent(a, new HashSet<String>()); // voteHash�� key�� a�� �ؽü��� ������(���� ����), ���� ����
			voteHash.get(a).add(b); // voteHash���� key�� a�� �ؽü¿� b�� �߰� => key�� 1�� �̻��� value�� ���� �� �ִ�
			candidate.put(b, candidate.getOrDefault(b, 0) + 1); // candidate �ؽøʿ� b�� key�� �ϴ� ���� ������ 0���� �ʱ�ȭ�ϰ� 1�� ���� ���� ����
		}

		int max=Integer.MIN_VALUE; // �ִ밪�� ������ ���� �ʱ�ȭ
		// voteHash�� ��� key�� ���� �ݺ��� ����
		for(String a : voteHash.keySet()){
			int cnt = 0; // cnt ���� �ʱ�ȭ
			// voteHash���� key�� a�� �ؽü��� ��� ����(value)�� ���� �ݺ��� ����
			for(String b : voteHash.get(a)){
				if(candidate.get(b) >= k) cnt++; // b�� key�� �ϴ� candidate �ؽø��� ���� k �̻��̸� cnt�� 1 ����
			}
			present.put(a, cnt); // present �ؽøʿ� a�� key��, cnt�� value�� ����
			max = Math.max(max, cnt); // cnt�� max �� ū ���� max�� ����
		}

		ArrayList<String> tmp = new ArrayList<>(); // String Ÿ���� ArrayList tmp ����
		// present �ؽø��� ��� key�� ���� �ݺ��� ����
		for(String name : present.keySet()){
			if(present.get(name) == max) tmp.add(name); // present���� key�� name�� ���� max�� ������ tmp�� name �߰�
		}
		tmp.sort((a, b) -> a.compareTo(b)); // tmp ����Ʈ�� ���ĺ� ������ ����
		answer = tmp.get(0); // tmp ����Ʈ�� ù ��° ���� answer�� ����
		return answer; // answer ��ȯ
	}

	public static void main(String[] args){
		P5_src T = new P5_src();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		//System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		//System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		//System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
}
