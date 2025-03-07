package annotation.springmvc.memberservice;

public interface MemberService {
	public abstract void registerMember();
	
	public abstract String registerMember(MemberDTO dto);
}
