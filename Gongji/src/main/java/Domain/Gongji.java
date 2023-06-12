package Domain;

import java.sql.Date;

import javax.xml.crypto.Data;

public class Gongji {
	private int id; // 공지 번호
	private String title; // 제목
	private String date; // 날짜
	private String content; // 내용
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
