package Java_230412;

public class CalcMain {

	public static void main(String[] args) {
		Calc calc1 = new Calc();
		Calc calc2 = new Calc();
		 
		int r1 = calc1.add(3,5);
		int r2 = calc1.add(6, 3);
		
		System.out.println(calc1.getMemory());
		System.out.println(calc2.getMemory());
		
		System.out.println(r1);
		System.out.println(r2);
		
		double r3 = Calc.getCircleLength(3);
		System.out.println(r3);
		

	}

}
