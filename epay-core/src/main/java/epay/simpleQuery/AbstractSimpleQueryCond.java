package epay.simpleQuery;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import epay.simpleQuery.convert.CondPropertiesConvertor;

public class AbstractSimpleQueryCond<T> implements Serializable, SimpleQueryCond<T> {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	private Set<QueryColumCond> queryConds;
	
	private Collection<OrderCond> orderConds;
	
	private Class<T> entyClass;
	
	private int maxSize;
	
	@SuppressWarnings("unchecked")
	public AbstractSimpleQueryCond() {
		this.entyClass=(Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.maxSize=DEFAULT_MAX_SIZE;
	}

	@Override
	public void initContext() {
		initQueryColumCond();
	}
	
	public void initOrder() {
		orderConds=new ArrayList<OrderCond>();
		OrderSet orderSet=(OrderSet)getClass().getAnnotation(OrderSet.class);
		if(null!=orderSet){
			IOrder[] orders = orderSet.orders();
			if(null!=orders&&orders.length!=0){
				for (IOrder order : orders) {
					setOrder(order);
				}
			}
		}
	}

	private void setOrder(IOrder order) {
		String properties = order.properties();
		if(!properties.trim().equals("")){
			String[] st = properties.split(",");
			if(st!=null&&st.length!=0){
				for (int i = 0; i < st.length; i++) {
					String string = st[i];
					orderConds.add(new OrderCond(string, order.type(), +order.index()));
				}
			}
		}
		
	}

	/** 
	 * 初始化查询条件临时保存对象
	 * @return: void
	 */
	private void initQueryColumCond() {
		queryConds=new TreeSet<QueryColumCond>();
		Method[] methods = getClass().getMethods();
		for (Method method : methods) {
			if(null==method){
				continue;
			}
			process(method);
		}
	}

	/** 
	 * 
	 * @param method
	 * @return: void
	 */
	private void process(Method method) {
		SimpleQuery annotation = method.getAnnotation(SimpleQuery.class);
		if(null==annotation) return;
		QueryColumCond cond = new QueryColumCond();
		cond.setWhenAbsentIsNull(annotation.absentWhenNull());
		if(annotation.convertClass()!=null&&annotation.convertClass().trim().equals("")==false){
			try {
				cond.setConvertor((CondPropertiesConvertor)Class.forName(annotation.convertClass()).newInstance());
			} catch (Throwable e) {
				logger.error("SimpleQuery使用反射发生错误..", e);
				throw new RuntimeException(e);
			}
		}
		cond.setPersistProperties(annotation.propertie());
		cond.setIndex(annotation.index());
		cond.setOper(annotation.operaTorType());
		Object value=null;
		try {
			value = method.invoke(this);
		} catch (Throwable e) {
			logger.error("",e);
			throw new RuntimeException(e);
		} 
		if(null!=value){
			cond.setValue(value);
		}
		addQueryCond(cond);
	}

	private void addQueryCond(QueryColumCond cond) {
		if(cond.getIndex()<0){
			cond.setIndex(queryConds.size()+999999);
		}
		this.queryConds.add(cond);
	}

	@Override
	public Class<T> getEntityClass() {
		return entyClass;
	}

	@Override
	public Set<QueryColumCond> getQueryColumConds() {
		return queryConds;
	}

	@Override
	public int getMaxSize() {
		return maxSize;
	}

	@Override
	public void setMaxSize(int size) {
		this.maxSize=size;
	}

	public Set<QueryColumCond> getQueryCond() {
		return queryConds;
	}

	public Class<T> getEntyClass() {
		return entyClass;
	}

	@Override
	public void clearOrders() {
		orderConds.clear();
		
	}

	@Override
	public void addOrder(OrderCond order) {
		orderConds.add(order);
	}

	@Override
	public Collection<OrderCond> getOrdersConds() {
		initOrder();
		return orderConds;
	}
}
