package epay.base.service.Impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import epay.base.dao.StudentDao;
import epay.base.model.Student;
import epay.base.service.StudentService;
import epay.simpleQuery.dao.BaseDao;
@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource(name="studentDao")
	private StudentDao dao;
	
	@Override
	@Transactional
	public void save(Student stu) {
		System.out.println(UUID.randomUUID().toString()+"2222");
		dao.save(stu);
	}
}
