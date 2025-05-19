    CREATE TABLE IF NOT EXISTS publishingHouse(
      id INTEGER NOT NULL AUTO_INCREMENT,
      publishing_house_name varchar(255) NOT NULL,
      book_id INTEGER,
      PRIMARY KEY (id)
      FOREIGN KEY (book_id) REFERENCES books(id)
    );

