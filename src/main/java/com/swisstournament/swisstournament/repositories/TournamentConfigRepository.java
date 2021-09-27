package com.swisstournament.swisstournament.repositories;

import com.swisstournament.swisstournament.models.TournamentConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentConfigRepository extends JpaRepository<TournamentConfig, Long> {

}
