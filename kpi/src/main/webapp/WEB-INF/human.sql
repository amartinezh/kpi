\c kpi;


DROP SCHEMA  human CASCADE;

CREATE SCHEMA human
  AUTHORIZATION postgres;

CREATE TABLE human.INDREC(
  mveano integer NOT NULL DEFAULT 0, -- Año de proceso
  mvemes integer NOT NULL DEFAULT 0, -- Mes de proceso
  mvereg character varying(3), -- Region
  mvecia integer NOT NULL DEFAULT 0, -- Compañia
  mvecin character varying(30) NOT NULL, -- Nombre Compañia
  mveind character varying(6) NOT NULL, -- ID. Indicador
  mvedes character varying(50) NOT NULL, -- Descripcion Indicador
  mverid character varying(1) NOT NULL, -- Indicador Visualizar
  mveval double precision DEFAULT 0, -- Valor Indicador USD
  mvevac double precision DEFAULT 0, -- Valor Indicador LOCAL
  mvevap double precision DEFAULT 0, -- Valor Indicador USD PROMEDIO
  mvevpe double precision DEFAULT 0, -- Valor Indicador PRESUPUESTO
  CONSTRAINT INDFIN_pk PRIMARY KEY (mveano, mvemes, mvereg, mvecia, mveind, mverid)
)WITH (OIDS=FALSE); ALTER TABLE finances.INDFIN OWNER TO postgres;

-- -------------------------------------------------------------------------------

CREATE TABLE human.cfg
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
ALTER TABLE human.cfg
  OWNER TO postgres;
  
-- -------------------------------------------------------------------------------

INSERT INTO human.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('REC001', 'SUM', 'Human', '', '1. Absenteeism', 'USD', 'V');
INSERT INTO human.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('REC002', 'AVG', 'Human', '', '2. Head Count', '% of Revenue', '%');
INSERT INTO human.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('REC003', 'SUM', 'Human', '', '3. Head Count Productivity', 'USD', '$');
INSERT INTO human.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('REC004', 'SUM', 'Human', '', '4. OSHA', 'USD', '$');
INSERT INTO human.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('REC005', 'AVG', 'Human', '', '5. Severity Index', '% of Revenue', '%');
INSERT INTO human.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('REC006', 'SUM', 'Human', '', '6. Training Coverage', 'USD', '$');
INSERT INTO human.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('REC007', 'SUM', 'Human', '', '7. RRHH Expenses', 'USD', '$');
INSERT INTO human.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('REC008', 'AVG', 'Human', '', '8. RRHH Expenses', '%', '%');
INSERT INTO human.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('REC009', 'SUM', 'Human', '', '9. RRHH Participation', 'USD', 'V');
INSERT INTO human.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('REC0010', 'SUM', 'Human', '', '10. Labour Expenses', 'Days', 'V');
INSERT INTO human.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('REC0011', 'SUM', 'Human', '', '11. Labour Expenses', 'Days', 'V');
