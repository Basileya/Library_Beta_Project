package lib.library.service;

import lib.library.dto.LibraryCardDataDTO;
import lib.library.model.LibraryCardData;

import java.io.IOException;
import java.util.Optional;

public interface LibraryCardDataService {

    Optional<LibraryCardData> findById(Integer id);

//    List<LibraryCardData> findByDate(LocalDate date);

    LibraryCardData addLibraryCardData(LibraryCardDataDTO libraryCardDataDTO);

    Optional <LibraryCardDataDTO> updateLibraryCardData(LibraryCardDataDTO libraryCardDataDTO, Integer Id) throws RuntimeException;

    void deleteLibraryCardData(Integer id) throws IOException;

}
