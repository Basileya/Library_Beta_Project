package lib.library.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PublishingHouseDTO {

    @NonNull
    private String name;

    private Boolean delete;

}
