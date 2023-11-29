package test.spring.mvc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.bean.BoardFileDTO;
import test.spring.mvc.service.BoardService;

@Controller
@RequestMapping("/free/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService service;

	@RequestMapping("list")
	public String list(Model model, @RequestParam(value="pageNum", defaultValue="1") int pageNum) {
		service.list(pageNum , model);
		return "board/list";
	}
	
	@RequestMapping("writeForm")
	public String writeForm(Model model,
			@RequestParam(value="num",defaultValue="0") int num,
			@RequestParam(value="ref",defaultValue="1") int ref,
			@RequestParam(value="re_step",defaultValue="0") int re_step,
			@RequestParam(value="re_level",defaultValue="0") int re_level) {
		model.addAttribute("num",num);
		model.addAttribute("ref",ref);
		model.addAttribute("re_step",re_step);
		model.addAttribute("re_level",re_level);
		return "board/writeForm";
	}
	
	@RequestMapping("writePro")
	public String writePro(BoardDTO dto , HttpServletRequest request,
			ArrayList<MultipartFile> files) {

		//파일 업로드
		int isfile = 0, result = 0;
		for(MultipartFile f : files) {
			if(!f.getOriginalFilename().equals("")) {	//공백체크(공백이 아닐때만)
				isfile++;
			}
		}
		
		//게시글 저장
		dto.setIsfile(isfile);
		dto.setIp(request.getRemoteAddr());
		service.create(dto);
		
		if(isfile > 0) {
			String filePath = request.getServletContext().getRealPath("/resources/file/board/");
			result = service.fileUpload(files, filePath);
		}
		
		return "redirect:/free/list";
	}
	
	@RequestMapping("content")
	public String content(Model model, int num, int pageNum) {
		BoardDTO article = service.readContent(num);
		
		List<BoardFileDTO> fileList = null;
		if(article.getIsfile() > 0) {
			fileList = service.fileList(num);
		}
		
		model.addAttribute("fileList",fileList);
		model.addAttribute("article",article);
		model.addAttribute("pageNum",pageNum);
		
		/*num 주면 파일이름 리스트 주는 메소드
		List<String> fList = new ArrayList<>(); 
		fList = service.getFiles(num); 
		model.addAttribute("fList",fList);
		*/
		
		return "board/content";
	}
	
	@RequestMapping("updateForm")
	public String updateForm(Model model, int num, int pageNum) {
		
		BoardDTO article = service.update(num);
		
		model.addAttribute("article",article);
		model.addAttribute("pageNum",pageNum);
		
		return "board/updateForm";
	}
	
	@RequestMapping("deleteForm")
	public String deleteForm(Model model, int num, int pageNum) {

		model.addAttribute("num",num);
		model.addAttribute("pageNum",pageNum);
		
		return "board/deleteForm";
	}
	@RequestMapping("deletePro")
	public String deletePro(HttpServletRequest request,Model model, int num,String passwd, int pageNum) {
		//첨부파일 삭제,DB삭제, 글삭제
		String filePath = request.getServletContext().getRealPath("/resources/file/board/"); 
		
		//글삭제
		int check = service.deleteNum(num, passwd,filePath);
		
		model.addAttribute("check",check);
		model.addAttribute("pageNum",pageNum);
		
		/*삭제할 포스트넘버 입력 후 파일 및 DB삭제
		String fDirectory = request.getServletContext().getRealPath("/resources/file/board/");
		int result = service.deleteFile(fDirectory,num);	//0이면 삭제실패
		*/
		
		return "board/deletePro";
	}
	
	@RequestMapping("download")
	public ModelAndView download(String filename, HttpServletRequest request) {
		
		String filePath = request.getServletContext().getRealPath("/resources/file/board/");
		File file = new File(filePath+filename);
		//mv : 뷰를 바꿀수 있음
		//세팅해놓은 페이지 실행				//컴포넌트페이지이름,	 key값,	실제파일
		ModelAndView mv = new ModelAndView("downView","downFile",file);
		
		return mv;
	}
}

