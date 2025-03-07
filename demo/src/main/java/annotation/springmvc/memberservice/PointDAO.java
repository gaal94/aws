package annotation.springmvc.memberservice;

import org.springframework.stereotype.Repository;

@Repository("dao2")
public class PointDAO {
	int point;
//회원들 포인트 관리 테이블 - point 테이블 select /insert,update
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
}
