package epay.base.dao;

import java.util.List;

import epay.base.model.Student;
import epay.simpleQuery.dao.BaseDao;

public interface StudentDao extends BaseDao<Student, Integer>{
	
	public Student findById(Integer id);
	
	public List<Student> simple(String name);
	
	public void saveqq(Student student);
}
