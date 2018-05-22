package epay.simpleQuery;

import java.io.Serializable;

import epay.simpleQuery.convert.CondPropertiesConvertor;

/** 
 * @Description: 查询条件临时保存对象
 * @author: zhangyc
 * @date: 2017年9月20日 上午11:14:28  
 */
public class QueryColumCond implements Serializable,Comparable<QueryColumCond> {

	/**
	 * @fieldName: 属性名称
	 * @fieldType: String
	 */
	private String persistProperties;
	
	/**
	 * @fieldName: 序列
	 * @fieldType: int
	 */
	private int index;
	
	
	/**
	 * @fieldName: 值为空时候是否加条件null
	 * @fieldType: Boolean
	 */
	private Boolean whenAbsentIsNull;
	
	/**
	 * @fieldName: 操作对象属性
	 * @fieldType: OperaTorType
	 */
	private OperaTorType oper;
	
	/**
	 * @fieldName: 值对象
	 * @fieldType: Object
	 */
	private Object value;
	
	private CondPropertiesConvertor convertor;
	
	@Override
	public int compareTo(QueryColumCond o) {
		return this.index-o.index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getPersistProperties() {
		return persistProperties;
	}

	public void setPersistProperties(String persistProperties) {
		this.persistProperties = persistProperties;
	}

	public Boolean getWhenAbsentIsNull() {
		return whenAbsentIsNull;
	}

	public void setWhenAbsentIsNull(Boolean whenAbsentIsNull) {
		this.whenAbsentIsNull = whenAbsentIsNull;
	}

	public OperaTorType getOper() {
		return oper;
	}

	public void setOper(OperaTorType oper) {
		this.oper = oper;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public CondPropertiesConvertor getConvertor() {
		return convertor;
	}

	public void setConvertor(CondPropertiesConvertor convertor) {
		this.convertor = convertor;
	}
}
