-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2018 at 03:57 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_liga`
--

-- --------------------------------------------------------

--
-- Table structure for table `t_pelatih`
--

CREATE TABLE `t_pelatih` (
  `idpelatih` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `age` int(2) NOT NULL,
  `license` varchar(10) NOT NULL,
  `idclub` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_pelatih`
--

INSERT INTO `t_pelatih` (`idpelatih`, `name`, `age`, `license`, `idclub`) VALUES
(1, 'Mario Gomez', 67, 'AFC A', 1),
(2, 'Fernando Soler', 57, 'AFC B', 1),
(3, 'Wawan', 57, 'AFC A', 2),
(4, 'Jono', 57, 'AFC A', 3),
(5, 'Joni', 60, 'AFC A', 4),
(6, 'Alfred', 40, 'AFC A', 5),
(7, 'Fransis', 50, 'AFC A', 6),
(8, 'Herman', 50, 'AFC A', 7),
(9, 'Jyaladoski', 50, 'AFC A', 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_pelatih`
--
ALTER TABLE `t_pelatih`
  ADD PRIMARY KEY (`idpelatih`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
