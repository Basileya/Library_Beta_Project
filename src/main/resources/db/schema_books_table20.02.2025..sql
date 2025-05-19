    CREATE TABLE IF NOT EXISTS books(
    id INTEGER NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    authorName varchar(255) NOT NULL,
    year INTEGER,
    balance INTEGER,
    publishingHouse_id INTEGER,
    PRIMARY KEY(id),
    FOREIGN KEY (publishingHouse_id) REFERENCES publishingHouse(id),
    FOREIGN KEY (libraryCardData_id) REFERENCES libraryCardData(id),

 );
--      id INTEGER NOT NULL AUTO_INCREMENT,
--      name varchar(255) NOT NULL,
--      authorName varchar(255) NOT NULL,
--      year INTEGER NOT NULL,
--      libraryBase_id INTEGER NOT NULL,
--      publishingHouse_id INTEGER NOT NULL,
--      CONSTRAINT BooksPK PRIMARY KEY (id),
--      CONSTRAINT publishingHouse FOREIGN KEY (publishingHouse_id) REFERENCES publishingHouse(id)
--
--      CONSTRAINT libraryBase FOREIGN KEY (libraryBase_id) REFERENCES libraryBase(id)
--      FOREIGN KEY (publishingHouse_id) REFERENCES publishingHouse(id) ON DELETE CASCADE,
--      FOREIGN KEY (libraryBase_id) REFERENCES libraryBase(id) ON DELETE CASCADE,



