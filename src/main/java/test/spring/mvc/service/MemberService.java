package test.spring.mvc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.MemberDTO;

public interface MemberService {
	
	//�α���üũ
	public int loginCheck(MemberDTO dto);
	//ȸ������
	public void userInput(MemberDTO dto);
	//����1�� ����
	public MemberDTO getUser(String id);
	//ȸ����������
	public void userUpdate(MemberDTO dto);
	//ȸ��Ż��
	public int userDelete(String id, String passwd);
	
	public List<MemberDTO> userAll();
	public int statusChange(MemberDTO dto);
	
	//������ ����
	public boolean imgChange(String path, String id, MultipartFile img);
}
