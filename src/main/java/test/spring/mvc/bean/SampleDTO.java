package test.spring.mvc.bean;

import java.util.Date;

import lombok.Data;

//lombok(setget�ڵ�)
@Data
public class SampleDTO {
	
	//field
	private String name;
	private int number;
	private Date day;
	
}
