package boardmapper;

import java.util.List;

public interface BoardService {
	String registerBoard(BoardDTO dto);
	List<BoardDTO> pagingList(int pagenum);
	int totalCount();
	BoardDTO updateViewcountAndGetDetail(int seq);
	int deleteBoard(int seq);
	int updateBoard(BoardDTO dto);
}
