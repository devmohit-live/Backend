CREATE USER 'todos-user'@'localhost' IDENTIFIED BY 'dummytodos';
GRANT ALL PRIVILEGES ON *.* TO 'todos-user'@'localhost' WITH GRANT OPTION;
DROP SCHEMA IF EXISTS `todos`;
CREATE SCHEMA `todos`;