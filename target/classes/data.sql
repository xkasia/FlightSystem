

INSERT INTO flights(departure_time, arrival_time, amount_of_seats, ticket_price) VALUES (GETDATE(), GETDATE(), 20, 30.3);
INSERT INTO tourists(first_name, last_name, country, birth_date) VALUES ('Kasia', 'Les', 'Poland',GETDATE());
INSERT INTO flight_tourist (Flight_ID, Tourist_ID) VALUES (1,1);
INSERT INTO notes(tourist_id, text) VALUES (1, 'TEKST NOTATKI');
