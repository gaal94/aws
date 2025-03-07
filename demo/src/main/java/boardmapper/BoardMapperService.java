package boardmapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardMapperService implements BoardService {
	@Autowired
	BoardMapper mapper;
	
	@Override
	public String registerBoard(BoardDTO dto) {
		int result = mapper.insertBoard(dto);
		if(result == 1) return "글쓰기 성공";
		else return "글쓰기 실패";
	}

	@Override
	public List<BoardDTO> pagingList(int pagenum) {
		int cnt = 3;
		int start = (pagenum - 1) * cnt + 1;
		int end = pagenum * cnt;
		int array[] = {start, end};
		return mapper.pagingList(array);
	}

	@Override
	public int totalCount() {
		return mapper.totalCount();
	}

	@Override
	public BoardDTO updateViewcountAndGetDetail(int seq) {
		mapper.updateViewcount(seq);
		return mapper.getDetail(seq);
	}

	@Override
	public int deleteBoard(int seq) {
		return mapper.deleteBoard(seq);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		return mapper.updateBoard(dto);
	}
	
}
