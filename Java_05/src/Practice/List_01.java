package Practice;

import java.util.ArrayList;
import java.util.Collections;

public class List_01 { //List => 중복 허용

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> name = new ArrayList<String>();

		name.add("kim");
		name.add("lee");
		name.add("john");

		System.out.println(name);
		System.out.println(name.size()); // 3
		System.out.println(name.get(2));

		name.remove(1);
		System.out.println(name);

		name.set(1, "park");
		System.out.println(name);
		System.out.println(name.size());

		name.add("lee");
		System.out.println(name);

		Collections.sort(name); //내림차순
		System.out.println(name);

		Collections.reverse(name);
		System.out.println(name);
	}

}
