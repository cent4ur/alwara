INSERT INTO vehicle_type (id, name) VALUES (alwara_sequence.NEXTVAL, 'Bus')

INSERT INTO vehicle_type (id, name) VALUES (alwara_sequence.NEXTVAL, 'Train')

INSERT INTO vehicle_type (id, name) VALUES (alwara_sequence.NEXTVAL, 'Both')

INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Budapest', (SELECT id FROM vehicle_type WHERE name = 'Both'))

INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Esztergom', (SELECT id FROM vehicle_type WHERE name = 'Bus'))

INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Komárom', (SELECT id FROM vehicle_type WHERE name = 'Bus'))

INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Székesfehérvár', (SELECT id FROM vehicle_type WHERE name = 'Train'))
