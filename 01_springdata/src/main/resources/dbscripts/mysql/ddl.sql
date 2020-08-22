CREATE DATABASE covid_repo;

use covid_repo;

CREATE TABLE test_data (
  test_id INT(10) NOT NULL AUTO_INCREMENT,
  remarks VARCHAR(100) NULL,
  PRIMARY KEY (test_id)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

