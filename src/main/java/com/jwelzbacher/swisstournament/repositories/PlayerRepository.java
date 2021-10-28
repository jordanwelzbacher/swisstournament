package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTournamentId(Long tournamentId);
}
