package test.spring.mvc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberDTO {
	
	//field
	private String id;
	private String passwd;
	private String name;
	private String jumin1;
	private String jumin2;
	private String email;
	private String blog;
	private String img;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date reg_date;
	
	private int status; 

}
