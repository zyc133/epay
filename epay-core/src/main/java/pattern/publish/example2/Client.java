package pattern.publish.example2;

public class Client {

	public static void main(String[] args) {
		// 创建水质主题对象
		WaterQualifyPublish subject = new WaterQualifyPublish();
		// 创建几个观察者
		ConcreteSub1 watcher1 = new ConcreteSub1();
		watcher1.setJob("监测人员");
		ConcreteSub1 watcher2 = new ConcreteSub1();
		watcher2.setJob("预警人员");
		ConcreteSub1 watcher3 = new ConcreteSub1();
		watcher3.setJob("监测部门领导");
		// 注册观察者
		subject.addSub(watcher1);
		subject.addSub(watcher2);
		subject.addSub(watcher3);

		// 填写水质报告
		System.out.println("当水质为正常的时候------------------〉");
		subject.setStatus(0);
		System.out.println("当水质为轻度污染的时候---------------〉");
		subject.setStatus(1);
		System.out.println("当水质为中度污染的时候---------------〉");
		subject.setStatus(2);
	}

}
