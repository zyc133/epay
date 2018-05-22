package pattern.publish.example1;

public class Main {
	public static void main(String[] args) {
		ConcretePublish publish = new ConcretePublish();
		
		new ConcreteSub("1", publish);
		new ConcreteSub("2", publish);
		new ConcreteSub("3", publish);
		new ConcreteSub("4", publish);
		new ConcreteSub("5", publish);
		publish.sendMessage("ssssssssss");
	}
}
