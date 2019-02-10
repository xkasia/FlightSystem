

INSERT INTO flights(departure_time, arrival_Time, amount_of_seats, ticket_price) VALUES (GETDATE(), GETDATE(), 2, 30.3);
INSERT INTO flights(departure_time, arrival_Time, amount_of_seats, ticket_price) VALUES (GETDATE(), GETDATE(), 2, 30.3);
INSERT INTO flights(departure_time, arrival_Time, amount_of_seats, ticket_price) VALUES (GETDATE(), GETDATE(), 4, 30.3);
INSERT INTO flights(departure_time, arrival_Time, amount_of_seats, ticket_price) VALUES (GETDATE(), GETDATE(), 34, 45);
INSERT INTO tourists(first_name, last_name, country, birth_date, note) VALUES ('Kasia', 'Les', 'Poland',GETDATE(), 'notatka');
INSERT INTO tourists(first_name, last_name, country, birth_date, note) VALUES ('Basia', 'Les', 'Poland',GETDATE(), 'notatkaaa');
INSERT INTO tourists(first_name, last_name, country, birth_date, note) VALUES ('Jasia', 'Les', 'Poland',GETDATE(), 'notatrkaaa');
INSERT INTO tourists(first_name, last_name, country, birth_date, note) VALUES ('Asia', 'Les', 'Poland',GETDATE(), 'notatksaaa');
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (1,1);
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (2,1);
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (1,3);
INSERT INTO tourist_flights (Flight_ID, Tourist_ID) VALUES (2,2);
