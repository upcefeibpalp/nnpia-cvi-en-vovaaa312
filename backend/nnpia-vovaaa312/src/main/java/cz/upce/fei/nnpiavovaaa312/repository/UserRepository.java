package cz.upce.fei.nnpiavovaaa312.repository;

import cz.upce.fei.nnpiavovaaa312.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public  interface UserRepository extends JpaRepository<User, Integer> {
    public User findById(Long id) ;

    public User findByEmail(String email) ;

    public User findByUsername(String username) ;

    public User save(User user);


}
