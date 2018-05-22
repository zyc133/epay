package epay.simpleQuery;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @Description: 排序对象集合
 * @author: zhangyc
 * @date: 2017年9月21日 下午3:31:06  
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OrderSet {
	
	/** 
	 * 支持IOrder的多个属性的index相同 
	 * 即 index=10,properties="grade,id" 是有允许的。grade的index在前
	 * @return
	 * @return: IOrder[]
	 */
	IOrder[] orders();
}
