package pattern.single.singleResource;

import java.util.concurrent.Callable;

import pattern.single.SingleResouce;

public class SingelTask implements Callable<SingleResouce> {

	@Override
	public SingleResouce call() throws Exception {
		return SingleEnum.getResource();
	}

}
