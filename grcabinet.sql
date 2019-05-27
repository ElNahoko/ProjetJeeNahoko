-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 27, 2019 at 04:00 AM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `grcabinet`
--

-- --------------------------------------------------------

--
-- Table structure for table `evenement`
--

CREATE TABLE `evenement` (
  `id_e` int(11) NOT NULL,
  `Evenement` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `evenement`
--

INSERT INTO `evenement` (`id_e`, `Evenement`) VALUES
(1, 'Visiter Rania Chez Soit'),
(2, 'Visiter Rania Chez Soit'),
(3, 'Visiter Rania Chez Soit'),
(4, 'Visiter Rania Chez Soit'),
(5, 'Visiter Rania Chez Soit');

-- --------------------------------------------------------

--
-- Table structure for table `rdv`
--

CREATE TABLE `rdv` (
  `id` int(11) NOT NULL,
  `Nom` varchar(50) COLLATE utf8_bin NOT NULL,
  `Prenom` varchar(50) COLLATE utf8_bin NOT NULL,
  `Date` varchar(50) COLLATE utf8_bin NOT NULL,
  `Heure` varchar(50) COLLATE utf8_bin NOT NULL,
  `Motif` varchar(50) COLLATE utf8_bin NOT NULL,
  `Telephone` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `rdv`
--

INSERT INTO `rdv` (`id`, `Nom`, `Prenom`, `Date`, `Heure`, `Motif`, `Telephone`) VALUES
(6, '6', 'Adham', '2019-05-30', '2018-07-22', 'Baquroun', 'Rien'),
(12, 'Ranuch', 'Babuch', '5/30/2019', '1:00am', 'Rien', '0668999949');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_u` int(11) NOT NULL,
  `USERNAME` varchar(50) COLLATE utf8_bin NOT NULL,
  `PASSWORD` varchar(50) COLLATE utf8_bin NOT NULL,
  `TYPE` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_u`, `USERNAME`, `PASSWORD`, `TYPE`) VALUES
(1, 'admin', 'admin', 'docteur');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id_e`);

--
-- Indexes for table `rdv`
--
ALTER TABLE `rdv`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_u`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id_e` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `rdv`
--
ALTER TABLE `rdv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_u` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
