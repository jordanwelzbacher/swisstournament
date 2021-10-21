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
DROP SEQUENCE IF EXISTS st_user_id_seq;

CREATE SEQUENCE IF NOT EXISTS st_user_id_seq
        INCREMENT 1
        START 1
        MINVALUE 1
        MAXVALUE 2147483647
        CACHE 1;

CREATE TABLE IF NOT EXISTS st_user
(
	id integer UNIQUE NOT NULL DEFAULT nextval('st_user_id_seq'::regclass),
	CONSTRAINT user_pk PRIMARY KEY (id),
	username character varying(25) UNIQUE NOT NULL,
	email_address character varying(100),
	password text NOT NULL,
	created_date timestamp with time zone,
	is_verified boolean,
	full_name character varying(60)
);


CREATE SEQUENCE IF NOT EXISTS tournament_id_seq
        INCREMENT 1
        START 10000
        MINVALUE 1
        MAXVALUE 2147483647
        CACHE 1;

CREATE TABLE IF NOT EXISTS tournament
(
        id integer UNIQUE NOT NULL DEFAULT nextval('tournament_id_seq'::regclass),
        CONSTRAINT tournament_pk PRIMARY KEY (id),
        owner_user_id integer,
        CONSTRAINT owner_user_id_fk FOREIGN KEY(owner_user_id) REFERENCES st_user(id),
        tournament_name character varying(255),
        competition_type character varying(255),
        tournament_date timestamp with time zone,
        venue character varying(255) COLLATE pg_catalog."default",
        is_player_registration_on boolean,
        is_player_results_on boolean,
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
        created_date timestamp with time zone,
        is_registration_open boolean,
        is_completed boolean
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
	CONSTRAINT tournament_admin_pk PRIMARY KEY (id),
	tournament_id integer,
	CONSTRAINT tournament_id_fk FOREIGN KEY(tournament_id) REFERENCES tournament(id),
	user_id integer,
	CONSTRAINT user_id_fk FOREIGN KEY(user_id) REFERENCES st_user(id)
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
        CONSTRAINT player_pk PRIMARY KEY (id),
	tournament_id integer,
	CONSTRAINT tournament_id_fk FOREIGN KEY(tournament_id) REFERENCES tournament(id),
	user_id integer,
	CONSTRAINT user_id_fk FOREIGN KEY(user_id) REFERENCES st_user(id),
	display_name varchar(60),
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
        CONSTRAINT round_pk PRIMARY KEY (id),
	tournament_id integer,
	CONSTRAINT tournament_id_fk FOREIGN KEY(tournament_id) REFERENCES tournament(id),
	round_number smallint,
	top_cut smallint
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
        CONSTRAINT pairing_pk PRIMARY KEY (id),
	player_a_id int,
	CONSTRAINT player_a_fk FOREIGN KEY(player_a_id) REFERENCES player(id),
	player_b_id int,
	CONSTRAINT player_b_fk FOREIGN KEY(player_b_id) REFERENCES player(id),
	round_id int,
	CONSTRAINT round_fk FOREIGN KEY(round_id) REFERENCES round(id),
	match_result_player_a character varying(4),
	match_result_player_b character varying(4),
	game_wins_player_a smallint,
	game_wins_player_b smallint,
	game_draws_player_a smallint,
	game_draws_player_b smallint,
	game_losses_player_a smallint,
	game_losses_player_b smallint,
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
        CONSTRAINT feedback_pk PRIMARY KEY (id),
	feedback_text character varying(8192),
	created_date timestamp with time zone
);
