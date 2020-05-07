-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2020 at 10:00 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employee`
--

-- --------------------------------------------------------

--
-- Table structure for table `emp`
--

CREATE TABLE `emp` (
  `emp_id` varchar(25) NOT NULL,
  `emp_name` varchar(25) NOT NULL,
  `emp_contact` int(11) NOT NULL,
  `emp_email` varchar(50) NOT NULL,
  `emp_photo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emp`
--

INSERT INTO `emp` (`emp_id`, `emp_name`, `emp_contact`, `emp_email`, `emp_photo`) VALUES
('emp01', 'Ankita', 98999, 'anki@gmail.com', 'http://anki.jpg'),
('emp02', 'Jaideep', 9958, 'jai@gmail.com', 'http://jai.jpg'),
('emp03', 'Anki', 8826, 'nonu@yahoo.com', 'http://nonu.jpg'),
('emp05', 'Akansh', 919212, 'akansh@redif.com', 'http://akansh.jpg'),
('emp07', 'Shubham Gupta', 97170, 'shubham@gmail.com', 'http://shubham.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `login_id` varchar(255) NOT NULL,
  `contact` int(11) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`login_id`, `contact`, `password`) VALUES
('emp01', 98999, '�l$bð>mß'),
('emp02', 9958, 'LøønëË�7'),
('emp03', 8826, 'w3hmÆ´Ž£@'),
('emp05', 919212, '@ó;S<â…'),
('emp07', 97170, 'ž\nU:›hG');

-- --------------------------------------------------------

--
-- Table structure for table `tracks`
--

CREATE TABLE `tracks` (
  `skill_id` varchar(25) NOT NULL,
  `skill_name` varchar(25) DEFAULT NULL,
  `emp_id` varchar(25) DEFAULT NULL,
  `employee_entity_emp_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tracks`
--

INSERT INTO `tracks` (`skill_id`, `skill_name`, `emp_id`, `employee_entity_emp_id`) VALUES
('111', 'Java', 'emp01', NULL),
('22', 'Marketing', 'emp02', NULL),
('32', 'Python', 'emp03', NULL),
('55', 'Angular7', 'emp05', NULL),
('77', 'React', 'emp07', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `emp`
--
ALTER TABLE `emp`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`login_id`);

--
-- Indexes for table `tracks`
--
ALTER TABLE `tracks`
  ADD PRIMARY KEY (`skill_id`),
  ADD KEY `emp_id` (`emp_id`),
  ADD KEY `FKleamdqm2qm1byseh9scusahp` (`employee_entity_emp_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tracks`
--
ALTER TABLE `tracks`
  ADD CONSTRAINT `FKleamdqm2qm1byseh9scusahp` FOREIGN KEY (`employee_entity_emp_id`) REFERENCES `emp` (`emp_id`),
  ADD CONSTRAINT `tracks_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `emp` (`emp_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
