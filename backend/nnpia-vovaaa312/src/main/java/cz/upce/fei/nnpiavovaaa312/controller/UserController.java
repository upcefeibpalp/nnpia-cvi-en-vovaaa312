package cz.upce.fei.nnpiavovaaa312.controller;

import cz.upce.fei.nnpiavovaaa312.domain.User;
import cz.upce.fei.nnpiavovaaa312.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {
        User finded = userService.findByEmail(email);
        return ResponseEntity.ok(finded);
    }
    @PostMapping("/save")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?>findAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

}

