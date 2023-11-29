package test.spring.mvc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import test.spring.mvc.bean.MemberDTO;

public interface MemberMapper {
	
	public int loginCheck(MemberDTO dto); //id가 메서드이름
	
	public MemberDTO member(String id);	
	
	public void memberUpdate(MemberDTO dto);
	
	public int statusChange(@Param("id") String id,
							@Param("passwd") String passwd);
	
	public List<MemberDTO> memberList();
	public int statusAdminChange(MemberDTO dto);
	public int imgChange(@Param("img")String img,@Param("id") String id);
}
