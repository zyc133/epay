package epay.base.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class S {
	public static void main(String[] args) {
		SegmentLock<A> segmentLock = new SegmentLock<>();
		// segmentLock.lock(a);
		// a.add();
		ExecutorService c = Executors.newFixedThreadPool(20);
		A a1 = new A(5, "a1");
		A a2 = new A(0, "a2");
		Thread2 myThread = new Thread2(a1);
		Thread t1 = new Thread(myThread, "t1");
		Thread t2 = new Thread(myThread, "t2");
		Thread t3 = new Thread(myThread, "t3");
		Thread t4 = new Thread(myThread, "t4");
		Thread t5 = new Thread(myThread, "t5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
//		for (int i = 0; i < 5; i++) {
//			try {
//				c.execute(new Thread1(a1, segmentLock));
//
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		c.shutdown();
		// while(true){}

	}
}
