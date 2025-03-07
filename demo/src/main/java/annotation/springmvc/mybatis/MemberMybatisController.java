package annotation.springmvc.mybatis;

import java.util.HashMap;
import java.util.List;

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
//sql-mapping.xml (insert, update, delete, 1명회원조회, 페이징처리리스트, 검색어리스트	
	@Autowired
	@Qualifier("memberMapperServiceImpl")
	MemberService memberservice;
	
	@RequestMapping("/membermybatislist")
	public ModelAndView memberlist() {
		ModelAndView mv = new ModelAndView();

		List<MemberDTO> list = memberservice.memberList();//마지막회원 암호=총회원수저장
		int membercount = memberservice.memberCount();
		mv.addObject("memberlist", list);
		mv.addObject("membercount", membercount);
		
		mv.setViewName("mybatis/memberlist");
	
		return mv;
	}
	
	@RequestMapping("/membersearchlist")
	public ModelAndView membersearchlist(String item, String searchword) {
		HashMap<String, String> map = new HashMap();
		MemberDTO dto = new MemberDTO();
		if(item.contains("이름")){
			dto.setName(searchword);
		    map.put("colname", "name");
		}
		else if(item.contains("폰번호")){
			dto.setPhone(searchword);
		    map.put("colname", "phone");
		}
		else if(item.contains("이메일")){
			dto.setEmail(searchword);
		    map.put("colname", "email");
		}	
		else if(item.contains("아이디")){
			dto.setId(searchword);
		    map.put("colname", "id");
		}
		map.put("colvalue", "%"+searchword+"%");
		
		//List<MemberDTO> memberlist = memberservice.memberSearchList(map);
		List<MemberDTO> memberlist = memberservice.memberSearchList(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	
	@GetMapping("/login")
	public String loginform() {
		return "mybatis/loginform";
	}
	
	@PostMapping("/login")
	public ModelAndView login(String id, int pw, HttpSession session) {
		MemberDTO dto = memberservice.oneMember(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mybatis/loginform");
		if(dto.getPw() == pw) {
			session.setAttribute("sessionid", id); 
			mv.setViewName("mybatis/start");
		}
		return mv;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("sessionid");
		return "mybatis/start";
	}
}










