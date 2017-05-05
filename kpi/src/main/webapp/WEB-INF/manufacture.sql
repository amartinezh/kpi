\c kpi;

DROP SCHEMA man CASCADE;

CREATE SCHEMA man
  AUTHORIZATION postgres;

CREATE TABLE man.INDMAN1(
  MVEANO integer NOT NULL DEFAULT 0, -- Año de proceso
  MVEMES integer NOT NULL DEFAULT 0, -- Mes de proceso
  MVEREG character varying(3), -- Region
  MVECIA integer NOT NULL DEFAULT 0, -- Compañia
  MVECIN character varying(30) NOT NULL, -- Nombre Compañia
  MVEPCE character varying(6) NOT NULL, -- Proceso
  MVECLN character varying(50) NOT NULL, -- Nombre Proceso
  MVEIND character varying(6) NOT NULL, -- ID. Indicador
  MVEDES character varying(50) NOT NULL, -- Descripcion Indicador
  MVECEN character varying(6) NOT NULL, -- Codigo Centro
  MVECED character varying(30) NOT NULL, -- Nombre Centro Productivo
  MVEPRO character varying(15) NOT NULL, -- Codigo Producto
  MVEPRN character varying(50) NOT NULL, -- Nombre Producto
  MVECAL character varying(2) NOT NULL, -- Clase Articulo
  MVECAN character varying(30) NOT NULL, -- Nombre Clase Articulo
  MVETUR character varying(1) NOT NULL, -- Turno
  MVETUD character varying(10) NOT NULL, -- Nombre Turno
  MVEVAL double precision DEFAULT 0, -- Valor Indicador USD
  MVEVAC double precision DEFAULT 0, -- Valor Indicador LOCAL
  MVERID character varying(1) NOT NULL, -- Indicador Visualizar
  MVEVAP double precision DEFAULT 0, -- Valor Indicador USD PROMEDIO
  MVEVPE double precision DEFAULT 0, -- Valor Indicador PRESUPUESTO

  CONSTRAINT INDMAN1_pk PRIMARY KEY (MVEANO, MVEMES, MVEREG, MVECIA, MVEPCE, MVEIND, MVECEN, MVEPRO, MVECAL, MVETUR)
)WITH (OIDS=FALSE); ALTER TABLE man.INDMAN1 OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE man.cfg1
(
  indicador character varying(10),
  operacion character varying(3),
  area character varying,
  division character varying,
  descripcion character varying,
  unidad character varying,
  tipo character varying,
  CONSTRAINT cfg1_pk PRIMARY KEY (indicador)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE man.cfg1
  OWNER TO postgres;
  
-- -------------------------------------------------------------------------------

INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN001', 'SUM', 'Manufacture', '', '1. ', '%', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN002', 'SUM', 'Manufacture', '', '2. ', '%', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN003', 'SUM', 'Manufacture', '', '3. ', 'Days', 'V');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN004', 'SUM', 'Manufacture', '', '4. ', 'USD/Ton', '$');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN005', 'AVG', 'Manufacture', '', '5. ', 'Days', 'V');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN006', 'SUM', 'Manufacture', '', '6. ', '%', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN007', 'SUM', 'Manufacture', '', '7. ', 'Times per Month', 'V');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN008', 'AVG', 'Manufacture', '', '8. ', 'USD/Ton', '$');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN009', 'SUM', 'Manufacture', '', '9. ', '% of Revenue', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN010', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN011', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN012', 'SUM', 'Manufacture', '', '12. ', '%', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN013', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN014', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN015', 'SUM', 'Manufacture', '', '12. ', '%', '%');

-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------

