package org.exam.mapper;

import org.exam.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		
		mapper.getList().forEach(board->log.info(board));
	}//testGetList 종료
	
	@Test
	public void testInsert() {
		
		BoardVO board = new BoardVO();
		log.info("============================");
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newUser");
		log.info("============================");
		mapper.insert(board);
		log.info(board);
		
	} //testInsert 종료
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글  select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newUser");
		
		mapper.insertSelectKey(board);
		log.info(board);
		
	} //testInsertSelectKey종료
	
	@Test
	public void testRead() {
		// 존재하는 게시물 번호로 테스트
		BoardVO board = mapper.read(21L);
		log.info(board);
	}// testRead 종료
	
	@Test
	public void testDelete() {
		log.info("삭제 번호: " + mapper.delete(22L));
	}//testDelete 종료
	
	@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		//  실행 전 존재하는 번호인지 확인 할 것
		board.setBno(21L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("업데이트 번호: " +count);
	}
	

} // class종료
