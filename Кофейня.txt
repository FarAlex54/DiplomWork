********************************* Создание таблиц *********************************
CREATE TABLE IF NOT EXISTS post(
	id serial NOT NULL PRIMARY KEY,
	title varchar(50) NOT NULL,
	salary numeric(10,2) NOT NULL);
CREATE TABLE IF NOT EXISTS employee (
	id serial NOT NULL PRIMARY KEY,
	firstname varchar(50) NOT NULL,
	name_employee varchar(50) NOT NULL,
	patronymic varchar(50) NULL,
	telephone varchar(18) NOT NULL,
	datebirth date NOT NULL,
	post_id integer NOT NULL,
	FOREIGN KEY (post_id) REFERENCES post(id));
CREATE TABLE IF NOT EXISTS "order" (
	id serial NOT NULL PRIMARY KEY,
	"create" date NOT NULL,
	price numeric(10,2) NOT NULL,
	status varchar(50) NOT NULL,
	end_order date NULL);
CREATE TABLE IF NOT EXISTS order_employee (
	order_id integer NOT NULL REFERENCES "order"(id),
	employee_id integer NOT NULL REFERENCES employee(id),
	UNIQUE(order_id, employee_id));
CREATE TABLE IF NOT EXISTS cofe (
	id serial NOT NULL PRIMARY KEY,
	name_cofe varchar(50) NOT NULL,
	price numeric(10,2) NOT NULL,
	vol integer NOT NULL);
CREATE TABLE IF NOT EXISTS ingridients (
	id serial NOT NULL PRIMARY KEY,
	name_i varchar(50) NOT NULL);
CREATE TABLE IF NOT EXISTS cofe_ingridients (
	cofe_id integer NOT NULL REFERENCES cofe(id),
	ingridients_id integer NOT NULL REFERENCES ingridients(id)
	);
CREATE TABLE IF NOT EXISTS topping (
	id serial NOT NULL PRIMARY KEY,
	name_t varchar(50) NULL,
	price numeric(10,2) NULL);
CREATE TABLE IF NOT EXISTS order_topping (
	order_id integer NOT NULL REFERENCES "order"(id),
	topping_id integer NOT NULL REFERENCES topping(id),
	UNIQUE(order_id, topping_id));
CREATE TABLE IF NOT EXISTS order_cofe (
	order_id integer NOT NULL REFERENCES "order"(id),
	cofe_id integer NOT NULL REFERENCES cofe(id),
	UNIQUE(order_id, cofe_id));

****************************************** Заполнение таблиц **********************************
INSERT INTO post (title,salary) VALUES
		('Охранник',25000),('Продавец',42000),('Администратор',43700),('Директор',50000),
		('Менеджер',43000),('Владыка',150000),('Сисадмин',170000);
INSERT INTO employee (firstname,name_employee,telephone,datebirth,post_id) VALUES
		('Иванов','Алексей',89833113119,'1982-09-18',2),
		('Петрова','Софья',893251322615,'1990-03-04',3),
		('Сидоров','Иван',89933618723,'1922-07-01',2),
		('Переверзева','Елизавета',89826547218,'1928-06-18',4),
		('Пупкин','Олег',89088618113,'1998-08-20',3),
		('Олегин','Пуп',89432313810,'2000-11-30',1),
		('Чернов','Петр',8983651265119,'1981-09-23',2),
		('Петров','Лена',893251303245615,'1989-03-20',7),
		('Сидорова','Дима',8984113618723,'1932-10-08',6),
		('Великая','Елизавета',89013547218,'1958-07-11',4),
		('Очень','Сложно',8908165123163,'1993-05-25',3),
		('Сложно','Пипец',8943231227890,'2001-01-30',7);
INSERT INTO topping (name_t,price) VALUES
		('Улыбка красавицы',350),('Гренадин',420),('Лайм',370),('Комплимент бариста',275),
		('Корица',350),('Карамельный сироп',420),
		('Брусничный сироп',370),('Шоколад',275);
INSERT INTO ingridients (name_i) VALUES
		('Эспрессо'),('Молочная пена'),('Кипяток'),('Сливки'),('Мороженое'),('Вспененное молоко'),
		('Лед'),('Внильный сахар'),('Шоколад'),('Какао'),('Виски'),('Лимон'),
		('Поцелуй администратора'), ('Леща охраника'), ('Обнимашки соседки');
INSERT INTO cofe (name_cofe,price,vol) VALUES
		('Макиато',150,50),('Латте',250,50),('Капучино',250,250),('ФлэтУайт',200,200),
		('Эспрессо',150,50);
INSERT INTO cofe_ingridients (cofe_id,ingridients_id)VALUES
		(1,3),(1,4),(1,5),
		(2,9),(2,3),(2,7),(2,4),(2,1),(2,5),
		(3,2),(3,12),(3,1),(3,10),(3,3),
		(4,1),(4,5),(4,2),(4,4),(4,9),(4,8),
		(5,11),(5,2),(5,1),(5,7),(5,6),(5,5);
