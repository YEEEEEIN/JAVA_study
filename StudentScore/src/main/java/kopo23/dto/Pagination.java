package kopo23.dto;

public class Pagination {
	private int c; // 현재 페이지, private 지정
	private int s; // 하단 페이지 바 시작 지점, private 지정
	private int e; // 하단 페이지 바 끝 지점, private 지정
	private int p; // 10p 뒤로 이동, private 지정
	private int pp; // 처음 페이지로 이동, private 지정
	private int n; // 10p 앞으로 이동, private 지정
	private int nn; // 마지막 페이지로 이동, private 지정
	
	// private 지정되어있기 때문에 데이터 직접 수정 불가
	// getter, setter 설정
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
	}
	public int getE() {
		return e;
	}
	public void setE(int e) {
		this.e = e;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getPp() {
		return pp;
	}
	public void setPp(int pp) {
		this.pp = pp;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getNn() {
		return nn;
	}
	public void setNn(int nn) {
		this.nn = nn;
	}
	
}
