INSERT INTO vehicle_type (id, name) VALUES (alwara_sequence.NEXTVAL, 'Bus')
INSERT INTO vehicle_type (id, name) VALUES (alwara_sequence.NEXTVAL, 'Train')
INSERT INTO vehicle_type (id, name) VALUES (alwara_sequence.NEXTVAL, 'Both')

INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Budapest', (SELECT id FROM vehicle_type WHERE name = 'Both'))
INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Vác', (SELECT id FROM vehicle_type WHERE name = 'Both'))
INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Balassagyarmat', (SELECT id FROM vehicle_type WHERE name = 'Both'))
INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Salgótarján', (SELECT id FROM vehicle_type WHERE name = 'Both'))
INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Dunakeszi', (SELECT id FROM vehicle_type WHERE name = 'Bus'))
INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Érsekvadkert', (SELECT id FROM vehicle_type WHERE name = 'Bus'))
INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Szátok', (SELECT id FROM vehicle_type WHERE name = 'Bus'))
INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Romhány', (SELECT id FROM vehicle_type WHERE name = 'Bus'))

INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Bánk', (SELECT id FROM vehicle_type WHERE name = 'Bus'))

INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Tereske', (SELECT id FROM vehicle_type WHERE name = 'Bus'))

INSERT INTO station (id, name, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Hatvan', (SELECT id FROM vehicle_type WHERE name = 'Bus'))


INSERT INTO line (id, name) VALUES (alwara_sequence.NEXTVAL, 'Bp_Bgy_St')
INSERT INTO line (id, name) VALUES (alwara_sequence.NEXTVAL, 'Bp_Hatvan_St')
INSERT INTO line (id, name) VALUES (alwara_sequence.NEXTVAL, 'Bp_Bgy')
INSERT INTO line (id, name) VALUES (alwara_sequence.NEXTVAL, 'Bgy_St')
INSERT INTO line (id, name) VALUES (alwara_sequence.NEXTVAL, 'St_Bgy')
INSERT INTO line (id, name) VALUES (alwara_sequence.NEXTVAL, 'Bgy_Év')
INSERT INTO line (id, name) VALUES (alwara_sequence.NEXTVAL, 'Bgy_Bánk')

INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bp_Bgy_St'), 1, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM station WHERE name = 'Dunakeszi'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 342, 19, 31)
INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bp_Bgy_St'), 2, (SELECT id FROM station WHERE name = 'Dunakeszi'), (SELECT id FROM station WHERE name = 'Vác'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 324, 18, 27)
INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bp_Bgy_St'), 3, (SELECT id FROM station WHERE name = 'Vác'), (SELECT id FROM station WHERE name = 'Érsekvadkert'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 612, 34, 32)
INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bp_Bgy_St'), 4, (SELECT id FROM station WHERE name = 'Érsekvadkert'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 270, 15, 14)
INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bp_Bgy_St'), 5, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM station WHERE name = 'Salgótarján'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 864, 48, 50)

INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bgy_Év'), 1, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM station WHERE name = 'Romhány'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 450, 25, 34)
INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bgy_Év'), 2, (SELECT id FROM station WHERE name = 'Romhány'), (SELECT id FROM station WHERE name = 'Szátok'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 72, 4, 8)
INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bgy_Év'), 3, (SELECT id FROM station WHERE name = 'Szátok'), (SELECT id FROM station WHERE name = 'Tereske'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 72, 4, 8)
INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bgy_Év'), 4, (SELECT id FROM station WHERE name = 'Tereske'), (SELECT id FROM station WHERE name = 'Érsekvadkert'), (SELECT id FROM vehicle_type WHERE name = 'Train'), 126, 7, 8)

INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bp_Bgy'), 1, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM station WHERE name = 'Vác'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 422, 42, 53)
INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bp_Bgy'), 2, (SELECT id FROM station WHERE name = 'Vác'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM vehicle_type WHERE name = 'Train'), 483, 48, 56)

INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bgy_Bánk'), 1, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM station WHERE name = 'Érsekvadkert'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 270, 15, 15)
INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bgy_Bánk'), 2, (SELECT id FROM station WHERE name = 'Érsekvadkert'), (SELECT id FROM station WHERE name = 'Szátok'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 108, 6, 7)
INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bgy_Bánk'), 3, (SELECT id FROM station WHERE name = 'Szátok'), (SELECT id FROM station WHERE name = 'Romhány'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 72, 4, 8)
INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bgy_Bánk'), 4, (SELECT id FROM station WHERE name = 'Romhány'), (SELECT id FROM station WHERE name = 'Bánk'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 126, 7, 9)

INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bp_Hatvan_St'), 1, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM station WHERE name = 'Hatvan'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 1026, 57, 46)
INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bp_Hatvan_St'), 2, (SELECT id FROM station WHERE name = 'Hatvan'), (SELECT id FROM station WHERE name = 'Salgótarján'), (SELECT id FROM vehicle_type WHERE name = 'Bus'), 1026, 57, 52)

INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'Bgy_St'), 1, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM station WHERE name = 'Salgótarján'), (SELECT id FROM vehicle_type WHERE name = 'Train'), 480, 48, 60)

