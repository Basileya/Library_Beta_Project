package lib.library.service;

import lib.library.dto.PublishingHouseDTO;
import lib.library.model.PublishingHouse;

import java.io.IOException;
import java.util.Optional;

public interface PublishingHouseService {

    PublishingHouse addPublishingHouse (PublishingHouseDTO publishingHouseDTO);

    PublishingHouse updatePublishingHouse (PublishingHouseDTO publishingHouseDTO, Integer id);

    Optional<PublishingHouse> getPublishingHouse (Integer id);

    void deletePublishingHouse(String name) throws IOException;





}
