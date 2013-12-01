INSERT INTO station (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Budapest', 1, 1)
INSERT INTO station (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Vác', 1, 1)
INSERT INTO station (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Balassagyarmat', 1, 1)
INSERT INTO station (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Salgótarján', 1, 1)
INSERT INTO station (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Dunakeszi', 1, 0)
INSERT INTO station (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Érsekvadkert', 1, 0)
INSERT INTO station (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Szátok', 1, 0)
INSERT INTO station (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Romhány', 1, 0)
INSERT INTO station (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Bánk', 1, 0)
INSERT INTO station (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Tereske', 1, 0)
INSERT INTO station (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Hatvan', 1, 0)

INSERT INTO route (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Bp_Bgy_St', 1, 0)
INSERT INTO route (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Bp_Hatvan_St', 1, 0)
INSERT INTO route (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Bp_Bgy', 0, 1)
INSERT INTO route (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Bgy_St', 0, 1)
INSERT INTO route (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'St_Bgy', 0, 1)
INSERT INTO route (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Bgy_Év', 1, 0)
INSERT INTO route (id, name, bus, train) VALUES (alwara_sequence.NEXTVAL, 'Bgy_Bánk', 1, 0)

INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bp_Bgy_St'), 1, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM station WHERE name = 'Dunakeszi'), 1, 0, 342, 19, 31)
INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bp_Bgy_St'), 2, (SELECT id FROM station WHERE name = 'Dunakeszi'), (SELECT id FROM station WHERE name = 'Vác'), 1, 0, 324, 18, 27)
INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bp_Bgy_St'), 3, (SELECT id FROM station WHERE name = 'Vác'), (SELECT id FROM station WHERE name = 'Érsekvadkert'), 1, 0, 612, 34, 32)
INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bp_Bgy_St'), 4, (SELECT id FROM station WHERE name = 'Érsekvadkert'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), 1, 0, 270, 15, 14)
INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bp_Bgy_St'), 5, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM station WHERE name = 'Salgótarján'), 1, 0, 864, 48, 50)

INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bgy_Év'), 1, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM station WHERE name = 'Romhány'), 1, 0, 450, 25, 34)
INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bgy_Év'), 2, (SELECT id FROM station WHERE name = 'Romhány'), (SELECT id FROM station WHERE name = 'Szátok'), 1, 0, 72, 4, 8)
INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bgy_Év'), 3, (SELECT id FROM station WHERE name = 'Szátok'), (SELECT id FROM station WHERE name = 'Tereske'), 1, 0, 72, 4, 8)
INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bgy_Év'), 4, (SELECT id FROM station WHERE name = 'Tereske'), (SELECT id FROM station WHERE name = 'Érsekvadkert'), 0, 1, 126, 7, 8)

INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bp_Bgy'), 1, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM station WHERE name = 'Vác'), 1, 0, 422, 42, 53)
INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bp_Bgy'), 2, (SELECT id FROM station WHERE name = 'Vác'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), 0, 1, 483, 48, 56)

INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bgy_Bánk'), 1, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM station WHERE name = 'Érsekvadkert'), 1, 0, 270, 15, 15)
INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bgy_Bánk'), 2, (SELECT id FROM station WHERE name = 'Érsekvadkert'), (SELECT id FROM station WHERE name = 'Szátok'), 1, 0, 108, 6, 7)
INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bgy_Bánk'), 3, (SELECT id FROM station WHERE name = 'Szátok'), (SELECT id FROM station WHERE name = 'Romhány'), 1, 0, 72, 4, 8)
INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bgy_Bánk'), 4, (SELECT id FROM station WHERE name = 'Romhány'), (SELECT id FROM station WHERE name = 'Bánk'), 1, 0, 126, 7, 9)

INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bp_Hatvan_St'), 1, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM station WHERE name = 'Hatvan'), 1, 0, 1026, 57, 46)
INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bp_Hatvan_St'), 2, (SELECT id FROM station WHERE name = 'Hatvan'), (SELECT id FROM station WHERE name = 'Salgótarján'), 1, 0, 1026, 57, 52)

INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'Bgy_St'), 1, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM station WHERE name = 'Salgótarján'), 0, 1, 480, 48, 60)

INSERT INTO line (id, route_fk, ordinal, start_station_fk, stop_station_fk, bus, train, cost, length, time) VALUES (alwara_sequence.NEXTVAL, (SELECT id FROM route WHERE name = 'St_Bgy'), 1, (SELECT id FROM station WHERE name = 'Salgótarján'), (SELECT id FROM station WHERE name = 'Balassagyarmat'), 0, 1, 480, 48, 60)

INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 720, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Bgy_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 720, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Hatvan_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 720, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Bgy'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 720, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 720, (SELECT id FROM station WHERE name = 'Salgótarján'), (SELECT id FROM route WHERE name = 'St_Bgy'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 720, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_Év'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 720, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_Bánk'))

INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 840, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Bgy_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 840, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Hatvan_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 840, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Bgy'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 840, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 840, (SELECT id FROM station WHERE name = 'Salgótarján'), (SELECT id FROM route WHERE name = 'St_Bgy'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 840, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_Év'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 840, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_Bánk'))

INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 960, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Bgy_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 960, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Hatvan_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 960, (SELECT id FROM station WHERE name = 'Budapest'), (SELECT id FROM route WHERE name = 'Bp_Bgy'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 960, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_St'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 960, (SELECT id FROM station WHERE name = 'Salgótarján'), (SELECT id FROM route WHERE name = 'St_Bgy'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 960, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_Év'))
INSERT INTO timetable (id, start_time, station_fk, route_fk) VALUES (alwara_sequence.NEXTVAL, 960, (SELECT id FROM station WHERE name = 'Balassagyarmat'), (SELECT id FROM route WHERE name = 'Bgy_Bánk'))