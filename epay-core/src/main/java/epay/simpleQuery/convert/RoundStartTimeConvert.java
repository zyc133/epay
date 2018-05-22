package epay.simpleQuery.convert;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * 对齐到起始日期的格式化类
 * @author Administrator
 *
 */
public class RoundStartTimeConvert implements CondPropertiesConvertor {

	@Override
	public Object convert(Object condProperty) {
		if(!(condProperty instanceof java.util.Date) ){
			throw new RuntimeException("不支持的日期类型");
		}
		return epay.simpleQuery.convert.DateUtils.roundDate((java.util.Date)condProperty, Calendar.DATE);
	}

}
