INSERT INTO PERSON(person_id, first_name, last_name, middle_name, birth_dt, sex) VALUES (person_id_seq.nextval, 'Fred', 'Flintstone', null, '1900-07-01', 0);
INSERT INTO PERSON(person_id, first_name, last_name, middle_name, birth_dt, sex) VALUES (person_id_seq.nextval, 'Barney', 'Rubble', null, '1900-02-15', 0);

INSERT INTO ADDRESS(address_id, attention, street_address, city, prov, country, postal, person_id) VALUES (address_id_seq.nextval, 'Bam Bam', '301 Cobblestone Way', 'Bedrock', '', '', '70777', 2)
