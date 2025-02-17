package cz.upce.fei.nnpiavovaaa312.controller;

import cz.upce.fei.nnpiavovaaa312.domain.User;
import cz.upce.fei.nnpiavovaaa312.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String findUser() {
        return userService.findUser();
    }

    @GetMapping("/users")
    public Collection<User> findUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/find/{id}")
    public String findUserById(@PathVariable Long id) {
        return userService.findUser(id).toString();
    }

    @GetMapping("/greeting/{name}")
    public String findUser(
            @PathVariable String name
    ) {
        return userService.findUser(name);
    }

}

