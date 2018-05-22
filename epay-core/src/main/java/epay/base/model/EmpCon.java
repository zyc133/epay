package epay.base.model;

import java.util.Date;

import javax.persistence.Column;

import org.apache.commons.lang.StringUtils;

import epay.simpleQuery.AbstractSimpleQueryCond;
import epay.simpleQuery.OperaTorType;
import epay.simpleQuery.IOrder;
import epay.simpleQuery.OrderSet;
import epay.simpleQuery.OrderType;
import epay.simpleQuery.SimpleQuery;

@OrderSet(orders={
				  @IOrder(index=2,properties="hdate", type = OrderType.ASC),
				  @IOrder(index=10,properties="eno", type = OrderType.ASC)})
public class EmpCon extends AbstractSimpleQueryCond<Emp> {

	private Integer eno;
	
	private String ename;
	
	private Date beginTime;
	
	private Date endTime;
	
	private Date currentTime;

	@SimpleQuery(propertie="eno",index=1,operaTorType=OperaTorType.EQ)
	public Integer getEno() {
		return eno;
	}
	@SimpleQuery(propertie="ename",index=10,operaTorType=OperaTorType.LIKE)
	public String getEname() {
		return ename;
	}
	@SimpleQuery(propertie="hdate",index=12,operaTorType=OperaTorType.GE,convertClass="epay.simpleQuery.convert.RoundStartTimeConvert")
	public Date getBeginTime() {
		return beginTime;
	}
	
	@SimpleQuery(propertie="hdate",index=13,operaTorType=OperaTorType.LE,convertClass="epay.simpleQuery.convert.RoundEndTimeConvert")
	public Date getEndTime() {
		return endTime;
	}
	@SimpleQuery(propertie="hdate",index=11,operaTorType=OperaTorType.EQ)
	public Date getCurrentTime() {
		return currentTime;
	}
	

	public void setEno(Integer eno) {
		this.eno = eno;
	}

	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	
	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}
	
	
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
