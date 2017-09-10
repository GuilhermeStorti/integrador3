--
-- PostgreSQL database cluster dump
--

-- Started on 2017-09-10 17:59:36 -03

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'md59df270eb52907fff723d9b8b7436113a';






--
-- Database creation
--

CREATE DATABASE integrador3 WITH TEMPLATE = template0 OWNER = postgres;
REVOKE CONNECT,TEMPORARY ON DATABASE template1 FROM PUBLIC;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;
CREATE DATABASE teste WITH TEMPLATE = template0 OWNER = postgres;


\connect integrador3

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.4

-- Started on 2017-09-10 17:59:36 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12393)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2258 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 189 (class 1259 OID 43311)
-- Name: campanha; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE campanha (
    id integer NOT NULL,
    descricao text NOT NULL,
    data_inicio date NOT NULL,
    data_fim date
);


ALTER TABLE campanha OWNER TO postgres;

--
-- TOC entry 2259 (class 0 OID 0)
-- Dependencies: 189
-- Name: TABLE campanha; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE campanha IS 'TABELA PARA CONTROLAR QUAL CAMPANHA O DOADOR PERTENCE';


--
-- TOC entry 2260 (class 0 OID 0)
-- Dependencies: 189
-- Name: COLUMN campanha.descricao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN campanha.descricao IS 'CAMPANHA UNITRI';


--
-- TOC entry 2261 (class 0 OID 0)
-- Dependencies: 189
-- Name: COLUMN campanha.data_inicio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN campanha.data_inicio IS 'INICIO CAMPANHA';


--
-- TOC entry 2262 (class 0 OID 0)
-- Dependencies: 189
-- Name: COLUMN campanha.data_fim; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN campanha.data_fim IS 'FIM CAMPANHA';


--
-- TOC entry 188 (class 1259 OID 43309)
-- Name: campanha_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE campanha_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE campanha_id_seq OWNER TO postgres;

--
-- TOC entry 2263 (class 0 OID 0)
-- Dependencies: 188
-- Name: campanha_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE campanha_id_seq OWNED BY campanha.id;


--
-- TOC entry 191 (class 1259 OID 43322)
-- Name: cargo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cargo (
    id integer NOT NULL,
    descricao text NOT NULL
);


ALTER TABLE cargo OWNER TO postgres;

--
-- TOC entry 2264 (class 0 OID 0)
-- Dependencies: 191
-- Name: TABLE cargo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE cargo IS 'CONTROLE DE CARGOS';


--
-- TOC entry 190 (class 1259 OID 43320)
-- Name: cargo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cargo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cargo_id_seq OWNER TO postgres;

--
-- TOC entry 2265 (class 0 OID 0)
-- Dependencies: 190
-- Name: cargo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cargo_id_seq OWNED BY cargo.id;


--
-- TOC entry 200 (class 1259 OID 43390)
-- Name: contribuinte; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE contribuinte (
    id integer NOT NULL,
    id_funcionario integer NOT NULL,
    cep integer NOT NULL,
    nome text NOT NULL,
    sobrenome text,
    tipo character(1) DEFAULT NULL::bpchar,
    sexo character(1) DEFAULT NULL::bpchar,
    data_nascimento date,
    email text,
    telefone_1 text,
    telefone_2 text,
    numero_residencia integer,
    complemento_residencia text,
    data_cadastro date,
    situacao character(1) DEFAULT NULL::bpchar
);


ALTER TABLE contribuinte OWNER TO postgres;

--
-- TOC entry 2266 (class 0 OID 0)
-- Dependencies: 200
-- Name: TABLE contribuinte; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE contribuinte IS 'TABELA ONDE ENCONTRA-SE TODOS CONTRIBUINTES CADASTRADOS, TABELA PARA CADASTRAR NOVOS CONTRIBUINTES';


--
-- TOC entry 2267 (class 0 OID 0)
-- Dependencies: 200
-- Name: COLUMN contribuinte.tipo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN contribuinte.tipo IS 'J = JURIDICA, F = FISICA';


--
-- TOC entry 2268 (class 0 OID 0)
-- Dependencies: 200
-- Name: COLUMN contribuinte.sexo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN contribuinte.sexo IS 'M = Masculino,  F = Feminino';


--
-- TOC entry 2269 (class 0 OID 0)
-- Dependencies: 200
-- Name: COLUMN contribuinte.data_cadastro; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN contribuinte.data_cadastro IS 'DATA SALVA PELA ACAO DO SISTEMA CURRENT DATE';


