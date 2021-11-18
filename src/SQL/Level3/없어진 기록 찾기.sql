
-- ANIMAL_INS, ANIMAL_OUTS 테이블
-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 id와 이름을 id 순으로 조회
-- ANIMAL_INS 에는 없는데 ANIMAL_OUTS 에만 있는 것들 조회
SELECT ANIMAL_ID, NAME FROM ANIMAL_OUTS
WHERE ANIMAL_ID NOT IN(SELECT ANIMAL_ID FROM ANIMAL_INS);