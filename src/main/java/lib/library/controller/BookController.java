package lib.library.controller;

import jakarta.persistence.EntityNotFoundException;
import lib.library.dto.BookDTO;
import lib.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import lib.library.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String hello() {
        return "Hello, World! This is my second personality work";
    }

    @GetMapping("/getBook/{id}")
    public Optional<Book> getBook(@PathVariable Integer id){
        return bookService.getBook(id);
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

}

