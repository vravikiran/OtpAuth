CREATE TABLE 'user_profile' (
  'mobileno' bigint NOT NULL,
  'username' varchar(255) NOT NULL,
  'email' varchar(255) DEFAULT NULL,
  'role_id' int NOT NULL,
  'created_date' date NOT NULL,
  'updated_date' date NOT NULL,
  PRIMARY KEY ('mobileno'),
  UNIQUE KEY 'email_unique' ('email'),
  KEY `role_id` (`role_id`),
  CONSTRAINT 'user_profile_ibfk_1' FOREIGN KEY ('role_id') REFERENCES 'role' ('role_id')
)