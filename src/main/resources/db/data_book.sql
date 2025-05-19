-- написати скрипт враховуючи FOREIGN KEY;
--  id INTEGER NOT NULL AUTO_INCREMENT,
--  name varchar(255) NOT NULL,
--  authorName varchar(255) NOT NULL,
--  year INTEGER NOT NULL,
--  libraryBase_id INTEGER NOT NULL,
--  publishingHouse_id INTEGER NOT NULL,
--  CONSTRAINT BooksPK PRIMARY KEY (id)
--  CONSTRAINT libraryBase FOREIGN KEY (libraryBase_id) REFERENCES libraryBase(id)
--  CONSTRAINT publishingHouse FOREIGN KEY (publishingHouse_id) REFERENCES publishingHouse(id)


select id, name, author_name, `year`, balance,  publishing_house_id, library_card_data_user_id
FROM library.books;
INSERT INTO `library`.`books` (id, name, author_name, `year`, balance, publishing_house_id, library_card_data_user_id)
VALUES
(1, 'Альманах 2022. Конкурс воєнної поезії пам"яті Гліба Бабіча. Конкурс воєнної короткої прози', 'Дарка Бабіч, Геннадій Вальков, Леонід Данільчик', '2024', 10, '1', '1'),
(2, 'Анна Ін у гробницях світу', 'Ольга Токарчук', '2024', 10, '2', '2'),
(3, 'Бігуни', 'Ольга Токарчук', '2020', 10, '2', '3'),
(4, 'Гра на багатьох барабанчиках', 'Ольга Токарчук', '2024', 10, '2', '2'),
(5, 'Це те, що вас зцілить, коли будете готові', 'Бріанна Вест', '2024', 10, '3', '1'),
(6 'Кохання. Книга 1 (Twisted)', 'Ана Хван', '2025', 10, '4', '3'),
(7, 'Зайчик (рожева обкладинка)', 'Мона Авад', '2024', 10, '5', '3'),
(8, 'Безсила. Книга 1', 'Лорен Робертс', '2025', '6', 10, '1'),
(9, 'Сім чоловіків Евелін Г"юґо (м"яка обкладинка)', 'Тейлор Дженкінс Рід', '2024', 10, '7', '1'),
(10, 'Іди туди, де страшно. І матимеш те, про що мрієш', 'Джим Ловлесс', '2022', 10, '3', '1');

