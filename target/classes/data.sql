

INSERT INTO flights(departure_time, arrival_Time, amount_of_seats, ticket_price) VALUES ('2019-05-05T12:00:00', '2019-05-21T23:00:00', 5, 7500);
INSERT INTO flights(departure_time, arrival_Time, amount_of_seats, ticket_price) VALUES ('2019-03-05T20:30:00', '2019-03-17T14:00:00', 12, 5500);
INSERT INTO flights(departure_time, arrival_Time, amount_of_seats, ticket_price) VALUES ('2019-04-11T15:00:00', '2019-03-22T11:30:00', 15, 6300);
INSERT INTO flights(departure_time, arrival_Time, amount_of_seats, ticket_price) VALUES ('2019-06-29T06:00:00', '2019-07-12T16:00:00', 8, 6800);
INSERT INTO flights(departure_time, arrival_Time, amount_of_seats, ticket_price) VALUES ('2019-05-05T12:00:00', '2019-05-24T18:00:00', 8, 5800);
INSERT INTO flights(departure_time, arrival_Time, amount_of_seats, ticket_price) VALUES ('2019-06-21T06:00:00', '2019-06-29T16:00:00', 8, 8300);
INSERT INTO tourists(first_name, last_name, country, birth_date, note, gender) VALUES ('Katarzyna', 'Nowak', 'Poland', '1993-07-12', 'client phone number: +48 567-455-544', false);
INSERT INTO tourists(first_name, last_name, country, birth_date, note, gender) VALUES ('Barbara', 'Kowalska', 'Poland','1998-06-12', 'client lives in Warsaw', false );
INSERT INTO tourists(first_name, last_name, country, birth_date, note, gender) VALUES ('Joanna', 'Adamczyk', 'Poland','1967-02-22', 'client phone number: +48 567-233-544', false );
INSERT INTO tourists(first_name, last_name, country, birth_date, note, gender) VALUES ('John', 'Smith', 'England','1967-02-22', 'client has problems with payment', true );
INSERT INTO tourists(first_name, last_name, country, birth_date, note, gender) VALUES ('Avad', 'Samuel', 'India','1967-02-22', 'send to client flights time schedule', true );
INSERT INTO tourists(first_name, last_name, country, birth_date, note, gender) VALUES ('Caroline', 'Freitag', 'Germany','1967-02-22', 'client lives in Berlin', false );
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (1,1);
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (2,1);
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (1,3);
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (2,2);
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (3,3);
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (3,5);
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (3,6);
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (4,3);
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (5,5);
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (6,6);


