-- CREATE
CREATE TABLE MEMBER
(
    ID          VARCHAR2(50),
    PWD         NVARCHAR2(50),
    NAME        NVARCHAR2(50),
    GENDER      NCHAR(2),      -- ����, ����  UTF
    AGE         NUMBER(3),
    BIRTHDAY    CHAR(10),     -- 2000-01-02
    PHONE       CHAR(13),     -- 010-1234-2345
    REGDATE     DATE
);

INSERT INTO MEMBER(GENDER) VALUES('����');
SELECT LENGTHB(GENDER) FROM MEMBER;

DROP TABLE MEMBER;

SELECT LENGTH('ab') FROM DUAL;   -- 2
SELECT LENGTHB('ab') FROM DUAL;  -- 2

SELECT LENGTH('�ѱ�') FROM DUAL;  -- 2
SELECT LENGTHB('�ѱ�') FROM DUAL; -- 6(3byte ���)

SELECT * FROM NLS_DATABASE_PARAMETERS;


-- ALTER 
ALTER TABLE MEMBER MODIFY ID NVARCHAR2(50); -- ������Ÿ�� ����
ALTER TABLE MEMBER DROP COLUMN AGE;         -- �Ӽ��÷� ����
ALTER TABLE MEMBER ADD EMAIL VARCHAR2(200); -- �Ӽ��÷� �߰�



-- ������ ���̺� ����
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

CREATE TABLE "COMMENT"  -- COMMENT�� �̹� ����� �ܾ�(�����)
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

UPDATE MEMBER SET PWD='333', name='�տ���' WHERE ID='newlec';
DELETE MEMBER WHERE ID='newlec';


-- commit rollback
INSERT INTO MEMBER(ID, PWD) VALUES('test1','1234');
INSERT INTO MEMBER(ID, PWD) VALUES('test2','4321');
COMMIT;

SELECT ID, PWD FROM MEMBER;
ROLLBACK;


-- ��� ������
    -- ����
SELECT HIT+1 FROM NOTICE;
SELECT 1+'3' FROM DUAL;

    -- ����
SELECT '3' || 10 FROM DUAL;
SELECT 1 + 'A' FROM DUAL;

SELECT NAME || '(' || ID || ')' name FROM MEMBER;


-- �� ������ (WHERE ���� ���ȴ�)
SELECT * FROM NOTICE WHERE WRITER_ID = 'newlec';
SELECT * FROM NOTICE WHERE HIT > 3;
SELECT * FROM NOTICE WHERE CONTENT IS NULL;

-- ���� �� ������
SELECT * FROM NOTICE WHERE HIT BETWEEN 2 AND 4;
SELECT * FROM NOTICE WHERE HIT IN(2, 3, 7);
SELECT * FROM NOTICE WHERE HIT NOT IN(2, 3, 7);

-- ���� �� ������
    -- ��* �̸��� ã�ƶ�
SELECT * FROM MEMBER WHERE NAME = '��%';
SELECT * FROM NOTICE WHERE TITLE LIKE 'J%';

    -- ������ �����ϴ� �α��ڸ� ã�ƶ�
SELECT * FROM MEMBER WHERE NAME LIKE '��_';

    -- ȸ�� �߿��� �ھ� ���� ������ ȸ���� ��ȸ�Ͻÿ�.
SELECT * FROM MEMBER WHERE NAME NOT LIKE '��%';

    -- ȸ�� �߿� �̸��� '��'�ڰ� ���� ȸ���� ��ȸ�Ͻÿ�.
SELECT * FROM MEMBER WHERE NAME LIKE '%��%';
SELECT * FROM MEMBER WHERE NAME LIKE '%DB%';


-- ���Խ��� �̿��� ���� �� ����
    -- ��ȭ��ȣ�� ���� ������ �Խñ��� ��ȸ�ϰ� �ʹ�.
SELECT * FROM NOTICE WHERE TITLE LIKE '%-%-%';
        -- �� Ȯ���� ����
        -- 010-2222-3333
        -- 011-333-4444
        -- 016-234-4353
        -- 018-123-2345
        -- 019-232-2345
SELECT * FROM NOTICE WHERE TITLE 
LIKE '^01[016-9]-\d{3,4}-\d{4}$'; -- \d�� decimal digit�� [0-9]
        -- (X)
        
SELECT * FROM NOTICE 
WHERE REGEXP_LIKE(TITLE, '^01[01679]-\d{3,4}-\d{4}$');
        -- (O)


    -- ���Խ��� �̿��� ���ڿ� ��
        -- email
        -- newlec@nana.com
        -- sb92120@gmail.com
        -- @ .net com org 
        -- ^\D\w*@\D\w+.(com|net|org)$      -- [0-9a-zA-Z] = \w
SELECT * FROM NOTICE
WHERE REGEXP_LIKE(TITLE, '^\D\w*@\D\w+.(com|net|org)$');













