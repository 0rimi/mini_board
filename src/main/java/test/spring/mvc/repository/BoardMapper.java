package test.spring.mvc.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.bean.BoardFileDTO;

public interface BoardMapper {
	
	public int deleteNum(int num);
	
	public String readPasswd(int num);
	public int updateNum(BoardDTO dto);
	
	public void updateCountUp(int num);
	public BoardDTO readNum(int num);
	
	public int count();
	public List<BoardDTO> list(HashMap map);
	
	public int maxNum();
	public void writeUpdate(BoardDTO dto);
	public void writeInsert(BoardDTO dto);
	
	public int fileInsert(@Param("freeboardnum") int freeboardnum,
						  @Param("fileName") String fileName);
	
	public List<String> getFiles(int freeboardnum);
	public int deleteFile(int freeboardnum);
	public void set0isFile(int num);
	
	public List<BoardFileDTO> fileList(int freeboardnum);
}



