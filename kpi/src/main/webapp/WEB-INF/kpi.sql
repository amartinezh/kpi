DROP DATABASE kpi;

CREATE DATABASE kpi
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'es_CO.UTF-8'
       LC_CTYPE = 'es_CO.UTF-8'
       CONNECTION LIMIT = -1;

\c kpi;

CREATE SCHEMA kpi
  AUTHORIZATION postgres;
  
CREATE SCHEMA gestion
  AUTHORIZATION postgres;

CREATE TABLE kpi.MVINDVE(
  MVEANO integer NOT NULL DEFAULT 0, -- Año de proceso
  MVEMES integer NOT NULL DEFAULT 0, -- Mes de proceso
  MVEREG character varying(3), -- Region
  MVECIA integer NOT NULL DEFAULT 0, -- Compañia
  MVECIN character varying(30) NOT NULL, -- Nombre Compañia
  MVEIND character varying(6) NOT NULL, -- ID. Indicador
  MVEDES character varying(50) NOT NULL, -- Descripcion Indicador
  MVECLI character varying(16) NOT NULL, -- Cliente
  MVECLN character varying(50) NOT NULL, -- Nombre Cliente
  MVETIC character varying(4) NOT NULL, -- Tipo Cliente
  MVETIN character varying(25) NOT NULL, -- Nombre Tipo
  MVELOC character varying(3) NOT NULL, -- Bodega/Localidad 
  MVELON character varying(30) NOT NULL, -- Nombre Bodega/Localidad
  MVECR1 character varying(5) NOT NULL, -- Area Cliente   Ref1
  MVECN1 character varying(30) NOT NULL, -- Nombre Area
  MVECR2 character varying(5) NOT NULL, -- Zona Cliente   Ref2
  MVECN2 character varying(30) NOT NULL, -- Nombre Area
  MVECR3 character varying(5) NOT NULL, -- Region Cliente Ref3
  MVECN3 character varying(30) NOT NULL, -- Nombre Area
  MVECR4 character varying(5) NOT NULL, -- Local Cliente  Ref4
  MVECN4 character varying(30) NOT NULL, -- Nombre Area
  MVECR5 character varying(5) NOT NULL, -- Distrito Clien Ref5
  MVECN5 character varying(30) NOT NULL, -- Nombre Distrito
  MVESAL character varying(4) NOT NULL, -- Vendedor
  MVESAN character varying(30) NOT NULL, -- Nombre Vendedor
  MVEPRO character varying(15) NOT NULL, -- Codigo Producto
  MVEPRN character varying(50) NOT NULL, -- Nombre Producto
  MVECAL character varying(2) NOT NULL, -- Clase Articulo
  MVECAN character varying(30) NOT NULL, -- Nombre Clase Articulo
  MVESR1 character varying(5) NOT NULL, -- Tipo Articulo  Ref1
  MVESN1 character varying(30) NOT NULL, -- Nombre Tipo
  MVESR2 character varying(5) NOT NULL, -- Grupo Articulo Ref2
  MVESN2 character varying(30) NOT NULL, -- Nombre Grupo
  MVESR3 character varying(5) NOT NULL, -- Linea Articulo Ref3
  MVESN3 character varying(30) NOT NULL, -- Nombre Linea
  MVESR4 character varying(5) NOT NULL, -- Cate Articulo  Ref4
  MVESN4 character varying(30) NOT NULL, -- Nombre Categoria
  MVESR5 character varying(5) NOT NULL, -- Marca Articulo Ref5
  MVESN5 character varying(30) NOT NULL, -- Nombre Marca
  MVEVAL double precision DEFAULT 0, -- Valor Indicador USD
  MVEVAC double precision DEFAULT 0, -- Valor Indicador LOCAL
  MVERID character varying(1) NOT NULL, -- Indicador Visualizar
  MVEVAP double precision DEFAULT 0, -- Valor Indicador USD PROMEDIO
  MVEVPE double precision DEFAULT 0, -- Valor Indicador PRESUPUESTO

  CONSTRAINT tip_id_pk PRIMARY KEY (MVEANO, MVEMES, MVEREG, MVECIA, MVEIND, MVECLI, MVELOC, MVEPRO)
)WITH (OIDS=FALSE); ALTER TABLE kpi.MVINDVE OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.region
(
  region_id character varying(6) NOT NULL,
  descripcion character varying(128),
  CONSTRAINT region_pk PRIMARY KEY (region_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.region
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.company
(
  comp_id character varying(6) NOT NULL,
  region_id character varying(6),
  comp_desc character varying(255),
  CONSTRAINT comp_id_pk PRIMARY KEY (comp_id),
  CONSTRAINT region_fk FOREIGN KEY (region_id)
      REFERENCES gestion.region (region_id)  
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.company
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.nivel_organico
(
  nivel_organico_id serial NOT NULL,
  descripcion character varying(128),
  area_estrategica character varying(32),
  CONSTRAINT nivel_organico_pk PRIMARY KEY (nivel_organico_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.nivel_organico
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.currency
(
  currency_id integer NOT NULL,
  currency_desc character varying(255) COLLATE pg_catalog."es_CO.utf8",
  CONSTRAINT currency_id_pk PRIMARY KEY (currency_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.currency
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.type_users
(
  id serial NOT NULL,
  descripcion character varying(30),
  CONSTRAINT tip_id_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.type_users
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.users
(
  id character varying(255) COLLATE pg_catalog."es_CO.utf8" NOT NULL,
  pass character varying(255) COLLATE pg_catalog."es_CO.utf8",
  type_id integer,
  comp_comp_id character varying(6),
  curr_currency_id integer,
  nivel_organico_id integer,
  CONSTRAINT users_id_pk PRIMARY KEY (id),
  CONSTRAINT users_comp_id FOREIGN KEY (comp_comp_id)
      REFERENCES gestion.company (comp_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT users_curr_fk FOREIGN KEY (curr_currency_id)
      REFERENCES gestion.currency (currency_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT users_tip_fk FOREIGN KEY (type_id)
      REFERENCES gestion.type_users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT nivel_organico_fk FOREIGN KEY (nivel_organico_id)
      REFERENCES gestion.nivel_organico (nivel_organico_id)
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.users
  OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE gestion.cfg
(
  indicador character varying(10),
  operacion character varying(3),
  area character varying,
  division character varying,
  descripcion character varying,
  unidad character varying,
  tipo character varying,
  CONSTRAINT cfg_pk PRIMARY KEY (indicador)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.cfg
  OWNER TO postgres;
  

-- -------------------------------------------------------------------------------

CREATE TABLE gestion.indicador_nivel
(
  indicador character varying(10),
  nivel_organico_id integer NOT NULL,
  CONSTRAINT indicador_nivel_pk PRIMARY KEY (indicador, nivel_organico_id),
  CONSTRAINT nivel_fk FOREIGN KEY (nivel_organico_id)
      REFERENCES gestion.nivel_organico (nivel_organico_id)
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT cfg_fk FOREIGN KEY (indicador)
      REFERENCES gestion.cfg (indicador)
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gestion.indicador_nivel
  OWNER TO postgres;

-- -------------------------------------------------------------------------------

CREATE TABLE gestion.plan
(
  plan_id serial NOT NULL,
  indicador character varying(10),
  fecha date,
  problema_encontrado character varying,
  impacto_discrepancia character varying,
  plan_accion character varying,
  tipo character varying,
  responsable character varying,
  resultado_esperado character varying,
  fecha_compromiso date,
  estado character varying,
  CONSTRAINT plan_pk PRIMARY KEY (plan_id),
  CONSTRAINT indicador_fk FOREIGN KEY (indicador)
      REFERENCES gestion.cfg (indicador)  
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (OIDS=FALSE); ALTER TABLE gestion.plan OWNER TO postgres;
 
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------

INSERT INTO gestion.region(region_id, descripcion) VALUES ('COL','COLOMBIA');
INSERT INTO gestion.region(region_id, descripcion) VALUES ('VEN','VENEZUELA');
INSERT INTO gestion.region(region_id, descripcion) VALUES ('PAN','PANAMA');
INSERT INTO gestion.region(region_id, descripcion) VALUES ('TRI','TRINIDAD');
INSERT INTO gestion.region(region_id, descripcion) VALUES ('GUA','GUATEMALA');

INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('01', 'COL', 'PAPELES NACIONALES S.A');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('05', 'COL', 'GB BIOPACOL ANDINA S.A.S.');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('10', 'VEN', 'PAPELES VENEZOLANOS C.A.');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('24', 'VEN', 'DESARROLLOS FORESTALES S.C. II');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('50', 'PAN', 'PAPELERA ISTMEÑA S.A.');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('30', 'TRI', 'GRANDBAY PAPER PRODUCTS LIMITE');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('33', 'TRI', 'TRINIDAD TISSUE');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('12', 'GUA', 'PAPELERA LAT.DE NICARAGUA,S.A');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('14', 'GUA', 'RED ECOLOGICA Y PAPEL S.A. COSTA RICA');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('16', 'GUA', 'PAINSA EL SALVADOR,S.A.DE C.V.');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('17', 'GUA', 'PAINSA DE HONDURAS,S.A.DE C.V.');
INSERT INTO gestion.company(comp_id, region_id, comp_desc) VALUES ('20', 'GUA', 'PAPELERA INTERNACIONAL, S.A.');

INSERT INTO gestion.currency(currency_id, currency_desc) VALUES ('0', 'USD');
INSERT INTO gestion.currency(currency_id, currency_desc) VALUES ('1', 'LOCAL');
INSERT INTO gestion.type_users(id, descripcion) VALUES ('1', 'Usuario');
INSERT INTO gestion.type_users(id, descripcion)VALUES ('2', 'Regional');
INSERT INTO gestion.type_users(id, descripcion)VALUES ('3', 'Superuser');

INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('jesus.acevedo', '4b5833f2a579479ffa089123021612d6','2' , '10', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('fredy.gonzalez', '66b93908e158433a1b1d52d330a09168','2' , '20', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('javier.cordoba', 'a6f985740ba62728698bc11de7462ff9','1' , '30', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('claudia.ospina', '7fb8ab3a49382415e3626b8107843e44','2' , '01', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('andreina.marron', '2b6f58e0b1d2179638f5537446419622','2' , '50', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('americo.valles', '88d18cda8bdc4f750137ecb61156c4f0','3' , '01', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('claudia.ospina', '7fb8ab3a49382415e3626b8107843e44','2' , '01', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('armando.hung', '907a7449b27021c9980a202c0981c65f','2' , '01', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('tara.persad', 'ead0a95787f77ac07ea5991934f789c3','1' , '30', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('sallyann.rampat', '0d38dd3e8e150a53478f1fe131fff1d8','1' , '33', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('melissa.mahabir', 'fcd47b1e44436b441741e928dd6bb3c6','1' , '33', '1');

INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('fredy.gomez', '4b43ae1b3c0a4cbfd79ea45be7da4236','1' , '01', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('esteban.gomez', '8c5d7a099c93ad64bc8179186ddc07d4','1' , '01', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('roberto.palacio', '290874d6910f619e8a0e583316eddd12','1' , '01', '1');

INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('angel.chacon', 'c7c59cb09991999fc7363cc87998a9b5','1' , '50', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('nelson.labrador', '9854c0a45d46715dd47e26cee847a38c','2' , '01', '1');

INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('gonzalo.alvarez', '795b425d8685310b66c6934cb15ef55a','3' , '01', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('vicente.gonzalez', '68a96d195b07c9f61bcb33a5cd311e5a','3' , '01', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('antonio.bruni', '9259595e9948a56494961874c68245df','3' , '01', '1');
INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('antonio.neri', 'cb1dc087fab57e79337e1582b9b1ffe2','3' , '01', '1');

INSERT INTO gestion.users( id, pass, type_id, comp_comp_id, curr_currency_id) VALUES ('ricauter.jurado', '643e8cff3f108b36b2b3aa816ecebe37','2' , '50', '1');


INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN001', 'SUM', 'Comercial', '', 'Ventas', 'Own Cases', 'V');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN002', 'SUM', 'Comercial', '', 'Ventas', 'TM', 'V');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN003', 'SUM', 'Comercial', '', 'Venta Neta', 'USD', '$');

INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN004', 'SUM', 'Comercial', '', 'Salesman Perfo', 'USD', '$');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN005', 'SUM', 'Comercial', '', 'Descuentos, Promociones o Reembolsos', 'USD', '$');

INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN006', 'SUM', 'Comercial', '', 'Descuentos, Promociones o Reembolsos', 'USD', '$');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN007', 'AVG', 'Comercial', '', 'Cobertura de Clientes', '%', '%');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN008', 'AV2', 'Comercial', '', 'Precio Promedio', '%', '$');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN009', 'AV2', 'Comercial', '', 'Precio Promedio', 'USD/TM', '$');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN010', 'AV2', 'Comercial', '', 'Devoluciones', '%', '%');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN011', 'SUM', 'Comercial', '', 'Venta Perdida', 'Cases', 'V');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN012', 'AV2', 'Comercial', '', 'Cumplimiento del Forecast', '%', '%');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN013', 'AV2', 'Comercial', '', 'Cumplimiento del Presupuesto', '%', '%');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN014', 'AV2', 'Comercial', '', 'Precisión del Forecast', '%', '%');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN015', 'AV2', 'Comercial', '', 'Precisión del Presupuesto', '%', '%');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN016', 'SUM', 'Comercial', '', 'Estacionalidad de la Venta', 'Last Week', 'V');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN017', 'AVG', 'Comercial', '', 'Variabilidad de la Venta', '%', 'V');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN018', 'AVG', 'Comercial', '', 'Gastos de Ventas y Marketing', '% Revenue', '$');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN019', 'SUM', 'Comercial', '', 'Gastos de Ventas y Marketing', 'USD/Ton Sold.', 'V');
INSERT INTO gestion.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('VEN020', 'SUM', 'Comercial', '', 'OSHA', '#', 'V');

INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Saleman', 'Operational');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Supervisor', 'Operational');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('District Manager', 'Tactical');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Middle Manager', 'Tactical');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Area Manager', 'Estrategic');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('General Manager', 'Estrategic');
INSERT INTO gestion.nivel_organico(descripcion, area_estrategica) VALUES ('Regional V.P.', 'Estrategic');

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN001', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN002', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN002', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN002', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN002', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN002', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN003', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN003', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN003', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN003', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN004', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN004', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN004', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN004', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN005', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN005', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN005', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN005', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN005', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN005', 6);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN006', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN007', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN007', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN007', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN007', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN007', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN008', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN009', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN010', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN011', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN012', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN012', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN012', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN012', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN012', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN013', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN013', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN013', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN013', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN013', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN014', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN014', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN014', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN014', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN014', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN015', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN015', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN015', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN015', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN015', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN016', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN016', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN016', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN016', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN017', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN017', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN017', 6);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN017', 7);

INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN018', 1);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN018', 2);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN018', 3);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN018', 4);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN018', 5);
INSERT INTO gestion.indicador_nivel(indicador, nivel_organico_id) VALUES ('VEN018', 6);

