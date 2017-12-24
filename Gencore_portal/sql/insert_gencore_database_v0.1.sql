-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Jeu 30 Septembre 2010 à 18:00
-- Version du serveur: 5.1.36
-- Version de PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de données: `gencore_v0.1_db`
--

--
-- Contenu de la table `T_ROLE`
--

INSERT INTO `T_ROLE` (`ID`, `NAME`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

--
-- Contenu de la table `T_USER`
--

INSERT INTO `T_USER` (`LOGIN`, `PASSWORD`, `ENABLED`, `FIRSTNAME`, `LASTNAME`,`LANGUAGE`, `EMAIL`, `CREATION_DATE`, `LASTACCESS_DATE`, `LOCKED`, `ROLE_ID`,`PHOTO`) VALUES
('admin', 0x31303233383262373963346565623236656662393137666433386534646461633732653962326138, b'1', 'Joseph', 'Luccisano',0, 'joseph.luccisano@gmail.com', '2010-03-22 14:46:25', '2010-09-30 19:18:25', b'1', 1,null)
('user', 0x31303233383262373963346565623236656662393137666433386534646461633732653962326138, b'1', 'Elise', 'Luccisano',1, 'elise.luccisano@gmail.com', '2010-03-22 14:46:25', '2010-09-30 19:18:25', b'1', 1,null);


INSERT INTO `T_COURSE_TYPE` (`ID`, `NAME`) VALUES
(1, 'cycling'),
(2, 'running'),
(3, 'walking');