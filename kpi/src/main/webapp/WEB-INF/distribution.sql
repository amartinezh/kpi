\c kpi;


DROP SCHEMA  dis CASCADE;

CREATE SCHEMA dis
  AUTHORIZATION postgres;

CREATE TABLE dis.INDDIS(
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

  CONSTRAINT tip_id_pk PRIMARY KEY (MVEANO, MVEMES, MVEREG, MVECIA, MVEIND, MVECLI, MVETIC, MVELOC, MVECR1, MVECR2, MVECR3, MVECR4, MVECR5, MVESAL, MVEPRO, MVECAL, MVESR1, MVESR2, MVESR3, MVESR4, MVESR5)
)WITH (OIDS=FALSE); ALTER TABLE kpi.MVINDVE OWNER TO postgres;


-- -------------------------------------------------------------------------------

CREATE TABLE dis.cfg
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
ALTER TABLE dis.cfg
  OWNER TO postgres;
  
-- -------------------------------------------------------------------------------

INSERT INTO dis.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('DIS001', 'SUM', 'Distribution', '', '1. Fill Rate Qty', '%', '%');
INSERT INTO dis.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('DIS002', 'SUM', 'Distribution', '', '2. Fill Rate On Time', '%', '%');
INSERT INTO dis.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('DIS003', 'SUM', 'Distribution', '', '3. Lead Time', 'Days', 'V');
INSERT INTO dis.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('DIS004', 'SUM', 'Distribution', '', '4. Transportation Cost', 'USD/Ton', '$');
INSERT INTO dis.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('DIS005', 'AVG', 'Distribution', '', '5. Delivery average time', 'Days', 'V');
INSERT INTO dis.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('DIS006', 'SUM', 'Distribution', '', '6. Cubic Capacity use per vehicle', '%', '%');
INSERT INTO dis.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('DIS007', 'SUM', 'Distribution', '', '7. Finished Product inventory turn', 'Times per Month', 'V');
INSERT INTO dis.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('DIS008', 'AVG', 'Distribution', '', '8. Delivery Expensess', 'USD/Ton', '$');
INSERT INTO dis.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('DIS009', 'SUM', 'Distribution', '', '9. Delivery Expensess', '% of Revenue', '%');
INSERT INTO dis.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('DIS010', 'SUM', 'Distribution', '', '10. Direct Delivery', '%', '%');
INSERT INTO dis.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('DIS011', 'SUM', 'Distribution', '', '11. OSHA Rate', '#', 'V');
INSERT INTO dis.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('DIS012', 'SUM', 'Distribution', '', '12. Adsenteeism', '%', '%');
