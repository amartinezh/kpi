\c kpi;


DROP SCHEMA  finances CASCADE;

CREATE SCHEMA finances
  AUTHORIZATION postgres;

CREATE TABLE finances.INDFIN(
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

CREATE TABLE finances.cfg
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
ALTER TABLE finances.cfg
  OWNER TO postgres;
  
-- -------------------------------------------------------------------------------

INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN001', 'SUM', 'Finances', '', 'Net profit', 'USD', 'V');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN002', 'AVG', 'Finances', '', 'Net profit', '% of Revenue', '$');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN003', 'SUM', 'Finances', '', 'Operating Cash Flow', 'USD', '$');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN004', 'SUM', 'Finances', '', 'EBITDA', 'USD', '$');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN005', 'AVG', 'Finances', '', 'EBITDA', '% of Revenue', '%');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN006', 'SUM', 'Finances', '', 'Cash balance', 'USD', '$');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN007', 'SUM', 'Finances', '', 'Cash Balance Change', 'USD', '$');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN008', 'AVG', 'Finances', '', 'Taxes expenses', '%', '%');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN009', 'SUM', 'Finances', '', 'The Break-even Point', 'USD', 'V');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN010', 'SUM', 'Finances', '', 'Trade Receivables', 'Days', 'V');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN011', 'SUM', 'Finances', '', 'Trade Account Payable', 'Days', 'V');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN012', 'SUM', 'Finances', '', 'Inventories days', 'Days', 'V');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN013', 'SUM', 'Finances', '', 'Working Capital', 'Days', 'V');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN014', 'SUM', 'Finances', '', 'Current Ratio', '#', 'V');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN015', 'SUM', 'Finances', '', 'Acid Test Ratio', '#', 'V');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN016', 'AVG', 'Finances', '', 'Short Term Financial Debt to Current Assets', '%', '%');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN017', 'AVG', 'Finances', '', 'Assets Efficiency', '%', '%');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN018', 'AVG', 'Finances', '', 'Financial Leverage (Liabilities to Assets)', '%', '%');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN019', 'AVG', 'Finances', '', 'Total Financial Debt to Assets', '%', '%');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN020', 'AVG', 'Finances', '', 'Long Term Debt to Fixed Assets', '%', '%');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN021', 'SUM', 'Finances', '', 'Total Financial Debt to Ebitda', '#', 'V');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN022', 'SUM', 'Finances', '', 'Financial Debt', 'USD', 'V');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN023', 'SUM', 'Finances', '', 'Interest Coverage', '#', 'V');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN024', 'AVG', 'Finances', '', 'Financial Cost', '%', '%');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN025', 'SUM', 'Finances', '', 'Financial Cost', 'USD/Ton', 'V');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN026', 'AVG', 'Finances', '', 'Return of Investment (ROI)', '%', '%');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN027', 'AVG', 'Finances', '', 'Return on Equity (ROE)', '%', '%');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN028', 'AVG', 'Finances', '', 'Financial Area Expenses', '% of Revenue', '%');
INSERT INTO finances.cfg(indicador, operacion, area, division, descripcion, unidad, tipo) VALUES ('FIN029', 'SUM', 'Finances', '', 'Financial Area Expenses', 'USD/Ton', 'V');


