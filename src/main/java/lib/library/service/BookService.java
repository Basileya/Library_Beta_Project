package lib.library.service;

import jakarta.persistence.EntityNotFoundException;
import lib.library.dto.BookDTO;
import lib.library.model.Book;

import java.io.IOException;
import java.util.Optional;

public interface BookService {

    Optional<Book> saveBook(BookDTO bookDTO);

    Optional<Book> updateBook(BookDTO bookDTO, Integer id);

    Book issuanceBook(String name) throws IOException;

    void deleteBook(String name) throws IOException ;

    void returnBook(String name) throws EntityNotFoundException, IOException;

    Optional<Book> getBook(Integer id);

    Book getByName(String name);
}
