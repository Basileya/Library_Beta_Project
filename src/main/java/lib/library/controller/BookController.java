package lib.library.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import lib.library.converter.BookToBookDTOConverter;
import lib.library.dto.BookDTO;
import lib.library.service.BookService;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import lib.library.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@SecurityRequirement(name = "Vasyl")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookToBookDTOConverter bookToBookDTOConverter;

    public BookController(BookToBookDTOConverter bookToBookDTOConverter) {
        this.bookToBookDTOConverter = bookToBookDTOConverter;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, World! This is my second personality work";
    }
    

    @GetMapping("/findOrderYearBook")
    public List<Book> findByLessThenYear(@RequestParam Integer year){
        List<Book> books = bookService.findByLessThenYear(year);
        return books;
    }

    @GetMapping("/getBook/{id}")
    public Optional<Book> getBook(@PathVariable Integer id){
        return bookService.getBook(id);
    }

    @GetMapping("/getBookByFirstLetter")
    public List<Book> findByFirstLetter(@RequestParam String letter) {
        return bookService.findByFirstLetter(letter);
    }

    @PostMapping("/addBook")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> saveBook(@ModelAttribute BookDTO bookDTO){
    Optional<Book> book = bookService.saveBook(bookDTO);
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @PutMapping("/putBook")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> updateBook(@RequestParam Integer id, @ModelAttribute BookDTO bookDTO){
        Optional<Book> book = bookService.updateBook(bookDTO, id);
        return ResponseEntity.of(book);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteBook(@PathVariable String name) throws IOException {
        bookService.deleteBook(name);
        return ResponseEntity.ok("Книга видалена ");
    }
    @DeleteMapping("/return/{name}")
    public ResponseEntity<String> returnBook(@PathVariable String name) throws EntityNotFoundException, IOException {
        bookService.returnBook(name);
        return ResponseEntity.ok("Книгу повернено ");
    }

    @PutMapping("/balance/{name}")
    public ResponseEntity<Book> updateBalance(@PathVariable String name) throws IOException {
        Book book = bookService.issuanceBook(name);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }


//    @PostMapping("/search")
//    @ResponseStatus(HttpStatus.OK)
//    public Result searchBooks(@RequestBody Map<String, String> searchCriteria, Pageable pageable) {
//        List<Book> books = bookService.findByCriteria(searchCriteria);
//
//        List<BookDTO> dtoList = books.stream()
//                .map(bookToBookDTOConverter::convert)
//                .toList();
//
//            return new Result() {
//                @Override
//                public void setSystemId(String systemId) {
//
//                }
//
//                @Override
//                public String getSystemId() {
//                    return "";
//                }
//            };
//    }
//    @PostMapping("/search")
//    @ResponseStatus(HttpStatus.OK)
//    public Book searchBooks(@RequestBody Map<String, String> searchCriteria, Pageable pageable) {
//        List<Book> books = bookService.findByCriteria(searchCriteria);
//        List<BookDTO> dtoList = books.stream()
//                .map(bookToBookDTOConverter::convert)
//                .toList();
//        return new Book(true, StatuseCode.SUCCESS, "OK", dtoList);
//    }
}
// 08.11 прочитати sql like %
// як генеруються query в spring boot;
// розібрати метод  findByCriteria(Map<String, String> criteria) - файл BookServiceImpl line №105
