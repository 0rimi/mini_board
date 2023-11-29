package test.spring.mvc.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.MemberDTO;
import test.spring.mvc.repository.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public int loginCheck(MemberDTO dto) {
		return mapper.loginCheck(dto);
	}

	@Override
	public void userInput(MemberDTO dto) {
		
	}

	@Override
	public MemberDTO getUser(String id) {
		MemberDTO dto = mapper.member(id);
		return dto;
	}

	@Override
	public void userUpdate(MemberDTO dto) {
		mapper.memberUpdate(dto);
	}

	@Override
	public int userDelete(String id, String passwd) {
		return mapper.statusChange(id, passwd);
	}

	@Override
	public List<MemberDTO> userAll() {
		return mapper.memberList();
	}

	@Override
	public int statusChange(MemberDTO dto) {
		return mapper.statusAdminChange(dto);
	}

	@Override
	public boolean imgChange(String path, String id, MultipartFile img) {
		String contentType = img.getContentType();	// ex)image/jpeg
		boolean result = typeCheck("image", contentType);
		
		if(result) {
			String fileName = fileUpload(path, id, img);
			//mapper 호출
			mapper.imgChange(fileName, id);
		}
		
		return result;
	}
	
	//파일 업로드
	public String fileUpload(String path, String id, MultipartFile img) {
		String orgName = img.getOriginalFilename();	//ex)profile.png
		String ext = orgName.substring(orgName.lastIndexOf("."));	//ex).png : .부터끝까지
		String fileName = id+ext;
		
		File copy = new File(path+fileName);	// ex) D://..../resources/img/yh0808.png
		System.out.println(copy);
		
		//copy.isFile();	//파일이면 true
		try {
			img.transferTo(copy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	//파일타입 확인 메서드
	public boolean typeCheck(String checkType, String fileType) {	
		boolean result = false;
		if(checkType.equals(fileType.split("/")[0])) {
			result = true;
		}	
		return result;
	}
}