--
-- TOC entry 2270 (class 0 OID 0)
-- Dependencies: 200
-- Name: COLUMN contribuinte.situacao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN contribuinte.situacao IS 'A = ATIVO, I = INATIVO';


--
-- TOC entry 199 (class 1259 OID 43388)
-- Name: contribuinte_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE contribuinte_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE contribuinte_id_seq OWNER TO postgres;

--
-- TOC entry 2271 (class 0 OID 0)
-- Dependencies: 199
-- Name: contribuinte_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE contribuinte_id_seq OWNED BY contribuinte.id;


--
-- TOC entry 201 (class 1259 OID 43412)
-- Name: doacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE doacao (
    numero_recibo integer NOT NULL,
    valor numeric NOT NULL,
    status character(1) DEFAULT NULL::bpchar,
    data_operacao date,
    data_vencimento date,
    data_baixa date,
    parcela text,
    id_contribuinte integer NOT NULL,
    id_campanha integer NOT NULL,
    id_forma_pagamento integer NOT NULL,
    id_funcionario_atendente integer NOT NULL,
    id_funcionario_motoboy integer NOT NULL
);


ALTER TABLE doacao OWNER TO postgres;

--
-- TOC entry 2272 (class 0 OID 0)
-- Dependencies: 201
-- Name: TABLE doacao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE doacao IS 'TABELA ONDE ENCONTRA-SE TODOS DOACAO PRODUZIDOS';


--
-- TOC entry 2273 (class 0 OID 0)
-- Dependencies: 201
-- Name: COLUMN doacao.valor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN doacao.valor IS 'VALOR DOACAO';


--
-- TOC entry 2274 (class 0 OID 0)
-- Dependencies: 201
-- Name: COLUMN doacao.status; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN doacao.status IS 'B = BAIXADO, G = GERADO, R = REAGENDADO, C = CANCELADO';


--
-- TOC entry 2275 (class 0 OID 0)
-- Dependencies: 201
-- Name: COLUMN doacao.data_operacao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN doacao.data_operacao IS 'DATA PRODUCAO RECIBO';


--
-- TOC entry 2276 (class 0 OID 0)
-- Dependencies: 201
-- Name: COLUMN doacao.data_vencimento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN doacao.data_vencimento IS 'DATA VENCIMENTO RECIBO';


--
-- TOC entry 2277 (class 0 OID 0)
-- Dependencies: 201
-- Name: COLUMN doacao.data_baixa; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN doacao.data_baixa IS 'QUANDO OUVE BAIXA, CANCELAMENTO OU REAGENDAMENTO';


--
-- TOC entry 2278 (class 0 OID 0)
-- Dependencies: 201
-- Name: COLUMN doacao.parcela; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN doacao.parcela IS 'QUANTIDADE PARCELAS PRODUZAIDAS 1/N';


--
-- TOC entry 187 (class 1259 OID 43287)
-- Name: doacao_numero_recibo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE doacao_numero_recibo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE doacao_numero_recibo_seq OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 43448)
-- Name: empresa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE empresa (
    id integer NOT NULL,
    nome_fantasia text NOT NULL,
    razao_social text,
    cnpj text,
    email text,
    telefone_1 text,
    telefone_2 text,
    cep integer NOT NULL,
    numero_residencia integer,
    complemento_residencia text,
    situacao character(1)
);


ALTER TABLE empresa OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 43446)
-- Name: empresa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE empresa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE empresa_id_seq OWNER TO postgres;

--
-- TOC entry 2279 (class 0 OID 0)
-- Dependencies: 202
-- Name: empresa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE empresa_id_seq OWNED BY empresa.id;


--
-- TOC entry 192 (class 1259 OID 43331)
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE endereco (
    cep integer NOT NULL,
    logradouro text NOT NULL,
    bairro text NOT NULL,
    cidade text NOT NULL,
    uf text NOT NULL
);


ALTER TABLE endereco OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 43341)
-- Name: forma_pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE forma_pagamento (
    id integer NOT NULL,
    descricao text NOT NULL
);


ALTER TABLE forma_pagamento OWNER TO postgres;

--
-- TOC entry 2280 (class 0 OID 0)
-- Dependencies: 194
-- Name: TABLE forma_pagamento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE forma_pagamento IS 'TABELA PARA CONTROLE DE FORMA DE PAGAMENTO POR CONTRIBUINTE, MENSAGEIRO, CARTAO , DDA';


