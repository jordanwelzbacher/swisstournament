SELECT tournament.id, owner_user_id, tournament_name, competition_type, tournament_date,
venue, is_player_registration_on, player_limit, is_registration_open, is_completed,
player.user_id IS NOT NULL as in_tourney,
COUNT(player) as count_players,
COUNT(round) as count_rounds
FROM tournament
LEFT JOIN player ON tournament.id = player.tournament_id
LEFT JOIN round ON tournament.id = round.tournament_id
WHERE player.user_id = :username OR player.user_id IS NULL
GROUP BY tournament.id, owner_user_id, tournament_name, competition_type, tournament_date,
venue, is_player_registration_on, player_limit, is_registration_open, is_completed, in_tourney;
