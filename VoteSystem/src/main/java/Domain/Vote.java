package Domain;

public class Vote {
	private int kiho; // 변수 kiho int형 선언
	private String name; // 변수 name String형 선언
	private int age; // 변수 age int형 선언
	private int count; // 변수 count int형 선언
	
	
	// 변수가 private이기 때문에 값을 변경할 수 없다
	// 객체를 사용해여 형식을 쓰기 위하여 getter setter 설정
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getKiho() {
		return kiho;
	}
	public void setKiho(int kiho) {
		this.kiho = kiho;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
