package test.spring.mvc;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import test.spring.mvc.bean.SampleDTO;

@Controller
@RequestMapping("/1120/*")
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("main.do")
	public String main(SampleDTO dto, @RequestParam("name") String a, @RequestParam("number") int b, Model model, HttpSession session) {
		
//		String name = request.getParameter("name");
//		String number = request.getParameter("number");
		
		model.addAttribute("dto", dto);
		
		logger.info("parameter > name ===== "+dto.getName());
		logger.info("parameter > number ===== "+dto.getNumber());
		logger.info("parameter > name ===== "+a);
		logger.info("parameter > number ===== "+b);
		
		return "1120/main";
	}
	
	@RequestMapping("form.do")
	public String test() {
		return "1120/form";
	}
	
	@RequestMapping("form2.do")
	public String test2() {
		return "1120/form2";
	}
	
	@RequestMapping("main2.do")
	//public String main2(@RequestParam("name") ArrayList<String> names) {
	public String main2(@RequestParam("name") String[] names) {
		logger.info("parameter list =====> "+names);
		logger.info("parameter list =====> "+names[0]);
		logger.info("parameter list =====> "+names[1]);
		
		return "1120/main2";
	}
	/*
	@RequestMapping("test.do")
	public @ResponseBody String test2() {
		//리턴문(String변수)자체를 출력
		return "1120/form";
	}
	*/
	
	@RequestMapping("main3.do")
	public String main3(Model model,
						@ModelAttribute("name") String name,
						@ModelAttribute("number") int number) {
		model.addAttribute("name", name);
		
		return "1120/main";
	}
	
	@RequestMapping("main4.do")
	public void main4() {
			
	}
	
	@RequestMapping("test.do")
	public String main5(RedirectAttributes rttr) {
		rttr.addFlashAttribute("msg", "ㅋㅋ장혜지 멍청이ㅋㅋㅋ");	//한번 보내면 해당 파라미터는 다시 이용할 수 없음(새로고침시 사라짐)
		
		return "redirect:/1120/test2.do";
	}
	
	@RequestMapping("test2.do")
	public String main6(RedirectAttributes rttr) {		
		return "1120/main";
	}
	
	@RequestMapping("upload.do")
	public @ResponseBody String upload(MultipartFile save) {
		String fileName = save.getOriginalFilename(); //파일명
		long size = save.getSize();	//파일 크기
		return "name : "+fileName+", size : "+size;
	}
}
	