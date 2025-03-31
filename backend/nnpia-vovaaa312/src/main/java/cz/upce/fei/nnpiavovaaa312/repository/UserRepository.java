package cz.upce.fei.nnpiavovaaa312.repository;

import cz.upce.fei.nnpiavovaaa312.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public  interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findById(Long id) ;

    public Optional<User> findByEmail(String email) ;

    public Optional<User> findByUsername(String username) ;

    // public Optional<User> save(User user);

    //public Optional<User> delete(Long id);

    // public Optional<User> update(User user);




}
