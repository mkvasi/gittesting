
DROP DATABASE IF EXISTS `legohouse`; 

CREATE SCHEMA IF NOT EXISTS `legohouse` DEFAULT CHARACTER SET utf8 ;
USE `legohouse` ;


CREATE TABLE IF NOT EXISTS `legohouse`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;



CREATE TABLE IF NOT EXISTS `legohouse`.`order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `length` INT(11) NOT NULL,
  `width` INT(11) NOT NULL,
  `layers` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,

  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `legohouse`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
