package bearcation.controller;

import bearcation.model.dto.LocationDTO;
import bearcation.model.dto.UserDTO;
import bearcation.service.ReviewService;
import bearcation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

}