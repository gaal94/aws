package boardmapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardmembermapperservice")
public class MemberMapperServiceImpl implements MemberService{
	@Autowired
	MemberMapper mapper;
	
	@Override
	public MemberDTO oneMember(String id) {
		return mapper.oneMember(id);
	}
}





