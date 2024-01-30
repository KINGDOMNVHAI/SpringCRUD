-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table spring_security.channels
CREATE TABLE IF NOT EXISTS `channels` (
  `id_channel` varchar(30) NOT NULL DEFAULT 'idChannel',
  `name_channel` varchar(255) NOT NULL,
  `url_channel` varchar(255) NOT NULL,
  `url_video_present` varchar(255) DEFAULT NULL,
  `description_channel` text DEFAULT NULL,
  `created_date_channel` date DEFAULT NULL,
  `subscribe` int(11) NOT NULL DEFAULT 0,
  `thumbnail_channel` varchar(255) DEFAULT NULL,
  `banner_channel` varchar(255) DEFAULT NULL,
  `enable_channel` bit(1) DEFAULT NULL,
  `facebook_channel` varchar(255) DEFAULT NULL,
  `twitter_channel` varchar(255) DEFAULT NULL,
  `virtual_youtuber` tinyint(4) NOT NULL DEFAULT 0,
  `hololive` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_channel`),
  UNIQUE KEY `url_channel` (`url_channel`),
  UNIQUE KEY `name_channel` (`name_channel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Data exporting was unselected.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
