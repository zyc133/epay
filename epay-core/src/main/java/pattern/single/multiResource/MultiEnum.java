package pattern.single.multiResource;

import java.util.HashMap;

import org.apache.commons.lang.math.RandomUtils;

import pattern.single.SingleResouce;

/**
 * 
 * @ClassName: MultiEnum
 * @Description: 单例模式扩展，类的实例有3个
 * @author:zhangyc
 * @date: 2018年5月13日 下午2:49:22
 */
public enum MultiEnum {
	instance0("0"), instance1("1"), instance2("2");
	
	private String index;
	
	private SingleResouce singleResouce;
	
	
	public static HashMap<String, MultiEnum> maps=new HashMap<String, MultiEnum>();
	
	
	static {
		MultiEnum[] values = MultiEnum.values();
		for (MultiEnum multiEnum : values) {
			maps.put(multiEnum.getIndex(), multiEnum);
		}
	}
	private MultiEnum(String index) {
		this.index = index;
		singleResouce=new SingleResouce();
		
	}

	private String getIndex() {
		return index;
	}

	private SingleResouce getSingleResouce() {
		return singleResouce;
	}
	/**
	 * 
	 * @Title: getResouce 
	 * @Description: 对外提供获取实例的方法
	 * @return: SingleResouce
	 */
	public  static SingleResouce getResouce() {
		String keys=RandomUtils.nextInt(3)+"";
		return MultiEnum.maps.get(keys).getSingleResouce();
	}

}
