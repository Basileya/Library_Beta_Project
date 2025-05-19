package lib.library.map;

import lib.library.dto.BookDTO;
import lib.library.dto.LibraryCardDataDTO;
import lib.library.dto.PublishingHouseDTO;
import lib.library.dto.UserDTO;
import lib.library.model.LibraryCardData;
import lib.library.model.PublishingHouse;
import lib.library.model.User;
import lombok.ToString;
import org.springframework.stereotype.Component;

import lib.library.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ToString
public class LibraryCardDataMap {


    public LibraryCardData mapToLibraryCardData(LibraryCardDataDTO libraryCardDataDTO){
        LibraryCardData libraryCardData = new LibraryCardData();
        libraryCardDataDTO.setDate(libraryCardDataDTO.getDate());
        libraryCardDataDTO.setDelete(libraryCardDataDTO.getDelete());
        User user = new User();
        user.setSurname(libraryCardData.getUser().getSurname());
        user.setName(libraryCardData.getUser().getName());
        user.setBirthYear(libraryCardData.getUser().getBirthYear());
        user.setDelete(libraryCardData.getUser().getDelete());
        libraryCardData.setUser(user);
        List<BookDTO> books = libraryCardData.getBooks()
                .stream()
                .map(LibraryCardDataMap::map)
                .collect(Collectors.toList());
        libraryCardDataDTO.setBooks(books);
        return libraryCardData;
    }

    public LibraryCardDataDTO updateLibraryCardDataDTO(LibraryCardData libraryCardData, Integer id){
        LibraryCardDataDTO libraryCardDataDTO = new LibraryCardDataDTO();
     //   libraryCardDataDTO.setId(id);
        libraryCardDataDTO.setDate(libraryCardData.getDate());
        libraryCardDataDTO.setDelete(libraryCardData.getDelete());
        UserDTO userDTO = new UserDTO();
        userDTO.setSurname(libraryCardData.getUser().getSurname());
        userDTO.setName(libraryCardData.getUser().getName());
        userDTO.setBirthYear(libraryCardData.getUser().getBirthYear());
        userDTO.setDelete(libraryCardData.getUser().getDelete());
        libraryCardDataDTO.setUserDTO(userDTO);
        List<BookDTO> books = libraryCardData.getBooks()
                .stream()
                .map(LibraryCardDataMap::map)
                .collect(Collectors.toList());
        libraryCardDataDTO.setBooks(books);
        return libraryCardDataDTO;
    }

    public static BookDTO map(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setName(book.getName());
        bookDTO.setAuthorName(book.getAuthorName());
        bookDTO.setYear(book.getYear());
        bookDTO.setPublishingHouseDTO(getPublishingHouse(book.getPublishingHouse()));
        bookDTO.setBalance(book.getBalance());
        bookDTO.setDelete(book.getDelete());
        return bookDTO;
    }

    private static PublishingHouseDTO getPublishingHouse(PublishingHouse publishingHouse){
        PublishingHouseDTO dto = new PublishingHouseDTO();
        dto.setName(publishingHouse.getName());
        return dto;
    }


    public static LibraryCardData convertDTOtoEntity(LibraryCardDataDTO libraryCardDataDTO){
        LibraryCardData libraryCardData = new LibraryCardData();
        libraryCardData.setDate(libraryCardDataDTO.getDate());
        libraryCardData.setDelete(libraryCardDataDTO.getDelete());
        return libraryCardData;
    }

}
