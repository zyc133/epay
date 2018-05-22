package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import epay.activemq.service.ProducerService;
import epay.base.dao.EmpDao;
import epay.base.model.Emp;
import epay.base.model.EmpCon;

public class EmpTest extends BaseTest {

	@Autowired
	private EmpDao EmpDao;
	
	@Test
	@Transactional
	public void test() throws ParseException{
		EmpCon empCon = new EmpCon();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date begin = simpleDateFormat.parse("1981-02-21");
//		empCon.setCurrentTime(begin);
		Date end = simpleDateFormat.parse("1981-02-21");
		empCon.setBeginTime(begin);
		empCon.setEndTime(end);
		List<Emp> simpleQuery = EmpDao.simpleQuery(empCon);
		for (Emp emp : simpleQuery) {
			System.err.println("员工数据"+emp.toString());
		}
	}
}
