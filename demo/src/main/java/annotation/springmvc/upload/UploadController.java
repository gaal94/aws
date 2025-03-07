package annotation.springmvc.upload;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	@GetMapping("/fileupload")
	public String uploadForm() {
		return "upload/uploadform";
	}
	
	@PostMapping("/fileupload")
	public ModelAndView uploadResult(UploadDTO dto) throws IOException {
		String savePath = "c:/ezwel/upload/";
		String newfilename1 = null, newfilename2 = null;
		MultipartFile file1 = dto.getF1();
		if(!file1.isEmpty()) {
			String originalfilename1 = file1.getOriginalFilename();
			String before1 = originalfilename1.substring(0, originalfilename1.indexOf(","));
			String ext1 = originalfilename1.substring(originalfilename1.indexOf(","));
			newfilename1 = before1 + "(" + UUID.randomUUID() + ")" + ext1;
			file1.transferTo(new java.io.File(savePath + newfilename1));
		}
		MultipartFile file2 = dto.getF2();
		if(!file2.isEmpty()) {
			String originalfilename2 = file2.getOriginalFilename();
			String before2 = originalfilename2.substring(0, originalfilename2.indexOf(","));
			String ext2 = originalfilename2.substring(originalfilename2.indexOf(","));
			newfilename2 = before2 + "(" + UUID.randomUUID() + ")" + ext2;
			file2.transferTo(new java.io.File(savePath + newfilename2));
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("uploadresult1", savePath + " 경로에 " + newfilename1 + " 이름으로 저장했습니다.");
		mv.addObject("uploadresult2", savePath + " 경로에 " + newfilename2 + " 이름으로 저장했습니다.");
		mv.setViewName("upload/uploadresult");
		return mv;
	}
}
