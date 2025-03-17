package cz.upce.fei.nnpiavovaaa312.service;

import cz.upce.fei.nnpiavovaaa312.domain.User;
import cz.upce.fei.nnpiavovaaa312.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findUserById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User deleteUserById(Long id) {
        User deletedUser = userRepository.findUserById(id);
        userRepository.deleteUserById(id);
        return deletedUser;
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        // обновите другие поля по необходимости
        return userRepository.save(existingUser);
    }
}
