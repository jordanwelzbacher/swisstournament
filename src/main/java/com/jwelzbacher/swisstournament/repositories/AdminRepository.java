package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(value = "SELECT user_id, username, st_user.id FROM tournament_admin " +
            "JOIN st_user ON tournament_admin.user_id = st_user.id " +
            "WHERE tournament_id = :tournamentId " +
            "ORDER BY username;", nativeQuery = true)
    List<Admin> findByTournamentId(@Param("tournamentId") Long tournamentId);
}