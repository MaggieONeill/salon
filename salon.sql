--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: sandimckendrick; Tablespace: 
--

CREATE TABLE clients (
    id integer NOT NULL,
    clients_name character varying,
    hairdressers_id integer
);


ALTER TABLE clients OWNER TO sandimckendrick;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: sandimckendrick
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO sandimckendrick;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sandimckendrick
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: hairdressers; Type: TABLE; Schema: public; Owner: sandimckendrick; Tablespace: 
--

CREATE TABLE hairdressers (
    id integer NOT NULL,
    name character varying,
    client_id integer
);


ALTER TABLE hairdressers OWNER TO sandimckendrick;

--
-- Name: hairdressers_id_seq; Type: SEQUENCE; Schema: public; Owner: sandimckendrick
--

CREATE SEQUENCE hairdressers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hairdressers_id_seq OWNER TO sandimckendrick;

--
-- Name: hairdressers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sandimckendrick
--

ALTER SEQUENCE hairdressers_id_seq OWNED BY hairdressers.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: sandimckendrick
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: sandimckendrick
--

ALTER TABLE ONLY hairdressers ALTER COLUMN id SET DEFAULT nextval('hairdressers_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: sandimckendrick
--

COPY clients (id, clients_name, hairdressers_id) FROM stdin;
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: sandimckendrick
--

SELECT pg_catalog.setval('clients_id_seq', 7, true);


--
-- Data for Name: hairdressers; Type: TABLE DATA; Schema: public; Owner: sandimckendrick
--

COPY hairdressers (id, name, client_id) FROM stdin;
\.


--
-- Name: hairdressers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: sandimckendrick
--

SELECT pg_catalog.setval('hairdressers_id_seq', 1, false);


--
-- Name: clients_pkey; Type: CONSTRAINT; Schema: public; Owner: sandimckendrick; Tablespace: 
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: hairdressers_pkey; Type: CONSTRAINT; Schema: public; Owner: sandimckendrick; Tablespace: 
--

ALTER TABLE ONLY hairdressers
    ADD CONSTRAINT hairdressers_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: sandimckendrick
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM sandimckendrick;
GRANT ALL ON SCHEMA public TO sandimckendrick;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

