package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAddress(String emailAddress);
    boolean existsByUsername(String username);
    User findOneById(Long Id);
    User findOneByUsername(String username);

}
