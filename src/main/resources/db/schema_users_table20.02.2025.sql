    CREATE TABLE IF NOT EXISTS user(
      id INTEGER NOT NULL AUTO_INCREMENT,
      surname varchar(255) NOT NULL,
      name varchar(255) NOT NULL,
      birthYear INTEGER NOT NULL,
      libraryCardData_id INTEGER,
      PRIMARY KEY (id),
      FOREIGN KEY (libraryCardData_id) REFERENCES libraryCardData(id)
    );