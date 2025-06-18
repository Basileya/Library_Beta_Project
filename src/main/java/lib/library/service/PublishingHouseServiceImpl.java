package lib.library.service;

import jakarta.persistence.EntityNotFoundException;
import lib.library.dto.PublishingHouseDTO;
import lib.library.map.PublishingHouseMap;
import lib.library.model.PublishingHouse;
import lib.library.repository.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class PublishingHouseServiceImpl implements PublishingHouseService{

    @Autowired
    PublishingHouseRepository publishingHouseRepository;

    @Autowired
    PublishingHouseMap publishingHouseMap;


    @Override
    public PublishingHouse addPublishingHouse(PublishingHouseDTO publishingHouseDTO) {
        PublishingHouse map = publishingHouseMap.savePublishingHouse(publishingHouseDTO);
        PublishingHouse publishingHouse = publishingHouseRepository.save(map);
        return publishingHouse;
    }

    @Override
    public PublishingHouse updatePublishingHouse(PublishingHouseDTO publishingHouseDTO, Integer id) {
        PublishingHouse map = publishingHouseMap.updatePublishingHouse(publishingHouseDTO, id);
        return publishingHouseRepository.save(map);
    }

    @Override
    public Optional<PublishingHouse> getPublishingHouse(Integer id) {
        return publishingHouseRepository.findById(id);
    }

    
    @Override
    public void deletePublishingHouse(String name) throws IOException {
        PublishingHouse publishingHouse = publishingHouseRepository.getByNameAndDeleteFalse(name);
        publishingHouseRepository.findAll();
        if (publishingHouse == null){
            throw new EntityNotFoundException("Видавництва " + name +  " немає в наявності") ;
        }
        if (publishingHouse.getDelete() == false){
            publishingHouse.setDelete(true);
            publishingHouseRepository.save(publishingHouse);
        } else {
            throw new IOException("Не співпрацюємо із видавництвом " + publishingHouse);
        }
    }


}
