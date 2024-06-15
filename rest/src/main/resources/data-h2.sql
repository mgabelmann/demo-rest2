INSERT INTO SEX_CODE(id, description) VALUES ('M', 'Male');
INSERT INTO SEX_CODE(id, description) VALUES ('F', 'Female');

INSERT INTO PERSON(person_id, first_name, last_name, middle_name, birth_dt, sex_code) VALUES (RANDOM_UUID(), 'Fred', 'Flintstone', null, '1900-07-01', (SELECT id FROM SEX_CODE WHERE id = 'M'));
INSERT INTO PERSON(person_id, first_name, last_name, middle_name, birth_dt, sex_code) VALUES (RANDOM_UUID(), 'Barney', 'Rubble', null, '1900-02-15', (SELECT id FROM SEX_CODE WHERE id = 'M'));

INSERT INTO ADDRESS(address_id, attention, delivery_info, civic_address, postal_info, city, prov, postal, country, primary_address, person_id) VALUES (RANDOM_UUID(), 'Barney Rubble', null, '123 Bedrock St', null, 'Bedrock City', 'BC', '123456', 'CA', 'Y', (SELECT person_id FROM PERSON WHERE first_name = 'Barney' AND last_name = 'Rubble'));

COMMIT;

