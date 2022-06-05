-- GROUP BY, HAVING
--
--
-- COUNT(*)
-- 와일드카드 '*'는 전체 칼럼을 뜻하는데 
-- 전체 칼럼이 NULL이 될 경우는 없으므로
-- 전체 행수를 리턴한다.
SELECT COUNT(*) "전체 행수", COUNT(HEIGHT) "키 건수",
        MAX(HEIGHT) 최대키, MIN(HEIGHT) 최소키, ROUND(AVG(HEIGHT),2) 평균키
FROM PLAYER
;

-- GROUP BY 절
-- 각 그룹으로 구성할지에 대한 결과를 리턴한다
--
-- SELECT [DISTINCT] 칼럼명 [ALIAS명]
-- FROM 테이블명
-- [WHERE 조건식]
-- [GROUP BY 칼럼(Column)이나 표현식]
-- [HAVING 그룹조건식]
-- ;
SELECT POSITION 포지션, COUNT(*) 인원수, COUNT(HEIGHT) 키대상,
       MAX(HEIGHT) 최대키, MIN(HEIGHT) 최소키, ROUND(AVG(HEIGHT),2) 평균키
FROM PLAYER GROUP BY POSITION
;