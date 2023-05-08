package Practice;

import java.util.HashSet;

public class HashSet_01 { // Set => 순서X 중복 허용 X

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> name = new HashSet<String>();
		name.add("Kim");
		System.out.println(name);
		name.add("lee");
		System.out.println(name);
		name.add("Kim");

	}
}
