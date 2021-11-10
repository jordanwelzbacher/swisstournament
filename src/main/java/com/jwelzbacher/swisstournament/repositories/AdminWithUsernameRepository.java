package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.DTOs.AdminWithUsername;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminWithUsernameRepository extends JpaRepository<AdminWithUsername, Long> {

    @Query(value = "SELECT tournament_admin.id as id, tournament_id, user_id, username FROM tournament_admin " +
            "JOIN st_user ON tournament_admin.user_id = st_user.id " +
            "WHERE tournament_id = :tournamentId " +
            "ORDER BY username;", nativeQuery = true)
    List<AdminWithUsername> findByTournamentId(@Param("tournamentId") Long tournamentId);

    @Query(value = "SELECT tournament_admin.id as id, tournament_id, user_id, username FROM tournament_admin " +
            "JOIN st_user ON tournament_admin.user_id = st_user.id " +
            "WHERE tournament_admin.id = :adminId " +
            "ORDER BY username;", nativeQuery = true)
    AdminWithUsername findByAdminId(@Param("adminId") Long adminId);

}
