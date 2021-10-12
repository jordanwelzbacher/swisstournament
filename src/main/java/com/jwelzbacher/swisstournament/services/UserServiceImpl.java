package com.jwelzbacher.swisstournament.services;

import com.jwelzbacher.swisstournament.Constants;
import com.jwelzbacher.swisstournament.models.User;
import com.jwelzbacher.swisstournament.exceptions.EtAuthException;
import com.jwelzbacher.swisstournament.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> validateUser(User user) throws EtAuthException {
        if (user.getUsername() != null) user.setUsername(user.getUsername().toLowerCase());
        else throw new EtAuthException("Username required");
        if (!userRepository.existsByUsername(user.getUsername())) throw new EtAuthException("Username or password incorrect.");
        if (user.getPassword().length() < 1) throw new EtAuthException("Password required");
        if (!BCrypt.checkpw(user.getPassword(), userRepository.findOneByUsername(user.getUsername()).getPassword()))
            throw new EtAuthException("Username or password incorrect.");
        return new ResponseEntity<Object>(generateJWTToken(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> registerUser(User user) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (user.getEmailAddress() != null) user.setEmailAddress(user.getEmailAddress().toLowerCase());
        else throw new EtAuthException("Email address required");
        if (user.getUsername().length() > 30) throw new EtAuthException("Username must be 30 characters or less");
        if (user.getFullName().length() > 60) throw new EtAuthException("Full name must be 60 characters or less");
        if (user.getEmailAddress().length() > 255) throw new EtAuthException("Email address must be 255 characters or less");
        if (!pattern.matcher(user.getEmailAddress()).matches()) throw new EtAuthException("Invalid email format");
        if (userRepository.existsByEmailAddress(user.getEmailAddress())) throw new EtAuthException("Email address already in use");
        if (userRepository.existsByUsername(user.getUsername())) throw new EtAuthException("Username already in use");
        user.setVerified(false);
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
        return new ResponseEntity<Object>(generateJWTToken(userRepository.save(user)), HttpStatus.OK);
    }

    private Map<String, String> generateJWTToken(User user) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("username", user.getUsername())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }
}
