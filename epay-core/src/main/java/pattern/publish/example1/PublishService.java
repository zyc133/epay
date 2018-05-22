package pattern.publish.example1;


/** 
 * @ClassName: PublishService 
 * @Description: 主题 可供订阅
 * @author:zhangyc
 * @date: 2018年5月13日 下午6:05:53  
 */
public interface PublishService {
	
	void addSub(SubScribe sub);
	
	void deleteSub(SubScribe sub);
	
	void sendMessage(String msg);
	
}
