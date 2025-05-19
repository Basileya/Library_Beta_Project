package lib.library.service;

import jakarta.persistence.EntityNotFoundException;
import lib.library.dto.LibraryCardDataDTO;
import lib.library.map.LibraryCardDataMap;
import lib.library.model.LibraryCardData;
import lib.library.repository.LibraryCardDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class LibraryCardDataServiceImpl implements LibraryCardDataService {

    @Autowired
    LibraryCardDataRepository libraryCardDataRepository;

    @Autowired
    LibraryCardDataMap libraryCardDataMap;

    @Override
    public Optional<LibraryCardData> findById(Integer id) {
        return libraryCardDataRepository.findById(id);
    }

    @Override
    public LibraryCardData addLibraryCardData(LibraryCardDataDTO libraryCardDataDTO) {
        LibraryCardData map = libraryCardDataMap.mapToLibraryCardData(libraryCardDataDTO);
        return libraryCardDataRepository.save(map);

    }

    @Override
    public Optional<LibraryCardDataDTO> updateLibraryCardData(LibraryCardDataDTO libraryCardDataDTO, Integer id) throws RuntimeException {
        libraryCardDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Library card not found"));
        LibraryCardData entity = LibraryCardDataMap.convertDTOtoEntity(libraryCardDataDTO);
        LibraryCardData saveLibraryCardData = libraryCardDataRepository.save(entity);
        return Optional.ofNullable(libraryCardDataMap.updateLibraryCardDataDTO(saveLibraryCardData, id));
    }

    @Override
    public void deleteLibraryCardData(Integer id) throws IOException {
        LibraryCardData libraryCardData = libraryCardDataRepository.findById(id)
                   .orElseThrow(() -> new EntityNotFoundException("Користувача з ID " + id + " не існує"));

        if (!libraryCardData.getDelete()){
            libraryCardData.setDelete(true);
            libraryCardDataRepository.save(libraryCardData);
        }else {
            throw new IOException("Користувача " + libraryCardData +  " немає в базі " );
        }
    }
}
