package Practice;

public class Pratice_03 {
	public static void main(String[] args) {
		boolean[] checkDup = new boolean[45];
		for (int i = 0; i < checkDup.length; i++) {
			checkDup[i] = false;
		}

		for (int i = 0; i < 6; i++) {
			while (true) {
				try {
					int n = getRandom();
					if (checkDup[n - 1] == false) {
						System.out.println(n);
						checkDup[n - 1] = true;
						break;
					}
				} catch(Exception e) {
					
				}
			}
		}
	}

	public static int getRandom() {
		int ret = 0;
		int n = (int) (Math.random() * 45);
		ret = n;
		return ret;
	}
}








/* 다른 풀이
package Practice;

public class Pratice_03 {
	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			System.out.println(getRandom());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static int getRandom() {
		int ret = 0;
		int n = (int) (Math.random() * 45);
		ret = n;
		return ret;
	}
}
*/