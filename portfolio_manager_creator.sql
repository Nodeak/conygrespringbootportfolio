-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.20-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for portfolio_manager
CREATE DATABASE IF NOT EXISTS `portfolio_manager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `portfolio_manager`;

-- Dumping structure for table portfolio_manager.account
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `cash_value` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__user` (`user_id`),
  CONSTRAINT `FK__user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table portfolio_manager.account: ~4 rows (approximately)
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
REPLACE INTO `account` (`id`, `user_id`, `name`, `type`, `cash_value`) VALUES
	(1, 1, 'Kaedon Investments', 'Investments', 50),
	(2, 1, 'Kaedon Checkings', 'Cash', 0),
	(3, 2, 'Serena Investments', 'Investments', 750000),
	(4, 2, 'Serena Checkings', 'Cash', 250000);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;

-- Dumping structure for table portfolio_manager.holdings
CREATE TABLE IF NOT EXISTS `holdings` (
  `account_id` int(11) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `symbol` varchar(50) DEFAULT NULL,
  `buy_price` float DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  KEY `account_id` (`account_id`),
  CONSTRAINT `FK__account` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table portfolio_manager.holdings: ~4 rows (approximately)
/*!40000 ALTER TABLE `holdings` DISABLE KEYS */;
REPLACE INTO `holdings` (`account_id`, `type`, `name`, `symbol`, `buy_price`, `amount`) VALUES
	(1, 'Stock', 'Citi', 'C', 76.11, 1),
	(1, 'Stock', 'Tesla', 'TSLA', 211.31, 1),
	(3, 'Stock', 'Apple', 'AAPL', 148.42, 100),
	(3, 'Stock', 'Google', 'GOOG', 1232, 57);
/*!40000 ALTER TABLE `holdings` ENABLE KEYS */;

-- Dumping structure for table portfolio_manager.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `net_worth` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='User personal information';

-- Dumping data for table portfolio_manager.user: ~2 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `first_name`, `last_name`, `net_worth`) VALUES
	(1, 'Kaedon', 'Hamm', 50),
	(2, 'Serena', 'Rampersad', 1000000);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
