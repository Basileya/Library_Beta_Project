package lib.library.controller;

import lib.library.dto.UserDTO;
import lib.library.model.User;
import lib.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDTO>> getByUserName(@RequestParam String name){
        return new ResponseEntity<List<UserDTO>>(userService.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/add/{user}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO){
        Optional<User> user = userService.addUser(userDTO);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PutMapping("/upgrade/{user}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> updateUser(@ModelAttribute UserDTO userDTO, @RequestParam Integer id){
        Optional<User> user = userService.updateUser(userDTO, id);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @DeleteMapping("/delede/{user}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteUser(@PathVariable String name) throws IOException {
        userService.deleteUser(name);
        return ResponseEntity.ok("Користувач видалений");
    }
    
// написати бізнес логіку беремо книгу по id і в базі даних
// повинно відніматися що на 1 книгу менше. повернув +1 книга.
    //===========================================================================================
    // створити метод який буде повертати книги (коли принесе користувач)...
    // почитати @OneToMany реалізацію для LibraryCardData
    //===========================================================================================

    // якщо книга остання - видаємо... (якщо книг нема повертаємо помилку "не можемо видати. звертайтесь пізніше")
}
