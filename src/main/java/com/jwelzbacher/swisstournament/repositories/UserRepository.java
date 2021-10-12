package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Tournament;
import com.jwelzbacher.swisstournament.models.User;
import com.jwelzbacher.swisstournament.exceptions.EtAuthException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByEmailAddress(String emailAddress);
    boolean existsByUsername(String username);
    User findOneByUsername(String username);

//
//    void create(String username, String fullName, String emailAddress, String password, boolean isVerified) throws EtAuthException;
//
//    User findByUsernameAndPassword(String username, String password) throws EtAuthException;
//
//    Integer getCountByEmail(String emailAddress);
//
//    Integer getCountByUsername(String emailAddress);
//
//    User findByUsername(String username);

}
