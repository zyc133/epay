package epay.base.lock;

public class A{

	private volatile Integer age;
	
	private String  name;

	
	public synchronized void add() throws InterruptedException{
		age--;
		System.out.println("--age-等于"+age);
//		Thread.sleep(5000);
	}


	public A(Integer age, String name) {
		super();
		this.age = age;
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
