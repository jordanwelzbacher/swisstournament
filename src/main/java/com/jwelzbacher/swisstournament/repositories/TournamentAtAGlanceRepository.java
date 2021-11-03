package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.DTOs.TournamentAtAGlance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentAtAGlanceRepository extends JpaRepository<TournamentAtAGlance, Long> {

    @Query(value = " SELECT tournament.id, st_user.username as owner_username, tournament_name, competition_type, tournament_date, " +
            "venue, is_player_registration_on, player_limit, is_registration_open, is_completed, " +
            "first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker, " +
            "first_custom_tiebreaker_name, second_custom_tiebreaker_name, lower_better_for_first_custom, lower_better_for_second_custom, " +
            "player.user_id IS NOT NULL as in_tourney, " +
            "COUNT(DISTINCT player) as count_players, " +
            "COUNT(DISTINCT round) as count_rounds FROM tournament " +
            "LEFT JOIN player ON tournament.id = player.tournament_id " +
            "LEFT JOIN round ON tournament.id = round.tournament_id " +
            "JOIN st_user ON owner_user_id = st_user.id " +
            "WHERE player.user_id = :userId OR player.user_id IS NULL " +
            "GROUP BY tournament.id, owner_username, tournament_name, competition_type, tournament_date, " +
            "venue, is_player_registration_on, player_limit, is_registration_open, is_completed, in_tourney, " +
            "first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker, " +
            "first_custom_tiebreaker_name, second_custom_tiebreaker_name, lower_better_for_first_custom, lower_better_for_second_custom " +
            "ORDER BY in_tourney DESC, tournament_date;", nativeQuery = true)
    List<TournamentAtAGlance> getTournamentsAtAGlance(@Param("userId") Long userId);

    @Query(value = " SELECT tournament.id, st_user.username as owner_username, tournament_name, competition_type, tournament_date, " +
            "venue, is_player_registration_on, player_limit, is_registration_open, is_completed, " +
            "first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker, " +
            "first_custom_tiebreaker_name, second_custom_tiebreaker_name, lower_better_for_first_custom, lower_better_for_second_custom, " +
            "false as in_tourney, " +
            "COUNT(DISTINCT player) as count_players, " +
            "COUNT(DISTINCT round) as count_rounds FROM tournament " +
            "LEFT JOIN player ON tournament.id = player.tournament_id " +
            "LEFT JOIN round ON tournament.id = round.tournament_id " +
            "JOIN st_user ON owner_user_id = st_user.id " +
            "GROUP BY tournament.id, owner_username, tournament_name, competition_type, tournament_date, " +
            "venue, is_player_registration_on, player_limit, is_registration_open, is_completed, " +
            "first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker, " +
            "first_custom_tiebreaker_name, second_custom_tiebreaker_name, lower_better_for_first_custom, lower_better_for_second_custom " +
            "ORDER BY tournament_date;", nativeQuery = true)
    List<TournamentAtAGlance> getTournamentsAtAGlance();

    @Query(value = " SELECT tournament.id, st_user.username as owner_username, tournament_name, competition_type, tournament_date, " +
            "venue, is_player_registration_on, player_limit, is_registration_open, is_completed, " +
            "COUNT(DISTINCT player) as count_players, " +
            "COUNT(DISTINCT round) as count_rounds, " +
            "first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker, " +
            "first_custom_tiebreaker_name, second_custom_tiebreaker_name, lower_better_for_first_custom, lower_better_for_second_custom " +
            "FROM tournament " +
            "LEFT JOIN player ON tournament.id = player.tournament_id " +
            "LEFT JOIN round ON tournament.id = round.tournament_id " +
            "JOIN st_user ON owner_user_id = st_user.id " +
            "WHERE tournament.id = :id " +
            "GROUP BY tournament.id, owner_username, tournament_name, competition_type, tournament_date, " +
            "venue, is_player_registration_on, player_limit, is_registration_open, is_completed, " +
            "first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker, " +
            "first_custom_tiebreaker_name, second_custom_tiebreaker_name, lower_better_for_first_custom, lower_better_for_second_custom;", nativeQuery = true)
    TournamentAtAGlance findByTournamentId(@Param("id") Long id);

}
