package epay.base.lock;

import java.util.concurrent.Callable;

public class Thread2 implements Runnable {
	
	private A a;

	
	

	public Thread2(A a) {
		super();
		this.a = a;
	}


	@Override
	public void run() {
		try {
			a.add();
//			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
