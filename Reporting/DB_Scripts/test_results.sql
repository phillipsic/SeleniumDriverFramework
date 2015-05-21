-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2015 at 09:08 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `autotest`
--
CREATE DATABASE `autotest`;
CREATE USER 'autouser'@'localhost' IDENTIFIED BY 'autopassword';
GRANT ALL PRIVILEGES ON autotest.* TO `autouser`@`localhost`;
FLUSH PRIVILEGES;
-- --------------------------------------------------------

--
-- Table structure for table `test_results`
--

CREATE TABLE IF NOT EXISTS `test_results` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `bug_id` varchar(50) NOT NULL,
  `ip` varchar(25) NOT NULL,
  `version` varchar(50) NOT NULL,
  `application` varchar(100) NOT NULL,
  `test_id` varchar(200) NOT NULL,
  `time_stamp` timestamp NOT NULL,
  `test_result` varchar(15) NOT NULL,
  `browser` varchar(30) NOT NULL,
  `OS` varchar(30) NOT NULL,
  `fail_message` varchar(250) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
