SELECT
  t1.a AS t1_a,
  t1.b AS t1_b,
  (
    SELECT ARRAY_AGG(t2.c ORDER BY t2.order_column)
    FROM table2 t2
    WHERE t1.a = ANY(t2.a) AND t1.b = ANY(t2.b)
  ) AS c_array,
  (
    SELECT ARRAY_AGG(t2.d ORDER BY t2.order_column)
    FROM table2 t2
    WHERE t1.a = ANY(t2.a) AND t1.b = ANY(t2.b)
  ) AS d_array,
  (
    SELECT ARRAY_AGG(t2.e ORDER BY t2.order_column)
    FROM table2 t2
    WHERE t1.a = ANY(t2.a) AND t1.b = ANY(t2.b)
  ) AS e_array
FROM
  table1 t1;
