package pattern.single.singleResource;

import pattern.single.SingleResouce;

/**
 * 
 * @ClassName: SingleEnum 
 * @Description: 单例模式enum，规定类的实例只有一个
 * @author:zhangyc
 * @date: 2018年5月13日 下午2:47:48
 */
public enum SingleEnum {
	data;
	private SingleResouce singleResource;
	
	SingleEnum(){
		singleResource=new SingleResouce();
		//something 初始化操作 
	}
	private SingleResouce getSingleResource() {
		return singleResource;
	}
	/**
	 * 
	 * @Title: getResouce 
	 * @Description: 对外提供获取实例的方法
	 * @return: SingleResouce
	 */
	public static SingleResouce getResource() {
		return SingleEnum.data.getResource();
	}
}
