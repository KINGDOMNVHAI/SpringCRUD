-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.2.0 - MySQL Community Server - GPL
-- Server OS:                    Linux
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

-- Dumping structure for table 2024_BB.tb_bb_user
CREATE TABLE IF NOT EXISTS `tb_bb_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `firstname` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `lastname` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `role` tinyint NOT NULL,
  `phone` varchar(100) NULL,
  `address_ship` varchar(100) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `tb_bb_user_chk_1` CHECK ((`role` between 0 and 1))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- Dumping data for table 2024_BB.tb_bb_user: ~2 rows (approximately)
TRUNCATE TABLE `tb_bb_user`;
INSERT INTO `tb_bb_user` (`id`, `email`, `firstname`, `lastname`, `username`, `password`, `role`, `phone`, `address_ship`) VALUES
	(1, 'nvhai061993@gmail.com', 'Hai Admin', 'Nguyen Viet', 'admin1', '$2a$10$wekB9agEwGb4GWaTIA8cVeHFKSCRKVfsfB.4YE7vLnQ9c1AhZto.m', 1, '0123456789', 'Cobi Tower'),
	(2, 'nvhai2306@gmail.com', 'Hai User', 'Le', 'user1', '$2a$10$IcK6/J9f7X53tAXSebdAN.LjkV9ouw/jd9zNWEfsSl3kjiYV25b/y', 0, '0123456789', 'Cobi Tower'),
    (3, 'nvhai061993@gmail.com', 'An User', 'Nguyen', 'user2', '$2a$10$IcK6/J9f7X53tAXSebdAN.LjkV9ouw/jd9zNWEfsSl3kjiYV25b/y', 0, null, 'Cobi Tower')
;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
