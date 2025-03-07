package annotation.springmvc.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pointservice")
public class MemberPointService implements MemberService {
	
	@Autowired	
	MemberDAO dao;
	
	@Autowired
	PointDAO dao2;
		
	public MemberPointService() {
		System.out.println("MemberPointService 객체 생성");
	}
	
	public MemberDAO getDao() {
		return dao;
	}

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	public PointDAO getDao2() {
		return dao2;
	}


	public void setDao2(PointDAO dao2) {
		this.dao2 = dao2;
	}


	@Override
	public void registerMember() {
		boolean b = dao.selectMember();
		if(b == false) { 
			dao.insertMember();
			//dao2.setPoint(1000);// xml태그 설정 <property name="point" value="1000"
		}
		
	}
	
	@Override
	public String registerMember(MemberDTO dto) {
		boolean b = dao.selectMember(dto);
		if(b == false) { 
			dao.insertMember(dto);
			dao2.setPoint(1000);// xml태그 설정 <property name="point" value="1000"
			return dao2.getPoint() + " 포인트 받고 회원가잆되셨습니다.";
		} else {
			return "이미 존재하는 회원아이디입니다.";
		}
		
	}
}
