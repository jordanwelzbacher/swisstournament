package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> findByTournamentId(Long tournament_id);
}
