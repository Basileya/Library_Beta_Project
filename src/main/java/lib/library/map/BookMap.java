package lib.library.map;

import lib.library.dto.BookDTO;
import lib.library.dto.PublishingHouseDTO;
import lib.library.model.Book;
import lib.library.model.PublishingHouse;
import lib.library.repository.PublishingHouseRepository;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Objects.nonNull;

@Component
@ToString
public class BookMap {

    public Book updateBook(BookDTO bookDTO, Integer id) {
        Book book = new Book();
        book.setId(nonNull(id) ? id : null);
        book.setName(bookDTO.getName());
        book.setAuthorName(bookDTO.getAuthorName());
        book.setYear(bookDTO.getYear());
        book.setBalance(bookDTO.getBalance());
        return book;
    }

    public BookDTO getBookDTO(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setName(book.getName());
        bookDTO.setAuthorName(book.getAuthorName());
        bookDTO.setYear(book.getYear());
        bookDTO.setBalance(book.getBalance());

        PublishingHouseDTO publishingHouse = new PublishingHouseDTO();
        publishingHouse.setName(book.getPublishingHouse().getName());
        bookDTO.setPublishingHouseDTO(publishingHouse);
        return  bookDTO;
    }

}
