package kopo23.domian;

public class StudentScore {
	
	private String name; // 변수 name String형 선언
	private String studentid; // 변수 studentid형 String 선언
	private int kor; // 변수 kor int형 선언
	private int eng; // 변수 eng int형 선언
	private int mat; // 변수 mat int형 선언
	private int sum; // 변수 sum int형 선언
	private double avg; // 변수 avg double형 선언
	private int rank; // 변수 rank int형 선언

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double d) {
		this.avg = d;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	

}
