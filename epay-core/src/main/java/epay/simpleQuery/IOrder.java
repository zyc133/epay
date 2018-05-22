package epay.simpleQuery;

/** 
 * @Description: 排序
 * @author: zhangyc
 * @date: 2017年9月21日 下午3:37:00  
 */
public @interface IOrder {
	
	public String properties();
	
	public OrderType type();
	
	public int index();
}
