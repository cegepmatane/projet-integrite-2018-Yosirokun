--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5 (Ubuntu 10.5-0ubuntu0.18.04)
-- Dumped by pg_dump version 10.5 (Ubuntu 10.5-0ubuntu0.18.04)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: jeu_interessant; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE jeu_interessant WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE jeu_interessant OWNER TO postgres;

\connect jeu_interessant

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: jeu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jeu (
    id integer NOT NULL,
    nom text,
    description text
);


ALTER TABLE public.jeu OWNER TO postgres;

--
-- Name: jeu_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.jeu_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.jeu_id_seq OWNER TO postgres;

--
-- Name: jeu_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.jeu_id_seq OWNED BY public.jeu.id;


--
-- Name: studio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.studio (
);


ALTER TABLE public.studio OWNER TO postgres;

--
-- Name: jeu id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jeu ALTER COLUMN id SET DEFAULT nextval('public.jeu_id_seq'::regclass);


--
-- Data for Name: jeu; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.jeu VALUES (2, 'WowBFA', 'Nouvelle expention a la hauteur');
INSERT INTO public.jeu VALUES (3, 'Monster Hunter World', 'Le jeu de capcom tant attendu');
INSERT INTO public.jeu VALUES (5, 'hifhdsif', 'feiowsfhfewfs');
INSERT INTO public.jeu VALUES (1, 'Fallout76', 'Un bon jeu! woo');
INSERT INTO public.jeu VALUES (4, 'Forza H4', 'le jeu de course le plus attendu!');


--
-- Data for Name: studio; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: jeu_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.jeu_id_seq', 5, true);


--
-- Name: jeu jeu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jeu
    ADD CONSTRAINT jeu_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

