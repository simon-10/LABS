
INSERT INTO `security`.`users`(`user_id`,`email`,`first_name`,`last_name`,`middle_name`,`password`,`username`)
VALUES(1,'admin@miu.edu','adminfname','adminlname', 'adminmname','$2a$10$0dflzX9XT8bj7E9ia.GuxO9ZM0iPmIXmjzx23dDHqmYXMkW1uIUw.','admin');

INSERT INTO `security`.`users`(`user_id`,`email`,`first_name`,`last_name`,`middle_name`,`password`,`username`)
VALUES(2,'simon@miu.edu','simon','welde', 'abraham','$2a$10$x0OYgwCDO11mFsD/48Fjj.10qTvb/VXDOC.khlMKtpWsWOf/qzDBq','simon');

INSERT INTO `security`.`users`(`user_id`,`email`,`first_name`,`last_name`,`middle_name`,`password`,`username`)
VALUES(3,'dani@miu.edu','daniel','hagos', 'mebrahtu','$2a$10$eXIHq3dmujNi4WYGAFh98u2erayUbnJXOOlY.lHthrZvDOvC/78JS','dani');




INSERT INTO `security`.`roles`(`role_id`,`name`)VALUES('1','ROLE_ADMIN');
INSERT INTO `security`.`roles`(`role_id`,`name`)VALUES('3','ROLE_REGISTRAR');
INSERT INTO `security`.`roles`(`role_id`,`name`)VALUES('2','ROLE_STUDENT');






INSERT INTO `security`.`users_roles`(`user_id`,`role_id`)VALUES('3','3');
INSERT INTO `security`.`users_roles`(`user_id`,`role_id`)VALUES('1','1');
INSERT INTO `security`.`users_roles`(`user_id`,`role_id`)VALUES('2','2');


