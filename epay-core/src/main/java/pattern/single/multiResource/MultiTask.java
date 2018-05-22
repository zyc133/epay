package pattern.single.multiResource;

import java.util.concurrent.Callable;

import pattern.single.SingleResouce;

public class MultiTask implements Callable<SingleResouce>{

	@Override
	public SingleResouce call() throws Exception {
		return MultiEnum.getResouce();
	}
}
