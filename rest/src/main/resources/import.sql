--CREATE SEQUENCE IF NOT EXISTS person_id_seq AS INTEGER START WITH 1;

INSERT INTO SEX_CODE(id, description) VALUES ('M', 'Male');
INSERT INTO SEX_CODE(id, description) VALUES ('F', 'Female');

INSERT INTO PERSON(person_id, first_name, last_name, middle_name, birth_dt, sex_code) VALUES (NEXTVAL('PERSON_ID_SEQ'), 'Fred', 'Flintstone', null, '1900-07-01', (SELECT id FROM SEX_CODE WHERE id = 'M'));
INSERT INTO PERSON(person_id, first_name, last_name, middle_name, birth_dt, sex_code) VALUES (NEXTVAL('PERSON_ID_SEQ'), 'Barney', 'Rubble', null, '1900-02-15', (SELECT id FROM SEX_CODE WHERE id = 'M'));

INSERT INTO ADDRESS(address_id, attention, delivery_info, civic_address, postal_info, city, prov, postal, country, primary_address, person_id) VALUES (NEXTVAL('ADDRESS_ID_SEQ'), 'Barney Rubble', null, '123 Bedrock St', null, 'Bedrock City', 'BC', '123456', 'CA', 'Y', 2);

