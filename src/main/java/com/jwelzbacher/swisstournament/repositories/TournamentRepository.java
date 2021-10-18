package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.DTOs.TournamentAtAGlance;
import com.jwelzbacher.swisstournament.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    @Query(value = " SELECT tournament.id as Id, owner_user_id as Owner_user_id, tournament_name as Tournament_name, competition_type as Competition_type, tournament_date as Tournament_date, " +
            "venue as Venue, is_player_registration_on as Is_player_registration_on, player_limit as Player_limit, is_registration_open as Is_registration_open, is_completed as Is_completed, " +
            "player.user_id IS NOT NULL as In_tourney, " +
            "COUNT(player) as Count_players, " +
            "COUNT(round) as Count_rounds FROM tournament " +
            "LEFT JOIN player ON tournament.id = player.tournament_id " +
            "LEFT JOIN round ON tournament.id = round.tournament_id " +
            "WHERE player.user_id = :userId OR player.user_id IS NULL " +
            "GROUP BY tournament.id, owner_user_id, tournament_name, competition_type, tournament_date, " +
            "venue, is_player_registration_on, player_limit, is_registration_open, is_completed, in_tourney;", nativeQuery = true)
    List<TournamentAtAGlance> getTournamentsAtAGlance(@Param("userId") Long userId);

}
