package epay.simpleQuery.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.loader.custom.Return;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import epay.simpleQuery.OrderCond;
import epay.simpleQuery.OrderType;
import epay.simpleQuery.QueryColumCond;
import epay.simpleQuery.SimpleQueryCond;
import epay.simpleQuery.SimpleQueryOperator;
/**
 * @Description: TODO
 * @author: zhangyc
 * @date: 2017年7月31日 下午4:49:25
 * @param <T>
 * @param <ID>
 */
public abstract class BaseDaoImpl<T, ID extends Serializable> extends HibernateDaoSupport implements BaseDao<T, ID> {
	
	protected  static Logger logger =LoggerFactory.getLogger(BaseDaoImpl.class);
	
	private Class<T> entityClass;

	public BaseDaoImpl() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T findById(ID id) {
		Assert.notNull(id);
		return getHibernateTemplate().get(entityClass, id);
	}

	public Class<T> getEntittyClass() {
		return entityClass;
	}

	@Resource(name = "mySessionFactory")
	public void injectSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T save(T entity) {
		Assert.notNull(entity);
		getHibernateTemplate().save(entity);
		return entity;
	}

	@Override
	public  T update(T entity) {
		Assert.notNull(entity);
		getHibernateTemplate().update(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		Assert.notNull(entity);
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void deleleById(ID id) {
		Assert.notNull(id);
		T findById = findById(id);
		getHibernateTemplate().delete(findById);
	}

	@Override
	public T saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}
	
	@Override
	public List<T> simpleQuery( SimpleQueryCond<? extends T>   cond){
		DetachedCriteria dc=creatCriteria(cond);
		appendOrder(dc,cond);
		dc.setResultTransformer(Criteria.ROOT_ENTITY);
		return (List<T>) this.getHibernateTemplate().findByCriteria(dc, 0, cond.getMaxSize());
	}

	private void appendOrder(DetachedCriteria dc, SimpleQueryCond<? extends T> cond) {
		Collection<OrderCond> ordersConds = cond.getOrdersConds();
		Collections.sort((List<OrderCond>) ordersConds);
		if(null==ordersConds||ordersConds.size()==0){
			return;
		}
		for (OrderCond orderCond : ordersConds) {
			org.hibernate.criterion.Order order=null;
			if(orderCond.getType().equals(OrderType.ASC)){
				order=org.hibernate.criterion.Order.asc(orderCond.getProperties());
			}else{
				order=org.hibernate.criterion.Order.desc(orderCond.getProperties());
			}
			dc.addOrder(order);
		}
	}

	private DetachedCriteria creatCriteria(SimpleQueryCond<? extends T> cond) {
		cond.initContext();
		DetachedCriteria criteria = DetachedCriteria.forClass(cond.getEntityClass());
		Set<QueryColumCond> queryColumConds = cond.getQueryColumConds();
		
		//查询条件必须全部添加标志位operator
		Boolean isNoneOperator=true;
		for (QueryColumCond queryColumCond : queryColumConds) {
			if(SimpleQueryOperator.opera(criteria,queryColumCond)){
				if(isNoneOperator){
					isNoneOperator=false;
				}
			}
		}
		if(isNoneOperator){
			throw new RuntimeException("系统异常.where 查询条件不能为空");
		}
		
		return criteria;
	}
}
