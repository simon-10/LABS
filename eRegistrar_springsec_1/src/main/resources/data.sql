
INSERT INTO `security`.`users`(`user_id`,`email`,`first_name`,`last_name`,`middle_name`,`password`,`username`)
VALUES(1,'ana.admin@eregistrar.com','adminfname','adminlname', 'adminmname','$2a$10$0dflzX9XT8bj7E9ia.GuxO9ZM0iPmIXmjzx23dDHqmYXMkW1uIUw.','ana.admin@eregistrar.com');

INSERT INTO `security`.`users`(`user_id`,`email`,`first_name`,`last_name`,`middle_name`,`password`,`username`)
VALUES(2,'bob.registrar@eregistrar.com','simon','welde', 'abraham','$2a$10$x0OYgwCDO11mFsD/48Fjj.10qTvb/VXDOC.khlMKtpWsWOf/qzDBq','bob.registrar@eregistrar.com');

INSERT INTO `security`.`users`(`user_id`,`email`,`first_name`,`last_name`,`middle_name`,`password`,`username`)
VALUES(3,'carlos.student@eregistrar.com','daniel','hagos', 'mebrahtu','$2a$10$eXIHq3dmujNi4WYGAFh98u2erayUbnJXOOlY.lHthrZvDOvC/78JS','carlos.student@eregistrar.com');




INSERT INTO `security`.`roles`(`role_id`,`name`)VALUES('1','ROLE_ADMIN');
INSERT INTO `security`.`roles`(`role_id`,`name`)VALUES('2','ROLE_REGISTRAR');
INSERT INTO `security`.`roles`(`role_id`,`name`)VALUES('3','ROLE_STUDENT');






INSERT INTO `security`.`users_roles`(`user_id`,`role_id`)VALUES('3','3');
INSERT INTO `security`.`users_roles`(`user_id`,`role_id`)VALUES('1','1');
INSERT INTO `security`.`users_roles`(`user_id`,`role_id`)VALUES('2','2');


