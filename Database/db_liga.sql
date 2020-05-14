-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2018 at 03:55 PM
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
-- Indexes for table `t_footballclub`
--
ALTER TABLE `t_footballclub`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_match`
--
ALTER TABLE `t_match`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_pelatih`
--
ALTER TABLE `t_pelatih`
  ADD PRIMARY KEY (`idpelatih`);

--
-- Indexes for table `t_pemain`
--
ALTER TABLE `t_pemain`
  ADD PRIMARY KEY (`idpemain`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
