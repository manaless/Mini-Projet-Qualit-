-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 29 Janvier 2016 à 19:23
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `prj`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `cin` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  PRIMARY KEY (`idClient`),
  KEY `login` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClient`, `nom`, `prenom`, `cin`, `login`) VALUES
(4, 'Monsif', 'Ilham', 'H1458', 'user'),
(5, 'Benjelloun', 'Meryeme', 'J4578', 'admin'),
(8, 'Kamali', 'Mohammed', 'J1566', 'user1'),
(9, 'Ismaili', 'Rachid', 'H1147', 'user2');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE IF NOT EXISTS `compte` (
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enable` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`login`, `password`, `enable`) VALUES
('admin', 'admin', 1),
('user', 'user', 1),
('user1', 'user1', 1),
('user2', 'user2', 1),
('userr', 'userr', 1);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `idRole` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`idRole`),
  KEY `login` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`idRole`, `login`, `role`) VALUES
(3, 'admin', 'ROLE_ADMIN'),
(4, 'user', 'ROLE_USER'),
(5, 'userr', 'ROLE_USER'),
(6, 'user1', 'ROLE_USER'),
(7, 'user2', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Structure de la table `solde`
--

CREATE TABLE IF NOT EXISTS `solde` (
  `idSolde` int(11) NOT NULL AUTO_INCREMENT,
  `solde` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  PRIMARY KEY (`idSolde`),
  KEY `idClient` (`idClient`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `solde`
--

INSERT INTO `solde` (`idSolde`, `solde`, `idClient`) VALUES
(3, 100000, 4),
(4, 64000, 5),
(5, 52000, 8),
(6, 100000, 9);

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

CREATE TABLE IF NOT EXISTS `transaction` (
  `idTransaction` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `montant` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  `date` date NOT NULL,
  `etat` varchar(10) NOT NULL,
  PRIMARY KEY (`idTransaction`),
  KEY `idClient` (`idClient`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Contenu de la table `transaction`
--

INSERT INTO `transaction` (`idTransaction`, `type`, `montant`, `idClient`, `date`, `etat`) VALUES
(5, 'retrait', 1000, 4, '2016-12-06', '-'),
(10, 'retrait', 1000, 8, '2016-01-03', '-'),
(11, 'retrait', 500, 9, '2016-01-01', '-'),
(16, 'retrait', 1000, 9, '2016-12-06', '-'),
(17, 'retracted', 2000, 5, '2016-12-05', 'Réglé'),
(18, 'retrait', 1000, 8, '2016-12-10', '-'),
(19, 'retracted', 2000, 8, '2016-12-04', 'Réglé');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`login`) REFERENCES `compte` (`login`);

--
-- Contraintes pour la table `role`
--
ALTER TABLE `role`
  ADD CONSTRAINT `role_ibfk_1` FOREIGN KEY (`login`) REFERENCES `compte` (`login`);

--
-- Contraintes pour la table `solde`
--
ALTER TABLE `solde`
  ADD CONSTRAINT `solde_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`);

--
-- Contraintes pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
