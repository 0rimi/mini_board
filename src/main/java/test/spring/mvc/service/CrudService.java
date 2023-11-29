package test.spring.mvc.service;

import java.util.List;

public interface CrudService {
	
	public int create(Object dto);
	
	public List<Object> read();
	
	public void update(Object dto);
	
	public void delete(Object dto);

	public List<Integer> readNo();
	
}
