package lib.library.converter;

import lib.library.dto.BookDTO;
import lib.library.model.Book;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import lib.library.dto.PublishingHouseDTO;
import org.springframework.core.convert.converter.Converter;

@Component
@AllArgsConstructor
//@NoArgsConstructor
public class BookToBookDTOConverter implements Converter<Book, BookDTO>  {


        @Override
        public BookDTO convert(Book source) {
            if (source == null) return null;

            PublishingHouseDTO ph = new PublishingHouseDTO(
            );

            return new BookDTO(
                    source.getName(),
                    source.getAuthorName(),
                    source.getYear(),
                    source.getBalance(),
                    source.getDelete(),
                    ph
            );
        }

}
