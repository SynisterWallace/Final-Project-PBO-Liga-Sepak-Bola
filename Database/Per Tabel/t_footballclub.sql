-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2018 at 03:56 PM
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
-- Table structure for table `t_footballclub`
--

CREATE TABLE `t_footballclub` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `match_played` int(11) NOT NULL,
  `win` int(11) NOT NULL,
  `draw` int(11) NOT NULL,
  `lose` int(11) NOT NULL,
  `goal` int(11) NOT NULL,
  `conceded` int(11) NOT NULL,
  `point` int(11) NOT NULL,
  `location` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_footballclub`
--

INSERT INTO `t_footballclub` (`id`, `name`, `match_played`, `win`, `draw`, `lose`, `goal`, `conceded`, `point`, `location`) VALUES
(1, 'Persib', 1, 1, 0, 0, 2, 0, 3, 'Bandung'),
(2, 'Persija', 1, 0, 0, 1, 0, 2, 0, 'Jakarta'),
(3, 'Arema', 1, 0, 0, 1, 2, 3, 0, 'Malang'),
(4, 'Persebaya', 1, 1, 0, 0, 3, 2, 3, 'Surabaya'),
(5, 'PSMS', 1, 1, 0, 0, 3, 1, 3, 'Medan'),
(6, 'Persipura', 1, 0, 0, 1, 1, 3, 0, 'Jayapura'),
(7, 'Perseru', 1, 1, 0, 0, 5, 1, 3, 'Serui'),
(8, 'Bali United', 1, 0, 0, 1, 1, 5, 0, 'Bali');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_footballclub`
--
ALTER TABLE `t_footballclub`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
