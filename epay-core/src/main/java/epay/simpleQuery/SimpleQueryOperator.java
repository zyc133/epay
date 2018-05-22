package epay.simpleQuery;

import java.util.Collection;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/** 
 * @Description: Operator转为criteria
 * @author: zhangyc
 * @date: 2017年9月21日 上午10:50:43  
 */
public class SimpleQueryOperator {

	public static boolean opera(DetachedCriteria criteria, QueryColumCond queryColumCond) {
		if(prepare(criteria,queryColumCond)==false) 
			return true;
		switch(queryColumCond.getOper()){
			case EQ:
				criteria.add(Restrictions.eq(queryColumCond.getPersistProperties(), queryColumCond.getValue()));
				break;
			case LT:
				criteria.add(Restrictions.lt(queryColumCond.getPersistProperties(), queryColumCond.getValue()));
				break;
			case LE:
				criteria.add(Restrictions.le(queryColumCond.getPersistProperties(), queryColumCond.getValue()));
				break;
			case GE:
				criteria.add(Restrictions.ge(queryColumCond.getPersistProperties(), queryColumCond.getValue()));
				break;
			case GT:
				criteria.add(Restrictions.gt(queryColumCond.getPersistProperties(), queryColumCond.getValue()));
				break;
			case IN:
				Object value=queryColumCond.getValue();
				if(value instanceof Object[]){
					criteria.add(Restrictions.in(queryColumCond.getPersistProperties(), (Object[])value));
					break;
				}
				if(value instanceof Collection<?>){
					criteria.add(Restrictions.in(queryColumCond.getPersistProperties(), (Collection<?>)value));
					break;
				}
				break;
			case LIKE:
				criteria.add(Restrictions.like(queryColumCond.getPersistProperties(), "%"+queryColumCond.getValue().toString()+"%", MatchMode.EXACT));
				break;
			default:
				throw new RuntimeException("can support operator .."+queryColumCond.getOper()+"..");
		}
		return true;
	}

	/** 
	 * 值为空时候处理。有格式化类时候处理
	 * @param criteria
	 * @param queryColumCond
	 * @return: void
	 */
	private static boolean prepare(DetachedCriteria criteria, QueryColumCond queryColumCond) {
		Object value = queryColumCond.getValue();
		if(null==value){
			if(queryColumCond.getWhenAbsentIsNull()==true){
				criteria.add(Restrictions.isNull(queryColumCond.getPersistProperties()));
			}
			return false;
		}
		
		if(queryColumCond.getConvertor()!=null){
			value=queryColumCond.getConvertor().convert(value);
			queryColumCond.setValue(value);
		}
		return true;
		
	}
	
}
