package bearcation.controller;

import bearcation.model.User;
import bearcation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User userById(@PathVariable("id") Long id) {
        return userService.userById(id);
    }

    @PostMapping("/users")
    public User createEmployee(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/check")
    public User checkEmployee(@RequestBody User user) {
        return userService.userByUsernameAndPassword(user);
    }

    @PutMapping("/update")
    public void updateLocation(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/delete/{username}")
    public void deleteLocation(@PathVariable String username){
        userService.deleteUser(username);
    }
    /*
    @PostMapping("post")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

     */
}