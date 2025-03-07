package boardmapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberMybatisController {	
	@Autowired
	@Qualifier("boardmembermapperservice")
	MemberService memberservice;
	
	@GetMapping("/boardlogin")
	public String loginform() {
		return "board/loginform";
	}
	
	@PostMapping("/boardlogin")
	public ModelAndView login(String id, int pw, HttpSession session) {
		MemberDTO dto = memberservice.oneMember(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mybatis/loginform");
		if(dto.getPw() == pw) {
			session.setAttribute("sessionid", id); 
			mv.setViewName("board/start");
		}
		return mv;
	}
	
	@RequestMapping("/boardlogout")
	public String logout(HttpSession session) {
		session.removeAttribute("sessionid");
		return "board/start";
	}
}










