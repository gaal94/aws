package boardmapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class BoardMybatisController {
	@Autowired
	@Qualifier("boardMapperService")
	BoardService boardService;
	
	@RequestMapping("/")
	String start() {
		return "board/start";
	}
	
	@GetMapping("/boardwrite")
	String writeform() {
		return "board/writeform";
	}
	
	@PostMapping("/boardwrite")
	String writeprocess(BoardDTO dto) throws IOException {
		String savePath = "c:/ezwel/upload/";
		String newfilename1 = null;
		MultipartFile file1 = dto.getMultifile1();
		if(!file1.isEmpty()) {
			String originalfilename1 = file1.getOriginalFilename();
			String before1 = originalfilename1.substring(0, originalfilename1.indexOf(","));
			String ext1 = originalfilename1.substring(originalfilename1.indexOf(","));
			newfilename1 = before1 + "(" + UUID.randomUUID() + ")" + ext1;
			file1.transferTo(new java.io.File(savePath + newfilename1));
		}
		
		dto.setFile1(newfilename1);
		boardService.registerBoard(dto);
		return "board/start";
	}
	
	@RequestMapping("/boardlist")
	ModelAndView boardlist(@RequestParam(value = "pagenum", required = false, defaultValue = "1") int pagenum) {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> list = boardService.pagingList(pagenum);
		int total = boardService.totalCount();
		mv.addObject("boardlist", list);
		mv.addObject("total", total);
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping("/boarddetail")
	ModelAndView boarddetail(int seq) {
		ModelAndView mv = new ModelAndView();
		BoardDTO dto = boardService.updateViewcountAndGetDetail(seq);
		mv.addObject("detailboard", dto);
		mv.setViewName("board/boarddetail");
		return mv;
	}
	
	@RequestMapping("/boarddelete")
	@ResponseBody
	String boarddelete(int seq) {
		int rows = boardService.deleteBoard(seq);
		if(rows == 1) {
			return "{\"result\":\"삭제성공\"}";
		} else {
			return "{\"result\":\"삭제실패\"}";
		}
	}
	
	@RequestMapping("/boardupdate")
	@ResponseBody
	String boarddelete(BoardDTO dto) {
		int rows = boardService.updateBoard(dto);
		if(rows == 1) {
			return "{\"result\":\"수정성공\"}";
		} else {
			return "{\"result\":\"수정실패\"}";
		}
	}
	
	@GetMapping("/boarddownload")
	public void boarddownload(String filename, HttpServletResponse response) throws IOException {
		FileInputStream fin = new FileInputStream(new File("c:/ezwel/upload/" + filename));
		filename = new String(filename.getBytes("utf-8") , "iso-8859-1" );
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
		OutputStream out = response.getOutputStream();
		FileCopyUtils.copy(fin, out);
		fin.close();
		out.close();
	}
}
