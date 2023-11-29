package test.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.MemberDTO;
import test.spring.mvc.service.MemberService;

@Controller
@RequestMapping("/user/*")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("main.me")
	public String main() {
		return "member/main";
	}
	
	@RequestMapping("loginPro.me")
	public String loginPro(Model model, MemberDTO dto) {
		//�α���
		int check = service.loginCheck(dto);
		//���������
		model.addAttribute("check", check);
		return "member/loginPro";
	}
	
	@RequestMapping("logout.me")
	public String logout(HttpSession session){
		//session.invalidate();	��ü����
		session.removeAttribute("memId");
		return "redirect:/user/main.me";
	}
	
	@RequestMapping("modify.me")
	public String modify(MemberDTO member, HttpSession session, Model model){
		//���� �޾ƿ���
		member = service.getUser((String)session.getAttribute("memId"));
		model.addAttribute("member", member);
		return "member/modify";
	}
	
	@RequestMapping("modifyForm.me")
	public String modifyForm(MemberDTO member, HttpSession session, Model model){
		//���� �޾ƿ���
		member = service.getUser((String)session.getAttribute("memId"));
		model.addAttribute("member", member);
		return "member/modifyForm";
	}
	
	@RequestMapping("modifyPro.me")
	public String modifyPro(MemberDTO member, HttpSession session, Model model){
		//���� �����ϱ�
		String id = (String)session.getAttribute("memId");
		member.setId(id);
		service.userUpdate(member);
		return "member/modifyPro";
	}
	
	@RequestMapping("deleteForm.me")
	public String deleteForm(){
		return "member/deleteForm";
	}
	
	@RequestMapping("deletePro.me")
	public String deletePro(Model model, String passwd, HttpSession session){
		String id = (String)session.getAttribute("memId");
		int check = service.userDelete(id, passwd);
		if(check == 1) {
			session.invalidate();	//�α׾ƿ��� ����
		}
		model.addAttribute("check",check);
		return "member/deletePro";
	}
	
	@RequestMapping("userList.me")
	public String userList(Model model) {
		model.addAttribute("list" ,service.userAll());	
		return "member/memberList";
	}
	
	@RequestMapping("statusChange.me")
	public String statusChange(MemberDTO dto) {
		service.statusChange(dto);
		return "redirect:/user/userList.me";
	}
	
	@RequestMapping("imgForm.me")
	public String imgForm() {
		return "member/imgForm";
	}
	
	@RequestMapping("imgPro.me")		// ������ü
	public String imgPro(Model model, MultipartFile img,
					HttpSession session,HttpServletRequest request) {
		
		String filePath = request.getServletContext().getRealPath("/resources/file/");
		//System.out.println("getServeltContext : "+request.getServletContext());	org.apache.catalina.core.ApplicationContextFacade@39b5a29
		
		String id = (String) session.getAttribute("memId");
		boolean result = service.imgChange(filePath, id, img);
		model.addAttribute("result", result);
		
		return "member/imgPro";
	}
	
	
}
