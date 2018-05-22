package pattern.publish.example3;

import java.util.Observable;
import java.util.Observer;

import pattern.publish.example2.ISubScribe;

public class WaterPublish extends Observable {
	
	private Integer status;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
		//注意在用Java中的Observer模式的时候，这句话不可少
		this.setChanged();
		this.notifyObservers();
	}
}
