/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  IanPhillips
 * Created: 13-Apr-2016
 */

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `autotest`
--

-- --------------------------------------------------------

--
-- Table structure for table `dynamic_test_data`
--

CREATE TABLE `dynamic_test_data` (
  `environment` varchar(500) NOT NULL,
  `property_key` varchar(500) NOT NULL,
  `property_value` varchar(500) NOT NULL,
  `property_comment` varchar(500) NOT NULL,
  `property_used` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
