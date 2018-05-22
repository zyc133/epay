package pattern.publish.example2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: abstractPublish 
 * @Description: 订阅模式 -抽象主题
 * @author:zhangyc
 * @date: 2018年5月13日 下午9:40:11
 */
public abstract class abstractPublish {
	
	protected List<ISubScribe> subList=new ArrayList<ISubScribe>();
	
	public void addSub(ISubScribe sub){
		subList.add(sub);
	}
	
	public void removeSub(ISubScribe sub){
		subList.remove(sub);
	}
	
	public abstract void notifySub();
}
