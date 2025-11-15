package lib.library.repository;

import lib.library.model.Book;
import lib.library.model.BooksSpecs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<BooksSpecs> {

    Book getByName(String name);

//    @Query("SELECT b FROM Book b WHERE b.year < :year ORDER by b.year ASC")
//        List<Book> findByBookOlderThen(@Param("year")Integer year);
//
//        Book findByAuthorNameAndBalanceASC(String authorName, Integer balance);

    @Query ("SELECT b.authorName FROM Book b WHERE b.authorName LIKE 'A%'")
    List<Book> findByFirstLetter ();

//    SELECT * FROM Customers
//    WHERE CustomerName LIKE 'a%';

//      @Query("SELECT b FROM Book b WHERE b.authorName LIKE CONCAT(:letter, '%')")
//        List<Book> findByFirstLetter(@Param("letter") String letter);
}
