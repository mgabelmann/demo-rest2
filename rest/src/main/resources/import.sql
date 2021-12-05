--CREATE SEQUENCE IF NOT EXISTS person_id_seq AS INTEGER START WITH 1;

INSERT INTO PERSON(person_id, first_name, last_name, middle_name, birth_dt, sex) VALUES (NEXTVAL('PERSON_ID_SEQ'), 'Fred', 'Flintstone', null, '1900-07-01', 0);
INSERT INTO PERSON(person_id, first_name, last_name, middle_name, birth_dt, sex) VALUES (NEXTVAL('PERSON_ID_SEQ'), 'Barney', 'Rubble', null, '1900-02-15', 0);

INSERT INTO ADDRESS(address_id, attention, street_address, city, prov, country, postal, person_id) VALUES (NEXTVAL('ADDRESS_ID_SEQ'), 'Bam Bam', '301 Cobblestone Way', 'Bedrock', '', '', '70777', 2)
