INSERT INTO `customer`(`name`,`email`,`mobile_number`,`create_dt`)
VALUES ('Gagan Sharma','gagansharma2717@gmail.com','1234223451',CURDATE());

INSERT INTO `accounts`(`customer_id`,`account_number`,`account_type`,`branch_address`,`create_dt`)
VALUES (1,12345633,'Savings','123 Main Street, New York', CURDATE());