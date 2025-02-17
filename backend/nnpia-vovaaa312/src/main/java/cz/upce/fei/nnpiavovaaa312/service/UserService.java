package cz.upce.fei.nnpiavovaaa312.service;

import cz.upce.fei.nnpiavovaaa312.domain.User;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final HashMap<Long, User> users = new HashMap<>();

    @PostConstruct
    public void init() {

        Arrays.asList(
                new User(1l, "John Doe", "john@doe.com"),
                new User(2l, "Doe John", "doe@john.com")
        ).forEach(u -> users.put(u.getId(), u));
    }


    public String findUser() {
//        User user = new User(1l, "John Doe", "john@doe.com");
//
        logger.info(users.get(1L).toString());
        return users.get(1L).toString();
        //return "Hello World";
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }


    public String findUser(String name) {
        return "Hello, " + name;
    }

    public User findUser(Long id) {
        return users.get(id);
    }
}
