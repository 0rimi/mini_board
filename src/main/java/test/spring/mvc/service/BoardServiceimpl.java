package test.spring.mvc.service;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import test.spring.mvc.bean.BoardDTO;
import test.spring.mvc.bean.BoardFileDTO;
import test.spring.mvc.repository.BoardMapper;

@Service
public class BoardServiceimpl implements BoardService{
	@Autowired
	private BoardMapper mapper;

	@Autowired
	private HashMap boardMap;
	
	@Override
	public int count() {
		return mapper.count();
	}

	@Override
	public void list(int pageNum , Model model) {
		int pageSize = 10;
	    int startRow = (pageNum - 1) * pageSize + 1;
	    int endRow = pageNum * pageSize;
	    int count = mapper.count();
	    List<BoardDTO> list = Collections.EMPTY_LIST;
	    if(count > 0) {
	    	boardMap.put("start", startRow);
		    boardMap.put("end", endRow);	
		    list = mapper.list(boardMap);
	    }    
	    model.addAttribute("list",list);
	    model.addAttribute("count",count);
	    model.addAttribute("pageNum",pageNum);
	    model.addAttribute("pageSize",pageSize);
	  
	    //page
	    int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
		 
        int startPage = (int)(pageNum/10)*10+1;
		int pageBlock=10;
        int endPage = startPage + pageBlock-1;
        if (endPage > pageCount) {
			endPage = pageCount;
        }				
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("startPage",startPage);
        model.addAttribute("pageBlock",pageBlock);
        model.addAttribute("endPage",endPage);
	}

	@Override
	public void create(BoardDTO dto) {
		int number = mapper.maxNum()+1;
		if(dto.getNum() != 0) {
			mapper.writeUpdate(dto);
			dto.setRe_step(dto.getRe_step()+1);
			dto.setRe_level(dto.getRe_level()+1);
		}else {
			dto.setRef(number);
		}
		mapper.writeInsert(dto);
	}


	@Override
	public BoardDTO readContent(int num) {
		mapper.updateCountUp(num);
		return mapper.readNum(num);
	}

	@Override
	public BoardDTO update(int num) {
		return mapper.readNum(num);
	}

	@Override
	public String readPasswd(int num) {
		return mapper.readPasswd(num);
	}

	@Override
	public int updateNum(BoardDTO dto) {
		String dbpw = readPasswd(dto.getNum());
		int result = 0;
		if(dbpw.equals(dto.getPasswd())) {
			result = mapper.updateNum(dto);
		}
		return result; 
	}

	@Override
	public int deleteNum(int num , String passwd, String path) {
		String dbpw = readPasswd(num);
		int result = 0;
		if(dbpw.equals(passwd)) {
			List<BoardFileDTO> fileList = mapper.fileList(num);
			if(fileList != null) {
				for(BoardFileDTO fileDTO : fileList) {
					File f = new File(path+fileDTO.getFileName());
					if(f.isFile()) {	//file이맞으면 true
						f.delete();
					}
				}
			}
			mapper.deleteFile(num);
			result = mapper.deleteNum(num);
		}
		return result; 
	}

	@Override
	public int fileUpload(ArrayList<MultipartFile> files, String path) {
		int result = 0;
		int freeboardNum = mapper.maxNum();
		
		for(int i=0; i<files.size(); i++) {
			MultipartFile f = files.get(i);
			String fileName = f.getOriginalFilename();
			if(!fileName.equals("")) {	//공백체크(공백이 아닐때만)
				String ext = fileName.substring(fileName.lastIndexOf("."));
				fileName="file_"+freeboardNum+"_"+i+ext;
				File copy = new File(path+fileName);
				result += mapper.fileInsert(freeboardNum,fileName);
				try {
					f.transferTo(copy);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public List<String> getFiles(int num) {
		return mapper.getFiles(num);
	}

	@Override
	public int deleteFile(String fDirectory, int num) {
		//_file DB삭제
		int result = mapper.deleteFile(num);
		//isfile 0으로 만들기
		mapper.set0isFile(num);
		
		if(result != 0) {
			deleteRealFile(fDirectory, num);
		}
		return result;
	}

	@Override
	public void deleteRealFile(String fDirectory, int postNum) {
		//이미지경로 내 파일 추출
		File dir = new File(fDirectory);
		
		//파일 이름에 해당 포스트 넘버가 붙은것들만 필터링
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File f, String name) {
				return name.contains("_"+postNum);
			}
		};
		String[] filenames = dir.list(filter);
		for (String filename : filenames) {
			File file = new File(fDirectory+filename);
			file.delete();
		}
	}

	@Override
	public List<BoardFileDTO> fileList(int freeboardnum) {
		return mapper.fileList(freeboardnum);
	}
}












