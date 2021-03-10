-- Insert into chamber_type table two types:
INSERT INTO hospital.chamber_type (chamber_name) VALUES ('ward');
INSERT INTO hospital.chamber_type (chamber_name) VALUES ('cabinet');

-- Insert into chamber table seven chamber:
INSERT INTO hospital.chamber (max_count, number, fk_ch_type) VALUES (20, 1, 2);
INSERT INTO hospital.chamber (max_count, number, fk_ch_type) VALUES (5, 2, 2);
INSERT INTO hospital.chamber (max_count, number, fk_ch_type) VALUES (3, 3, 1);
INSERT INTO hospital.chamber (max_count, number, fk_ch_type) VALUES (5, 4, 1);
INSERT INTO hospital.chamber (max_count, number, fk_ch_type) VALUES (7, 5, 1);
INSERT INTO hospital.chamber (max_count, number, fk_ch_type) VALUES (18, 6, 1);
INSERT INTO hospital.chamber (max_count, number, fk_ch_type) VALUES (8, 7, 1);
INSERT INTO hospital.chamber (max_count, number, fk_ch_type) VALUES (1, 8, 2);

-- Insert into role table:
INSERT INTO hospital.role (role_name) VALUES ('patient');
INSERT INTO hospital.role (role_name) VALUES ('admin');
INSERT INTO hospital.role (role_name) VALUES ('doctor');
INSERT INTO hospital.role (role_name) VALUES ('nurse');

-- Insert into person table

-- admin (staff registration with basic password '1111'
INSERT INTO hospital.person (name, surname, birthday, phone, email, password, fk_role, fk_chamber)
VALUES ('Andrei', 'Kazavou', '1989-02-06', '0507841205', 'abcd.hospital@gmail.com', '12345', 2, 8);

-- doctors (patient registration with basic password '1111'
INSERT INTO hospital.person (name, surname, birthday, phone, email, password, fk_role, fk_chamber)
VALUES ('Василий', 'Петушков', '1972-05-23', '0632551239', 'dcba.zh@gmail.com', '12345', 3, 1);

INSERT INTO hospital.person (name, surname, birthday, phone, email, password, fk_role, fk_chamber)
VALUES ('Иван', 'Иванов', '1999-05-23', '0999912426', 'vbnm@gmail.com', '12345', 3, 1);

INSERT INTO hospital.person (name, surname, birthday, phone, email, password, fk_role, fk_chamber)
VALUES ('Sam', 'Anderson', '1998-11-05', '0504852333', 'sam@gmail.com', '12345', 3, 1);

-- nurses
INSERT INTO hospital.person (name, surname, birthday, phone, email, password, fk_role, fk_chamber)
VALUES ('Валентина', 'Петушкова', '1983-04-29', '0670442385', 'valyap@gmail.com', '12345', 4, 1);

INSERT INTO hospital.person (name, surname, birthday, phone, email, password, fk_role, fk_chamber)
VALUES ('Петр', 'Петров', '1999-01-01', '0630574513', 'petr@gmail.com', '12345', 4, 1);
