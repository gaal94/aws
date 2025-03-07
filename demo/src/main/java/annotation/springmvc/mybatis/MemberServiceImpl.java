package annotation.springmvc.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO dao;
	
	//public void setDao(MemberDAO dao) {
	//	this.dao = dao;
	//}
	
	@Override
	public List<MemberDTO> memberList() {//총회원리스트
		//int count = dao.memberCount();//총회원수 
		//MemberDTO dto = new MemberDTO();
		//dto.setPw(count);
		List<MemberDTO> list = dao.memberList();
		//list.add(dto);//회원리스트 마지막 MemberDTO.pw 총회원수 추가
		return list;
	}

	@Override
	public MemberDTO oneMember(String id) {
		return dao.oneMember(id);
	}

	@Override
	public String registerMember(MemberDTO dto) {
		MemberDTO db_dto = dao.oneMember(dto.getId());
		// dto.getId : db 이미 존재-select
		if(db_dto != null) {
			return "아이디 중복 - 회원 가입 불가능합니다.";
		}
		else {
			dao.insertMember(dto);
			return "정상적으로 회원 가입되었습니다.";
		}
	}

	@Override
	public String modifyMember(MemberDTO dto) {
		MemberDTO db_dto = dao.oneMember(dto.getId());
		if(db_dto == null) {
			return "수정할 회원 정보가 없습니다.";
		}
		else {
			dao.updateMember(dto);
			return "정상적으로 회원 정보 수정되었습니다.";
		}
	}

	@Override
	public String deleteMember(String id) {
		MemberDTO db_dto = dao.oneMember(id);
		if(db_dto == null) {
			return "삭제할 회원 정보가 없습니다.";
		}
		else {
			dao.deleteMember(id);
			return "정상적으로 회원 탈퇴되었습니다.";
		}
	}

	@Override
	public List<MemberDTO> memberList(String month) {
		return dao.month(month);
	}

	@Override
	public List<MemberDTO> memberPagingList(ArrayList list) {
       return dao.memberPagingList(list);
	}

	@Override
	public List<MemberDTO> memberSearchList(HashMap map) {
		return dao.memberSearchList(map);
	}

	@Override
	public List<MemberDTO> memberSearchList(MemberDTO dto) {
		return dao.memberSearchList(dto);
	}

	@Override
	public int memberCount() {
		return dao.memberCount();
	}
 
	
	
}





