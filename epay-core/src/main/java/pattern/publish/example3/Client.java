package pattern.publish.example3;

import pattern.publish.example2.ConcreteSub1;

public class Client {
	public static void main(String[] args) {
		// 创建水质主题对象
		WaterPublish subject = new WaterPublish();
		
		WaterSubscribe watcher1 = new WaterSubscribe();
		watcher1.setJob("监测人员");
		WaterSubscribe watcher2 = new WaterSubscribe();
		watcher2.setJob("预警人员");
		WaterSubscribe watcher3 = new WaterSubscribe();
		watcher3.setJob("监测部门领导");
		
		subject.addObserver(watcher3);
		subject.addObserver(watcher2);
		subject.addObserver(watcher1);
		
		subject.setStatus(1);
	}
	
}