CREATE TABLE man.INDMAN2(
  MVEANO integer NOT NULL DEFAULT 0, -- Año de proceso
  MVEMES integer NOT NULL DEFAULT 0, -- Mes de proceso
  MVEREG character varying(3), -- Region
  MVECIA integer NOT NULL DEFAULT 0, -- Compañia
  MVECIN character varying(30) NOT NULL, -- Nombre Compañia
  MVEPCE character varying(6) NOT NULL, -- Proceso
  MVECLN character varying(50) NOT NULL, -- Nombre Proceso
  MVEIND character varying(6) NOT NULL, -- ID. Indicador
  MVEDES character varying(50) NOT NULL, -- Descripcion Indicador
  MVECEN character varying(6) NOT NULL, -- Codigo Centro
  MVECED character varying(30) NOT NULL, -- Nombre Centro Productivo
  MVEPRO character varying(15) NOT NULL, -- Codigo Producto
  MVEPRN character varying(50) NOT NULL, -- Nombre Producto
  MVECAL character varying(2) NOT NULL, -- Clase Articulo
  MVECAN character varying(30) NOT NULL, -- Nombre Clase Articulo
  MVETUR character varying(1) NOT NULL, -- Turno
  MVETUD character varying(10) NOT NULL, -- Nombre Turno
  MVEVAL double precision DEFAULT 0, -- Valor Indicador USD
  MVEVAC double precision DEFAULT 0, -- Valor Indicador LOCAL
  MVERID character varying(1) NOT NULL, -- Indicador Visualizar
  MVEVAP double precision DEFAULT 0, -- Valor Indicador USD PROMEDIO
  MVEVPE double precision DEFAULT 0, -- Valor Indicador PRESUPUESTO

  CONSTRAINT INDMAN2_pk PRIMARY KEY (MVEANO, MVEMES, MVEREG, MVECIA, MVEPCE, MVEIND, MVECEN, MVEPRO, MVECAL, MVETUR)
)WITH (OIDS=FALSE); ALTER TABLE man.INDMAN2 OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE man.cfg2
(
  indicador character varying(10),
  operacion character varying(3),
  area character varying,
  division character varying,
  descripcion character varying,
  unidad character varying,
  tipo character varying,
  CONSTRAINT cfg2_pk PRIMARY KEY (indicador)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE man.cfg2
  OWNER TO postgres;
  
-- -------------------------------------------------------------------------------

INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN001', 'SUM', 'Manufacture', '', '1. ', '%', '%');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN002', 'SUM', 'Manufacture', '', '2. ', '%', '%');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN003', 'SUM', 'Manufacture', '', '3. ', 'Days', 'V');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN004', 'SUM', 'Manufacture', '', '4. ', 'USD/Ton', '$');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN005', 'AVG', 'Manufacture', '', '5. ', 'Days', 'V');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN006', 'SUM', 'Manufacture', '', '6. ', '%', '%');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN007', 'SUM', 'Manufacture', '', '7. ', 'Times per Month', 'V');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN008', 'AVG', 'Manufacture', '', '8. ', 'USD/Ton', '$');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN009', 'SUM', 'Manufacture', '', '9. ', '% of Revenue', '%');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN010', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN011', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN012', 'SUM', 'Manufacture', '', '12. ', '%', '%');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN013', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN014', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg2(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN015', 'SUM', 'Manufacture', '', '12. ', '%', '%');

-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------

CREATE TABLE man.INDMAN3(
  MVEANO integer NOT NULL DEFAULT 0, -- Año de proceso
  MVEMES integer NOT NULL DEFAULT 0, -- Mes de proceso
  MVEREG character varying(3), -- Region
  MVECIA integer NOT NULL DEFAULT 0, -- Compañia
  MVECIN character varying(30) NOT NULL, -- Nombre Compañia
  MVEPCE character varying(6) NOT NULL, -- Proceso
  MVECLN character varying(50) NOT NULL, -- Nombre Proceso
  MVEIND character varying(6) NOT NULL, -- ID. Indicador
  MVEDES character varying(50) NOT NULL, -- Descripcion Indicador
  MVECEN character varying(6) NOT NULL, -- Codigo Centro
  MVECED character varying(30) NOT NULL, -- Nombre Centro Productivo
  MVEPRO character varying(15) NOT NULL, -- Codigo Producto
  MVEPRN character varying(50) NOT NULL, -- Nombre Producto
  MVECAL character varying(2) NOT NULL, -- Clase Articulo
  MVECAN character varying(30) NOT NULL, -- Nombre Clase Articulo
  MVETUR character varying(1) NOT NULL, -- Turno
  MVETUD character varying(10) NOT NULL, -- Nombre Turno
  MVEVAL double precision DEFAULT 0, -- Valor Indicador USD
  MVEVAC double precision DEFAULT 0, -- Valor Indicador LOCAL
  MVERID character varying(1) NOT NULL, -- Indicador Visualizar
  MVEVAP double precision DEFAULT 0, -- Valor Indicador USD PROMEDIO
  MVEVPE double precision DEFAULT 0, -- Valor Indicador PRESUPUESTO

  CONSTRAINT INDMAN3_pk PRIMARY KEY (MVEANO, MVEMES, MVEREG, MVECIA, MVEPCE, MVEIND, MVECEN, MVEPRO, MVECAL, MVETUR)
)WITH (OIDS=FALSE); ALTER TABLE man.INDMAN3 OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE man.cfg3
(
  indicador character varying(10),
  operacion character varying(3),
  area character varying,
  division character varying,
  descripcion character varying,
  unidad character varying,
  tipo character varying,
  CONSTRAINT cfg3_pk PRIMARY KEY (indicador)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE man.cfg3
  OWNER TO postgres;
  
-- -------------------------------------------------------------------------------

INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN001', 'SUM', 'Manufacture', '', '1. ', '%', '%');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN002', 'SUM', 'Manufacture', '', '2. ', '%', '%');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN003', 'SUM', 'Manufacture', '', '3. ', 'Days', 'V');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN004', 'SUM', 'Manufacture', '', '4. ', 'USD/Ton', '$');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN005', 'AVG', 'Manufacture', '', '5. ', 'Days', 'V');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN006', 'SUM', 'Manufacture', '', '6. ', '%', '%');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN007', 'SUM', 'Manufacture', '', '7. ', 'Times per Month', 'V');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN008', 'AVG', 'Manufacture', '', '8. ', 'USD/Ton', '$');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN009', 'SUM', 'Manufacture', '', '9. ', '% of Revenue', '%');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN010', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN011', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN012', 'SUM', 'Manufacture', '', '12. ', '%', '%');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN013', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN014', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg3(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN015', 'SUM', 'Manufacture', '', '12. ', '%', '%');

-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------

CREATE TABLE man.INDMAN4(
  MVEANO integer NOT NULL DEFAULT 0, -- Año de proceso
  MVEMES integer NOT NULL DEFAULT 0, -- Mes de proceso
  MVEREG character varying(3), -- Region
  MVECIA integer NOT NULL DEFAULT 0, -- Compañia
  MVECIN character varying(30) NOT NULL, -- Nombre Compañia
  MVEPCE character varying(6) NOT NULL, -- Proceso
  MVECLN character varying(50) NOT NULL, -- Nombre Proceso
  MVEIND character varying(6) NOT NULL, -- ID. Indicador
  MVEDES character varying(50) NOT NULL, -- Descripcion Indicador
  MVECEN character varying(6) NOT NULL, -- Codigo Centro
  MVECED character varying(30) NOT NULL, -- Nombre Centro Productivo
  MVEPRO character varying(15) NOT NULL, -- Codigo Producto
  MVEPRN character varying(50) NOT NULL, -- Nombre Producto
  MVECAL character varying(2) NOT NULL, -- Clase Articulo
  MVECAN character varying(30) NOT NULL, -- Nombre Clase Articulo
  MVETUR character varying(1) NOT NULL, -- Turno
  MVETUD character varying(10) NOT NULL, -- Nombre Turno
  MVEVAL double precision DEFAULT 0, -- Valor Indicador USD
  MVEVAC double precision DEFAULT 0, -- Valor Indicador LOCAL
  MVERID character varying(1) NOT NULL, -- Indicador Visualizar
  MVEVAP double precision DEFAULT 0, -- Valor Indicador USD PROMEDIO
  MVEVPE double precision DEFAULT 0, -- Valor Indicador PRESUPUESTO

  CONSTRAINT INDMAN4_pk PRIMARY KEY (MVEANO, MVEMES, MVEREG, MVECIA, MVEPCE, MVEIND, MVECEN, MVEPRO, MVECAL, MVETUR)
)WITH (OIDS=FALSE); ALTER TABLE man.INDMAN4 OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE man.cfg4
(
  indicador character varying(10),
  operacion character varying(3),
  area character varying,
  division character varying,
  descripcion character varying,
  unidad character varying,
  tipo character varying,
  CONSTRAINT cfg4_pk PRIMARY KEY (indicador)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE man.cfg4
  OWNER TO postgres;
  
-- -------------------------------------------------------------------------------

INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN001', 'SUM', 'Manufacture', '', '1. ', '%', '%');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN002', 'SUM', 'Manufacture', '', '2. ', '%', '%');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN003', 'SUM', 'Manufacture', '', '3. ', 'Days', 'V');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN004', 'SUM', 'Manufacture', '', '4. ', 'USD/Ton', '$');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN005', 'AVG', 'Manufacture', '', '5. ', 'Days', 'V');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN006', 'SUM', 'Manufacture', '', '6. ', '%', '%');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN007', 'SUM', 'Manufacture', '', '7. ', 'Times per Month', 'V');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN008', 'AVG', 'Manufacture', '', '8. ', 'USD/Ton', '$');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN009', 'SUM', 'Manufacture', '', '9. ', '% of Revenue', '%');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN010', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN011', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN012', 'SUM', 'Manufacture', '', '12. ', '%', '%');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN013', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN014', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg4(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN015', 'SUM', 'Manufacture', '', '12. ', '%', '%');

-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------

CREATE TABLE man.INDMAN5(
  MVEANO integer NOT NULL DEFAULT 0, -- Año de proceso
  MVEMES integer NOT NULL DEFAULT 0, -- Mes de proceso
  MVEREG character varying(3), -- Region
  MVECIA integer NOT NULL DEFAULT 0, -- Compañia
  MVECIN character varying(30) NOT NULL, -- Nombre Compañia
  MVEPCE character varying(6) NOT NULL, -- Proceso
  MVECLN character varying(50) NOT NULL, -- Nombre Proceso
  MVEIND character varying(6) NOT NULL, -- ID. Indicador
  MVEDES character varying(50) NOT NULL, -- Descripcion Indicador
  MVECEN character varying(6) NOT NULL, -- Codigo Centro
  MVECED character varying(30) NOT NULL, -- Nombre Centro Productivo
  MVEPRO character varying(15) NOT NULL, -- Codigo Producto
  MVEPRN character varying(50) NOT NULL, -- Nombre Producto
  MVECAL character varying(2) NOT NULL, -- Clase Articulo
  MVECAN character varying(30) NOT NULL, -- Nombre Clase Articulo
  MVETUR character varying(1) NOT NULL, -- Turno
  MVETUD character varying(10) NOT NULL, -- Nombre Turno
  MVEVAL double precision DEFAULT 0, -- Valor Indicador USD
  MVEVAC double precision DEFAULT 0, -- Valor Indicador LOCAL
  MVERID character varying(1) NOT NULL, -- Indicador Visualizar
  MVEVAP double precision DEFAULT 0, -- Valor Indicador USD PROMEDIO
  MVEVPE double precision DEFAULT 0, -- Valor Indicador PRESUPUESTO

  CONSTRAINT INDMAN5_pk PRIMARY KEY (MVEANO, MVEMES, MVEREG, MVECIA, MVEPCE, MVEIND, MVECEN, MVEPRO, MVECAL, MVETUR)
)WITH (OIDS=FALSE); ALTER TABLE man.INDMAN5 OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE man.cfg5
(
  indicador character varying(10),
  operacion character varying(3),
  area character varying,
  division character varying,
  descripcion character varying,
  unidad character varying,
  tipo character varying,
  CONSTRAINT cfg5_pk PRIMARY KEY (indicador)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE man.cfg5
  OWNER TO postgres;
  
  -- -------------------------------------------------------------------------------

INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN001', 'SUM', 'Manufacture', '', '1. ', '%', '%');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN002', 'SUM', 'Manufacture', '', '2. ', '%', '%');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN003', 'SUM', 'Manufacture', '', '3. ', 'Days', 'V');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN004', 'SUM', 'Manufacture', '', '4. ', 'USD/Ton', '$');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN005', 'AVG', 'Manufacture', '', '5. ', 'Days', 'V');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN006', 'SUM', 'Manufacture', '', '6. ', '%', '%');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN007', 'SUM', 'Manufacture', '', '7. ', 'Times per Month', 'V');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN008', 'AVG', 'Manufacture', '', '8. ', 'USD/Ton', '$');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN009', 'SUM', 'Manufacture', '', '9. ', '% of Revenue', '%');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN010', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN011', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN012', 'SUM', 'Manufacture', '', '12. ', '%', '%');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN013', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN014', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg5(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN015', 'SUM', 'Manufacture', '', '12. ', '%', '%');
  
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------

CREATE TABLE man.INDMAN6(
  MVEANO integer NOT NULL DEFAULT 0, -- Año de proceso
  MVEMES integer NOT NULL DEFAULT 0, -- Mes de proceso
  MVEREG character varying(3), -- Region
  MVECIA integer NOT NULL DEFAULT 0, -- Compañia
  MVECIN character varying(30) NOT NULL, -- Nombre Compañia
  MVEPCE character varying(6) NOT NULL, -- Proceso
  MVECLN character varying(50) NOT NULL, -- Nombre Proceso
  MVEIND character varying(6) NOT NULL, -- ID. Indicador
  MVEDES character varying(50) NOT NULL, -- Descripcion Indicador
  MVECEN character varying(6) NOT NULL, -- Codigo Centro
  MVECED character varying(30) NOT NULL, -- Nombre Centro Productivo
  MVEPRO character varying(15) NOT NULL, -- Codigo Producto
  MVEPRN character varying(50) NOT NULL, -- Nombre Producto
  MVECAL character varying(2) NOT NULL, -- Clase Articulo
  MVECAN character varying(30) NOT NULL, -- Nombre Clase Articulo
  MVETUR character varying(1) NOT NULL, -- Turno
  MVETUD character varying(10) NOT NULL, -- Nombre Turno
  MVEVAL double precision DEFAULT 0, -- Valor Indicador USD
  MVEVAC double precision DEFAULT 0, -- Valor Indicador LOCAL
  MVERID character varying(1) NOT NULL, -- Indicador Visualizar
  MVEVAP double precision DEFAULT 0, -- Valor Indicador USD PROMEDIO
  MVEVPE double precision DEFAULT 0, -- Valor Indicador PRESUPUESTO

  CONSTRAINT INDMAN6_pk PRIMARY KEY (MVEANO, MVEMES, MVEREG, MVECIA, MVEPCE, MVEIND, MVECEN, MVEPRO, MVECAL, MVETUR)
)WITH (OIDS=FALSE); ALTER TABLE man.INDMAN6 OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE man.cfg6
(
  indicador character varying(10),
  operacion character varying(3),
  area character varying,
  division character varying,
  descripcion character varying,
  unidad character varying,
  tipo character varying,
  CONSTRAINT cfg6_pk PRIMARY KEY (indicador)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE man.cfg6
  OWNER TO postgres;
  
-- -------------------------------------------------------------------------------

INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN001', 'SUM', 'Manufacture', '', '1. ', '%', '%');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN002', 'SUM', 'Manufacture', '', '2. ', '%', '%');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN003', 'SUM', 'Manufacture', '', '3. ', 'Days', 'V');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN004', 'SUM', 'Manufacture', '', '4. ', 'USD/Ton', '$');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN005', 'AVG', 'Manufacture', '', '5. ', 'Days', 'V');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN006', 'SUM', 'Manufacture', '', '6. ', '%', '%');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN007', 'SUM', 'Manufacture', '', '7. ', 'Times per Month', 'V');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN008', 'AVG', 'Manufacture', '', '8. ', 'USD/Ton', '$');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN009', 'SUM', 'Manufacture', '', '9. ', '% of Revenue', '%');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN010', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN011', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN012', 'SUM', 'Manufacture', '', '12. ', '%', '%');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN013', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN014', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg6(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN015', 'SUM', 'Manufacture', '', '12. ', '%', '%');

-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------

CREATE TABLE man.INDMAN7(
  MVEANO integer NOT NULL DEFAULT 0, -- Año de proceso
  MVEMES integer NOT NULL DEFAULT 0, -- Mes de proceso
  MVEREG character varying(3), -- Region
  MVECIA integer NOT NULL DEFAULT 0, -- Compañia
  MVECIN character varying(30) NOT NULL, -- Nombre Compañia
  MVEPCE character varying(6) NOT NULL, -- Proceso
  MVECLN character varying(50) NOT NULL, -- Nombre Proceso
  MVEIND character varying(6) NOT NULL, -- ID. Indicador
  MVEDES character varying(50) NOT NULL, -- Descripcion Indicador
  MVECEN character varying(6) NOT NULL, -- Codigo Centro
  MVECED character varying(30) NOT NULL, -- Nombre Centro Productivo
  MVEPRO character varying(15) NOT NULL, -- Codigo Producto
  MVEPRN character varying(50) NOT NULL, -- Nombre Producto
  MVECAL character varying(2) NOT NULL, -- Clase Articulo
  MVECAN character varying(30) NOT NULL, -- Nombre Clase Articulo
  MVETUR character varying(1) NOT NULL, -- Turno
  MVETUD character varying(10) NOT NULL, -- Nombre Turno
  MVEVAL double precision DEFAULT 0, -- Valor Indicador USD
  MVEVAC double precision DEFAULT 0, -- Valor Indicador LOCAL
  MVERID character varying(1) NOT NULL, -- Indicador Visualizar
  MVEVAP double precision DEFAULT 0, -- Valor Indicador USD PROMEDIO
  MVEVPE double precision DEFAULT 0, -- Valor Indicador PRESUPUESTO

  CONSTRAINT INDMAN7_pk PRIMARY KEY (MVEANO, MVEMES, MVEREG, MVECIA, MVEPCE, MVEIND, MVECEN, MVEPRO, MVECAL, MVETUR)
)WITH (OIDS=FALSE); ALTER TABLE man.INDMAN7 OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE man.cfg7
(
  indicador character varying(10),
  operacion character varying(3),
  area character varying,
  division character varying,
  descripcion character varying,
  unidad character varying,
  tipo character varying,
  CONSTRAINT cfg7_pk PRIMARY KEY (indicador)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE man.cfg7
  OWNER TO postgres;
  
-- -------------------------------------------------------------------------------

INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN001', 'SUM', 'Manufacture', '', '1. ', '%', '%');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN002', 'SUM', 'Manufacture', '', '2. ', '%', '%');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN003', 'SUM', 'Manufacture', '', '3. ', 'Days', 'V');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN004', 'SUM', 'Manufacture', '', '4. ', 'USD/Ton', '$');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN005', 'AVG', 'Manufacture', '', '5. ', 'Days', 'V');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN006', 'SUM', 'Manufacture', '', '6. ', '%', '%');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN007', 'SUM', 'Manufacture', '', '7. ', 'Times per Month', 'V');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN008', 'AVG', 'Manufacture', '', '8. ', 'USD/Ton', '$');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN009', 'SUM', 'Manufacture', '', '9. ', '% of Revenue', '%');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN010', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN011', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN012', 'SUM', 'Manufacture', '', '12. ', '%', '%');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN013', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN014', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg7(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN015', 'SUM', 'Manufacture', '', '12. ', '%', '%');

-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------

CREATE TABLE man.INDMAN8(
  MVEANO integer NOT NULL DEFAULT 0, -- Año de proceso
  MVEMES integer NOT NULL DEFAULT 0, -- Mes de proceso
  MVEREG character varying(3), -- Region
  MVECIA integer NOT NULL DEFAULT 0, -- Compañia
  MVECIN character varying(30) NOT NULL, -- Nombre Compañia
  MVEPCE character varying(6) NOT NULL, -- Proceso
  MVECLN character varying(50) NOT NULL, -- Nombre Proceso
  MVEIND character varying(6) NOT NULL, -- ID. Indicador
  MVEDES character varying(50) NOT NULL, -- Descripcion Indicador
  MVECEN character varying(6) NOT NULL, -- Codigo Centro
  MVECED character varying(30) NOT NULL, -- Nombre Centro Productivo
  MVEPRO character varying(15) NOT NULL, -- Codigo Producto
  MVEPRN character varying(50) NOT NULL, -- Nombre Producto
  MVECAL character varying(2) NOT NULL, -- Clase Articulo
  MVECAN character varying(30) NOT NULL, -- Nombre Clase Articulo
  MVETUR character varying(1) NOT NULL, -- Turno
  MVETUD character varying(10) NOT NULL, -- Nombre Turno
  MVEVAL double precision DEFAULT 0, -- Valor Indicador USD
  MVEVAC double precision DEFAULT 0, -- Valor Indicador LOCAL
  MVERID character varying(1) NOT NULL, -- Indicador Visualizar
  MVEVAP double precision DEFAULT 0, -- Valor Indicador USD PROMEDIO
  MVEVPE double precision DEFAULT 0, -- Valor Indicador PRESUPUESTO

  CONSTRAINT INDMAN8_pk PRIMARY KEY (MVEANO, MVEMES, MVEREG, MVECIA, MVEPCE, MVEIND, MVECEN, MVEPRO, MVECAL, MVETUR)
)WITH (OIDS=FALSE); ALTER TABLE man.INDMAN8 OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE man.cfg8
(
  indicador character varying(10),
  operacion character varying(3),
  area character varying,
  division character varying,
  descripcion character varying,
  unidad character varying,
  tipo character varying,
  CONSTRAINT cfg8_pk PRIMARY KEY (indicador)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE man.cfg8
  OWNER TO postgres;
  
-- -------------------------------------------------------------------------------

INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN001', 'SUM', 'Manufacture', '', '1. ', '%', '%');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN002', 'SUM', 'Manufacture', '', '2. ', '%', '%');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN003', 'SUM', 'Manufacture', '', '3. ', 'Days', 'V');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN004', 'SUM', 'Manufacture', '', '4. ', 'USD/Ton', '$');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN005', 'AVG', 'Manufacture', '', '5. ', 'Days', 'V');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN006', 'SUM', 'Manufacture', '', '6. ', '%', '%');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN007', 'SUM', 'Manufacture', '', '7. ', 'Times per Month', 'V');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN008', 'AVG', 'Manufacture', '', '8. ', 'USD/Ton', '$');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN009', 'SUM', 'Manufacture', '', '9. ', '% of Revenue', '%');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN010', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN011', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN012', 'SUM', 'Manufacture', '', '12. ', '%', '%');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN013', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN014', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg8(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN015', 'SUM', 'Manufacture', '', '12. ', '%', '%');


-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------

CREATE TABLE man.INDMAN9(
  MVEANO integer NOT NULL DEFAULT 0, -- Año de proceso
  MVEMES integer NOT NULL DEFAULT 0, -- Mes de proceso
  MVEREG character varying(3), -- Region
  MVECIA integer NOT NULL DEFAULT 0, -- Compañia
  MVECIN character varying(30) NOT NULL, -- Nombre Compañia
  MVEPCE character varying(6) NOT NULL, -- Proceso
  MVECLN character varying(50) NOT NULL, -- Nombre Proceso
  MVEIND character varying(6) NOT NULL, -- ID. Indicador
  MVEDES character varying(50) NOT NULL, -- Descripcion Indicador
  MVECEN character varying(6) NOT NULL, -- Codigo Centro
  MVECED character varying(30) NOT NULL, -- Nombre Centro Productivo
  MVEPRO character varying(15) NOT NULL, -- Codigo Producto
  MVEPRN character varying(50) NOT NULL, -- Nombre Producto
  MVECAL character varying(2) NOT NULL, -- Clase Articulo
  MVECAN character varying(30) NOT NULL, -- Nombre Clase Articulo
  MVETUR character varying(1) NOT NULL, -- Turno
  MVETUD character varying(10) NOT NULL, -- Nombre Turno
  MVEVAL double precision DEFAULT 0, -- Valor Indicador USD
  MVEVAC double precision DEFAULT 0, -- Valor Indicador LOCAL
  MVERID character varying(1) NOT NULL, -- Indicador Visualizar
  MVEVAP double precision DEFAULT 0, -- Valor Indicador USD PROMEDIO
  MVEVPE double precision DEFAULT 0, -- Valor Indicador PRESUPUESTO

  CONSTRAINT INDMAN9_pk PRIMARY KEY (MVEANO, MVEMES, MVEREG, MVECIA, MVEPCE, MVEIND, MVECEN, MVEPRO, MVECAL, MVETUR)
)WITH (OIDS=FALSE); ALTER TABLE man.INDMAN9 OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE man.cfg9
(
  indicador character varying(10),
  operacion character varying(3),
  area character varying,
  division character varying,
  descripcion character varying,
  unidad character varying,
  tipo character varying,
  CONSTRAINT cfg9_pk PRIMARY KEY (indicador)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE man.cfg9
  OWNER TO postgres;
  
-- -------------------------------------------------------------------------------

INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN001', 'SUM', 'Manufacture', '', '1. ', '%', '%');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN002', 'SUM', 'Manufacture', '', '2. ', '%', '%');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN003', 'SUM', 'Manufacture', '', '3. ', 'Days', 'V');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN004', 'SUM', 'Manufacture', '', '4. ', 'USD/Ton', '$');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN005', 'AVG', 'Manufacture', '', '5. ', 'Days', 'V');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN006', 'SUM', 'Manufacture', '', '6. ', '%', '%');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN007', 'SUM', 'Manufacture', '', '7. ', 'Times per Month', 'V');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN008', 'AVG', 'Manufacture', '', '8. ', 'USD/Ton', '$');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN009', 'SUM', 'Manufacture', '', '9. ', '% of Revenue', '%');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN010', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN011', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN012', 'SUM', 'Manufacture', '', '12. ', '%', '%');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN013', 'SUM', 'Manufacture', '', '10. ', '%', '%');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN014', 'SUM', 'Manufacture', '', '11. ', '#', 'V');
INSERT INTO man.cfg9(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN015', 'SUM', 'Manufacture', '', '12. ', '%', '%');