package pattern.single;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang.math.RandomUtils;

import com.sun.istack.internal.Pool;

import pattern.single.multiResource.MultiEnum;
import pattern.single.singleResource.SingleEnum;

public class Main {

	public static void main(String[] args) throws Exception {
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
//			SingleResouce singleResouce = pool.submit(new MultiTask()).get(10, TimeUnit.SECONDS);
//			System.out.println(singleResouce.hashCode());
			System.out.println("单例"+SingleEnum.getResource().hashCode());
			System.out.println("多例"+MultiEnum.getResouce().hashCode());
			System.out.println("多例"+MultiEnum.getResouce().hashCode());
		}
		pool.shutdown();
	}
	
}
