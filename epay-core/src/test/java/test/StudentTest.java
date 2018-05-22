package test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import epay.base.dao.StudentDao;
import epay.base.model.Student;
import epay.base.model.StudentCon;
import epay.base.service.StudentService;

public class StudentTest  extends BaseTest{
	
	@Autowired
	private StudentDao dao;
	
	@Test
	@Transactional
	public void test(){
//		Student student = new Student();
//		student.setAge(100);
//		dao.save(student);
		List<Student> simpleQuery = dao.simple("ss");
		for (Student student : simpleQuery) {
			System.out.println(student.getName());
		}
	}
}