--
-- TOC entry 2281 (class 0 OID 0)
-- Dependencies: 194
-- Name: COLUMN forma_pagamento.descricao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN forma_pagamento.descricao IS 'MENSAGEIRO, CARTAO , DDA';


--
-- TOC entry 193 (class 1259 OID 43339)
-- Name: forma_pagamento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE forma_pagamento_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE forma_pagamento_id_seq OWNER TO postgres;

--
-- TOC entry 2282 (class 0 OID 0)
-- Dependencies: 193
-- Name: forma_pagamento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE forma_pagamento_id_seq OWNED BY forma_pagamento.id;


--
-- TOC entry 198 (class 1259 OID 43363)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE funcionario (
    id integer NOT NULL,
    id_usuario integer NOT NULL,
    id_cargo integer NOT NULL,
    cep integer NOT NULL,
    nome text NOT NULL,
    sobrenome text,
    sexo character(1) DEFAULT NULL::bpchar,
    cpf text,
    email text,
    telefone_1 text,
    telefone_2 text,
    numero_residencia integer,
    complemento_residencia text,
    situacao character(1)
);


ALTER TABLE funcionario OWNER TO postgres;

--
-- TOC entry 2283 (class 0 OID 0)
-- Dependencies: 198
-- Name: COLUMN funcionario.sexo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN funcionario.sexo IS 'M = Masculino, F = Feminino';


--
-- TOC entry 2284 (class 0 OID 0)
-- Dependencies: 198
-- Name: COLUMN funcionario.situacao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN funcionario.situacao IS 'A = ATIVO, I = INATIVO';


--
-- TOC entry 197 (class 1259 OID 43361)
-- Name: funcionario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE funcionario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE funcionario_id_seq OWNER TO postgres;

--
-- TOC entry 2285 (class 0 OID 0)
-- Dependencies: 197
-- Name: funcionario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE funcionario_id_seq OWNED BY funcionario.id;


--
-- TOC entry 186 (class 1259 OID 42454)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 43352)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuario (
    id integer NOT NULL,
    nome text NOT NULL,
    usuario text NOT NULL,
    senha text
);


ALTER TABLE usuario OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 43350)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario_id_seq OWNER TO postgres;

--
-- TOC entry 2286 (class 0 OID 0)
-- Dependencies: 195
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuario_id_seq OWNED BY usuario.id;


--
-- TOC entry 2065 (class 2604 OID 43314)
-- Name: campanha id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY campanha ALTER COLUMN id SET DEFAULT nextval('campanha_id_seq'::regclass);


--
-- TOC entry 2066 (class 2604 OID 43325)
-- Name: cargo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cargo ALTER COLUMN id SET DEFAULT nextval('cargo_id_seq'::regclass);


--
-- TOC entry 2071 (class 2604 OID 43393)
-- Name: contribuinte id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contribuinte ALTER COLUMN id SET DEFAULT nextval('contribuinte_id_seq'::regclass);


--
-- TOC entry 2076 (class 2604 OID 43451)
-- Name: empresa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY empresa ALTER COLUMN id SET DEFAULT nextval('empresa_id_seq'::regclass);


--
-- TOC entry 2067 (class 2604 OID 43344)
-- Name: forma_pagamento id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY forma_pagamento ALTER COLUMN id SET DEFAULT nextval('forma_pagamento_id_seq'::regclass);


--
-- TOC entry 2069 (class 2604 OID 43366)
-- Name: funcionario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario ALTER COLUMN id SET DEFAULT nextval('funcionario_id_seq'::regclass);


--
-- TOC entry 2068 (class 2604 OID 43355)
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario ALTER COLUMN id SET DEFAULT nextval('usuario_id_seq'::regclass);


--
-- TOC entry 2237 (class 0 OID 43311)
-- Dependencies: 189
-- Data for Name: campanha; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY campanha (id, descricao, data_inicio, data_fim) FROM stdin;
2	Dia das crianças	2017-10-01	2017-11-01
3	Campanha de teste	2017-11-01	2017-11-30
4	Teste	2017-09-09	2017-09-14
6	Teste 2	2017-09-01	2017-09-21
7	Teste celular	2017-09-11	2017-09-30
8	Testando novo padrão	2017-09-01	2017-09-02
1	Proclamação da republica a	2017-09-01	2017-10-01
\.


--
-- TOC entry 2287 (class 0 OID 0)
-- Dependencies: 188
-- Name: campanha_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('campanha_id_seq', 8, true);


