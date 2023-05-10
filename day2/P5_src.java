package day2;

//day2 패키지에 속하는 P5_src 클래스 정의
import java.util.*; // Java Util 패키지 import

class P5_src {
	// solution 메서드 시작
	public String solution(String[] votes, int k){
		String answer = " "; // 초기화
		HashMap<String, HashSet<String>> voteHash = new HashMap<>(); // key는 String, value는 HashSet<String> 타입의 해시맵 생성
		HashMap<String, Integer> candidate = new HashMap<>(); // key는 String, value는 Integer 타입의 해시맵 생성
		HashMap<String, Integer> present = new HashMap<>(); // key는 String, value는 Integer 타입의 해시맵 생성

		// votes 배열의 모든 원소에 대해 반복문 실행
		for(String x : votes){
			String a = x.split(" ")[0]; // x를 공백을 기준으로 자른 후 첫 번째 문자열을 a에 저장
			String b = x.split(" ")[1]; // x를 공백을 기준으로 자른 후 두 번째 문자열을 b에 저장
			voteHash.putIfAbsent(a, new HashSet<String>()); // voteHash에 key가 a인 해시셋이 없으면(없을 때만), 새로 생성
			voteHash.get(a).add(b); // voteHash에서 key가 a인 해시셋에 b를 추가 => key는 1개 이상의 value를 가질 수 있다
			candidate.put(b, candidate.getOrDefault(b, 0) + 1); // candidate 해시맵에 b를 key로 하는 값이 없으면 0으로 초기화하고 1을 더한 값을 넣음
		}

		int max=Integer.MIN_VALUE; // 최대값을 저장할 변수 초기화
		// voteHash의 모든 key에 대해 반복문 실행
		for(String a : voteHash.keySet()){
			int cnt = 0; // cnt 변수 초기화
			// voteHash에서 key가 a인 해시셋의 모든 원소(value)에 대해 반복문 실행
			for(String b : voteHash.get(a)){
				if(candidate.get(b) >= k) cnt++; // b를 key로 하는 candidate 해시맵의 값이 k 이상이면 cnt를 1 증가
			}
			present.put(a, cnt); // present 해시맵에 a를 key로, cnt를 value로 넣음
			max = Math.max(max, cnt); // cnt와 max 중 큰 값을 max에 저장
		}

		ArrayList<String> tmp = new ArrayList<>(); // String 타입의 ArrayList tmp 생성
		// present 해시맵의 모든 key에 대해 반복문 실행
		for(String name : present.keySet()){
			if(present.get(name) == max) tmp.add(name); // present에서 key가 name인 값이 max와 같으면 tmp에 name 추가
		}
		tmp.sort((a, b) -> a.compareTo(b)); // tmp 리스트를 알파벳 순으로 정렬
		answer = tmp.get(0); // tmp 리스트의 첫 번째 값을 answer에 저장
		return answer; // answer 반환
	}

	public static void main(String[] args){
		P5_src T = new P5_src();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		//System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		//System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		//System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
}
