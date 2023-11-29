package test.spring.mvc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.MemberDTO;

public interface MemberService {
	
	//로그인체크
	public int loginCheck(MemberDTO dto);
	//회원가입
	public void userInput(MemberDTO dto);
	//유저1명 정보
	public MemberDTO getUser(String id);
	//회원정보수정
	public void userUpdate(MemberDTO dto);
	//회원탈퇴
	public int userDelete(String id, String passwd);
	
	public List<MemberDTO> userAll();
	public int statusChange(MemberDTO dto);
	
	//프로필 수정
	public boolean imgChange(String path, String id, MultipartFile img);
}
