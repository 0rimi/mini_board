package test.spring.mvc.repository;

import java.util.List;

import test.spring.mvc.bean.EmpDTO;

public interface EmpMapper {
	
	public List<EmpDTO> all();
	
	public List<Integer> allEmpno();
	
	public int insertEmp(EmpDTO dto);
	
}
