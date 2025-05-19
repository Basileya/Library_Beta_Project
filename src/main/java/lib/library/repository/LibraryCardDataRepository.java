package lib.library.repository;

import lib.library.model.LibraryCardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardDataRepository extends JpaRepository<LibraryCardData, Integer> {
}
