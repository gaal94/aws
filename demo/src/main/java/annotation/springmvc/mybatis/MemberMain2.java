package annotation.springmvc.mybatis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain2 {


	public static void main(String[] args) throws IOException, SQLException {
	
		ApplicationContext factory = new ClassPathXmlApplicationContext
				("spring/mybatis/spring-mybatis.xml");
		
		MemberService service = factory.getBean("memberServiceImpl", MemberService.class);
		
		System.out.println("===회원리스트===");
		List<MemberDTO> list = service.memberList();
		for(MemberDTO dto : list) {
			System.out.println(dto.getId() +":" + dto.getName() + ":" + dto.getEmail());
		}
		System.out.println("총회원수 = " + list.get( list.size()-1 ).getPw());
		
		/*
		System.out.println("===1명의 회원정보===");
		MemberDTO dto1 = service.oneMember("jdbc1");
		System.out.println(dto1.getId()+":"+dto1.getName());
		
		MemberDTO dto2 = new MemberDTO();
		dto2.setId("mybatis4");
		dto2.setName("박길동");
		dto2.setPw(4444);
		dto2.setPhone("010-1111-2222");
		dto2.setEmail("mybatis4@multi.com");
		
		String result = service.registerMember(dto2); 
		System.out.println("가입결과=" + result);
		
		MemberDTO dto3 = new MemberDTO();
		dto3.setId("mybatis4");
		dto3.setPw(44444);
		dto3.setPhone("010-2222-2222");
		dto3.setEmail("mybatis444@multi.com");
		
		String result2 = service.modifyMember(dto3);
		System.out.println("수정결과=" + result2);
		
		String result3 = service.deleteMember("mybatis4");
		System.out.println("탈퇴결과=" + result3);
		*/
		/*List<MemberDTO> list = service.memberList("12");
		for(MemberDTO dto : list) {
			System.out.println(dto.getId() + ":" + dto.getName() + ":" + dto.getRegdate());
		}
		//12월에 가입한 회원 조회
		//호출한 결과를 리턴받아 출력
		//12월에 가입한 회원의 아이디, 이름, 가입일 출력
		//MemberServie, MemberServieImpl, MemberDAO, sql-mapping.xml 
		*/
		
		/*//페이징처리
		//2페이지일 때, 3개씩
		ArrayList<Integer> mypage = new ArrayList();
		mypage.add(4);
		mypage.add(6);
		
		List<MemberDTO> paginglist = service.memberPagingList(mypage);
		for(MemberDTO dto : paginglist) {
			System.out.println
			(dto.getId() + ":" + dto.getName() + ":" + dto.getRegdate());
		}*/
		
		/*//검색을 위해 map 전송
		HashMap<String, String> map = new HashMap();
		//map.put("colname", "id");
		//map.put("colvalue", "jdbc%");
		
		//map.put("colname", "name");
		//map.put("colvalue", "김%");
		
		//map.put("colname", "email");
		//map.put("colvalue", "%multi%");
		
		map.put("colname", "regdate");
		map.put("colvalue", "___01%");
		
		List<MemberDTO> searchlist = service.memberSearchList(map);
		for(MemberDTO dto : searchlist) {
			System.out.println
			(dto.getId() + ":" + dto.getName() + ":" + ":" + dto.getEmail() + ":" + dto.getRegdate());
		}*/
		
		/*MemberDTO dto = new MemberDTO();
		//dto.setId("jdbc");
		dto.setName("%한국%");
		dto.setEmail("%park%");
         //NAME, EMAIL, PHONE -- NULL
		List<MemberDTO> searchlist2 = service.memberSearchList(dto);
		for(MemberDTO dto2 : searchlist2) {
			System.out.println
			(dto2.getId() + ":" + dto2.getName() + ":" + ":" + dto2.getEmail() + ":" 
			+ dto2.getPhone() + ":" + dto2.getRegdate());
		}*/	
		
		/*MemberDTO dto = new MemberDTO();
		dto.setId("jdbc1");
		dto.setPw(11111);
		MemberDTO resultdto = session.selectOne("totalsql", dto) ;
		System.out.println
		(resultdto.getId() + ":" + resultdto.getName() + ":" + ":" + resultdto.getEmail() + ":" 
		+ resultdto.getPhone() + ":" + resultdto.getRegdate());
		*/
	}

}











