package pattern.publish.example1;

public class ConcreteSub implements SubScribe {

	String name;
	
	PublishService publish;
	
	@Override
	public void update(String msg) {
		System.out.println("订阅者"+this.name+"订阅了"+msg);
	}
	public ConcreteSub(String name) {
		this.name = name;
	}
	public ConcreteSub(String name, PublishService publish) {
		this(publish);
		this.name=name;
	}
	public ConcreteSub(PublishService publish) {
		this.publish = publish;
		this.publish.addSub(this);
	}
}
