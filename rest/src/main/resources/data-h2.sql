INSERT INTO SEX_CODE(id, description) VALUES ('M', 'Male');
INSERT INTO SEX_CODE(id, description) VALUES ('F', 'Female');

INSERT INTO PERSON(person_id, first_name, last_name, middle_name, birth_dt, sex_code) VALUES (RANDOM_UUID(), 'Fred', 'Flintstone', null, '1900-07-01', (SELECT id FROM SEX_CODE WHERE id = 'M'));
INSERT INTO PERSON(person_id, first_name, last_name, middle_name, birth_dt, sex_code) VALUES (RANDOM_UUID(), 'Barney', 'Rubble', null, '1900-02-15', (SELECT id FROM SEX_CODE WHERE id = 'M'));

INSERT INTO ADDRESS(address_id, attention, delivery_info, civic_address, postal_info, city, prov, postal, country, primary_address, person_id) VALUES (RANDOM_UUID(), 'Barney Rubble', null, '123 Bedrock St', null, 'Bedrock City', 'BC', '123456', 'CA', 'Y', (SELECT person_id FROM PERSON WHERE first_name = 'Barney' AND last_name = 'Rubble'));

INSERT INTO GROUP_CODE(group_id, description) VALUES ('CNT', 'Country');
INSERT INTO GROUP_CODE(group_id, description) VALUES ('PRO', 'Province or State');

--FIXME: parent nodes dont need to reference themselves
INSERT INTO GROUP_TYPE_CODE(group_id, type_id, description, position, effective, p_group_id, p_type_id) VALUES ('CNT', 'CA', 'Canada', 1, 'Y', null, null);
INSERT INTO GROUP_TYPE_CODE(group_id, type_id, description, position, effective, p_group_id, p_type_id) VALUES ('CNT', 'US', 'United States', 0, 'Y', null, null);

INSERT INTO GROUP_TYPE_CODE(group_id, type_id, description, position, effective, p_group_id, p_type_id) VALUES ('PRO', 'BC', 'British Columbia', 0, 'Y', 'CNT', 'CA');
INSERT INTO GROUP_TYPE_CODE(group_id, type_id, description, position, effective, p_group_id, p_type_id) VALUES ('PRO', 'AB', 'Alberta', 1, 'Y', 'CNT', 'CA');

INSERT INTO GROUP_TYPE_CODE(group_id, type_id, description, position, effective, p_group_id, p_type_id) VALUES ('PRO', 'WA', 'Washington', 1, 'Y', 'CNT', 'US');

COMMIT;

