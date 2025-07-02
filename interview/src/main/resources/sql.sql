вычислить
количество заказов и их сумму для каждого клиента
order (id, amount, customer_id);

SELECT customer_id, COUNT(id), SUM(amount)
FROM order
GROUP BY customer_id;

найти вторую максимальную зарплату
employee(id, department_id, name, salary);

SELECT MAX(salary) FROM employee WHERE salary < (SELECT MAX(salary) FROM employee);


Компания ООО "Ромашка" представлена таблицами employee(id, department_id, name, salary) и department (id, name) Вывести список сотрудников (id, name), получающих максимальную заработную плату в своем отделе

SELECT e1.id, e1.name
FROM Employee e1
WHERE e1.salary = (SELECT MAX(salary) from employee e2 WHERE e1.department_id = e2.department_id);

SELECT id, name
FROM employee e1
WHERE salary IN
      (SELECT MAX(e2.salary) FROM employee e2 WHERE e1.department_id = e2.department_id GROUP BY e2.department_id)


Вывести список сотрудников, имеющих назначенного руководителя, работающего в другом отделе
employee (id, name, department_id, chief_id)

SELECT e1.* FROM   employee e1 LEFT JOIN employee e2 ON (e1.chief_id = e2.id   AND e1.department_id = e2.department_id) WHERE  e2.id IS NULL

SELECT e1.* FROM employee AS e1 JOIN employee e2 ON e1.chief_id = e2.id WHERE e1.department_id <> e2.department_id
