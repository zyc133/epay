package epay.simpleQuery;

import java.io.Serializable;

public class OrderCond implements Serializable,Comparable<OrderCond>{
	
	public String properties;
	
	public OrderType type;
	
	public int index;

	public OrderCond(String properties, OrderType type, int index) {
		this.properties = properties;
		this.type = type;
		this.index = index;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public int compareTo(OrderCond o) {
		return this.index-o.index;
	}
}
