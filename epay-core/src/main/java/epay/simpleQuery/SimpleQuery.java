package epay.simpleQuery;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.lang.model.element.Element;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface SimpleQuery {
	/** 
	 * @Description: 持久化对象属性
	 * @return: String
	 */
	public String propertie();
	/** 
	 * @Description: 持久化对象类名
	 * 如日期格式化
	 * @return: String
	 */
	 String convertClass() default "";
	/** 
	 * @Description: 值为空时候是否isNull
	 * @return: boolean
	 */
	boolean absentWhenNull() default false;
	/** 
	 * @Description: 操作类型
	 * @return: String
	 */
	public OperaTorType operaTorType();
	/** 
	 * @Description: 索引
	 * @return: int
	 */
	int index()default -1;
}
