package DAO;

import java.util.ArrayList;

public interface DAOInteface<T> {

	public int insert(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public ArrayList<T> selecAll();
	
	public T selectById(T t);
	
	public ArrayList<T> selectByCondition(String condition);
	
	
	
}
