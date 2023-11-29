package test.spring.mvc.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component("downView")	//<bean id="downView" ... 
public class FileDownloadView extends AbstractView{
	
	public FileDownloadView() {
		setContentType("application/download;charset=UTF-8");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		File file = (File)model.get("downFile");
		response.setCharacterEncoding(getContentType());
		response.setContentLength((int)file.length());
		
		String fileName = URLEncoder.encode(file.getName(),"UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=\'"+fileName+"\';");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();	//브라우저에 해당하는 output 연결
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(fis!=null) {try {fis.close();}catch(Exception e2){} }
		}
		out.flush();
		
		
	}

}
