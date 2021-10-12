package com.jwelzbacher.swisstournament.services;

import com.jwelzbacher.swisstournament.models.User;
import com.jwelzbacher.swisstournament.exceptions.EtAuthException;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> validateUser (User user) throws EtAuthException;

    ResponseEntity<?> registerUser (User user) throws EtAuthException;

}