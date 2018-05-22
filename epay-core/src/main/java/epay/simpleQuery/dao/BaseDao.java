package epay.simpleQuery.dao;

import java.io.Serializable;
import java.util.List;

import epay.simpleQuery.SimpleQueryCond;


/** 
 * @Description: TODO
 * @author: zhangyc
 * @date: 2017年7月31日 下午4:57:02 
 * @param <T>
 * @param <ID> 
 */
public interface BaseDao <T,ID extends Serializable>{
	/** 
	 * @Description: 根据主键查询
	 * @param id
	 * @return
	 * @return: T
	 */
	public T findById(ID id);	
	
	public List<T> findAll();
	
	public T save(T entity);
	
	public T update(T entity);
	
	public void delete(T entity);
	
	public void deleleById(ID id);
	
	public T saveOrUpdate(T entity);
	
	public List<T> simpleQuery( SimpleQueryCond<? extends T>   cond);
	
 }
