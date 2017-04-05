CREATE TABLE users (
user_id INT NOT NULL AUTO_INCREMENT,
first_name varchar(20) NOT NULL,
last_name varchar(20) NOT NULL,
email varchar(50) NOT NULL UNIQUE,
password varchar(40) NOT NULL,
dob INT,
profile varchar(15)NOT NULL,
state varchar(10)NOT NULL,
PRIMARY KEY (user_id)
);


CREATE TABLE `contacts` (
  `contact_id` INT NOT NULL AUTO_INCREMENT,
  `cellphone` VARCHAR(45) NULL,
  `telephone` VARCHAR(45) NULL,
  `address` VARCHAR(255) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`contact_id`, `user_id`),
  CONSTRAINT `fk_contacts_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


INSERT INTO users (first_name, last_name, email, password, dob, profile , state) VALUES
('Agustin', 'Larrarte', 'alarrarte@mail.com', '1234abcd', '19821112', 'CLIENT', 'ACTIVE'),
('Luciano', 'Charlier', 'lcharlier@mail.com', '1234abcd', '0', 'CLIENT', 'INACTIVE'),
('Luciano', 'Natoli', 'lnatoli@mail.com', '1234abcd', '19790102', 'CLIENT', 'ACTIVE'),
('Maotse', 'Hernandez', 'mhernandez@mail.com', '1234abcd', '0', 'MANAGER', 'ACTIVE');

INSERT INTO contacts (cellphone,telephone,address,user_id) VALUES
('1586598654','44315780','Rivadavia 5600 4to Piso 9 Depto, Capital Federal, Ciudad Autonoma de Buenos Aires, AR', (SELECT user_id FROM users WHERE email = 'alarrarte@mail.com')),
('1586598654','44315780','Rivadavia 5600 4to Piso 9 Depto, Capital Federal, Ciudad Autonoma de Buenos Aires, AR', (SELECT user_id FROM users WHERE email = 'lcharlier@mail.com')),
('1586598654','44315780','Rivadavia 5600 4to Piso 9 Depto, Capital Federal, Ciudad Autonoma de Buenos Aires, AR', (SELECT user_id FROM users WHERE email = 'lnatoli@mail.com')),
('1586598654','44315780','Rivadavia 5600 4to Piso 9 Depto, Capital Federal, Ciudad Autonoma de Buenos Aires, AR', (SELECT user_id FROM users WHERE email = 'mhernandez@mail.com'));