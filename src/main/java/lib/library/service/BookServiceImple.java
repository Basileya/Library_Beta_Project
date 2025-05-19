package lib.library.service;

import jakarta.persistence.EntityNotFoundException;
import lib.library.dto.BookDTO;
import lib.library.map.BookMap;
import lib.library.model.Book;
import lib.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class BookServiceImple implements BookService {

    @Autowired
    BookMap bookMap;

    @Autowired
    BookRepository bookRepository;

    @Override
    public Optional<Book> saveBook(BookDTO bookDTO) {
        Book map = bookMap.updateBook(bookDTO, null);
        Book book = bookRepository.save(map);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> updateBook(BookDTO bookDTO, Integer id) {
        Book book = bookMap.updateBook(bookDTO, id);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Book issuanceBook(String name) throws IOException {
        Book book = bookRepository.getByName(name);
        if (book == null) {
            throw new EntityNotFoundException("такої книги немає");
        }

        if (book.getBalance() > 0) {
            book.setBalance(book.getBalance() - 1);
            bookRepository.save(book);
        } else {
            throw new IOException("Немає доступних примірників " + name + " в базі даних");
        }
        return book;
    }


    @Override
    public void deleteBook(String name) throws IOException {
        Book book = bookRepository.getByName(name);
        if (book == null)  {
            throw new EntityNotFoundException("Книги " + name +  " немає в наявності") ;
        }
        if (book.getDelete() == false) {
            book.setDelete(true);
            bookRepository.save(book);
        } else {
            throw new IOException("Книги " + book +  " немає в базі " );
        }
    }

    @Override
    public void returnBook(String name)  throws EntityNotFoundException, IOException {
        Book book = bookRepository.getByName(name);
        if (book == null)  {
            throw new EntityNotFoundException("Книги " + name +  " немає в наявності") ;
        }

        if (book.getDelete()) {
            book.setDelete(false);
            bookRepository.save(book);
        } else {
            throw new IOException("Такої книг нема в базі");
        }
    }

    //створити додаткове поле boolean яке ставити true чи false
    @Override
    public Optional<Book> getBook(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book getByName(String name) {
        return bookRepository.getByName(name);
    }

}
