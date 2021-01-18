REM   Script: Activity10
REM   SDET_SQL_Activities

select *from orders where salesman_id= (select distinct salesman_id from orders where customer_id=3007;

select *from orders where salesman_id in (select salesman_id from salesman where salesman_city ='New York');

select grade, count(*) from customers_activity 
group by grade having grade >(select avg(grade) from customers_activity where city='New York');

select *from orders where salesman_id in (select salesman_id from salesman 
where commission= (select max(commission) from salesman));