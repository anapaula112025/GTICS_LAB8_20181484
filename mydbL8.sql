-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb8
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb8
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb8` DEFAULT CHARACTER SET utf8 ;
USE `mydb8` ;

-- -----------------------------------------------------
-- Table `mydb8`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb8`.`user` (
  `iduser` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb8`.`pokemon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb8`.`pokemon` (
  `idpokemon` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `lugar` VARCHAR(45) NULL,
  `user_iduser` INT NOT NULL,
  PRIMARY KEY (`idpokemon`),
  INDEX `fk_pokemon_user_idx` (`user_iduser` ASC) VISIBLE,
  CONSTRAINT `fk_pokemon_user`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `mydb8`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