--
-- TOC entry 2239 (class 0 OID 43322)
-- Dependencies: 191
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cargo (id, descricao) FROM stdin;
1	Gestor
2	Motoboy
3	Atendente
\.


--
-- TOC entry 2288 (class 0 OID 0)
-- Dependencies: 190
-- Name: cargo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cargo_id_seq', 3, true);


--
-- TOC entry 2248 (class 0 OID 43390)
-- Dependencies: 200
-- Data for Name: contribuinte; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY contribuinte (id, id_funcionario, cep, nome, sobrenome, tipo, sexo, data_nascimento, email, telefone_1, telefone_2, numero_residencia, complemento_residencia, data_cadastro, situacao) FROM stdin;
\.


--
-- TOC entry 2289 (class 0 OID 0)
-- Dependencies: 199
-- Name: contribuinte_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('contribuinte_id_seq', 1, false);


--
-- TOC entry 2249 (class 0 OID 43412)
-- Dependencies: 201
-- Data for Name: doacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY doacao (numero_recibo, valor, status, data_operacao, data_vencimento, data_baixa, parcela, id_contribuinte, id_campanha, id_forma_pagamento, id_funcionario_atendente, id_funcionario_motoboy) FROM stdin;
\.


--
-- TOC entry 2290 (class 0 OID 0)
-- Dependencies: 187
-- Name: doacao_numero_recibo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('doacao_numero_recibo_seq', 1, false);


--
-- TOC entry 2251 (class 0 OID 43448)
-- Dependencies: 203
-- Data for Name: empresa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY empresa (id, nome_fantasia, razao_social, cnpj, email, telefone_1, telefone_2, cep, numero_residencia, complemento_residencia, situacao) FROM stdin;
\.


--
-- TOC entry 2291 (class 0 OID 0)
-- Dependencies: 202
-- Name: empresa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('empresa_id_seq', 1, false);


--
-- TOC entry 2240 (class 0 OID 43331)
-- Dependencies: 192
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY endereco (cep, logradouro, bairro, cidade, uf) FROM stdin;
\.


--
-- TOC entry 2242 (class 0 OID 43341)
-- Dependencies: 194
-- Data for Name: forma_pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY forma_pagamento (id, descricao) FROM stdin;
1	Dinheiro
2	Cartão de crédito
3	Cartão de débito
4	Boleto bancário
\.


--
-- TOC entry 2292 (class 0 OID 0)
-- Dependencies: 193
-- Name: forma_pagamento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('forma_pagamento_id_seq', 4, true);


--
-- TOC entry 2246 (class 0 OID 43363)
-- Dependencies: 198
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY funcionario (id, id_usuario, id_cargo, cep, nome, sobrenome, sexo, cpf, email, telefone_1, telefone_2, numero_residencia, complemento_residencia, situacao) FROM stdin;
\.


--
-- TOC entry 2293 (class 0 OID 0)
-- Dependencies: 197
-- Name: funcionario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('funcionario_id_seq', 1, false);


--
-- TOC entry 2294 (class 0 OID 0)
-- Dependencies: 186
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hibernate_sequence', 1, false);


--
-- TOC entry 2244 (class 0 OID 43352)
-- Dependencies: 196
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (id, nome, usuario, senha) FROM stdin;
1	Guilherme Storti	guistorti	12345
\.


--
-- TOC entry 2295 (class 0 OID 0)
-- Dependencies: 195
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_seq', 1, true);


--
-- TOC entry 2078 (class 2606 OID 43319)
-- Name: campanha campanha_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY campanha
    ADD CONSTRAINT campanha_pkey PRIMARY KEY (id);


--
-- TOC entry 2080 (class 2606 OID 43330)
-- Name: cargo cargo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (id);


--
-- TOC entry 2090 (class 2606 OID 43401)
-- Name: contribuinte contribuinte_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contribuinte
    ADD CONSTRAINT contribuinte_pkey PRIMARY KEY (id);


--
-- TOC entry 2092 (class 2606 OID 43420)
-- Name: doacao doacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doacao
    ADD CONSTRAINT doacao_pkey PRIMARY KEY (numero_recibo);


--
-- TOC entry 2094 (class 2606 OID 43456)
-- Name: empresa empresa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (id);


--
-- TOC entry 2082 (class 2606 OID 43338)
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (cep);


