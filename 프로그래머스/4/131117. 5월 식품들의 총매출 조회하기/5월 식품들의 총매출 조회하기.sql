-- 코드를 입력하세요
SELECT product_id, product_name, price * amount AS total_sales
FROM food_product
JOIN (
    SELECT product_id, SUM(amount) as amount
    FROM food_order
    WHERE YEAR(produce_date) = 2022 AND MONTH(produce_date) = 5
    GROUP BY (product_id)
) A
USING (product_id)
ORDER BY total_sales DESC, product_id;

