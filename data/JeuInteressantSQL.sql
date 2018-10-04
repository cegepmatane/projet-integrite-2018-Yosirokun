--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5 (Ubuntu 10.5-0ubuntu0.18.04)
-- Dumped by pg_dump version 10.5 (Ubuntu 10.5-0ubuntu0.18.04)

-- Started on 2018-10-04 10:27:39 EDT

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
-- TOC entry 1 (class 3079 OID 13039)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2918 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 16390)
-- Name: jeu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jeu (
    id integer NOT NULL,
    nom text,
    description text
);


ALTER TABLE public.jeu OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16388)
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
-- TOC entry 2919 (class 0 OID 0)
-- Dependencies: 196
-- Name: jeu_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.jeu_id_seq OWNED BY public.jeu.id;


--
-- TOC entry 2785 (class 2604 OID 16393)
-- Name: jeu id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jeu ALTER COLUMN id SET DEFAULT nextval('public.jeu_id_seq'::regclass);


--
-- TOC entry 2910 (class 0 OID 16390)
-- Dependencies: 197
-- Data for Name: jeu; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jeu (id, nom, description) FROM stdin;
2	WowBFA	Nouvelle expention a la hauteur
3	Monster Hunter World	Le jeu de capcom tant attendu
1	Fallout76	Un bon jeu! woo
4	Forza H4	le jeu de course le plus attendu!
\.


--
-- TOC entry 2920 (class 0 OID 0)
-- Dependencies: 196
-- Name: jeu_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.jeu_id_seq', 4, true);


--
-- TOC entry 2787 (class 2606 OID 16398)
-- Name: jeu jeu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jeu
    ADD CONSTRAINT jeu_pkey PRIMARY KEY (id);


-- Completed on 2018-10-04 10:27:39 EDT

--
-- PostgreSQL database dump complete
--

