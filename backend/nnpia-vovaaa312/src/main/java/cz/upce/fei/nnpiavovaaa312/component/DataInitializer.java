package cz.upce.fei.nnpiavovaaa312.component;

import cz.upce.fei.nnpiavovaaa312.domain.User;
import cz.upce.fei.nnpiavovaaa312.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner{

    private final UserRepository userRepository;



    @Override
    public void run(String... args) throws Exception {
//        User admin = new User(1L, "admin", "admin@mail.com");
//        userRepository.save(admin);
//
//        log.info(userRepository.findById(1L).toString());
    }
}

