package test.spring.mvc.bean;

import lombok.Data;

@Data	//lombok »ç¿ë
public class EmpDTO {
	
	//field
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;

}
