package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<User, String> {}
