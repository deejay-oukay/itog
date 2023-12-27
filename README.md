Вижу 3 варианта итогового задания. Использую [это](https://gbcdn.mrgcdn.ru/uploads/asset/4868005/attachment/1f0bfdadc1c954fc748a4890b644e605.pdf)...

Команды для заданий 1-2:
```
cat > "Домашние животные"
cat > "Вьючные животные"
cat "Домашние животные" "Вьючные животные" > 2in1
cat 2in1
mv 2in1 "Друзья человека"
mkdir Директория
mv "Друзья человека" Директория/
```

Команды для задания 3:
```
wget https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb
sudo dpkg -i Загрузки/mysql-apt-config_0.8.24-1_all.deb
sudo apt-get update
sudo apt-get install mysql-server -y
```

Команды для задания 4:
```
wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j_8.0.32-1ubuntu22.04_all.deb
sudo dpkg -i mysql-connector-j_8.0.32-1ubuntu22.04_all.deb
sudo dpkg -r mysql-connector-j
```
Задание 5 - выполнено путём перечисления команд из терминала Ubuntu, необходимых для выполнения задания 1-4

Задание 6 - как понял, так и выполнил. Надеюсь, имелось ввиду именно это:
![Диаграмма](6.jpg)

Запросы для выполнения задания 7-9:
```
CREATE DATABASE people_friends;
USE people_friends;
CREATE TABLE dogs (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(32),
    commands TEXT,
    birthday DATE
);
CREATE TABLE cats LIKE dogs;
CREATE TABLE hamsters LIKE dogs;
CREATE TABLE horses LIKE dogs;
CREATE TABLE camels LIKE dogs;
CREATE TABLE donkeys LIKE dogs;
INSERT INTO dogs (name,commands,birthday) VALUES
	("Шарик","Сидеть;Лежать;Голос","2020-01-01"),
	("Барбос","Гулять","2021-01-01"),
	("Тузик","Фас;Место","2022-01-01")
;
INSERT INTO cats (name,commands,birthday) VALUES
	("Мурзик","Не трогай Потёмкина","2020-02-01"),
	("Рыжик","Брысь, блохастый","2021-02-01"),
	("Гарфилд","Кушать подано","2022-02-01")
;
INSERT INTO hamsters (name,commands,birthday) VALUES
	("Луиз Альберто","Побегай в колесе","2020-03-01"),
	("Мариванна","Прикинься дохлым","2021-03-01"),
	("Потёмкин","Спасайся от Мурзика","2022-03-01")
;
INSERT INTO horses (name,commands,birthday) VALUES
	("Сервелат","Но;Тпру","2020-04-01"),
	("Зе-Бра","Но;Тпру","2021-04-01"),
	("Петрович","Но;Тпру","2022-04-01")
;
INSERT INTO camels (name,commands,birthday) VALUES
	("Первый верблюд","Гит;Дурр","2020-05-01"),
	("Второй верблюд","Каш;Кхх-кхх","2021-05-01"),
	("Третий верблюд","Хап-хап-хап-хап;Цок-цок","2022-05-01")
;
INSERT INTO donkeys (name,commands,birthday) VALUES
	("Иа","Грустить,Удручать всех своим присутсвием","2020-06-01"),
	("Подруга Иа","Вези меня мой не арабский и не скакун","2021-06-01"),
	("Похож на Иа, но не не Иа","Сделай вид, что ты - Иа","2022-06-01")
;
```
Запросы для выполнения задания 10 (как понял, так и выполнил - в т.ч., удалил записи из таблицы, а не саму таблицу):
```
TRUNCATE camels;
CREATE TABLE horses_and_donkeys LIKE dogs;
INSERT INTO horses_and_donkeys SELECT * FROM horses;
INSERT INTO horses_and_donkeys (name,commands,birthday) SELECT name,commands,birthday FROM donkeys;
```
Запросы для выполнения задания 11 (пустая таблица camels, не используется; вместо двух таблиц horses и donkeys используется одна таблица horses_and_donkeys - для ускорения процесса):
```
CREATE TABLE young_animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(32),
    commands TEXT,
    birthday DATE,
    age TEXT
);

DELIMITER //
CREATE FUNCTION age (birthday DATE)
RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE result TEXT DEFAULT "";
	SET res = CONCAT("Лет: ", TIMESTAMPDIFF(YEAR, birthday, CURDATE()),'. Месяцев: ',TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12,'.');
	RETURN result;
END //
DELIMITER ;

INSERT INTO young_animals (name, commands, birthday, age)
	SELECT name, commands, birthday, age(birthday)
	FROM dogs
    WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 1 AND 3
	UNION ALL
	SELECT name, commands, birthday, age(birthday)
	FROM cats
    WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 1 AND 3
	UNION ALL
	SELECT name, commands, birthday, age(birthday)
	FROM hamsters
	WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 1 AND 3
	UNION ALL
	SELECT name, commands, birthday, age(birthday)
	FROM horses_and_donkeys
	WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 1 AND 3
;
```
Запросы для выполнения задания 12 (используются только "изначальные" таблицу, кроме пустой camels):
```
CREATE TABLE animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(32),
    commands TEXT,
    birthday DATE,
    from_table VARCHAR(8)
);

INSERT INTO animals (name, commands, birthday, from_table)
SELECT name, commands, birthday, 'dogs'
FROM dogs;

INSERT INTO animals (name, commands, birthday, from_table)
SELECT name, commands, birthday, 'cats'
FROM cats;

INSERT INTO animals (name, commands, birthday, from_table)
SELECT name, commands, birthday, 'hamsters'
FROM hamsters;

INSERT INTO animals (name, commands, birthday, from_table)
SELECT name, commands, birthday, 'horses'
FROM horses;

INSERT INTO animals (name, commands, birthday, from_table)
SELECT name, commands, birthday, 'donkeys'
FROM donkeys;
```
Для задания 13, видимо, нужно было создать не класс, а классы:
* [Животные](Classes/Aminals.java)
	* [Домашние животные](Classes/Pets.java)
		* [Собаки](Classes/Dogs.java)
		* [Кошки](Classes/Cats.java)
		* [Хомяки](Classes/Hamsters.java)
	* [Вьючные животные](Classes/Packs.java)
		* [Лошади](Classes/Horses.java)
		* [Верблюды](Classes/Camels.java)
		* [Ослы](Classes/Donkeys.java)

Для задания 14 созданы ещё 2 класса:
* [Главный](Classes/Main.java)
* [Реестр](Classes/Registry.java)

> 15 пункт задания необязателен к выполнению, так как он сформулирован некорректно