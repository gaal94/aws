package annotation.springmvc.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberServiceController {
	@Autowired
	@Qualifier("basicservice")
	MemberService basicservice;
	
	@Autowired
	@Qualifier("pointservice")
	MemberService pointservice;
	
	@GetMapping("/memberservice")
	public String memberservice() {
		return "memberservice";
	}
	
	@PostMapping("/memberservice")
	public ModelAndView memberserviceresult(MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		String month = dto.getRegdate().split("-")[1];
		String result = "";
		if(month.equals("01") || month.equals("06") || month.equals("12")) {
			result = pointservice.registerMember(dto);
		} else {
			result = basicservice.registerMember(dto);
		}
		
		mv.addObject("result", result);
		mv.setViewName("memberserviceresult");
		return mv;
	}
}
