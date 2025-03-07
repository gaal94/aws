package boardmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardMapper {
	int insertBoard(BoardDTO dto);
	List<BoardDTO> pagingList(int[] array);
	int totalCount();
	int updateViewcount(int seq);
	BoardDTO getDetail(int seq);
	int deleteBoard(int seq);
	int updateBoard(BoardDTO dto);
}
