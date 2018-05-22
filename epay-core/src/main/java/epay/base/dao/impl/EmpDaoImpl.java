package epay.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import epay.base.dao.EmpDao;
import epay.base.model.Emp;
import epay.simpleQuery.SimpleQueryCond;
import epay.simpleQuery.dao.BaseDaoImpl;

@Service("empDaoImpl")
public class EmpDaoImpl extends BaseDaoImpl<Emp, Integer> implements EmpDao  {}
