package annotation.springmvc.ajax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import annotation.springmvc.memberservice.MemberDTO;

@Controller
public class AjaxController {
	@GetMapping("/nonajaxlogin")
	public String nonajaxlogin() {
		return "ajax/login";
	}
	@PostMapping("/nonajaxlogin")
	public ModelAndView nonajaxlogin(String id, int pw) {
		ModelAndView mv = new ModelAndView();
		//id = ajax, pw = 1111 이면 로그인 성공 아니면 로그인 실패
		if(id.equals("ajax") && pw == 1111) {
			mv.addObject("loginresult", "로그인 성공");
		}
		else {
			mv.addObject("loginresult", "로그인 실패");
		}
		mv.setViewName("ajax/loginresult");
		return mv;
	}
	
	@RequestMapping(value="/ajaxlogin", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public String ajaxlogin(String id, int pw) {
		String result = null;
		if(id.equals("ajax") && pw == 1111) {
			//json형식을 가진 String 
			// "{\"  \" : \" \",  }"
			result = "{\"loginresult\":\"로그인 성공\"}";
		}
		else {
			result = "{\"loginresult\":\"로그인 실패\"}";
		}
		return result;
	}
	
	@RequestMapping(value="/ajaxmyinform", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public MemberDTO ajaxmyinform(String id, int pw) {
		MemberDTO dto = new MemberDTO();
		if(id.equals("ajax") && pw == 1111) {
			dto.setId(id);
			dto.setPw(pw);
			dto.setName("박정보");
			dto.setEmail("park@a.com");
			dto.setPhone("010-1111-1111");
			dto.setRegdate("2025-01-07");
		}
		else {
			dto.setId(id);
			dto.setPw(pw);
		}

		return dto;
	}	

	@RequestMapping(value="/ajaxlist", produces = {"application/json;charset=utf-8"})
	
	public @ResponseBody ArrayList<MemberDTO> ajaxlist(String id, int pw) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		if(id.equals("admin") && pw == 1111) {
			for(int i = 1; i <= 5; i++ ) {
				MemberDTO dto = new MemberDTO();
				dto.setId("ajax" + i); 
				dto.setPw(i * 1000); 
				dto.setName("홍길동" + i);
				dto.setPhone("010-1234-456" + i);
				dto.setEmail("hong" + i + "@gil.dong");
				dto.setRegdate("2025-01-07");
				list.add(dto);
			}
		}
		return list;
	}	

	@PostMapping(value="/ajaxupload", produces = {"application/json;charset=utf-8"})
	public @ResponseBody String ajaxupload(String detail, MultipartFile uploadfile)
	throws IOException {
		System.out.println(detail);
		System.out.println(uploadfile);
		String savePath ="c:/ezwel/upload/";
		String newFilename1 = null;
		if(!uploadfile.isEmpty()) {
		String originalname1 = uploadfile.getOriginalFilename();
		String beforeext1 = originalname1.substring(0, originalname1.indexOf("."));//pom
		String ext1 = originalname1.substring(originalname1.indexOf("."));//xml
		newFilename1 = beforeext1 + "(" + UUID.randomUUID().toString() +  ")" +  ext1;
		uploadfile.transferTo(new File(savePath +  newFilename1));
		}//if end
		
		return "{\"uploadresult\":\"" + detail + " 설명에 해당하는 파일을 서버에 저장했습니다\" }";
	}	

	@RequestMapping(value="/ajaxrole/{id}", produces = {"application/json;charset=utf-8"})
	public @ResponseBody String ajaxrole(@PathVariable("id") String id){
		//admin, user, blacklist
		HashMap<String, String> map = new HashMap();
		map.put("spring", "blacklist");
		map.put("admin", "admin");
		map.put("test","user");
		if(map.containsKey(id)) return "{\"role\": \"" +  map.get(id) + "\"}";
		else return "{\"role\": \"모름\"}";
		
	}	
	
	
	
}



