package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTournamentId(Long tournamentId);
}
