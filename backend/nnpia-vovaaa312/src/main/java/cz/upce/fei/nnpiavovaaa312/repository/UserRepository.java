package cz.upce.fei.nnpiavovaaa312.repository;

import cz.upce.fei.nnpiavovaaa312.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public  interface UserRepository extends JpaRepository<User, Long> {
    public User findUserById(Long id) ;

    public User findUserByEmail(String email);

    public User findUserByUsername(String username);

    public User save(User user);

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.Id = :id")
    void deleteUserById(@Param("id") Long id);

}
