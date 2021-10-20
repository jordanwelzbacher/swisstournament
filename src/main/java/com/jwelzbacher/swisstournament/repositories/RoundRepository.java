package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Round;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoundRepository extends JpaRepository<Round, Long> {
    List<Round> findByTournamentId(Long tournament_id);
}
