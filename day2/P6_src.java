package day2;

import java.util.*;
class Info implements Comparable<Info>{ // Comparable Ŭ������ override
	public String name;
	public int time;
	Info(String name, int time){
		this.name = name;
		this.time = time;
	}
	@Override
	public int compareTo(Info ob) {
		// Info ��ü�� ������ �� ���Ǵ� compareTo �޼���
        // ���� ��ü�� �ð�(time)�� ���ڷ� ���� ��ü(ob)�� �ð�(time)�� ���Ͽ� ��ȯ�Ѵ�.
		//System.out.println("compare out : " + (this.time - ob.time));
		
		return this.time - ob.time; // ���ϰ��� �ð��̴� (�̸�X)
	}
	
}

class P6_src { // ���� ����
	public int getTime(String time) { // ���ڿ� �ð�:�� �� �ɰ��� ���ϴ� �Լ�
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);
		return H*60+M;
	}
	public String[] solution(String[] reports, String times){
        ArrayList<Info> tmp = new ArrayList<>(); // Info ��ü list�� ������ �� �ִ� �� ArrayList ��ü tmp �����ϴ� �ڵ�
        for(String x : reports){ // �α� ������ ó���Ͽ� Info ��ü�� �����ϰ� ArrayList�� �߰�
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            tmp.add(new Info(a, getTime(b)));
        }
        Collections.sort(tmp); // ArrayList�� �ð� ������ ����

        int s = getTime(times.split(" ")[0]); // �˻� ���� �ð�
        Info startTime = new Info("startTime", s);

        int e = getTime(times.split(" ")[1]); // �˻� ���� �ð�
        Info endTime = new Info("endTime", e);

        ArrayList<String> res = new ArrayList<>(); // �˻� ����� ������ ArrayList
        for(Info ob : tmp){
            // �˻� ���� ���� �ִ� �α׸� res ����Ʈ�� �߰�
            if(ob.compareTo(startTime) > 1 && ob.compareTo(endTime) <= 0){
                res.add(ob.name);
            }
            // endTime ������ �α״� �˻��� �ʿ䰡 �����Ƿ� �ݺ����� Ż���Ѵ�.
            if(ob.compareTo(endTime) > 0) break;
        }
        // ����� String �迭�� ��ȯ�Ͽ� ��ȯ
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

	public static void main(String[] args){
		P6_src T = new P6_src();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
		//System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
		//System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}
}

