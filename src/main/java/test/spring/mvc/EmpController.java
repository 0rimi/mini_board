package test.spring.mvc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.spring.mvc.bean.EmpDTO;
import test.spring.mvc.service.CrudService;

@Controller
@RequestMapping("/emp/*")
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private CrudService empService;
	@Autowired
	private CrudService freeService;
	
	@RequestMapping("read.do")
	public String read(Model model) {
		
		List<Object> empList = empService.read();
		logger.info("mybatis=====>"+empList);
		model.addAttribute("empList", empList);
		
		List<Integer> empnoList = empService.readNo();
		model.addAttribute("empnoList",empnoList);
		
		return "emp/read";
	}
	
	@RequestMapping("insert.do")
	public @ResponseBody String insert(Model model, EmpDTO dto) {
		int r = empService.create(dto);
		logger.info("emp insert=====>"+r);
		return r+" successed";
	}
	
	@RequestMapping("form.do")
	public String form() {
		return "emp/form";
	}
	
}
