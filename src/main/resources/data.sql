
INSERT INTO address (street, postal_code, city) VALUES
        ('Hökvägen 13', '12345', 'Borås'),
        ('Grenskogen 44', '91918', 'Madagaskar'),
        ('Magtrakten 9', '64252', 'Kroppen'),
        ('Ovan Molnen 7', '77777', 'Himlavalvet'),
        ('Maxi Yatzy 36', '65432', 'Lyckokastet');

INSERT INTO member (first_name, last_name, date_of_birth, email, phone, address_id) VALUES
        ('Anton', 'Skugga', '1972-03-11', 'anton@skugga.se', '070-1234567', 2),
        ('Bengt', 'Sture', '1919-11-11', 'gammalochsliten@jorden.se', null, 2),
        ('Mogen', 'Dans', '1901-01-01', 'icke@aktiv.se', '072-1923873', 3),
        ('Åke', 'Mullvad', '1983-04-04', 'fyrbent@djurenshem.se', null, 1),
        ('Magnus', 'Ladulås', '1240-03-18', 'theman@kingen.se', '073-9999999', 4);