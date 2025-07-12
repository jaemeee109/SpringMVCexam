package org.exam.service;

import java.util.List;

import org.exam.domain.BoardVO;
import org.exam.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper; //db 쿼리용 객체
	
	
	@Override
	public void register(BoardVO board) {
		
		log.info("BoardServiceImpl.register 메서드 실행" );
		mapper.insertSelectKey(board);
		mapper.getList2();
		
	} // register종료

	@Override
	public BoardVO get(Long bno) {
		log.info("get..." + bno);
		return mapper.read(bno);
	} // get 종료

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify..." + board);
		
		return mapper.update(board)==1;
	} // modify 종료

	@Override
	public boolean remove(Long bno) {
		log.info("remove..." + bno);
		return mapper.delete(bno)==1;
	} // remove 종료

	@Override
	public List<BoardVO> getList() {

		log.info("getList..");
		
		return mapper.getList();
	} // getList 종료

} // class종료
