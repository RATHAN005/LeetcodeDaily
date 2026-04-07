SELECT DISTINCT l1.num AS ConsecutiveNums
FROM Logs l1
WHERE 2 = 
(
    SELECT COUNT(l2.id)
    FROM Logs l2
    WHERE (l1.num = l2.num) AND (l2.id - l1.id = 1 || l2.id-l1.id = 2)
)