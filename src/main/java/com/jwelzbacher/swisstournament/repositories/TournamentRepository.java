package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    Long getOwnerUserIdById(Long id);

    @Query(value = "SELECT t.id FROM pairing p " +
            "JOIN round r ON p.round_id = r.id " +
            "JOIN tournament t ON r.tournament_id = t.id " +
            "WHERE p.id = :pairingId", nativeQuery = true)
    Long getIdByPairingId(Long pairingId);
}
