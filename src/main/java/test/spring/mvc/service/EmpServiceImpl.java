package test.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mvc.repository.EmpMapper;

@Service("empService")
public class EmpServiceImpl implements CrudService{
	
	@Autowired
	private EmpMapper mapper;

	@Override
	public List<Object> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int create(Object dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> readNo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
