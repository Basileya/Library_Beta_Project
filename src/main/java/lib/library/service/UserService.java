package lib.library.service;

import lib.library.dto.UserDTO;
import lib.library.model.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService{

    List<UserDTO> findByName(String name);

    Optional<User> addUser(UserDTO userDTO);

    Optional<User> updateUser(UserDTO userDTO, Integer id);

    void deleteUser(String name) throws IOException;

}
