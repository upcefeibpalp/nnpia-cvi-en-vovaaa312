package cz.upce.fei.nnpiavovaaa312.controller;

import cz.upce.fei.nnpiavovaaa312.domain.User;
import cz.upce.fei.nnpiavovaaa312.domain.exception.UserAlreadyExistsException;
import cz.upce.fei.nnpiavovaaa312.domain.exception.UserNotFoundException;
import cz.upce.fei.nnpiavovaaa312.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        // Místo toho, abychom vraceli entitu, vracíme DTO.
        return ResponseEntity.ok(userService.findById(id).toDto());
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<?> findByEmail(@RequestParam String findByEmail) {
        return ResponseEntity.ok(userService.findByEmail(findByEmail));
    }
    @PostMapping("/save")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/findAll")
    public Collection<User> findAll() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping()
    public ResponseEntity<?>deleteUser(@RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(user));
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

}

