package kopo23.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import kopo23.domian.StudentScore;
import kopo23.dto.Pagination;
import kopo23.service.StudentScoreService;
import kopo23.service.StudentScoreServiceImpl;

class StudentScoreDaoTest {

	@Test	
	void test_create() {
		StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
		StudentScore studentScore = new StudentScore();

		studentScore.setName("2예인");
		studentScore.setKor(100);
		studentScore.setEng(100);
		studentScore.setMat(100);

		studentScoreDao.create(studentScore);
	}

	@Test
	void test_selectOne() {
		StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
//		StudentScore studentScore = new StudentScore();
		StudentScore studentScore = studentScoreDao.selectOne("studentid");
		
		// 확인용
		System.out.println(studentScore.getName());
		System.out.println(studentScore.getStudentid());
		System.out.println(studentScore.getKor());
		System.out.println(studentScore.getEng());
		System.out.println(studentScore.getMat());

	}
	
	@Test
	   void test_selectAll() {
	      StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
	      StudentScoreService studentScoreService = new StudentScoreServiceImpl();
	      Pagination pagination = studentScoreService.getPagination(11, 50);
	      List<StudentScore> studentScores = studentScoreDao.selectAll(pagination.getC(), 50);
	      System.out.println(studentScores.toString());
	   }

	   @Test
	   void test_update() {
	      StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
	      StudentScore studentScore = new StudentScore();
	      studentScore.setName("이예인");
	      studentScore.setKor(100);
	      studentScore.setEng(10);
	      studentScore.setMat(100);   
	      StudentScore updateStudentScore = studentScoreDao.update("studentid", studentScore);
	      System.out.println(updateStudentScore.getName());
	      System.out.println(updateStudentScore.getKor());
	      System.out.println(updateStudentScore.getEng());
	      System.out.println(updateStudentScore.getMat());
	   }

	   @Test
	   void test_delete() {
	      StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
	      StudentScore studentScore = new StudentScore();
	      studentScore = studentScoreDao.delete("studentid");
	   }


}
