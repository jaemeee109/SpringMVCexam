-- 시퀀스 객체 생성
create sequence seq2_board;
-- 시퀀스 삭제 (차후에 활용)
drop sequence seq2_board;

create table table_board(
	bno number(10,0), -- 게시글 번호 (시퀀스)
	title varchar2(200) not null, -- 게시글 타이틀
	content varchar2(2000) not null, -- 게시글 내용
	writer varchar2(50) not null, -- 게시글 작성자 (차후에 member와 연동)
	regdate date default sysdate, -- 게시글 작성일 (자동으로 DB날짜 입력됨)
	updatedate date default sysdate -- 게시글 수정일 (자동으로 DB알짜 입력됨)
); -- board 테이블 생성



alter table table_board add constraint pk_board primary key (bno);
-- tbl_board 구조변경(수정) 기본키를 bno로 지정함

-- 더미데이터 입력하기
insert into TABLE_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목A','테스트내용A','userA')
insert into TABLE_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목B','테스트내용B','userB')
insert into TABLE_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목C','테스트내용C','userC')
insert into TABLE_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목D','테스트내용D','userD')
insert into TABLE_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목E','테스트내용E','userE')
insert into TABLE_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목F','테스트내용F','userF')
insert into TABLE_BOARD (bno, title, content, writer) values (seq_board.nextval,'테스트제목G','테스트내용G','userG')

select*from table_board;

