package lib.library.controller;

import lib.library.dto.LibraryCardDataDTO;
import lib.library.map.LibraryCardDataMap;
import lib.library.model.LibraryCardData;
import lib.library.repository.LibraryCardDataRepository;
import lib.library.service.LibraryCardDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LibraryCardDataController {

    @Autowired
    LibraryCardDataService libraryCardDataService;

    @Autowired
    LibraryCardDataMap libraryCardDataMap;

    @Autowired
    LibraryCardDataRepository libraryCardDataRepository;

    @GetMapping("/cardData/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<LibraryCardData>> getById(@PathVariable Integer id){
        return ResponseEntity.ok(libraryCardDataService.findById(id));
    }

    @PostMapping("/addCardData")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LibraryCardData> addCardData(@ModelAttribute LibraryCardDataDTO libraryCardDataDTO){
        LibraryCardData libraryCardData = libraryCardDataService.addLibraryCardData(libraryCardDataDTO);
        return new ResponseEntity(libraryCardData, HttpStatus.OK);
    }

    @PutMapping("/putCardData")
    @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<LibraryCardData> updateLibraryCardData(@ModelAttribute LibraryCardDataDTO libraryCardDataDTO,
                                                                     @PathVariable Integer id) throws RuntimeException {
        Optional<LibraryCardDataDTO> updateLibraryCardData = libraryCardDataService.updateLibraryCardData(libraryCardDataDTO, id);

        return new ResponseEntity(updateLibraryCardData, HttpStatus.OK);
    }


}
