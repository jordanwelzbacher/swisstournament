--create two user accounts on frontend before running this

INSERT INTO tournament 
(owner_user_id, tournament_name, competition_type, tournament_date, venue, 
is_player_registration_on, is_player_results_on, player_limit, win_points, loss_points, draw_points,
first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker,
custom_a_name, custom_b_name, is_lower_better_for_custom_a, is_lower_better_for_custom_b,
is_use_first_last, created_date, is_registration_open, is_completed)
VALUES 
(1, 'Grand Prix Powell', 'Programming 1v1', '2021-10-23 03:00:00', 'PCC', 
false, false, 64, 3, 0, 1, 
1, 0, 0, 0, 0,
null, null, false, false,
false, '2021-09-23', false, false);

INSERT INTO tournament_admin
(tournament_id, user_id)
VALUES
(10000, 2);

INSERT INTO player
(tournament_id, display_name, is_dropped, is_confirmed)
VALUES
(10000, 'Cass Kay', false, true),
(10000, 'Ron Shabon', false, true),
(10000, 'Wil Rad', false, true),
(10000, 'Faf Ron', false, true),
(10000, 'Kick Stand', false, true),
(10000, 'Squar Ed', false, true),
(10000, 'Dia Wheaties', false, true),
(10000, 'Grack Son', false, true);

INSERT INTO round
(tournament_id, round_number)
VALUES
(10000, 1);

INSERT INTO pairing
(player_a_id, player_b_id, round_id)
VALUES
(1,2,1),
(3,4,1),
(5,6,1),
(7,8,1);

SELECT * FROM player;