--
-- TOC entry 2084 (class 2606 OID 43349)
-- Name: forma_pagamento forma_pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY forma_pagamento
    ADD CONSTRAINT forma_pagamento_pkey PRIMARY KEY (id);


--
-- TOC entry 2088 (class 2606 OID 43372)
-- Name: funcionario funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id);


--
-- TOC entry 2086 (class 2606 OID 43360)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 2102 (class 2606 OID 43407)
-- Name: contribuinte contribuinte_cep_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contribuinte
    ADD CONSTRAINT contribuinte_cep_fkey FOREIGN KEY (cep) REFERENCES endereco(cep);


--
-- TOC entry 2101 (class 2606 OID 43402)
-- Name: contribuinte contribuinte_id_funcionario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contribuinte
    ADD CONSTRAINT contribuinte_id_funcionario_fkey FOREIGN KEY (id_funcionario) REFERENCES funcionario(id);


--
-- TOC entry 2106 (class 2606 OID 43426)
-- Name: doacao doacao_id_campanha_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doacao
    ADD CONSTRAINT doacao_id_campanha_fkey FOREIGN KEY (id_campanha) REFERENCES campanha(id);


--
-- TOC entry 2105 (class 2606 OID 43421)
-- Name: doacao doacao_id_contribuinte_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doacao
    ADD CONSTRAINT doacao_id_contribuinte_fkey FOREIGN KEY (id_contribuinte) REFERENCES contribuinte(id);


--
-- TOC entry 2107 (class 2606 OID 43431)
-- Name: doacao doacao_id_forma_pagamento_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doacao
    ADD CONSTRAINT doacao_id_forma_pagamento_fkey FOREIGN KEY (id_forma_pagamento) REFERENCES forma_pagamento(id);


--
-- TOC entry 2108 (class 2606 OID 43436)
-- Name: doacao doacao_id_funcionario_atendente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doacao
    ADD CONSTRAINT doacao_id_funcionario_atendente_fkey FOREIGN KEY (id_funcionario_atendente) REFERENCES funcionario(id);


--
-- TOC entry 2109 (class 2606 OID 43441)
-- Name: doacao doacao_id_funcionario_motoboy_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doacao
    ADD CONSTRAINT doacao_id_funcionario_motoboy_fkey FOREIGN KEY (id_funcionario_motoboy) REFERENCES funcionario(id);


--
-- TOC entry 2115 (class 2606 OID 43457)
-- Name: empresa empresa_cep_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY empresa
    ADD CONSTRAINT empresa_cep_fkey FOREIGN KEY (cep) REFERENCES endereco(cep);


--
-- TOC entry 2116 (class 2606 OID 43497)
-- Name: empresa fk2ox4iy9mfll3geodc1yp0w4aj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY empresa
    ADD CONSTRAINT fk2ox4iy9mfll3geodc1yp0w4aj FOREIGN KEY (cep) REFERENCES endereco(cep);


--
-- TOC entry 2110 (class 2606 OID 43472)
-- Name: doacao fk3uafx0b0s9s3pbk6c3jcr0b8n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doacao
    ADD CONSTRAINT fk3uafx0b0s9s3pbk6c3jcr0b8n FOREIGN KEY (id_campanha) REFERENCES campanha(id);


--
-- TOC entry 2099 (class 2606 OID 43507)
-- Name: funcionario fk6nhx7o0mxiy2prclbk3k7ldsv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fk6nhx7o0mxiy2prclbk3k7ldsv FOREIGN KEY (cep) REFERENCES endereco(cep);


--
-- TOC entry 2098 (class 2606 OID 43502)
-- Name: funcionario fk92othhhe25gno2qtus5woc6ys; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fk92othhhe25gno2qtus5woc6ys FOREIGN KEY (id_cargo) REFERENCES cargo(id);


--
-- TOC entry 2114 (class 2606 OID 43492)
-- Name: doacao fkbcw0du729dai0mjc59ylciepy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doacao
    ADD CONSTRAINT fkbcw0du729dai0mjc59ylciepy FOREIGN KEY (id_funcionario_motoboy) REFERENCES funcionario(id);


--
-- TOC entry 2111 (class 2606 OID 43477)
-- Name: doacao fkbgll65ynpwc2ip236oyxy2kyf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doacao
    ADD CONSTRAINT fkbgll65ynpwc2ip236oyxy2kyf FOREIGN KEY (id_contribuinte) REFERENCES contribuinte(id);


