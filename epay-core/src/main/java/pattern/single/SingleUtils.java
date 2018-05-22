package pattern.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import pattern.single.multiResource.MultiTask;
import pattern.single.singleResource.SingelTask;

public class SingleUtils {
	
	static ExecutorService pool = Executors.newFixedThreadPool(3);
	public static SingleResouce getSingleResourceByOne() throws Exception{
		return pool.submit(new SingelTask()).get(10, TimeUnit.SECONDS);
	}
	public static SingleResouce getSingleResourceByMore() throws Exception{
		return pool.submit(new MultiTask()).get(10, TimeUnit.SECONDS);
	}
}
