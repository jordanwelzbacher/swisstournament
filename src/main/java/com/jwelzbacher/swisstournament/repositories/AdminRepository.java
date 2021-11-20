package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    List<Admin> findByTournamentId(Long tournamentId);

    @Query(value = "SELECT ta.id, ta.tournament_id, ta.user_id FROM pairing p " +
            "JOIN round r ON p.round_id = r.id " +
            "JOIN tournament t ON r.tournament_id = t.id " +
            "JOIN tournament_admin ta ON t.id = ta.tournament_id " +
            "WHERE p.id = :pairingId " +
            "ORDER BY ta.id;", nativeQuery = true)
    List<Admin> findByPairingId(Long pairingId);

//    @Query(value = "SELECT tournament_admin.id as id, tournament_id, user_id, username FROM tournament_admin " +
//            "JOIN st_user ON tournament_admin.user_id = st_user.id " +
//            "WHERE tournament_id = :tournamentId " +
//            "ORDER BY username;", nativeQuery = true)
//    List<Admin> findByTournamentId(@Param("tournamentId") Long tournamentId);

//    @Query(value = "INSERT INTO tournament_admin (tournament_id, user_id) " +
//            "VALUES (:tournamentId, :userId) " +
//            "RETURNING id;", nativeQuery = true)
//    Long addAdmin(@Param("tournamentId") Long tournamentId, @Param("userId") Long userId);

}