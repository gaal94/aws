package annotation.springmvc.ajax;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import annotation.springmvc.memberservice.MemberDTO;

@Controller
public class AjaxAdminController {
	ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
	
	@RequestMapping("/ajaxadminstart")
	public String start() {
		return "ajax/admin";
	}
	
	@RequestMapping(value="/ajaxlist2", produces = {"application/json;charset=utf-8"})
	public @ResponseBody ArrayList<MemberDTO> ajaxlist(String id, int pw) {
		if(id.equals("admin") && pw == 1111) {
			for(int i = 1; i <= 10; i++) {
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
	
	@ResponseBody
	@RequestMapping(value="/getpw/{id}", produces= {"application/json;charset=utf-8"})
	String getpw(@PathVariable("id") String id) {
		for(MemberDTO dto : list) {
			if(id.equals(dto.getId())) return "{\"pw\" : \"" + Integer.toString(dto.getPw()).substring(0, 2) + "*".repeat(Integer.toString(dto.getPw()).length() - 2) + "\"}"; 
		}
		return "{\"pw\" : \"해당 아이디 없음\"}";
	}
}
