package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAddress(String emailAddress);
    boolean existsByUsername(String username);
    User findOneById(Long Id);
    User findOneByUsername(String username);

}
