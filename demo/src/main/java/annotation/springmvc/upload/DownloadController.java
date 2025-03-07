package annotation.springmvc.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {
	@RequestMapping("/filedowloadlist")
	ModelAndView downloadlist() {
		File f = new File("c:/ezwel/upload/");
		String[] filearray = f.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filearray", filearray);
		mv.setViewName("upload/downloadlist");
		return mv;
	}
	
	@GetMapping("/filedownloadresult")
	public void downloadresult(String filename, HttpServletResponse response) throws IOException {
		FileInputStream fin = new FileInputStream(new File("c:/ezwel/upload/" + filename));
		filename = new String(filename.getBytes("utf-8") , "iso-8859-1" );
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
		OutputStream out = response.getOutputStream();
		FileCopyUtils.copy(fin, out);
		fin.close();
		out.close();
	}
}
