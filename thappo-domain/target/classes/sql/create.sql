CREATE TABLE users (
id INT NOT NULL AUTO_INCREMENT,
first_name varchar(20) NOT NULL,
last_name varchar(20) NOT NULL,
email varchar(50) NOT NULL UNIQUE,
password varchar(40),
dob INT DEFAULT 0,
profile varchar(15)NOT NULL,
state varchar(10)NOT NULL,
PRIMARY KEY (id),
UNIQUE KEY `id_UNIQUE` (`id`)
);

INSERT INTO users (first_name, last_name, email, password, dob, profile , state) VALUES
('Agustin', 'Larrarte', 'alarrarte@mail.com', '1234abcd', '19821112', 'CLIENT', 'ACTIVE');
