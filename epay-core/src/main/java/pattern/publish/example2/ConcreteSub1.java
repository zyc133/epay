package pattern.publish.example2;

public class ConcreteSub1 implements ISubScribe {
	
	private String job;

	@Override
	public void update(WaterQualifyPublish subject) {
		System.out.println("订阅者职务--："+job+"-已经接收到了状态"+subject.getStatus());
	}

	@Override
	public void setJob(String job) {
		this.job=job;
	}

	@Override
	public String getJob() {
		return job;
	}

}
