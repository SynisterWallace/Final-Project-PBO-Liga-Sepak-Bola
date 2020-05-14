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
-- Table structure for table `t_pemain`
--

CREATE TABLE `t_pemain` (
  `idpemain` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `idclub` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_pemain`
--

INSERT INTO `t_pemain` (`idpemain`, `name`, `age`, `idclub`) VALUES
(1, 'M Natshir', 30, 1),
(2, 'Igbonefo', 33, 1),
(3, 'Ardi Idrus', 26, 1),
(4, 'Atep', 34, 1),
(5, 'Ezechiel', 29, 1),
(6, 'Bauman', 27, 1),
(7, 'Hariono', 35, 1),
(8, 'Supardi Natsir', 35, 1),
(9, 'Kim Jeffrey', 30, 1),
(10, 'Wildan', 30, 1),
(11, 'Febri Hariadi', 23, 1),
(12, 'Toni Sucipto', 36, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_pemain`
--
ALTER TABLE `t_pemain`
  ADD PRIMARY KEY (`idpemain`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
