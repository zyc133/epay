package epay.base.model;

import javax.persistence.Column;

import org.apache.commons.lang.StringUtils;

import epay.simpleQuery.AbstractSimpleQueryCond;
import epay.simpleQuery.OperaTorType;
import epay.simpleQuery.IOrder;
import epay.simpleQuery.OrderSet;
import epay.simpleQuery.OrderType;
import epay.simpleQuery.SimpleQuery;

@OrderSet(orders={
				  @IOrder(index=2,properties="age", type = OrderType.ASC),
				  @IOrder(index=10,properties="grade,id", type = OrderType.DESC)})
public class StudentCon extends AbstractSimpleQueryCond<Student> {

	private String name;
	
	private String age;

	@SimpleQuery(propertie="name",index=1,operaTorType=OperaTorType.LIKE)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
