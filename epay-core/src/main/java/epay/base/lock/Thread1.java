package epay.base.lock;

import java.util.concurrent.Callable;

public class Thread1 implements Runnable {

	private A a;

	private SegmentLock segmentLock;

	public Thread1(A a, SegmentLock segmentLock) {
		super();
		this.a = a;
		this.segmentLock = segmentLock;
	}

	@Override
	public void run() {

		try {
			segmentLock.lock(a);
			a.add();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			segmentLock.unlock(a);
		}
	}

}