--
-- TOC entry 2112 (class 2606 OID 43482)
-- Name: doacao fkei3pls0orxi067j95wxgbg9ts; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doacao
    ADD CONSTRAINT fkei3pls0orxi067j95wxgbg9ts FOREIGN KEY (id_forma_pagamento) REFERENCES forma_pagamento(id);


--
-- TOC entry 2113 (class 2606 OID 43487)
-- Name: doacao fkic3vnyy3fu8vl6fg49eayi2mo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY doacao
    ADD CONSTRAINT fkic3vnyy3fu8vl6fg49eayi2mo FOREIGN KEY (id_funcionario_atendente) REFERENCES funcionario(id);


--
-- TOC entry 2103 (class 2606 OID 43462)
-- Name: contribuinte fksivaqlds0xje5jbxie8pm9kmj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contribuinte
    ADD CONSTRAINT fksivaqlds0xje5jbxie8pm9kmj FOREIGN KEY (cep) REFERENCES endereco(cep);


--
-- TOC entry 2097 (class 2606 OID 43383)
-- Name: funcionario funcionario_cep_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT funcionario_cep_fkey FOREIGN KEY (cep) REFERENCES endereco(cep);


--
-- TOC entry 2096 (class 2606 OID 43378)
-- Name: funcionario funcionario_id_cargo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT funcionario_id_cargo_fkey FOREIGN KEY (id_cargo) REFERENCES cargo(id);


--
-- TOC entry 2095 (class 2606 OID 43373)
-- Name: funcionario funcionario_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT funcionario_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES usuario(id);


--
-- TOC entry 2104 (class 2606 OID 43467)
-- Name: contribuinte id_funcionario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY contribuinte
    ADD CONSTRAINT id_funcionario FOREIGN KEY (id_funcionario) REFERENCES funcionario(id);


--
-- TOC entry 2100 (class 2606 OID 43512)
-- Name: funcionario id_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id);


-- Completed on 2017-09-10 17:59:36 -03

--
-- PostgreSQL database dump complete
--

\connect postgres

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.4

-- Started on 2017-09-10 17:59:36 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2132 (class 1262 OID 12407)
-- Dependencies: 2131
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 1 (class 3079 OID 12393)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2134 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 16393)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuarios (
    id integer NOT NULL,
    nome character varying(40) NOT NULL
);


ALTER TABLE usuarios OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16391)
-- Name: usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuarios_id_seq OWNER TO postgres;

--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 185
-- Name: usuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuarios_id_seq OWNED BY usuarios.id;


--
-- TOC entry 2005 (class 2604 OID 16396)
-- Name: usuarios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios ALTER COLUMN id SET DEFAULT nextval('usuarios_id_seq'::regclass);


--
-- TOC entry 2126 (class 0 OID 16393)
-- Dependencies: 186
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuarios (id, nome) FROM stdin;
\.


--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 185
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuarios_id_seq', 1, false);


--
-- TOC entry 2007 (class 2606 OID 16398)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


-- Completed on 2017-09-10 17:59:36 -03

--
-- PostgreSQL database dump complete
--

\connect template1

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.4

-- Started on 2017-09-10 17:59:36 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2121 (class 1262 OID 1)
-- Dependencies: 2120
-- Name: template1; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- TOC entry 1 (class 3079 OID 12393)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2123 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


-- Completed on 2017-09-10 17:59:36 -03

--
-- PostgreSQL database dump complete
--

\connect teste

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.4

-- Started on 2017-09-10 17:59:36 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12393)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2133 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 16401)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuarios (
    id integer NOT NULL,
    nome character varying(40) NOT NULL
);


ALTER TABLE usuarios OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16399)
-- Name: usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuarios_id_seq OWNER TO postgres;

--
-- TOC entry 2134 (class 0 OID 0)
-- Dependencies: 185
-- Name: usuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuarios_id_seq OWNED BY usuarios.id;


--
-- TOC entry 2005 (class 2604 OID 16404)
-- Name: usuarios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios ALTER COLUMN id SET DEFAULT nextval('usuarios_id_seq'::regclass);


--
-- TOC entry 2126 (class 0 OID 16401)
-- Dependencies: 186
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuarios (id, nome) FROM stdin;
\.


--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 185
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuarios_id_seq', 1, true);


--
-- TOC entry 2007 (class 2606 OID 16406)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


-- Completed on 2017-09-10 17:59:36 -03

--
-- PostgreSQL database dump complete
--

-- Completed on 2017-09-10 17:59:36 -03

--
-- PostgreSQL database cluster dump complete
--

