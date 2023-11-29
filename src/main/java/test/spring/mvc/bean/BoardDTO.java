package test.spring.mvc.bean;
import java.util.Date;

import lombok.Data;
@Data
public class BoardDTO {
	private int num;
	private String writer;
	private String subject;
	private String email;
	private String content;
	private String passwd;
	private Date reg_date;
	private int readcount;
	private String ip;
	private int ref;
	private int re_step;
	private int re_level;
	private int isfile;
}


