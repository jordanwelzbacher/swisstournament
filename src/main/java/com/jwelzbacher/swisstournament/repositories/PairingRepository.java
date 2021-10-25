package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Pairing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PairingRepository extends JpaRepository<Pairing, Long> {
    List<Pairing> findByRoundId(Long roundId);
    List<Pairing> findByFirstPlayerId(Long playerId);
    List<Pairing> findBySecondPlayerId(Long playerId);
}
