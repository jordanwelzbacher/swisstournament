package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Pairing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PairingRepository extends JpaRepository<Pairing, Long> {
    List<Pairing> findByRoundId(Long roundId);

    @Query(value = "SELECT * FROM pairing " +
            "WHERE first_player_id = :playerId OR second_player_id = :playerId " +
            "ORDER BY round_id;", nativeQuery = true)
    List<Pairing> findByPlayerId(@Param("playerId") Long playerId);
}
