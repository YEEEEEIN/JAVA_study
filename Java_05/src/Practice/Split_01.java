package Practice;

public class Split_01 { // split()
	public static void main(String[] args) {
		String words = "Kim,lee,park";
		String[] names = words.split(",");

		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}

	}

}
