package lib.library.map;

import lib.library.dto.UserDTO;
import lib.library.model.LibraryCardData;
import lib.library.model.User;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class UserMap {

    public User saveUser(UserDTO userDTO){
        User user = new User();
        user.setSurname(userDTO.getSurname());
        user.setName(userDTO.getName());
        user.setBirthYear(userDTO.getBirthYear());
        user.setDelete(userDTO.getDelete());
        LibraryCardData libraryCardData = new LibraryCardData();
        libraryCardData.setDate(userDTO.getLibraryCardData().getDate());
//        user.setLibraryCardData(libraryCardData);
        return user;
    }

    public User updateUser(UserDTO userDTO, Integer id){
        User user = new User();
        user.setId(id);
        user.setSurname(userDTO.getSurname());
        user.setName(userDTO.getName());
        user.setBirthYear(userDTO.getBirthYear());
        user.setDelete(userDTO.getDelete());
        LibraryCardData libraryCardData = new LibraryCardData();
        libraryCardData.setId(userDTO.getLibraryCardData().getId());
//        user.setLibraryCardData(libraryCardData);
        return user;
    }

    public UserDTO updateUser(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setSurname(user.getSurname());
        userDTO.setName(user.getName());
        userDTO.setBirthYear(user.getBirthYear());
        userDTO.setDelete(user.getDelete());
        LibraryCardData libraryCardData = new LibraryCardData();
        userDTO.setLibraryCardData(libraryCardData);
        return userDTO;
    }

}
