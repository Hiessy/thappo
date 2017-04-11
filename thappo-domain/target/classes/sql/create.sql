
-- -----------------------------------------------------
-- Table users
-- -----------------------------------------------------
CREATE TABLE users (
user_id INT NOT NULL AUTO_INCREMENT,
first_name varchar(20) NOT NULL,
last_name varchar(20) NOT NULL,
email varchar(50) NOT NULL UNIQUE,
password varchar(40) NOT NULL,
dob INT,
profile varchar(15)NOT NULL,
state varchar(10)NOT NULL,
telephone VARCHAR(45) NULL,
PRIMARY KEY (user_id)
);

-- -----------------------------------------------------
-- Table categories
-- -----------------------------------------------------
CREATE TABLE categories (
category_id INT NOT NULL,
category_name VARCHAR(45) NOT NULL,
description VARCHAR(255) NULL,
PRIMARY KEY (category_id),
UNIQUE INDEX category_name_UNIQUE (category_name ASC));

-- -----------------------------------------------------
-- Table businesses
-- -----------------------------------------------------
CREATE TABLE businesses (
  business_id INT NOT NULL,
  business_name VARCHAR(45) NOT NULL,
  owner_name VARCHAR(45) NOT NULL,
  user_id INT NOT NULL,
  category_id INT NOT NULL,
  last_update TIMESTAMP NULL,
  PRIMARY KEY (business_id),
  UNIQUE INDEX business_name_UNIQUE (business_name ASC),
  UNIQUE INDEX owner_name_UNIQUE (owner_name ASC),
  CONSTRAINT fk_businesses_users1
    FOREIGN KEY (user_id)
    REFERENCES users (user_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_businesses_categories1
    FOREIGN KEY (category_id)
    REFERENCES categories (category_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table subcategories
-- -----------------------------------------------------
CREATE TABLE subcategories (
  subcategory_id INT NOT NULL,
  subcategory_name VARCHAR(45) NOT NULL,
  subcategory_description VARCHAR(45) NULL,
  category_id INT NOT NULL,
  PRIMARY KEY (subcategory_id),
  UNIQUE INDEX subcategory_name_UNIQUE (subcategory_name ASC),
  CONSTRAINT fk_Subcategories_Categories
    FOREIGN KEY (category_id)
    REFERENCES categories (category_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table addresses
-- -----------------------------------------------------
CREATE TABLE addresses (
  address_id INT NOT NULL,
  street_nbr VARCHAR(45) NOT NULL,
  street_name VARCHAR(45) NOT NULL,
  floor_number VARCHAR(45) NULL,
  postal_code VARCHAR(45) NOT NULL,
  city VARCHAR(45) NOT NULL,
  province VARCHAR(45) NOT NULL,
  country VARCHAR(45) NOT NULL,
  latitud VARCHAR(45) NOT NULL,
  longitud VARCHAR(45) NOT NULL,
  PRIMARY KEY (address_id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table branches
-- -----------------------------------------------------
CREATE TABLE branches (
  branch_id INT NOT NULL,
  telephone VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  business_id INT NOT NULL,
  address_id INT NOT NULL,
  PRIMARY KEY (branch_id),
  CONSTRAINT fk_branches_businesses1
    FOREIGN KEY (business_id)
    REFERENCES businesses (business_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_branches_addresses1
    FOREIGN KEY (address_id)
    REFERENCES addresses (address_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table services
-- -----------------------------------------------------
CREATE TABLE services (
  service_id INT NOT NULL,
  service_name VARCHAR(45) NOT NULL,
  service_duration INT(2) NOT NULL,
  state varchar(10)NOT NULL,
  branch_id INT NOT NULL,
  subcategory_id INT NOT NULL,
  PRIMARY KEY (service_id),
  CONSTRAINT fk_services_branches1
    FOREIGN KEY (branch_id)
    REFERENCES branches (branch_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_services_subcategories1
    FOREIGN KEY (subcategory_id)
    REFERENCES subcategories (subcategory_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table schedules
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS schedules (
  schedule_id INT NOT NULL,
  sunday VARCHAR(45) NOT NULL,
  monday VARCHAR(45) NOT NULL,
  tuesday VARCHAR(45) NOT NULL,
  wednesday VARCHAR(45) NOT NULL,
  thursday VARCHAR(45) NOT NULL,
  friday VARCHAR(45) NOT NULL,
  service_id INT NOT NULL,
  user_id INT NOT NULL,
  PRIMARY KEY (schedule_id),
  CONSTRAINT fk_schedules_services1
    FOREIGN KEY (service_id)
    REFERENCES services (service_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_schedules_users1
    FOREIGN KEY (user_id)
    REFERENCES users (user_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table appointments
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS appointments (
  appointment_id INT NOT NULL,
  appointment VARCHAR(45) NOT NULL,
  appointment_state VARCHAR(45) NOT NULL,
  user_id INT NOT NULL,
  employee_id INT NOT NULL,
  PRIMARY KEY (appointment_id),
  CONSTRAINT fk_appointments_users1
    FOREIGN KEY (user_id)
    REFERENCES users (user_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_appointments_users2
    FOREIGN KEY (employee_id)
    REFERENCES users (user_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


INSERT INTO users (first_name, last_name ,telephone , email, password, dob, profile , state) VALUES
('Agustin', 'Larrarte', '1586598654', 'alarrarte@mail.com', '1234abcd', '19821112', 'CLIENT', 'ACTIVE'),
('Luciano', 'Charlier', '1586598654', 'lcharlier@mail.com', '1234abcd', '0', 'CLIENT', 'INACTIVE'),
('Luciano', 'Natoli', '1586598654', 'lnatoli@mail.com', '1234abcd', '19790102', 'CLIENT', 'ACTIVE'),
('Maotse', 'Hernandez', '1586598654', 'mhernandez@mail.com', '1234abcd', '0', 'MANAGER', 'ACTIVE');
