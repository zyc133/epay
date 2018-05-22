package epay.base.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import epay.base.dao.StudentDao;
import epay.base.model.Student;
import epay.base.model.StudentCon;
import epay.simpleQuery.dao.BaseDaoImpl;

@Service("studentDao")
public class StudentDaoImpl extends BaseDaoImpl<Student, Integer> implements StudentDao {

	@Override
	public List<Student> simple(String name) {
		StudentCon con = new StudentCon();
		con.setName(name);
		return simpleQuery(con);
	}

	@Override
	public void saveqq(Student student) {
		getHibernateTemplate().save(student);
		
	}
	
}
