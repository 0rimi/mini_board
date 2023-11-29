package test.spring.mvc.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.bean.BoardFileDTO;

public interface BoardService {	
	
	public int deleteNum(int num , String passwd, String path);
	
	public String readPasswd(int num);
	public int updateNum(BoardDTO dto);
	
	public BoardDTO update(int num);
	public BoardDTO readContent(int num);
	public int count();
	public void list(int pageNum , Model model);
	public void create(BoardDTO dto);
	public int fileUpload(ArrayList<MultipartFile> files, String path);
	
	public List<String> getFiles(int num);
	public int deleteFile(String fDirectory, int num);
	public void deleteRealFile(String fDirectory, int postNum);
	
	public List<BoardFileDTO> fileList(int freeboardnum);
}
