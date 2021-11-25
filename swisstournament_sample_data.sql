--!                                                                             !--
--!   create two user accounts (use postman for speed) before running this!     !--
--!                                                                             !--

BEGIN TRANSACTION;

--10000: insert a completed tournament, no user accounts as players
INSERT INTO tournament 
(owner_user_id, tournament_name, competition_type, tournament_date, venue, 
is_player_registration_on, is_player_results_on, player_limit, win_points, loss_points, draw_points, games_per_match,
first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker,
first_custom_tiebreaker_name, second_custom_tiebreaker_name, lower_better_for_first_custom, lower_better_for_second_custom,
is_use_first_last, created_date, is_registration_open, is_completed)
VALUES 
(1, 'Completed Tournament', 'Programming 1v1', '2021-10-23 03:00:00', 'PCC', 
false, false, 64, 3, 0, 1, 1,
1, 0, 0, 0, 0,
'', '', false, false,
false, '2021-09-23', false, true);

INSERT INTO tournament_admin
(tournament_id, user_id)
VALUES
(10000, 1),
(10000, 2);



INSERT INTO player
(tournament_id, display_name, is_dropped, is_confirmed)
VALUES
(10000, 'Drake Alexus', false, true),
(10000, 'Shannen Ebba', false, true),
(10000, 'Eleanor Gisselle', false, true),
(10000, 'Joanna Justy', false, true),
(10000, 'Tamara Stu', false, true),
(10000, 'Rollo Venetia', false, true),
(10000, 'Evelina Edith', false, true),
(10000, 'Odetta Zachary', false, true);

INSERT INTO round
(tournament_id, round_number)
VALUES
(10000, 1),
(10000, 2),
(10000, 3);

INSERT INTO round
(tournament_id, round_number, top_cut)
VALUES
(10000, 4, 4);

INSERT INTO round
(tournament_id, round_number, top_cut)
VALUES
(10000, 5, 2);

INSERT INTO pairing
(first_player_id, second_player_id, round_id, table_number, match_result_first_player, match_result_second_player)
VALUES
(1,2,1,1,'WIN','LOSS'),
(3,4,1,2,'WIN','LOSS'),
(5,6,1,3,'WIN','LOSS'),
(7,8,1,4,'WIN','LOSS'),

(1,3,2,1,'WIN','LOSS'),
(2,4,2,2,'WIN','LOSS'),
(5,7,2,3,'WIN','LOSS'),
(6,8,2,4,'WIN','LOSS'),

(1,5,3,1,'WIN','LOSS'),
(2,6,3,2,'WIN','LOSS'),
(3,7,3,3,'WIN','LOSS'),
(4,8,3,4,'WIN','LOSS'),

(1,3,4,1,'WIN','LOSS'),
(2,5,4,2,'WIN','LOSS'),
(1,2,5,1,'WIN','LOSS');

--10001: insert an in-progress tournament, no user accounts as players

INSERT INTO tournament 
(owner_user_id, tournament_name, competition_type, tournament_date, venue, 
is_player_registration_on, is_player_results_on, player_limit, win_points, loss_points, draw_points, games_per_match,
first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker,
first_custom_tiebreaker_name, second_custom_tiebreaker_name, lower_better_for_first_custom, lower_better_for_second_custom,
is_use_first_last, created_date, is_registration_open, is_completed)
VALUES 
(1, 'In-Progress Tournament', 'Programming 1v1', '2021-10-23 03:00:00', 'GCCC', 
false, false, 64, 3, 0, 1, 1,
1, 0, 0, 0, 0,
'', '', false, false,
false, '2021-09-23', false, false);

INSERT INTO tournament_admin
(tournament_id, user_id)
VALUES
(10001, 2);

INSERT INTO player
(tournament_id, display_name, is_dropped, is_confirmed)
VALUES
(10001, 'Johnathan Albert', false, true),
(10001, 'Weston Serina', false, true),
(10001, 'Lennox Trina', false, true),
(10001, 'Dusty Alexia', false, true),
(10001, 'Jocelyn Lucinda', false, true),
(10001, 'Lexi Joseph', false, true),
(10001, 'Polly Alex', false, true),
(10001, 'Lorayne Sienna', false, true);

INSERT INTO round
(tournament_id, round_number)
VALUES
(10001, 1);

INSERT INTO pairing
(first_player_id, second_player_id, round_id, table_number, match_result_first_player, match_result_second_player)
VALUES
(9,10,6,1,'WIN','LOSS'),
(11,12,6,2,'WIN','LOSS'),
(13,14,6,3,'WIN','LOSS'),
(15,16,6,4,'WIN','LOSS');

