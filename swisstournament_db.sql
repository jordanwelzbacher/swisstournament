-- Table: public.tournament

DROP TABLE IF EXISTS pairing;
DROP SEQUENCE IF EXISTS pairing_id_seq;
DROP TABLE IF EXISTS round;
DROP SEQUENCE IF EXISTS round_id_seq;
DROP TABLE IF EXISTS player;
DROP SEQUENCE IF EXISTS player_id_seq;
DROP TABLE IF EXISTS tournament_admin;
DROP SEQUENCE IF EXISTS tournament_admin_id_seq;
DROP TABLE IF EXISTS tournament;
DROP SEQUENCE IF EXISTS tournament_id_seq;
DROP TABLE IF EXISTS st_user;


CREATE TABLE IF NOT EXISTS st_user
(
	username character varying(25) UNIQUE PRIMARY KEY NOT NULL,
	email_address character varying(255),
	password text NOT NULL,
	created_date timestamp with time zone,
	is_verified boolean,
	full_name character varying(60)
);

INSERT INTO st_user ( username, email_address, password, is_verified, full_name)
		VALUES ('admin', 'aceracerff@gmail.com', 'password123', TRUE, 'Jordan Welzbacher');

CREATE SEQUENCE IF NOT EXISTS tournament_id_seq
    INCREMENT 1
    START 10000
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE IF NOT EXISTS tournament
(
    id integer UNIQUE NOT NULL DEFAULT nextval('tournament_id_seq'::regclass),
	CONSTRAINT tournament_config_pkey PRIMARY KEY (id),
	owner_user_id character varying(25),
	CONSTRAINT owner_user_id_fk FOREIGN KEY(owner_user_id) REFERENCES st_user(username),
    tournament_name character varying(255),
    competition_type character varying(255),
    tournament_date timestamp with time zone,
    venue character varying(255) COLLATE pg_catalog."default",
    player_registration_on boolean,
    player_results_on boolean,
	player_limit int,
    win_points real,
    loss_points real,
    draw_points real,
    first_tiebreaker smallint,
    second_tiebreaker smallint,
    third_tiebreaker smallint,
    fourth_tiebreaker smallint,
    fifth_tiebreaker smallint,
    custom_a_name character varying(255),
    custom_b_name character varying(255),
    is_lower_better_for_custom_a boolean,
    is_lower_better_for_custom_b boolean,
	is_use_first_last boolean,
    created_date timestamp with time zone
);

CREATE SEQUENCE IF NOT EXISTS tournament_admin_id_seq
    INCREMENT 1
    START 10000
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE IF NOT EXISTS tournament_admin
(
	id integer UNIQUE NOT NULL DEFAULT nextval('tournament_admin_id_seq'::regclass),
	tournament_id integer,
	CONSTRAINT tournament_id_fk FOREIGN KEY(tournament_id) REFERENCES tournament(id),
	user_id character varying(25),
	CONSTRAINT user_id_fk FOREIGN KEY(user_id) REFERENCES st_user(username)
);

CREATE SEQUENCE IF NOT EXISTS player_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE IF NOT EXISTS player
(
    id integer UNIQUE NOT NULL DEFAULT nextval('player_id_seq'::regclass),
	tournament_id integer,
	CONSTRAINT tournament_id_fk FOREIGN KEY(tournament_id) REFERENCES tournament(id),
	user_id character varying(25),
	CONSTRAINT user_id_fk FOREIGN KEY(user_id) REFERENCES st_user(username),
	is_dropped boolean,
	is_confirmed boolean
);

CREATE SEQUENCE IF NOT EXISTS round_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE IF NOT EXISTS round
(
    id integer UNIQUE NOT NULL DEFAULT nextval('round_id_seq'::regclass),
	tournament_id integer,
	CONSTRAINT tournament_id_fk FOREIGN KEY(tournament_id) REFERENCES tournament(id),
	round_number smallint,
	top_cut smallint,
	match_result character varying(4),
	game_wins smallint,
	game_draws smallint,
	game_losses smallint,
	custom_a integer,
	custom_b integer
);

CREATE SEQUENCE IF NOT EXISTS pairing_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE IF NOT EXISTS pairing
(
    id integer UNIQUE NOT NULL DEFAULT nextval('pairing_id_seq'::regclass),
	tournament_id integer,
	CONSTRAINT tournament_id_fk FOREIGN KEY(tournament_id) REFERENCES tournament(id),
	player_a_id int,
	CONSTRAINT player_a_fk FOREIGN KEY(player_a_id) REFERENCES player(id),
	player_b_id int,
	CONSTRAINT player_b_fk FOREIGN KEY(player_b_id) REFERENCES player(id),
	match_result_player_a character varying(4),
	match_result_player_b character varying(4),
	game_wins_a smallint,
	game_wins_b smallint,
	game_draws_a smallint,
	game_draws_b smallint,
	game_losses_a smallint,
	game_losses_b smallint,
	custom_a_player_a integer,
	custom_a_player_b integer,
	custom_b_player_a integer,
	custom_b_player_b integer
);

CREATE SEQUENCE IF NOT EXISTS feedback_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE IF NOT EXISTS feedback
(
    id integer UNIQUE NOT NULL DEFAULT nextval('feedback_id_seq'::regclass),
	feedback_text character varying(8192),
	created_date timestamp with time zone
);
