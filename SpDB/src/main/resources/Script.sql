CREATE TABLE ctry (
  ctry_id         NUMBER,
  ctry_name       VARCHAR2(50)  NOT NULL,
  ctry_area       NUMBER        NOT NULL,
  ctry_pop        NUMBER        NOT NULL,
 
  CONSTRAINT ctry_pk  PRIMARY KEY (ctry_id),
  CONSTRAINT ctry_uk UNIQUE (ctry_name)
);

DROP SEQUENCE ctry_seq;
CREATE SEQUENCE ctry_seq;
CREATE OR REPLACE TRIGGER ctry_trg
  BEFORE INSERT ON ctry FOR EACH ROW
BEGIN 
    IF :NEW.ctry_id IS NULL THEN
      SELECT ctry_seq.NEXTVAL INTO :NEW.ctry_id FROM DUAL;
    END IF;
END;

CREATE OR REPLACE TRIGGER ctry_trg
  BEFORE INSERT ON ctry FOR EACH ROW
BEGIN 
    IF :NEW.ctry_id IS NULL THEN
      SELECT ctry_seq.NEXTVAL INTO :NEW.ctry_id FROM DUAL;
    END IF;
END;