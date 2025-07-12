package org.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.exam.domain.BoardVO;

public interface BoardMapper {
	
	@Select("SELECT * FROM table_board WHERE bno > 0 ")
	public List<BoardVO> getList(); 
	//   어노테이션으로 간단한 쿼리문은 가능, 복잡한 쿼리문은 버그생김
	//   그래서  xml이용해서  sql 처리 진행
	public List<BoardVO> getList2();
	// xml 이용 쿼리 처리 매퍼용 메서드
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete (Long bno);
	
	public int update (BoardVO board);

} //인터페이스 종료
