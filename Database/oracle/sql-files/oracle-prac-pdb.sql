-- CREATE
CREATE TABLE MEMBER
(
    ID          VARCHAR2(50),
    PWD         NVARCHAR2(50),
    NAME        NVARCHAR2(50),
    GENDER      NCHAR(2),      -- 남성, 여성  UTF
    AGE         NUMBER(3),
    BIRTHDAY    CHAR(10),     -- 2000-01-02
    PHONE       CHAR(13),     -- 010-1234-2345
    REGDATE     DATE
);

INSERT INTO MEMBER(GENDER) VALUES('남성');
SELECT LENGTHB(GENDER) FROM MEMBER;

DROP TABLE MEMBER;

SELECT LENGTH('ab') FROM DUAL;   -- 2
SELECT LENGTHB('ab') FROM DUAL;  -- 2

SELECT LENGTH('한글') FROM DUAL;  -- 2
SELECT LENGTHB('한글') FROM DUAL; -- 6(3byte 사용)

SELECT * FROM NLS_DATABASE_PARAMETERS;


-- ALTER 
ALTER TABLE MEMBER MODIFY ID NVARCHAR2(50); -- 데이터타입 수정
ALTER TABLE MEMBER DROP COLUMN AGE;         -- 속성컬럼 삭제
ALTER TABLE MEMBER ADD EMAIL VARCHAR2(200); -- 속성컬럼 추가



-- 수업용 테이블 구성
CREATE TABLE NOTICE
(
    ID          NUMBER,
    TITLE       NVARCHAR2(100),
    WRITER_ID   NVARCHAR2(50),
    CONTENT     CLOB,
    REGDATE     TIMESTAMP,
    HIT         NUMBER,
    FILES       NVARCHAR2(1000)
);

CREATE TABLE "COMMENT"  -- COMMENT는 이미 예약된 단어(예약어)
(
    ID          NUMBER,
    CONTENT     NVARCHAR2(2000),
    REGDATE     TIMESTAMP,
    WRITER_ID   NVARCHAR2(50),
    NOTICE_ID   NUMBER
);

CREATE TABLE ROLE
(
    ID          VARCHAR(50),
    DESCRIPTION VARCHAR2(500)
);

CREATE TABLE MEMBER_ROLE
(
    MEMBER_ID   NVARCHAR2(50),
    ROLE_ID     VARCHAR(50)
);



-- insert
INSERT INTO MEMBER(ID, PWD) VALUES('newlec', '1111');
INSERT INTO MEMBER(ID, PWD) VALUES('dragon', '2222');
SELECT * FROM MEMBER;
SELECT id, name, pwd FROM MEMBER;
SELECT id as user_id, name pwd FROM MEMBER;
SELECT id user_id, name pwd FROM MEMBER;
SELECT id "user id", name pwd FROM MEMBER;
SELECT id "USER ID", name pwd FROM MEMBER;


-- update
UPDATE MEMBER SET PWD='222';
UPDATE MEMBER SET PWD='333' WHERE ID='newlec';

UPDATE MEMBER SET PWD='333', name='손오공' WHERE ID='newlec';
DELETE MEMBER WHERE ID='newlec';


-- commit rollback
INSERT INTO MEMBER(ID, PWD) VALUES('test1','1234');
INSERT INTO MEMBER(ID, PWD) VALUES('test2','4321');
COMMIT;

SELECT ID, PWD FROM MEMBER;
ROLLBACK;


-- 산술 연산자
    -- 숫자
SELECT HIT+1 FROM NOTICE;
SELECT 1+'3' FROM DUAL;

    -- 문자
SELECT '3' || 10 FROM DUAL;
SELECT 1 + 'A' FROM DUAL;

SELECT NAME || '(' || ID || ')' name FROM MEMBER;


-- 비교 연산자 (WHERE 절에 사용된다)
SELECT * FROM NOTICE WHERE WRITER_ID = 'newlec';
SELECT * FROM NOTICE WHERE HIT > 3;
SELECT * FROM NOTICE WHERE CONTENT IS NULL;

-- 관계 비교 연산자
SELECT * FROM NOTICE WHERE HIT BETWEEN 2 AND 4;
SELECT * FROM NOTICE WHERE HIT IN(2, 3, 7);
SELECT * FROM NOTICE WHERE HIT NOT IN(2, 3, 7);

-- 패턴 비교 연산자
    -- 박* 이름을 찾아라
SELECT * FROM MEMBER WHERE NAME = '박%';
SELECT * FROM NOTICE WHERE TITLE LIKE 'J%';

    -- 박으로 시작하는 두글자를 찾아라
SELECT * FROM MEMBER WHERE NAME LIKE '박_';

    -- 회원 중에서 박씨 성을 제외한 회원을 조회하시오.
SELECT * FROM MEMBER WHERE NAME NOT LIKE '박%';

    -- 회원 중에 이름에 '도'자가 들어가는 회원을 조회하시오.
SELECT * FROM MEMBER WHERE NAME LIKE '%도%';
SELECT * FROM MEMBER WHERE NAME LIKE '%DB%';


-- 정규식을 이용한 패턴 비교 연산
    -- 전화번호가 찍힌 제목의 게시글을 조회하고 싶다.
SELECT * FROM NOTICE WHERE TITLE LIKE '%-%-%';
        -- 더 확실한 제한
        -- 010-2222-3333
        -- 011-333-4444
        -- 016-234-4353
        -- 018-123-2345
        -- 019-232-2345
SELECT * FROM NOTICE WHERE TITLE 
LIKE '^01[016-9]-\d{3,4}-\d{4}$'; -- \d는 decimal digit로 [0-9]
        -- (X)
        
SELECT * FROM NOTICE 
WHERE REGEXP_LIKE(TITLE, '^01[01679]-\d{3,4}-\d{4}$');
        -- (O)


    -- 정규식을 이용한 문자열 비교
        -- email
        -- newlec@nana.com
        -- sb92120@gmail.com
        -- @ .net com org 
        -- ^\D\w*@\D\w+.(com|net|org)$      -- [0-9a-zA-Z] = \w
SELECT * FROM NOTICE
WHERE REGEXP_LIKE(TITLE, '^\D\w*@\D\w+.(com|net|org)$');













