package lib.library.service;

import jakarta.persistence.EntityNotFoundException;
import lib.library.dto.UserDTO;
import lib.library.map.UserMap;
import lib.library.model.User;
import lib.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMap userMap;

     @Override
    public List<UserDTO> findByName(String name) {
        List<User> users = userRepository.findByName(name);
        List<UserDTO> usersDTO = users.stream().map(m -> userMap.updateUser(m))
                 .collect(Collectors.toList());
        return usersDTO;
    }

    @Override
    public Optional<User> addUser(UserDTO userDTO) {
        User map = userMap.saveUser(userDTO);
//        User saveUser = userRepository.save(map);
        return Optional.of(userRepository.save(map));
    }

    @Override
    public Optional<User> updateUser(UserDTO userDTO, Integer id) {
      User user = userMap.updateUser(userDTO, id);
       return Optional.of(userRepository.save(user));
    }

    @Override
    public void deleteUser(String name) throws IOException {
        User user = (User) userRepository.findByName(name);

        if (user == null) {
            throw new EntityNotFoundException("Користувач із ім'ям " + user + " не існує");
        }

        if (user.getDelete() == false){
            user.setDelete(true);
            userRepository.save(user);
        } else {
            throw new IOException("Вийшов термін читацького квитка " + user);
        }
    }


    // створити користувача... методи create, delete, update, get...
}
