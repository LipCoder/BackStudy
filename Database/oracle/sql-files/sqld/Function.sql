-- 함수(FUNCTION)
-- 내장 함수 : 오라클과 같은 벤더에서 기본으로 제공해주는 함수 
-- 사용자 정의 함수 : 사용자가 직접 정의한 함수
-- 여러 개의 인수를 가질수 있음 단, 하나의 결과만 리턴
-- 함수는 중첩이 가능

-- 내장 함수
-- 함수명 (칼럼이나 표현식 [, Arg1, Arg2, ... ])

-- 문자형함수 
-- LOWER : 모든 문자를 소문자로 바꿈
SELECT LOWER('SQL Expert')
FROM DUAL
;

-- UPPER : 모든 문자를 대문자로 바꿈
SELECT UPPER('SQL Expert')
FROM DUAL
;

-- ASCII
-- 해당하는 문자의 아스키코드값을 반환
SELECT ASCII('A')
FROM DUAL
;

-- CHR
-- ASCII 함수의 반대 
SELECT CHR(65)
FROM DUAL
;

-- CONCAT
-- 문자열을 붙여서 출력
SELECT CONCAT('H', 'ello')
FROM DUAL
;
-- +, CONCAT은 세 문장이상부터 붙일 수 없다.
-- 만약 그렇게 하고 싶은 경우 || 를 사용한다.
SELECT 'H' || 'ello' || ' ' || 'World!'
FROM DUAL
;


-- SUBSTR
-- 문장의 일부를 리턴
SELECT SUBSTR('SQL Expert', 5, 3)
FROM DUAL
;

-- LENGTH
-- 문장의 길이를 리턴
SELECT LENGTH('SQL Expert')
FROM DUAL
;

-- LTRIM / RTRIM
-- 왼/오 방향으로 자름
SELECT LTRIM('xxxYYZZxYZ', 'x')
FROM DUAL
;
SELECT RTRIM('YYZZxYZzzzzzz', 'z')
FROM DUAL
;
-- TRIM
-- 양방향으로 자름
SELECT TRIM('x' FROM 'xxYYZZxYZxx')
FROM DUAL
;
-- 두번째 인수를 입력하지 않으면 공백을 제거한다
SELECT TRIM('HIH   HIHI  HIHIH         ')
FROM DUAL
;


-- 함수 중첩하여 사용하기
SELECT STADIUM STADUIM_ID, DDD || TEL AS TEL, LENGTH(DDD||TEL) AS T_LEN
FROM STADIUM
;


-- 숫자형 함수
-- ABS
-- 절대값으로 반환
SELECT ABS(-15)
FROM DUAL
;

-- SIGN
-- 양수인지 음수인지 0인지 구별
SELECT SIGN(-20), SIGN(20), SIGN(0)
FROM DUAL
;

-- MOD
-- 나머지 값을 리턴
SELECT MOD(7, 3)
FROM DUAL
;

-- CEIL
-- 숫자보다 크거나 같은 최소 정수를 리턴
SELECT CEIL(38.123)
FROM DUAL
;
-- FLOOR
-- 숫자보다 작거나 같은 최대 정수를 리턴
SELECT FLOOR(38.123)
FROM DUAL
;

-- ROUND
-- 숫자를 소수점 m자리에서 반올림하여 리턴
SELECT ROUND(38.5235, 3)
FROM DUAL
;

-- TRUNC
-- 숫자를 소수 m자리에서 잘라서 버린다.
SELECT TRUNC(38.5225, 3)
FROM DUAL
;


-- 날짜형 함수
-- SYSDATE
-- 현재 날짜와 시각을 출력
SELECT SYSDATE
FROM DUAL
;

-- EXTRACT
-- 날짜 데이터에서 년/월/일 데이터를 출력할 수 있다.
SELECT ENAME,
    EXTRACT(YEAR FROM HIREDATE) 입사년도,
    EXTRACT(MONTH FROM HIREDATE) 입사월,
    EXTRACT(DAY FROM HIREDATE) 입사일
FROM EMP
;

-- TO_NUMBER
-- EXTRACT랑 같은 기능
SELECT ENAME,
    TO_NUMBER(TO_CHAR(HIREDATE,'YYYY')) 입사년도,
    TO_NUMBER(TO_CHAR(HIREDATE,'MM')) 입사월,
    TO_NUMBER(TO_CHAR(HIREDATE,'DD')) 입사일
FROM EMP
;



-- 변환형 함수
-- TO_NUMBER
-- 숫자형식 문자열을 숫자로 변환
SELECT TO_NUMBER('12345.123312')
FROM DUAL
;
SELECT TEAM_ID,
    TO_NUMBER(ZIP_CODE1,'999') + TO_NUMBER(ZIP_CODE2,'999') 우편번호합
FROM TEAM
;

-- TO_CHAR
-- 숫자나 날짜를 주어진 FORMAT 형태로 
-- 문자열 타입으로 변환
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD') 날짜
FROM DUAL
;
SELECT TO_CHAR(SYSDATE, 'YYYY. MON, DAY')
FROM DUAL
;
SELECT TO_CHAR(123456789/1200, '$999,999,999.99') 환율반영달러,
       TO_CHAR(123456789, 'L999,999,999') 원화
FROM DUAL
;

-- TO_DATE
-- 문자열을 주어진 FORMAT 형태로 날짜 타입으로 변환
SELECT TO_DATE('1992/12/04') 탄신일
FROM DUAL
;


-- CASE 표현
-- IF-THEN-ELSE와 유사함

-- CASE WHEN THEN ELSE END
SELECT ENAME,
       CASE WHEN SAL > 2000
            THEN SAL
            ELSE 2000
       END REVISED_SALARY
FROM EMP
;
SELECT LOC,
    CASE LOC
    WHEN 'NEW YORK' THEN 'EAST'
    WHEN 'BOSTON' THEN 'EAST'
    WHEN 'CHICAGO' THEN 'CENTER'
    WHEN 'DALLAS' THEN 'CENTER'
    ELSE 'ETC'
    END AS AREA
FROM DEPT
;
SELECT ENAME,
    CASE WHEN SAL >= 3000 
         THEN 1000
         ELSE (CASE WHEN SAL >= 1000
                    THEN 500
                    ELSE 0
               END)
    END AS BONUS
FROM EMP
;


-- NULL 관련 함수

-- NVL
-- 표현식 1의 결과값이 NULL이면 표현식 2의 값을 출력
SELECT NVL(NULL, 'NVL-OK') NVL_TEST
FROM DUAL
;
SELECT NVL('NOT-NULL', 'NVL-OK') NVL_TEST
FROM DUAL
;
SELECT PLAYER_NAME 선수명, POSITION, NVL(POSITION, '없음') 포지션
FROM PLAYER
WHERE TEAM_ID = 'K08'
;

-- NULLIF
-- 표현식 1이 표현식 2와 같으면 NULL, 다르면 표현식 1을 리턴
SELECT ENAME, EMPNO, MGR, NULLIF(MGR,7698) NUIF
FROM EMP
;




-- COALESCE(표현식 1, 표현식 2, .....)
-- NULL이 아닌 최초의 표현식을 나타냄
-- 모든 표현식이 NULL이면 NULL을 리턴  
SELECT ENAME, COMM, SAL, COALESCE(COMM,SAL) COAL
FROM EMP
;

