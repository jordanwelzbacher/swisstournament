--create two user accounts on frontend before running this

BEGIN TRANSACTION;

--insert a completed tournament, no user accounts as players
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
(tournament_id, round_number)
VALUES
(10000, 5);


INSERT INTO pairing
(first_player_id, second_player_id, round_id, match_result_first_player, match_result_second_player)
VALUES
(1,2,1,'WIN','LOSS'),
(3,4,1,'WIN','LOSS'),
(5,6,1,'WIN','LOSS'),
(7,8,1,'WIN','LOSS'),

(1,3,2,'WIN','LOSS'),
(2,4,2,'WIN','LOSS'),
(5,7,2,'WIN','LOSS'),
(6,8,2,'WIN','LOSS'),

(1,5,3,'WIN','LOSS'),
(2,6,3,'WIN','LOSS'),
(3,7,3,'WIN','LOSS'),
(4,8,3,'WIN','LOSS'),

(1,3,4,'WIN','LOSS'),
(2,5,4,'WIN','LOSS'),
(1,2,5,'WIN','LOSS');

--insert an in-progress tournament, no user accounts as players

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
(first_player_id, second_player_id, round_id, match_result_first_player, match_result_second_player)
VALUES
(9,10,6,'WIN','LOSS'),
(11,12,6,'WIN','LOSS'),
(13,14,6,'WIN','LOSS'),
(15,16,6,'WIN','LOSS');

--insert a freshly made tournament, registration open
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


COMMIT;