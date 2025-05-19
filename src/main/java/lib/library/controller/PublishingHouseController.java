package lib.library.controller;

import lib.library.dto.PublishingHouseDTO;
import lib.library.model.PublishingHouse;
import lib.library.repository.PublishingHouseRepository;
import lib.library.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
public class PublishingHouseController {

    @Autowired
    PublishingHouseService publishingHouseService;


    @GetMapping("/getPublishingHouseName/{id}")
    public Optional<PublishingHouse> getPublishingHouse(@PathVariable Integer id) {
       return publishingHouseService.getPublishingHouse(id);
    }

    @PostMapping("/addPublishingHouse")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PublishingHouse> addPublishingHouse(@ModelAttribute PublishingHouseDTO publishingHouseDTO){
        PublishingHouse publishingHouse = publishingHouseService.addPublishingHouse(publishingHouseDTO);
        return new ResponseEntity(publishingHouse, HttpStatus.OK);
    }

    @PutMapping("/updatePublishingHouse")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PublishingHouse> updatePublishingHouse
            (@ModelAttribute PublishingHouseDTO publishingHouseDTO, @RequestParam Integer id){
        PublishingHouse publishingHouse = publishingHouseService.updatePublishingHouse(publishingHouseDTO, id);
        return new ResponseEntity(publishingHouse, HttpStatus.OK);
    }

    @DeleteMapping("/deletePublishingHouse/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deletePublishingHouse (@PathVariable String name) throws IOException {
        publishingHouseService.deletePublishingHouse(name);
        return ResponseEntity.ok("Це видавництво видалене з бази даних");
    }
}
//дописати в контроллері...
//створити нову гілку локально(розібратися що то таке)... додати коментар...
// і запушити в gitRepository, створити MergeRequest(pull request)
//специфікація spring boot...