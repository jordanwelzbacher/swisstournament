--create two user accounts on frontend before running this

INSERT INTO tournament 
(owner_user_id, tournament_name, competition_type, tournament_date, venue, 
is_player_registration_on, is_player_results_on, player_limit, win_points, loss_points, draw_points, games_per_match,
first_tiebreaker, second_tiebreaker, third_tiebreaker, fourth_tiebreaker, fifth_tiebreaker,
custom_a_name, custom_b_name, is_lower_better_for_custom_a, is_lower_better_for_custom_b,
is_use_first_last, created_date, is_registration_open, is_completed)
VALUES 
(1, 'Grand Prix Powell', 'Programming 1v1', '2021-10-23 03:00:00', 'PCC', 
false, false, 64, 3, 0, 1, 1,
1, 0, 0, 0, 0,
'', '', false, false,
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
(player_a_id, player_b_id, round_id, match_result_player_a, match_result_player_b)
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
--1: 3
--2: 2
--3: 2
--4: 1
--5: 2
--6: 1
--7: 1
--8: 0
(1,3,4,'WIN','LOSS'),
(2,5,4,'WIN','LOSS'),
(1,2,5,'WIN','LOSS');

SELECT * FROM pairing;