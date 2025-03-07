package annotation.springmvc.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberMapperServiceImpl implements MemberService{
	@Autowired
	MemberMapper mapper;
	
	//public void setDao(MemberDAO dao) {
	//	this.dao = dao;
	//}
	
	@Override
	public List<MemberDTO> memberList() {
		List<MemberDTO> list = mapper.memberList();
		return list;
	}

	@Override
	public MemberDTO oneMember(String id) {
		return mapper.oneMember(id);
	}

	@Override
	public String registerMember(MemberDTO dto) {
		MemberDTO db_dto = mapper.oneMember(dto.getId());
		// dto.getId : db 이미 존재-select
		if(db_dto != null) {
			return "아이디 중복 - 회원 가입 불가능합니다.";
		}
		else {
			mapper.insertMemberDTO(dto);
			return "정상적으로 회원 가입되었습니다.";
		}
	}

	@Override
	public String modifyMember(MemberDTO dto) {
		MemberDTO db_dto = mapper.oneMember(dto.getId());
		if(db_dto == null) {
			return "수정할 회원 정보가 없습니다.";
		}
		else {
			mapper.updateMember(dto);
			return "정상적으로 회원 정보 수정되었습니다.";
		}
	}

	@Override
	public String deleteMember(String id) {
		MemberDTO db_dto = mapper.oneMember(id);
		if(db_dto == null) {
			return "삭제할 회원 정보가 없습니다.";
		}
		else {
			mapper.deleteMember(id);
			return "정상적으로 회원 탈퇴되었습니다.";
		}
	}

	@Override
	public List<MemberDTO> memberList(String month) {
		return mapper.month(month);
	}

	@Override
	public List<MemberDTO> memberPagingList(ArrayList list) {
       return mapper.memberPagingList(list);
	}

	@Override
	public List<MemberDTO> memberSearchList(HashMap map) {
		return mapper.memberSearchList(map);
	}

	@Override
	public List<MemberDTO> memberSearchList(MemberDTO dto) {
		return mapper.memberSearchList2(dto);
	}

	@Override
	public int memberCount() {
		return mapper.memberCount();
	}
 
	
	
}





