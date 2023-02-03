insert into user_tb(username, password, email, created_at) values('ssar', '1234', 'ssar@nate.com', now());
insert into user_tb(username, password, email, created_at) values('cos', '1234', 'cos@nate.com', now());
insert into user_tb(username, password, email, created_at) values('love', '1234', 'love@nate.com', now());

insert into board_tb(title, content, userId, created_at) values('제목1번', '내용1번', 1, now());
insert into board_tb(title, content, userId, created_at) values('제목2번', '내용2번', 1, now());
insert into board_tb(title, content, userId, created_at) values('제목3번', '내용3번', 1, now());
insert into board_tb(title, content, userId, created_at) values('제목4번', '내용4번', 2, now());
insert into board_tb(title, content, userId, created_at) values('제목5번', '내용5번', 2, now());
insert into board_tb(title, content, userId, created_at) values('제목6번', '내용6번', 2, now());

commit;