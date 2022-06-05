
-- INSERT
-- 유형 1.
-- INSERT INTO 테이블명 (컬럼목록)
-- VALUES (컬럼목록에 넣을 값목록)    
-- 유형 2.
-- INSERT INTO 테이블명
-- VALUES (전체 컬럼에 넣을 값목록)
INSERT INTO PLAYER
(PLAYER_ID, PLAYER_NAME, TEAM_ID, POSITION, HEIGHT, WEIGHT, BACK_NO)
VALUES ('2002007', '박지성', 'K07', 'MF', 178, 73, 7)
;


-- UPDATE
-- 
-- UPDATE 테이블명
-- SET 수정할_칼럼명 = 수정할_값
--
-- 해당 테이블의 모든 행의 컬럼값이 수정한 값으로 변경된다. 
UPDATE PLAYER
SET BACK_NO = 99
;


-- DELETE
-- 
-- DELETE [FROM] 삭제할_정보가_담긴_테이블명
--
-- FROM은 생략이 가능
DELETE FROM PLAYER
;


-- SELECT
-- 
-- SELECT [ALL/DISTINCT] 보고 싶은 칼럼명, 칼럼명, ...
-- FROM 해당 칼럼들이 있는 테이블명
-- 
-- ALL은 생략 가능 
-- DISTINCT를 사용하면 중복되는 정보는 제외하고 보겠다..
SELECT PLAYER_ID, PLAYER_NAME, TEAM_ID, POSITION, HEIGHT, WEIGHT, BACK_NO
FROM PLAYER
;
SELECT DISTINCT POSITION
FROM PLAYER
;
-- WILDCARD
-- 모든 칼럼정보를 보겠다
SELECT *
FROM PLAYER
;
-- ALIAS
-- as를 뒤에 붙여 칼럼 별명을 지정할 수 있다.
-- 별명 중간에 공백이 필요한 경우 [""]를 사용해야 한다.
SELECT PLAYER_NAME AS 선수명, POSITION AS 위치, HEIGHT AS 키, WEIGHT AS "몸 무 게"
FROM PLAYER
;

-- 산술연산자
-- +,    /,    *,     - 
-- 더하기, 나누기, 곱하기, 빼기
SELECT PLAYER_NAME 이름, HEIGHT - WEIGHT "키 - 몸무게"
FROM PLAYER
;
SELECT PLAYER_NAME 이름, ROUND(WEIGHT/((HEIGHT/100)*(HEIGHT/100)),2) "BMI 비만지수"
FROM PLAYER
;
-- 합성연산자
-- ||
-- CONCAT (string1, string2)
SELECT PLAYER_NAME || '선수,' || HEIGHT || 'cm,' || WEIGHT || 'kg' 체격정보
FROM PLAYER
;
SELECT CONCAT('HI', ' ORACLE!') "hi"
FROM dual
;
SELECT 'HI' || ' ORACLE!' "hi"
FROM dual 
;