package annotation.springmvc.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {
	public List<MemberDTO> memberList();
	public MemberDTO oneMember(String id);
	public int memberCount();
	public int insertMemberDTO(MemberDTO dto);
	public int updateMember(MemberDTO dto);
	public int deleteMember(String id);
	
	public List<MemberDTO> month(String month);
	public List<MemberDTO> memberPagingList(ArrayList list);
	public List<MemberDTO> memberSearchList(HashMap map);
	public List<MemberDTO> memberSearchList2(MemberDTO dto);
}








