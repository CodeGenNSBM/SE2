-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2018 at 06:05 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `stockgame1`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank_transaction`
--

CREATE TABLE IF NOT EXISTS `bank_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active_Date` datetime DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `is_Active` bit(1) DEFAULT NULL,
  `is_Success` bit(1) DEFAULT NULL,
  `player_Id` int(11) DEFAULT NULL,
  `receiver_OR_sender` varchar(255) DEFAULT NULL,
  `transfer_Date` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Age` int(11) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `player_bank_details`
--

CREATE TABLE IF NOT EXISTS `player_bank_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active_Date` datetime DEFAULT NULL,
  `available_Balance` double DEFAULT NULL,
  `bank_Name` varchar(255) DEFAULT NULL,
  `is_Active` bit(1) DEFAULT NULL,
  `player_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Table structure for table `tblestock_sector_details`
--

CREATE TABLE IF NOT EXISTS `tblestock_sector_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `currentRate` double DEFAULT NULL,
  `sectorId_fk` int(11) DEFAULT NULL,
  `stockAmount` int(11) DEFAULT NULL,
  `stockID_fk` int(11) DEFAULT NULL,
  `user_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_g62gg1t1tjuj1qds5krn6esh9` (`user_fk`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `tblestock_sector_details`
--

INSERT INTO `tblestock_sector_details` (`id`, `currentRate`, `sectorId_fk`, `stockAmount`, `stockID_fk`, `user_fk`) VALUES
(1, 102, 1, 0, 1, NULL),
(2, 100, 1, 0, 2, NULL),
(3, 120, 1, 0, 3, NULL),
(4, 97, 1, 0, 4, NULL),
(5, 127, 2, 0, 1, NULL),
(6, 125, 2, 0, 2, NULL),
(7, 89, 2, 0, 3, NULL),
(8, 109, 2, 0, 4, NULL),
(9, 131, 3, 0, 1, NULL),
(10, 120, 3, 0, 2, NULL),
(11, 117, 3, 0, 3, NULL),
(12, 140, 3, 0, 4, NULL),
(13, 151, 4, 0, 1, NULL),
(14, 147, 4, 0, 2, NULL),
(15, 130, 4, 0, 3, NULL),
(16, 135, 4, 0, 4, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tblhistory`
--

CREATE TABLE IF NOT EXISTS `tblhistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `currentPrice` double DEFAULT NULL,
  `sectorName` varchar(255) DEFAULT NULL,
  `stockName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tblsector`
--

CREATE TABLE IF NOT EXISTS `tblsector` (
  `sectorId` int(11) NOT NULL AUTO_INCREMENT,
  `sectorName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sectorId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `tblsector`
--

INSERT INTO `tblsector` (`sectorId`, `sectorName`) VALUES
(1, 'Finance'),
(2, 'Technology'),
(3, 'Manufacturing'),
(4, 'Health');

-- --------------------------------------------------------

--
-- Table structure for table `tblstock`
--

CREATE TABLE IF NOT EXISTS `tblstock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stockName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `tblstock`
--

INSERT INTO `tblstock` (`id`, `stockName`) VALUES
(1, 'Softlogic'),
(2, 'Singer'),
(3, 'LOLC'),
(4, 'Abans'),
(5, 'Dialog'),
(6, 'Mobitel'),
(7, 'e-Wis'),
(8, 'Softlogic'),
(9, 'DSI'),
(10, 'Arpico'),
(11, 'Singer'),
(12, 'Holcim'),
(13, 'Hemas'),
(14, 'The Lanka Hospitals'),
(15, 'Eser Lanka'),
(16, 'Medex Holdings');

-- --------------------------------------------------------

--
-- Table structure for table `tbltemp_buy_sell`
--

CREATE TABLE IF NOT EXISTS `tbltemp_buy_sell` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isBuy` int(11) DEFAULT NULL,
  `sectorID_fk` int(11) DEFAULT NULL,
  `stockAmount` int(11) DEFAULT NULL,
  `stockID_fk` int(11) DEFAULT NULL,
  `userId_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tbluser`
--

CREATE TABLE IF NOT EXISTS `tbluser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tbluser`
--

INSERT INTO `tbluser` (`id`, `Name`, `Password`, `UserName`) VALUES
(1, 'vishwa m', '202cb962ac59075b964b07152d234b70', 'vm');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_temp_user`
--

CREATE TABLE IF NOT EXISTS `tbl_temp_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateTime` datetime DEFAULT NULL,
  `isPlay` int(11) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tbl_temp_user`
--

INSERT INTO `tbl_temp_user` (`id`, `dateTime`, `isPlay`, `Name`) VALUES
(1, '2018-06-26 09:05:54', 0, 'vm');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tblestock_sector_details`
--
ALTER TABLE `tblestock_sector_details`
  ADD CONSTRAINT `FK_g62gg1t1tjuj1qds5krn6esh9` FOREIGN KEY (`user_fk`) REFERENCES `tbluser` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
