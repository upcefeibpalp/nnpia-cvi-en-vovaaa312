package cz.upce.fei.nnpiavovaaa312.controller;

import cz.upce.fei.nnpiavovaaa312.domain.User;
import cz.upce.fei.nnpiavovaaa312.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/user")
//    public String findUser() {
//        return userService.findById();
//    }
//
//    @GetMapping("/users/find/{id}")
//    public String findUserById(@PathVariable Long id) {
//        return userService.findById(id).toString();
//    }


    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<?> findByEmail(@RequestParam String findByEmail) {
        return ResponseEntity.ok(userService.findByEmail(findByEmail));
    }
    @PostMapping("/save")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }



    @GetMapping("/users")
    public Collection<User> findAll() {
        return userService.getAllUsers();
    }


}

