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
  MVECEN character varying(4) NOT NULL, -- Codigo Centro
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

  CONSTRAINT INDMAN1_pk PRIMARY KEY (MVEANO, MVEMES, MVEREG, MVECIA, MVEPCE, MVEIND, MVECEN, MVEPRO, MVECAL)
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
  CONSTRAINT cfg_pk PRIMARY KEY (indicador)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE man.cfg1
  OWNER TO postgres;
  
-- -------------------------------------------------------------------------------

INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN001', 'SUM', 'Manufacture', '', '1. Fill Rate Qty', '%', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN002', 'SUM', 'Manufacture', '', '2. Fill Rate On Time', '%', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN003', 'SUM', 'Manufacture', '', '3. Lead Time', 'Days', 'V');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN004', 'SUM', 'Manufacture', '', '4. Transportation Cost', 'USD/Ton', '$');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN005', 'AVG', 'Manufacture', '', '5. Delivery average time', 'Days', 'V');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN006', 'SUM', 'Manufacture', '', '6. Cubic Capacity use per vehicle', '%', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN007', 'SUM', 'Manufacture', '', '7. Finished Product inventory turn', 'Times per Month', 'V');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN008', 'AVG', 'Manufacture', '', '8. Delivery Expensess', 'USD/Ton', '$');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN009', 'SUM', 'Manufacture', '', '9. Delivery Expensess', '% of Revenue', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN010', 'SUM', 'Manufacture', '', '10. Direct Delivery', '%', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN011', 'SUM', 'Manufacture', '', '11. OSHA Rate', '#', 'V');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN012', 'SUM', 'Manufacture', '', '12. Adsenteeism', '%', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN013', 'SUM', 'Manufacture', '', '10. Direct Delivery', '%', '%');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN014', 'SUM', 'Manufacture', '', '11. OSHA Rate', '#', 'V');
INSERT INTO man.cfg1(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('MAN015', 'SUM', 'Manufacture', '', '12. Adsenteeism', '%', '%');
