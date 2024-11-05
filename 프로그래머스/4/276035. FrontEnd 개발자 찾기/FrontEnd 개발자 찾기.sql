-- 코드를 작성해주세요
SELECT DISTINCT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS D
JOIN
(SELECT CODE FROM
SKILLCODES
WHERE CATEGORY = 'Front End') S
ON (D.SKILL_CODE & S.CODE)
ORDER BY ID