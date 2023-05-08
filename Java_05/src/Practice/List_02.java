package Practice;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class List_02 { // Iterator -> 파이썬에서 많이 씀

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("Kim");
		list.add("lee");
		list.add("park");

		Iterator<String> iterator = list.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("----------");

		for (String name : list) {
			System.out.println(name);
		}

		System.out.println("----------");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
