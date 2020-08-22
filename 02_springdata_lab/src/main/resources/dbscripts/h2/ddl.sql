CREATE TABLE if not exists subject_info (
  subject_id INT(10) NOT NULL AUTO_INCREMENT,
  subject_number VARCHAR(20),
  test_description VARCHAR(20),
  test_location VARCHAR(20),
  status VARCHAR(20),
  date_of_test VARCHAR(20),
  remarks VARCHAR(100) NULL,
  PRIMARY KEY (test_id)
);
