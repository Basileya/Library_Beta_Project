package lib.library.repository;

import lib.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);

    List<User> findBySurname(String surname);

    //     як генеруються кастомні методи в jpa репозиторії?;
}