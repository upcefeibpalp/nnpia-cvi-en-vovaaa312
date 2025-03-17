package cz.upce.fei.nnpiavovaaa312.service;

import cz.upce.fei.nnpiavovaaa312.domain.User;
import cz.upce.fei.nnpiavovaaa312.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

//    private final HashMap<Long, User> users = new HashMap<>();

    private final UserRepository userRepository;


//    @PostConstruct
//    public void init() {
//
//        userRepository.saveAll(Arrays.asList(
//                new User(1l, "John Doe", "john@doe.com"),
//                new User(2l, "Doe John", "doe@john.com")
//        ));
//    }
//    public String findUser() {
//
//        logger.info(userRepository.findById(1L).toString());
//        return userRepository.findById(1L).toString();
//    }

    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
