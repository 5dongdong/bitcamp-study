-- 게시판
DROP TABLE IF EXISTS TABLE RESTRICT;

-- 회원
DROP TABLE IF EXISTS member RESTRICT;

-- 입출금
DROP TABLE IF EXISTS Transaction RESTRICT;

-- 회원목록
DROP TABLE IF EXISTS TABLE4 RESTRICT;

-- 공지사항
DROP TABLE IF EXISTS Announcements RESTRICT;

-- 지출내역-외부
DROP TABLE IF EXISTS TABLE6 RESTRICT;

-- 댓글
DROP TABLE IF EXISTS Comments RESTRICT;

-- 주소
DROP TABLE IF EXISTS TABLE8 RESTRICT;

-- 은행
DROP TABLE IF EXISTS TABLE9 RESTRICT;

-- 카테고리
DROP TABLE IF EXISTS TABLE10 RESTRICT;

-- 자유게시판
DROP TABLE IF EXISTS CommunityPosts RESTRICT;

-- 지출내역공유 게시판
DROP TABLE IF EXISTS TABLE12 RESTRICT;

-- 입출금댓글
DROP TABLE IF EXISTS TransactionComments RESTRICT;


-- 회원
CREATE TABLE member (
  user_id         INTEGER      NOT NULL COMMENT '아이디', -- 아이디
  email           VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  nickname        VARCHAR(50)  NULL     COMMENT '닉네임', -- 닉네임
  name            VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  password        VARCHAR(255) NOT NULL COMMENT '비밀번호', -- 비밀번호
  postal_code     VARCHAR(255) NOT NULL COMMENT '우편번호', -- 우편번호
  address         VARCHAR(255) NOT NULL COMMENT '기본주소', -- 기본주소
  address_details VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
  gender          VARCHAR(10)  NOT NULL COMMENT '성별' -- 성별
)
COMMENT '회원';

-- 회원
ALTER TABLE member
  ADD CONSTRAINT PK_member -- 회원 기본키
  PRIMARY KEY (
  user_id -- 아이디
  );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_member
  ON member ( -- 회원
    email ASC -- 이메일
  );

-- 입출금
CREATE TABLE Transaction (
  expense_id       INTEGER     NOT NULL COMMENT '지출내역id', -- 지출내역id
  user_id          INTEGER     NOT NULL COMMENT '아이디', -- 아이디
  transaction_type VARCHAR(10) NULL     COMMENT '입/출금유형', -- 입/출금유형
  pprice           INTEGER     NULL     COMMENT '금액', -- 금액
  transaction_date DATETIME    NULL     COMMENT '날짜', -- 날짜
  contents         MEDIUMTEXT  NOT NULL COMMENT 'content' -- content
)
COMMENT '입출금';

-- 입출금
ALTER TABLE Transaction
  ADD CONSTRAINT PK_Transaction -- 입출금 기본키
  PRIMARY KEY (
  expense_id -- 지출내역id
  );


-- 공지사항
CREATE TABLE Announcements (
  notice_id  INTEGER      NOT NULL COMMENT '공지사항ID', -- 공지사항ID
  title      VARCHAR(255) NULL     COMMENT '제목', -- 제목
  contents   MEDIUMTEXT   NULL     COMMENT '내용', -- 내용
  created_at DATETIME     NULL     COMMENT '작성일자' -- 작성일자
)
COMMENT '공지사항';

-- 공지사항
ALTER TABLE Announcements
  ADD CONSTRAINT PK_Announcements -- 공지사항 기본키
  PRIMARY KEY (
  notice_id -- 공지사항ID
  );




-- 댓글
CREATE TABLE Comments (
  comment_id INTEGER    NOT NULL COMMENT '댓글ID', -- 댓글ID
  post_id    INTEGER    NULL     COMMENT '자유게시판ID', -- 자유게시판ID
  user_id    INTEGER    NULL     COMMENT '아이디', -- 아이디
  contents   MEDIUMTEXT NULL     COMMENT '내용', -- 내용
  created_at DATETIME   NULL     COMMENT '작성일시' -- 작성일시
)
COMMENT '댓글';

-- 댓글
ALTER TABLE Comments
  ADD CONSTRAINT PK_Comments -- 댓글 기본키
  PRIMARY KEY (
  comment_id -- 댓글ID
  );


-- 자유게시판
CREATE TABLE CommunityPosts (
  post_id    INTEGER      NOT NULL COMMENT '자유게시판ID', -- 자유게시판ID
  title      VARCHAR(255) NULL     COMMENT '제목', -- 제목
  content    MEDIUMTEXT   NULL     COMMENT '내용', -- 내용
  created_at DATETIME     NULL     COMMENT '작성일자', -- 작성일자
  view_count INTEGER      NULL     COMMENT '조회수', -- 조회수
  user_id    INTEGER      NULL     COMMENT '아이디' -- 아이디
)
COMMENT '자유게시판';

-- 자유게시판
ALTER TABLE CommunityPosts
  ADD CONSTRAINT PK_CommunityPosts -- 자유게시판 기본키
  PRIMARY KEY (
  post_id -- 자유게시판ID
  );


-- 입출금댓글
CREATE TABLE TransactionComments (
  user_id    INTEGER    NULL COMMENT '아이디', -- 아이디
  expense_id INTEGER    NULL COMMENT '지출내역id', -- 지출내역id
  contents   MEDIUMTEXT NULL COMMENT '내용', -- 내용
  created_at DATETIME   NULL COMMENT '작성일시' -- 작성일시
)
COMMENT '입출금댓글';

-- 입출금
ALTER TABLE Transaction
  ADD CONSTRAINT FK_member_TO_Transaction -- 회원 -> 입출금
  FOREIGN KEY (
  user_id -- 아이디
  )
  REFERENCES member ( -- 회원
  user_id -- 아이디
  );


-- 댓글
ALTER TABLE Comments
  ADD CONSTRAINT FK_member_TO_Comments -- 회원 -> 댓글
  FOREIGN KEY (
  user_id -- 아이디
  )
  REFERENCES member ( -- 회원
  user_id -- 아이디
  );

-- 댓글
ALTER TABLE Comments
  ADD CONSTRAINT FK_CommunityPosts_TO_Comments -- 자유게시판 -> 댓글
  FOREIGN KEY (
  post_id -- 자유게시판ID
  )
  REFERENCES CommunityPosts ( -- 자유게시판
  post_id -- 자유게시판ID
  );





-- 자유게시판
ALTER TABLE CommunityPosts
  ADD CONSTRAINT FK_member_TO_CommunityPosts -- 회원 -> 자유게시판
  FOREIGN KEY (
  user_id -- 아이디
  )
  REFERENCES member ( -- 회원
  user_id -- 아이디
  );


-- 입출금댓글
ALTER TABLE TransactionComments
  ADD CONSTRAINT FK_member_TO_TransactionComments -- 회원 -> 입출금댓글
  FOREIGN KEY (
  user_id -- 아이디
  )
  REFERENCES member ( -- 회원
  user_id -- 아이디
  );

-- 입출금댓글
ALTER TABLE TransactionComments
  ADD CONSTRAINT FK_Transaction_TO_TransactionComments -- 입출금 -> 입출금댓글
  FOREIGN KEY (
  expense_id -- 지출내역id
  )
  REFERENCES Transaction ( -- 입출금
  expense_id -- 지출내역id
  );