--10002: insert a freshly made tournament, registration open
INSERT INTO tournament 
(owner_user_id, tournament_name, competition_type, tournament_date, venue, 
is_player_registration_on, is_player_results_on, player_limit, win_points, loss_points, draw_points, games_per_match,
first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker,
first_custom_tiebreaker_name, second_custom_tiebreaker_name, lower_better_for_first_custom, lower_better_for_second_custom,
is_use_first_last, created_date, is_registration_open, is_completed)
VALUES 
(1, 'Freshly Created Tournament', 'No Signups Yet', '2021-10-23 03:00:00', 'CGCC', 
true, true, 128, 3, 0, 1, 1,
1, 0, 0, 0, 0,
'', '', false, false,
false, '2021-09-23', true, false);


--100003: insert an in progress tournament, one user account as a player, FFTCG
INSERT INTO tournament 
(owner_user_id, tournament_name, competition_type, tournament_date, venue, 
is_player_registration_on, is_player_results_on, player_limit, win_points, loss_points, draw_points, games_per_match,
first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker,
first_custom_tiebreaker_name, second_custom_tiebreaker_name, lower_better_for_first_custom, lower_better_for_second_custom,
is_use_first_last, created_date, is_registration_open, is_completed)
VALUES 
(1, 'FFTCG In-Progress', 'FFTCG', '2021-10-23 03:00:00', 'GCCC', 
true, true, 64, 1, 0, 0, 1,
1, 5, 6, 0, 0,
'Damage Dealt', 'Damage Received', false, true,
false, '2021-09-23', false, false);

INSERT INTO player
(tournament_id, user_id, display_name, is_dropped, is_confirmed)
VALUES
(10003,2, 'Ron Do', false, true),
(10003,null, 'Weston Serina', false, true),
(10003,null, 'Lennox Trina', false, true),
(10003,null, 'Dusty Alexia', false, true),
(10003,null, 'Jocelyn Lucinda', false, true),
(10003,null, 'Lexi Joseph', false, true),
(10003,null, 'Polly Alex', false, true),
(10003,null, 'Lorayne Sienna', false, true);

INSERT INTO round
(tournament_id, round_number)
VALUES
(10003, 1);

INSERT INTO pairing
(first_player_id, second_player_id, round_id, table_number, match_result_first_player, match_result_second_player, 
game_wins_first_player, game_wins_second_player, game_draws_first_player, game_draws_second_player, game_losses_first_player, game_losses_second_player,
first_custom_first_player, second_custom_first_player, first_custom_second_player, second_custom_second_player)
VALUES
(17,18,7,1,'WIN','LOSS',
2,1,0,0,1,2,
7,3,3,7),
(19,20,7,2,'WIN','LOSS',
1,2,0,0,2,1,
7,5,5,7);

INSERT INTO pairing
(first_player_id, second_player_id, round_id, table_number)
VALUES
(21,22,7,3),
(23,24,7,4);



--100004: insert an in progress tournament, one user account as a player, MTG
INSERT INTO tournament 
(owner_user_id, tournament_name, competition_type, tournament_date, venue, 
is_player_registration_on, is_player_results_on, player_limit, win_points, loss_points, draw_points, games_per_match,
first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker,
first_custom_tiebreaker_name, second_custom_tiebreaker_name, lower_better_for_first_custom, lower_better_for_second_custom,
is_use_first_last, created_date, is_registration_open, is_completed)
VALUES 
(1, 'BO3 In-Progress', 'MTG', '2021-10-23 03:00:00', 'ICC', 
true, true, 64, 3, 0, 1, 3,
1, 3, 4, 0, 0,
'', '', false, false,
false, '2021-09-23', false, false);

INSERT INTO player
(tournament_id, user_id, display_name, is_dropped, is_confirmed)
VALUES
(10004,2, 'Ron Do', false, true),
(10004,null, 'Weston Serina', false, true),
(10004,null, 'Lennox Trina', false, true),
(10004,null, 'Dusty Alexia', false, true),
(10004,null, 'Jocelyn Lucinda', false, true),
(10004,null, 'Lexi Joseph', false, true),
(10004,null, 'Polly Alex', false, true),
(10004,null, 'Lorayne Sienna', false, true);

INSERT INTO round
(tournament_id, round_number)
VALUES
(10004, 1);

INSERT INTO pairing
(first_player_id, second_player_id, round_id, table_number, match_result_first_player, match_result_second_player, 
game_wins_first_player, game_wins_second_player, game_draws_first_player, game_draws_second_player, game_losses_first_player, game_losses_second_player)
VALUES
(31,32,8,1,'LOSS','WIN',
1,2,0,0,2,1),
(27,28,8,2,'WIN','LOSS',
2,0,1,1,0,2);

INSERT INTO pairing
(first_player_id, second_player_id, round_id, table_number)
VALUES
(29,30,8,3),
(25,26,8,4);


COMMIT;


