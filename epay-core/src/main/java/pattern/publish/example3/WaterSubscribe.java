package pattern.publish.example3;

import java.util.Observable;
import java.util.Observer;

public class WaterSubscribe implements Observer {

	private String job;
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("订阅者职务--："+job+"-已经接收到了状态"+((WaterPublish)o).getStatus());
	
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
