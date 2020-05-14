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
-- Table structure for table `t_match`
--

CREATE TABLE `t_match` (
  `id` int(10) NOT NULL,
  `team_1` varchar(50) NOT NULL,
  `team1_score` int(11) NOT NULL,
  `team_2` varchar(50) NOT NULL,
  `team2_score` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_match`
--

INSERT INTO `t_match` (`id`, `team_1`, `team1_score`, `team_2`, `team2_score`, `date`) VALUES
(1, '1', 2, '2', 0, '2018-12-01'),
(2, '3', 2, '4', 3, '2018-12-01'),
(3, '5', 3, '6', 1, '2018-12-01'),
(4, '7', 5, '8', 1, '2018-12-01');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_match`
--
ALTER TABLE `t_match`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
