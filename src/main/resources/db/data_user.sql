-- id INTEGER NOT NULL,
--      surname varchar(255) NOT NULL,
--      authorName varchar(255) NOT NULL,
--      birthYear INTEGER NOT NULL,
--
--INSERT INTO user (id, surname, name, birthYear) VALUES (1, 'Tatsynets', 'Vasyl', '1993');
--INSERT INTO `library`.`user` (`birth_year`, `id`, `library_card_data_id`, `name`, `surname`) VALUES ('1993', '1', '25.11.2024', 'Vasyl', 'Tatsynets');
--INSERT INTO `library`.`user` (`birth_year`, `id`, `library_card_data_id`, `name`, `surname`) VALUES ('1996', '2', '11.05.2023', 'Vasylyna', 'Tatsynets');

SELECT id, surname, name, birth_year, library_card_data_id,
FROM library.`user`;
INSERT INTO `user` (id, surname, name, birth_year, library_card_data_id) VALUES
(1, 'Kisil', 'Marya', 1983, 1),
(2, 'Batig', 'Vasyl', 1993, 2),
(3, 'Tatsynets', 'Vasylyna', 1993, 3);

SELECT birth_year, id, library_card_data_id, name, surname
FROM library.`user`;
INSERT INTO `user` (id, surname, name, birth_year, library_card_data_id) VALUES
(1, 'Kisil', 'Marya', 1983, 1),
(2, 'Batig', 'Vasyl', 1993, 2),
(3, 'Tatsynets', 'Vasylyna', 1993, 3);