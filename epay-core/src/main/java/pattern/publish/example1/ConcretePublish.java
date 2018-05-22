package pattern.publish.example1;

import java.util.ArrayList;
import java.util.List;

public class ConcretePublish  implements PublishService{

	
	private List<SubScribe> subList=new ArrayList<SubScribe>();

	@Override
	public void addSub(SubScribe sub) {
		subList.add(sub);
	}

	@Override
	public void deleteSub(SubScribe sub) {
		subList.remove(sub);
	}

	@Override
	public void sendMessage(String msg) {
		if(null!=subList&&subList.size()>0){
			for (SubScribe subScribe : subList) {
				subScribe.update(msg);
			}
		}
		
	}
	
	
}
