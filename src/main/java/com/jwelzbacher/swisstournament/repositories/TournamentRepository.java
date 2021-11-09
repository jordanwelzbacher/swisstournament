package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    Long getOwnerUserIdById(Long id);
}
