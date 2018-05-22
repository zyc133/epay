package epay.simpleQuery;

import java.util.Collection;
import java.util.Set;

public interface SimpleQueryCond<T> {

	int DEFAULT_MAX_SIZE=2000;
	

	

	/** 
	 * 初始化上下文
	 * @return: void
	 */
	public void initContext();
	
	/**
	 * 
	 * @Description: 获得所运行的对象类型
	 * @return
	 * @return: Class<T>
	 */
	public Class<T> getEntityClass();
	
	
	/** 
	 * @Description: get查询条件类表
	 * @return
	 * @return: Set<QueryColumCond>
	 */
	public Set<QueryColumCond> getQueryColumConds();
	
	/** 
	 * @Description: 清空条件列表
	 * @return: void
	 */
	public void clearOrders();
	
	public Collection<OrderCond> getOrdersConds();
	
	public void addOrder(OrderCond order);
	
	public int getMaxSize();
	
	public void setMaxSize(int size);
}
