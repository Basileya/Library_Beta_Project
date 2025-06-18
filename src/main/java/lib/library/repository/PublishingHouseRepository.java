package lib.library.repository;

import lib.library.model.PublishingHouse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, Integer>, JpaSpecificationExecutor<PublishingHouse>{

    PublishingHouse getByName(String name);

    PublishingHouse getByNameAndDeleteFalse(String name);
}
