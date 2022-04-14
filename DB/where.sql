-- WHERE절
--
-- SELECT [DISTINCT/ALL] 칼럼명 [ALIAS명]
-- FROM 테이블명
-- WHERE 조건식;

SELECT COUNT(*)
FROM PLAYER
WHERE WEIGHT = 100
;


SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키
FROM PLAYER
WHERE TEAM_ID = 'K2'
;


SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키
FROM PLAYER
WHERE HEIGHT >= 170
;


-- IN
-- 다중 리스트를 이용한 IN 연산자
-- 두 조건 중 하나에 만족하는 정보를 필터링
-- SQL 문장을 짧게 만들어 주면서 성능 측면에서도 장점을 가질 수 있는 유용한 연산자
-- 적극적인 사용을 권장 
SELECT ENAME, JOB, DEPTNO
FROM EMP
WHERE (JOB, DEPTNO) IN (('MANAGER', 20), ('CLERK', 30))
;

SELECT ENAME, JOB, DEPTNO
FROM EMP
WHERE JOB IN ('MANAGER', 'CLERK') AND DEPTNO IN (20, 30)
;


-- LIKE 연산자
-- '~와 같다'는 의미
-- % : 0개 이상의 어떤 문자를 의미
-- _ : 1개인 단일 문자를 의미
SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE PLAYER_NAME LIKE '장%'
;


-- BETWEEN a AND b 연산자
-- a와 b 조건에 해당하는 데이터를 가져오기 위한 연산자
-- a와 b를 포함한다.
SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE HEIGHT BETWEEN 170 AND 180
;

-- IS NULL 연산자
SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE POSITION = NULL
;
-- 위 쿼리문은 NULL값을 비교함으로써 모든 조건이 부정하게 되므로
-- 아무런 의미가 없다. 
-- 그러면 NULL값을 조건문으로 쓰고 싶을때는 어떻게 해야할까?
SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE POSITION IS NULL
;


-- 논리 연산자
-- AND, OR, NOT
SELECT PLAYER_NAME 선수이름, POSITION 포지션, BACK_NO 백넘버, HEIGHT 키 
FROM PLAYER
WHERE TEAM_ID = 'K02'
AND HEIGHT >= 170
;


-- 부정 연산자
-- 기존에 사용했던 조건의 반대로 검사한다
-- 논리
-- !=, ^=, <>, NOT 칼럼명 =, NOT 칼럼명 >
-- SQL
-- NOT BETWEEN A AND B, NOT IN (list), IS NOT NULL


-- ROWNUM, TOP
-- ROWNUM : 각 행에 임시로 부여되는 일련번호
SELECT PLAYER_NAME
FROM PLAYER 
WHERE ROWNUM = 1 -- ROWNUM <= 1; -- ROWNUM < 2;
;
-- 테이블 내 고유한 키나 인덱스 값을 만들 수 있다.
UPDATE MY_TABLE 
SET COLUMN1 = ROWNUM
;

-- TOP : 행의 수를 제한할 수 있다.
SELECT TOP(1) PLAYER_NAME 
FROM PLAYER
;

SELECT ROWNUM
FROM tab
;