INSERT INTO link (id, line_fk, ordinal, start_station_fk, stop_station_fk, vehicle_type_fk, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM line WHERE name = 'St_Bgy'), 1, (SELECT id FROM station WHERE name = 'Salgótarján'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM vehicle_type WHERE name = 'Train'), 480, 48, 60)

INSERT INTO route (id, name, line_fk, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Bp_Bgy_St', (SELECT id FROM line WHERE name = 'Bp_Bgy_St'), (SELECT id FROM vehicle_type WHERE name = 'Bus'))
INSERT INTO route (id, name, line_fk, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Bp_Hatvan_St', (SELECT id FROM line WHERE name = 'Bp_Hatvan_St'), (SELECT id FROM vehicle_type WHERE name = 'Bus'))
INSERT INTO route (id, name, line_fk, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Bp_Bgy', (SELECT id FROM line WHERE name = 'Bp_Bgy'), (SELECT id FROM vehicle_type WHERE name = 'Train'))
INSERT INTO route (id, name, line_fk, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Bgy_St', (SELECT id FROM line WHERE name = 'Bgy_St'), (SELECT id FROM vehicle_type WHERE name = 'Train'))
INSERT INTO route (id, name, line_fk, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'St_Bgy', (SELECT id FROM line WHERE name = 'St_Bgy'), (SELECT id FROM vehicle_type WHERE name = 'Train'))
INSERT INTO route (id, name, line_fk, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Bgy_Év', (SELECT id FROM line WHERE name = 'Bgy_Év'), (SELECT id FROM vehicle_type WHERE name = 'Bus'))
INSERT INTO route (id, name, line_fk, vehicle_type_fk) VALUES (alwara_sequence.NEXTVAL, 'Bgy_Bánk', (SELECT id FROM line WHERE name = 'Bgy_Bánk'), (SELECT id FROM vehicle_type WHERE name = 'Bus'))

INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1200','HH24MI'), (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Bgy_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1200','HH24MI'), (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Hatvan_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1200','HH24MI'), (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Bgy'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1200','HH24MI'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1200','HH24MI'), (SELECT id FROM station WHERE name = 'Salgótarján'), (SELECT id FROM route WHERE name = 'St_Bgy'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1200','HH24MI'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_Év'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1200','HH24MI'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_Bánk'))

INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1400','HH24MI'), (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Bgy_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1400','HH24MI'), (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Hatvan_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1400','HH24MI'), (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Bgy'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1400','HH24MI'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1400','HH24MI'), (SELECT id FROM station WHERE name = 'Salgótarján'), (SELECT id FROM route WHERE name = 'St_Bgy'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1400','HH24MI'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_Év'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1400','HH24MI'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_Bánk'))

INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1600','HH24MI'), (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Bgy_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1600','HH24MI'), (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Hatvan_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1600','HH24MI'), (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Bgy'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1600','HH24MI'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1600','HH24MI'), (SELECT id FROM station WHERE name = 'Salgótarján'), (SELECT id FROM route WHERE name = 'St_Bgy'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1600','HH24MI'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_Év'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, TO_DATE('1600','HH24MI'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_Bánk'))