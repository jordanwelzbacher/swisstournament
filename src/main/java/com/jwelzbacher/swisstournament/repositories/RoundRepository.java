package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {
    List<Round> findByTournamentIdOrderByRoundNumber(Long tournamentId);
}