INSERT INTO "order" ("create",price,status,end_order) VALUES
		('2022-09-30',500,'Готов к выдаче','2022-09-30'),
		('2022-09-17',400,'Выдан','2022-09-17'),
		('2022-09-15',600,'Готов к выдаче','2022-09-15'),
		('2022-09-23',550,'Отменен','2022-09-23'),
		('2022-10-01',900,'Возврат','2022-10-01'),
		('2022-08-03',500,'Готов к выдаче','2022-08-03'),
		('2022-08-17',400,'Выдан','2022-08-17'),
		('2022-09-15',600,'Готов к выдаче','2022-09-15'),
		('2022-09-23',550,'Выдан','2022-09-23'),
		('2022-10-01',900,'Выдан','2022-10-01'),		
		('2022-09-30',500,'Готов к выдаче','2022-09-30'),
		('2022-09-20',400,'Выдан','2022-09-20'),
		('2022-09-15',600,'Готов к выдаче','2022-09-15'),
		('2022-09-23',550,'Выдан','2022-09-23'),
		('2022-10-01',900,'Выдан','2022-10-01'),		
		('2022-09-30',500,'Готов к выдаче','2022-09-30'),
		('2022-09-17',400,'Выдан','2022-09-17'),
		('2022-09-15',600,'Готов к выдаче','2022-09-15'),
		('2022-09-23',550,'Выдан','2022-09-23'),
		('2022-09-23',900,'Выдан','2022-09-23');
INSERT INTO order_topping (order_id,topping_id)VALUES
		(1,3),(2,5),(3,3),(4,2),(5,8),(6,3),(7,5),(8,7),(9,2),(10,6),
		(11,3),(12,5),(13,6),(14,2),(15,3),(16,7),(17,5),
		(18,3),(19,1),(20,3);
INSERT INTO order_employee (order_id,employee_id) VALUES 
		(1,2),(2,2),(3,3),(4,1),(5,5),
		(6,4),(7,9),(8,8),(9,6),(10,5),
		(11,12),(12,7),(13,9),(14,6),(15,8),
		(16,4),(17,11),(18,8),(19,7),(20,10);
INSERT INTO order_cofe (order_id,cofe_id)VALUES
		(1,3),(2,5),(3,1),(4,2),(5,3),
		(11,3),(12,5),(13,1),(14,2),(15,3),
		(16,3),(17,5),(18,1),(19,2),(20,3),
		(6,3),(7,5),(8,1),(9,2),(10,3);

		
******* Создает сводную таблицу данных из различных таблиц и упорядочивает*****

SELECT 
	"order".create AS "Дата заказа",
	"order".status AS "Статус",
	topping.price + cofe.price AS "Цена заказа",
	employee.firstname AS "Фамилия",
	employee.name_employee AS "Имя",
	post.title AS "Должность",
	employee.telephone AS "Телефон",
	cofe.name_cofe AS "Кофе",
	cofe.vol AS "Обьем",
	topping.name_t AS "Добавка"
FROM order_employee
LEFT JOIN employee
	ON order_employee.employee_id=employee.id
LEFT JOIN "order"
	ON order_employee.order_id="order".id
LEFT JOIN post
	ON employee.post_id=post.id
LEFT JOIN order_cofe
	ON order_employee.order_id=order_cofe.order_id
LEFT JOIN cofe
	ON order_cofe.cofe_id=cofe.id
LEFT JOIN order_topping
	ON order_employee.order_id=order_topping.order_id
LEFT JOIN topping
	ON order_topping.topping_id=topping.id
WHERE ("order".status<>'Отменен' AND "order".status<>'Возврат') ORDER BY "order".create ASC;

******* Формирует таблицу лидеров продаж из сотрудников кофейни *****	
CREATE TABLE IF NOT EXISTS svod AS (
SELECT
	employee.firstname,
	"order".price
FROM order_employee
LEFT JOIN employee
	ON order_employee.employee_id=employee.id
LEFT JOIN "order"
	ON order_employee.order_id="order".id );
SELECT firstname, SUM(price) AS units FROM svod
GROUP BY ROLLUP(firstname) ORDER BY units DESC;
	
******* Удаляет лишние цифры номера телефона сотрудника и приводит номер в читабельный вид*****

		UPDATE employee SET telephone=SUBSTRING(telephone, 1, 11) WHERE LENGTH(telephone)>=12;
		UPDATE employee SET telephone=SUBSTRING(telephone, 1, 1)||'('||SUBSTRING(telephone, 2, 3)||')'||SUBSTRING(telephone, 5, 3)||'-'||SUBSTRING(telephone, 8, 2)||'-'||SUBSTRING(telephone, 10, 2);
		SELECT * FROM employee;
		
******* Удаляет идентичные записи таблицы из другой*****

		CREATE TABLE IF NOT EXISTS ingridients_update AS (SELECT * FROM ingridients);
		DELETE FROM ingridients_update WHERE name_i IN (SELECT name_t FROM topping);
		SELECT * FROM ingridients_update;		

