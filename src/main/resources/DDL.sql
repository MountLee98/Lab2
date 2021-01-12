CREATE USER stm_user PASSWORD 'stm_user';
GRANT RIGHT ALL ON TASK TO stm_user;
GRANT RIGHT SELECT ON USER TO stm_user;

CREATE TABLE User (
  userId INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  lastName VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  status BOOLEAN NOT NULL default false,
  registration TIMESTAMP NOT NULL default now(),
  PRIMARY KEY(userId)
);

CREATE TABLE Task (
  taskId INT UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL,
  description VARCHAR(255) NOT NULL,
  dateAdded TIMESTAMP NOT NULL default now(),
  type ENUM('TASK', 'BUG', 'FEATURE'),
  status ENUM('NEW', 'IN_PROGRESS', 'DONE'),
  user INT UNSIGNED NOT NULL,
  PRIMARY KEY(taskId),
  CONSTRAINT FOREIGN KEY(user)
  REFERENCES User (userId)
);