REM   Script: Activity7
REM   SDET_SQL_Activities

select sum(purchase_amount) as "sum_of_orders" from orders;

select avg(purchase_amount) as "average_of_orders" from orders;

select max(purchase_amount) as "max_purchase_amount" from orders;

select min(purchase_amount) as "min_purchase_amount" from orders;

select count(distinct salesman_id) as "number_of_salesmen" from orders;

