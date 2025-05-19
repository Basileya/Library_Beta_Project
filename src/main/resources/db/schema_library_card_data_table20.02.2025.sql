CREATE TABLE IF NOT EXISTS libraryCardData(
    id INTEGER NOT NULL AUTO_INCREMENT,
    data INTEGER DATE,
    user_id INTEGER
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id)

);



--  id INTEGER NOT NULL AUTO_INCREMENT,
--  data INTEGER,
--  user_id INTEGER,
--  libraryBase_id INTEGER,
--  PRIMARY KEY (id)
--    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user(id),
--    CONSTRAINT libraryBase FOREIGN KEY (libraryBase_id) REFERENCES libraryBase(id)
--
--
----    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
----    FOREIGN KEY (libraryBase_id) REFERENCES libraryBase(id) ON DELETE CASCADE,
----  FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,

