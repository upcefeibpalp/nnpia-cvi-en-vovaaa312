package cz.upce.fei.nnpiavovaaa312.service;

import cz.upce.fei.nnpiavovaaa312.domain.User;
import cz.upce.fei.nnpiavovaaa312.domain.exception.UserAlreadyExistsException;
import cz.upce.fei.nnpiavovaaa312.domain.exception.UserNotFoundException;
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
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found"));
    }

    public User save(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists");
        }


        return userRepository.save(user);
    }

    public User deleteUser(Long id) {
        User deleted = findById(id);
        userRepository.delete(deleted);
        return deleted;

    }

    public User updateUser(User user) {
        User existingUser = findById(user.getId());
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        return userRepository.saveAndFlush(existingUser);
    }
}
