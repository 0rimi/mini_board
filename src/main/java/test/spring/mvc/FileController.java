package test.spring.mvc;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file/*")
public class FileController {
	
	@RequestMapping("uploadForm")
	public String uploadForm() {
		return "upload/uploadForm";
	}
	
	@RequestMapping("uploadPro")
	public String uploadPro(HttpServletRequest request, String writer, MultipartFile upload) {
		String filePath = request.getServletContext().getRealPath("/resources/file/");
		
		String contentType = upload.getContentType();
		//image/png
		if(contentType.split("/")[0].equals("images")) {
			String orgName=upload.getOriginalFilename();	//ex) test.png
			
			String ext = orgName.substring(orgName.lastIndexOf("."));	//가장 마지막 점의 위치(4),부터 자른다.
			
			File copy = new File(filePath+writer+ext);
				
			try {
				upload.transferTo(copy);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "upload/uploadPro";
	}
	
	@RequestMapping("uploadPro2")
	public String uploadPro2(String writer , ArrayList<MultipartFile> upload) {
		// 람다식
		upload.forEach(f -> {
			String filePath = "d://file//";
			String orgName = f.getOriginalFilename();
			File copy = new File(filePath+orgName);
			try {
				f.transferTo(copy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return "upload/uploadPro";
	}
}










