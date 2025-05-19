package lib.library.dto;

import jakarta.persistence.Column;
import lib.library.model.Book;
import lib.library.model.User;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LibraryCardDataDTO {

    private Date date;
    private Boolean delete;
    private UserDTO userDTO;
    private List<BookDTO> books;

}
