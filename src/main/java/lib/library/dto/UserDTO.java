package lib.library.dto;

import lib.library.model.LibraryCardData;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {

    private String surname;
    private String name;
    private Integer birthYear;
    private LibraryCardData libraryCardData;
    private Boolean delete;
}
