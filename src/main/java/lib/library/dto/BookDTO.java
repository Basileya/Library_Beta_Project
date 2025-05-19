package lib.library.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDTO {

    @NonNull
    private String name;
    @NonNull
    private String authorName;
    @NonNull
    private Integer year;
    private Integer balance;
    private Boolean delete;
    private PublishingHouseDTO publishingHouseDTO;

}
